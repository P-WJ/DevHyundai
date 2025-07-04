
from flask import request, jsonify
import pandas as pd
import re, joblib

from sklearn.metrics import classification_report
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB
import pytz
from datetime import datetime
from pymongo import MongoClient

client = MongoClient("mongodb://localhost:27017/")
db = client.sentiment_db
collection = db.predictions


def train_model():
    # 1. 데이터 로딩 및 전처리
    df = pd.read_csv("./routes/ratings_train.txt", sep='\t')[['document', 'label']].dropna()
    df['text'] = df['document'].apply(lambda x: re.sub(r"[^\uac00-\ud7a3\s]", "", str(x)))
    df['label'] = df['label'].map({1: "positive", 0: "negative"})

    # 2. 훈련/테스트 분할
    X_train, X_test, y_train, y_test = train_test_split(
        df['text'], df['label'], test_size=0.2, random_state=42
    )

    # 3. 벡터화 및 모델 학습
    vectorizer = CountVectorizer()
    X_train_vec = vectorizer.fit_transform(X_train)
    X_test_vec = vectorizer.transform(X_test)

    model = MultinomialNB()
    model.fit(X_train_vec, y_train)

    # 4. 모델 평가
    y_pred = model.predict(X_test_vec)
    report = classification_report(y_test, y_pred, output_dict=True)

    # 5. 모델 및 벡터 저장
    joblib.dump(model, "./routes/sentiment_model.pkl")
    joblib.dump(vectorizer, "./routes/vectorizer.pkl")

    # 6. JSON 응답
    return jsonify({
        "message": "모델 학습 및 저장 완료",
        "evaluation": {
            "accuracy": report["accuracy"],
            "positive": report["positive"],
            "negative": report["negative"],
            "macro avg": report["macro avg"]
        }
    })

# routes/predict.py

from flask import request, jsonify
import joblib

def predict():
    data = request.get_json()
    post_id = data.get("postId")
    title = data.get("title", "")
    content = data.get("content", "")
    text = title + " " + content

    # 모델 로딩
    model = joblib.load("./routes/sentiment_model.pkl")
    vectorizer = joblib.load("./routes/vectorizer.pkl")
    vec = vectorizer.transform([text])
    pred = model.predict(vec)[0]

    # 시간 기록
    kst = pytz.timezone("Asia/Seoul")
    now_kst = datetime.now(kst)

    # MongoDB 저장
    result = {
        "post_id": post_id,
        "title": title,
        "content": content,
        "prediction": pred,
        "created_at": now_kst.isoformat()
    }
    collection.insert_one(result)

    return jsonify({"prediction": pred})