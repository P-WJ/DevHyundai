from flask import jsonify, request
from db.mongodb import collection

def get_box_office():
    target_date = request.args.get("date")
    query = {"targetDt": target_date} if target_date else {}
    result = list(collection.find(query, {"_id": 0}))
    return jsonify(result)