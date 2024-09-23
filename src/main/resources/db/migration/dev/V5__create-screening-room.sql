CREATE TABLE tb_screening_room(
	room_number INTEGER NOT NULL,
	capacity INTEGER NOT NULL,
	CONSTRAINT screening_room_pk
	    PRIMARY KEY(room_number)
);