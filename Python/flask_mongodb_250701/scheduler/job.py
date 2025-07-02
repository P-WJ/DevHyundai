import requests  # HTTP 요청과 응답
from datetime import datetime, timedelta  # 운영체제로 부터 시간 정보를 가져옴
from db.mongodb import collection  # DB Table 정보를 가져옴

API_KEY = "88e8af5c07ec04486d77c628b60b1154"


def fetch_and_store():  # 스케줄러에 의해서 정해진 시간에 호출
    print("fetch_and_store 호출 됨!!!!")
    yesterday = (datetime.now() - timedelta(days=1)).strftime("%Y%m%d")
    url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
    params = {"key": API_KEY, "targetDt": yesterday}

    res = requests.get(url, params=params)
    if res.status_code == 200:
        result = res.json()
        data = result["boxOfficeResult"]["dailyBoxOfficeList"]

        # 오늘 날짜 기준 데이터 덮어쓰기
        collection.delete_many({"targetDt": yesterday})
        for item in data:
            item["targetDt"] = yesterday
            collection.insert_one(item)
