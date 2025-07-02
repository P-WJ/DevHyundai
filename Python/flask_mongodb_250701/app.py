from flask import Flask

from routes.product import create_product, get_all_products, root_path, update_product, delete_product

app = Flask(__name__)

# 라우터 등록
app.add_url_rule("/", view_func=root_path, methods=['GET'])
app.add_url_rule("/products", view_func=create_product, methods=['POST'])
app.add_url_rule("/products", view_func=get_all_products, methods=['GET'])
app.add_url_rule("/products/<name>", view_func=update_product, methods=['PUT'])
app.add_url_rule("/products/<name>", view_func=delete_product, methods=['DELETE'])

if __name__ == "__main__":
    app.run()
