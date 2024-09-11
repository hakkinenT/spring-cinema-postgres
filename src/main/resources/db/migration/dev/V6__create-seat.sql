CREATE TABLE tb_seat(
	code_seat VARCHAR(255) NOT NULL,
	room_number INTEGER NOT NULL,
	PRIMARY KEY(code_seat, room_number),
	FOREIGN KEY (room_number) REFERENCES tb_screening_room(room_number)
			ON DELETE SET NULL ON UPDATE CASCADE
);