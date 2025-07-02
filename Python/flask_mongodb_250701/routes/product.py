from flask import request, jsonify
from pymongo import MongoClient
from bson import ObjectId

client = MongoClient('mongodb://localhost:27017/')
db = client["shopdb"]
products = db["products"]

def convert_doc(doc):
    doc["id"] = str(doc["_id"])
    del doc["_id"]
    return doc

def root_path():
    return "파이썬 플라스크 루트"

# insert
def create_product():
    data = request.json     # 클라이언트에서 전송한 JSON 데이터
    result = products.insert_one(data)
    return jsonify({"id":str(result.inserted_id)}), 201

# 전체 상품 조회
def get_all_products():
    docs = products.find()      # 전체 문서 가져옴
    result = []     # 결과를 담을 빈 리스트 생성
    for doc in docs:
        conv_doc = convert_doc(doc)     # _id => id
        result.append(conv_doc)
    return jsonify(result)

# 개별 상품 조회
def get_product_by_name(name):
    doc = products.findOne({"name": name})
    if doc:
        converted = convert_doc(doc)
        return jsonify(converted)
    else:
        return jsonify({"error": "Not Found"}), 404

# 제품 수정
def update_product(name):
    data = request.json
    result = products.update_one({"name": name}, {"$set": data})
    return jsonify({"modify": result.matched_count})

# 제품 삭제
def delete_product(name):
    result = products.delete_one({"name": name})
    return jsonify({"delete": result.deleted_count})