CREATE TABLE tb_movie_gender(
	movie_id INTEGER NOT NULL,
	gender_id INTEGER NOT NULL,
	PRIMARY KEY(movie_id, gender_id),
	FOREIGN KEY (movie_id) REFERENCES tb_movie(movie_id)
    		ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (gender_id) REFERENCES tb_gender(gender_id)
    		ON DELETE SET NULL ON UPDATE CASCADE
);