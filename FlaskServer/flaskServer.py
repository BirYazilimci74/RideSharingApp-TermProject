from flask import Flask, request, jsonify, render_template
import pymysql

app = Flask(__name__)

# Connect to the local MySQL database
connection = pymysql.connect(
    host='localhost',
    user='root',  # Replace with your MySQL username
    password='',  # Replace with your MySQL password
    database='rideshareapp',  # Replace with your database name
    charset='utf8mb4',
    cursorclass=pymysql.cursors.DictCursor
)

@app.route('/add_data', methods=['POST'])
def add_data():
    try:
        # Get the data from the request body
        data = request.json
        driverName = data.get('driverName')
        target = data.get('target')
        plate = data.get('plate')
        latitude = data.get('latitude')
        longitude = data.get('longitude')

        # Validate the data
        if not (driverName and target and plate and latitude and longitude):
            return jsonify({'error': 'Name, description, and imageName are required'}), 400

        with connection.cursor() as cursor:
            # Execute the SQL query to insert the new data into the database
            sql = "INSERT INTO rides (driverName, target, plate, latitude, longitude) VALUES (%s, %s, %s, %s, %s)"
            cursor.execute(sql, (driverName, target, plate, latitude, longitude))
            connection.commit()

        return jsonify({'message': 'Data added successfully'})
    except Exception as e:
        return jsonify({'error': str(e)}), 500

@app.route('/read_data', methods=['GET'])
def read_data():
    target = request.args.get('target')
    if not target:
        return jsonify({'error': 'District parameter is required'}), 400

    try:
        with connection.cursor() as cursor:
            # Execute the SQL query to retrieve latitude and longitude by district
            sql = "SELECT * FROM rides WHERE target = %s"
            cursor.execute(sql, (target,))
            results = cursor.fetchall()
            if results:
                # Extract latitude and longitude from each row and store in a list
                locations = [{'driverName': row['driverName'],'target': row['target'],'plate': row['plate'],'latitude': row['latitude'], 'longitude': row['longitude']} for row in results]
                return jsonify({'data': locations})
            else:
                return jsonify({'error': 'No items found for the specified district'}), 404
    except Exception as e:
        return jsonify({'error': str(e)}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080) #It should be your localhost's socket instead of 8080.
