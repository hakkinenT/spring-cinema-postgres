CREATE TABLE tb_movie(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
	title VARCHAR(255) NOT NULL,
	duration VARCHAR(8) NOT NULL,
	image_url VARCHAR(255) NOT NULL,
	synopsis TEXT NOT NULL,
	age_rating VARCHAR(255) NOT NULL,
	CONSTRAINT movie_pk
	    PRIMARY KEY(id)
);