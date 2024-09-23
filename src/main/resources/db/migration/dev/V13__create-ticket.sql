CREATE TABLE tb_ticket(
	code_seat VARCHAR(255) NOT NULL,
	ticket_type SMALLINT NOT NULL,
	ticket_value DECIMAL NOT NULL,
	exhibition_date TIMESTAMP NOT NULL,
	room_number INTEGER NOT NULL,
	order_id INTEGER NOT NULL,
	CONSTRAINT ticket_pk
	    PRIMARY KEY(code_seat, exhibition_date, room_number),
	CONSTRAINT session_fk
	    FOREIGN KEY (exhibition_date, room_number) REFERENCES tb_session(exhibition_date, room_number)
    		ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT order_fk
        FOREIGN KEY (order_id) REFERENCES tb_order(id)
        		ON DELETE SET NULL ON UPDATE CASCADE
);