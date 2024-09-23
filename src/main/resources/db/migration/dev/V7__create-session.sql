CREATE TABLE tb_session(
	exhibition_date TIMESTAMP NOT NULL,
	ticket_full_value DECIMAL NOT NULL,
	ticket_half_value DECIMAL NOT NULL,
	session_closed BOOLEAN NOT NULL,
	room_number INTEGER NOT NULL,
	movie_id INTEGER NOT NULL,
	CONSTRAINT session_pk
	    PRIMARY KEY(exhibition_date, room_number),
	CONSTRAINT screening_room_fk
	    FOREIGN KEY (room_number) REFERENCES tb_screening_room(room_number)
    		ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT movie_fk FOREIGN KEY (movie_id) REFERENCES tb_movie(id)
    		ON DELETE SET NULL ON UPDATE CASCADE
);