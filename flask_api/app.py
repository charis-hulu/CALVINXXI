from flask import Flask, jsonify
from database import DB

app = Flask(__name__)
univ_database = DB()
app.secret_key = "Super duper secret"

@app.route("/")
def home():
	all_movies = univ_database.get_all_movie()
	list_of_movies = []
	for movie_info in all_movies:
		print(movie_info)
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
	
	

app.run(debug=True)