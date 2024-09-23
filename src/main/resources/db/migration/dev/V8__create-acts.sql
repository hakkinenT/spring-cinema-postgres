CREATE TABLE tb_acts(
	movie_id INTEGER NOT NULL,
	actor_id INTEGER NOT NULL,
	actor_role VARCHAR(255) NOT NULL,
	CONSTRAINT acts_pk
	    PRIMARY KEY(movie_id, actor_id, actor_role),
	CONSTRAINT movie_fk
	    FOREIGN KEY (movie_id) REFERENCES tb_movie(id)
    		ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT actor_fk
        FOREIGN KEY (actor_id) REFERENCES tb_actor(id)
    		ON DELETE SET NULL ON UPDATE CASCADE
);