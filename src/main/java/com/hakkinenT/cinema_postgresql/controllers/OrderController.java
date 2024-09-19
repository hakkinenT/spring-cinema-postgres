package com.hakkinenT.cinema_postgresql.controllers;

import com.hakkinenT.cinema_postgresql.dto.OrderDTO;
import com.hakkinenT.cinema_postgresql.dto.TicketMaxDTO;
import com.hakkinenT.cinema_postgresql.services.OrderService;
import com.hakkinenT.cinema_postgresql.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){
        dto = orderService.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}/tickets")
    public ResponseEntity<List<TicketMaxDTO>> findTicketsByOrderId(@PathVariable int id){
        List<TicketMaxDTO> tickets = ticketService.findTicketByOrderId(id);
        return ResponseEntity.ok(tickets);
    }
}
