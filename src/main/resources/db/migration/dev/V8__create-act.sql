CREATE TABLE tb_act(
	movie_id INTEGER NOT NULL,
	actor_id INTEGER NOT NULL,
	actor_role VARCHAR(255) NOT NULL,
	PRIMARY KEY(movie_id, actor_id, actor_role),
	FOREIGN KEY (movie_id) REFERENCES tb_movie(movie_id)
    		ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (actor_id) REFERENCES tb_actor(actor_id)
    		ON DELETE SET NULL ON UPDATE CASCADE
);