from pymongo import MongoClient

client = MongoClient("mongodb://localhost:27017/")
db = client["movie_db"]
collection = db["boxoffice"]
