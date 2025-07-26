import requests  # http로 정보 가져오기 위해 사용

url = "https://raw.githubusercontent.com/e9t/nsmc/master/ratings_train.txt"
response = requests.get(url)

with open("ratings_train.txt", "w", encoding="utf-8") as f:
    f.write(response.text)

import pandas as pd

# NSMC 데이터 불러오기
df = pd.read_csv("ratings_train.txt", sep='\t')
df = df[['document', 'label']].dropna()
print(df.head())

import re    # 정규식 처리를 위한 모듈

def clean_test(text):
    return re.sub(r"[^\uac00-\ud7a3\s]", "", str(text))

df['text'] = df['document'].apply(clean_test)
df['label'] = df['label'].map({1: "positive", 0: "negative"})
df = df[['text', 'label']].dropna()
print(df.head())

from sklearn.model_selection import train_test_split

X_train, X_test, y_train, y_test = train_test_split(
    df['text'], df['label'], test_size=0.2, random_state=42
)

from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB

vectorizer = CountVectorizer()
X_train_vec = vectorizer.fit_transform(X_train)
X_test_vec = vectorizer.transform(X_test)

model = MultinomialNB()
model.fit(X_train_vec, y_train)

from sklearn.metrics import classification_report

y_pred = model.predict(X_test_vec)
print(classification_report(y_test, y_pred))