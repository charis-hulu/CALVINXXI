import mysql.connector

class DB:

    def __init__(self):
        dbconfig = {
            'host': 'localhost',
            'user': 'root',
            'password': '',
            'database': 'calvinxxi'
        }
        self.conn = mysql.connector.connect(**dbconfig)
        self.cursor = self.conn.cursor()

    def get_all_movie(self):
        select_statement = """
        SELECT * FROM movie
        """
        self.cursor.execute(select_statement)
        all_movie = self.cursor.fetchall()
        return all_movie