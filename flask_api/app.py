from flask import Flask, jsonify, request
from database import DB
from flask_cors import CORS


app = Flask(__name__)
CORS(app)
movie_database = DB()
app.secret_key = "Super duper secret"

@app.route("/all")
def home():
	all_movies = movie_database.get_all_movie()
	list_of_movies = []
	for movie_info in all_movies:
		# print(movie_info)
		json_data = {
		"id": movie_info[0],
		"title" : movie_info[1],
		"genre" : movie_info[2],
		"duration" : movie_info[3],
		"url_trailer" : movie_info[4],
		"synopsis" : movie_info[5],
		"director" : movie_info[6],
		"cast" : movie_info[7],
		"status" : movie_info[8],
		"image" : movie_info[9]
 	}
		list_of_movies.append(json_data)
	return jsonify(list_of_movies)

@app.route("/details")
def details():
	movie_id = request.args.get('movie_id')
	all_movies = movie_database.get_movie_detail(movie_id)
	list_of_movies = []
	for movie_info in all_movies:
		# print(movie_info)
		json_data = {
		"id": movie_info[0],
		"title" : movie_info[1],
		"genre" : movie_info[2],
		"duration" : movie_info[3],
		"url_trailer" : movie_info[4],
		"synopsis" : movie_info[5],
		"director" : movie_info[6],
		"cast" : movie_info[7],
		"status" : movie_info[8],
		"image" : movie_info[9]
 	}
		list_of_movies.append(json_data)
	return jsonify(list_of_movies)

@app.route("/book")
def select_ticket():
	movie_id = request.args.get('movie_id')
	all_bookings = movie_database.get_ticket_bookings(movie_id)
	list_of_bookings = []
	for booking_info in all_bookings:
		bookings = {
		"title": booking_info[0],
		"duration": booking_info[1],
		"image": booking_info[2],
		"theatre_name": booking_info[3],
		"schedule": booking_info[4],
		"is_available": booking_info[5],
	}
		list_of_bookings.append(bookings)
	return jsonify(list_of_bookings)


app.run(debug=True, host="0.0.0.0")