CREATE TABLE tb_session(
	exhibition_date TIMESTAMP NOT NULL,
	ticket_full_value DECIMAL NOT NULL,
	ticket_half_value DECIMAL NOT NULL,
	session_closed BOOLEAN NOT NULL,
	room_number INTEGER NOT NULL,
	movie_id INTEGER NOT NULL,
	PRIMARY KEY(exhibition_date, room_number),
	FOREIGN KEY (room_number) REFERENCES tb_screening_room(room_number)
    		ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (movie_id) REFERENCES tb_movie(movie_id)
    		ON DELETE SET NULL ON UPDATE CASCADE
);