CREATE TABLE tb_movie_gender(
	movie_id INTEGER NOT NULL,
	gender_id INTEGER NOT NULL,
	CONSTRAINT movie_gender_pk PRIMARY KEY(movie_id, gender_id),
	CONSTRAINT movie_fk FOREIGN KEY (movie_id) REFERENCES tb_movie(id)
    		ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT gender_fk FOREIGN KEY (gender_id) REFERENCES tb_gender(id)
    		ON DELETE SET NULL ON UPDATE CASCADE
);