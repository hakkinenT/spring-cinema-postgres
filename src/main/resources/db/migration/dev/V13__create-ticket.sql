CREATE TABLE tb_ticket(
	code_seat_ticket VARCHAR(255) NOT NULL,
	ticket_type SMALLINT NOT NULL,
	exhibition_date TIMESTAMP NOT NULL,
	room_number INTEGER NOT NULL,
	order_id INTEGER NOT NULL,
	PRIMARY KEY(code_seat_ticket, exhibition_date, room_number),
	FOREIGN KEY (exhibition_date, room_number) REFERENCES tb_session(exhibition_date, room_number)
    		ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (order_id) REFERENCES tb_order(order_id)
        		ON DELETE SET NULL ON UPDATE CASCADE
);