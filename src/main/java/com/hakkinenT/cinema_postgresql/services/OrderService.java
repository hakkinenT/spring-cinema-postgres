package com.hakkinenT.cinema_postgresql.services;

import com.hakkinenT.cinema_postgresql.dto.OrderDTO;
import com.hakkinenT.cinema_postgresql.dto.PaymentDTO;
import com.hakkinenT.cinema_postgresql.dto.SessionMinDTO;
import com.hakkinenT.cinema_postgresql.dto.TicketDTO;
import com.hakkinenT.cinema_postgresql.entities.*;
import com.hakkinenT.cinema_postgresql.enums.PaymentType;
import com.hakkinenT.cinema_postgresql.enums.TicketType;
import com.hakkinenT.cinema_postgresql.exceptions.customs.ResourceNotFoundException;
import com.hakkinenT.cinema_postgresql.repositories.OrderRepository;
import com.hakkinenT.cinema_postgresql.repositories.TicketRepository;
import com.hakkinenT.cinema_postgresql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TicketRepository ticketRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order();
        createOrder(dto, order);
        order = orderRepository.save(order);

        List<Ticket> tickets = createTicketList(dto.getTickets(), order);
        tickets = ticketRepository.saveAll(tickets);

        return new OrderDTO(order, tickets);
    }

    private void createOrder(OrderDTO dto, Order order){
        order.setMoment(Instant.now());

        Double total = calculateOrderTotal(dto);
        order.setTotal(total);

        User user = userRepository
                .findByEmail(dto.getUserEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));

        order.setUser(user);

        Payment payment = createPayment(dto.getPayment(), order);
        order.setPayment(payment);
    }

    private Double calculateOrderTotal(OrderDTO dto) {
        return dto.getTickets()
                .stream()
                .map(TicketDTO::getTicketValue)
                .reduce(0.0, Double::sum);
    }

    private Payment createPayment(PaymentDTO dto, Order order){
        Payment payment = new Payment();
        PaymentType type = PaymentType.valueOf(dto.getPaymentType());
        payment.setMoment(Instant.now());
        payment.setPaymentType(type);
        payment.setOrder(order);
        return payment;
    }

    private List<Ticket> createTicketList(List<TicketDTO> ticketsDTO, Order order){

        return ticketsDTO.stream().map(ticket -> createTicket(ticket, order)).toList();
    }

    private Ticket createTicket(TicketDTO ticketDTO, Order order) {
        Ticket ticket = new Ticket();
        ticket.setOrder(order);
        ticket.setCodeSeatTicket(ticketDTO.getCodeSeat());

        TicketType type = TicketType.valueOf(ticketDTO.getTicketType());
        ticket.setTicketType(type);

        ticket.setTicketValue(ticketDTO.getTicketValue());

        Session session = createSession(ticketDTO.getSession());

        ticket.setSession(session);
        return ticket;
    }

    private Session createSession(SessionMinDTO sessionDTO){
        Session session = new Session();

        ScreeningRoom room = createScreeningRoom(sessionDTO.getRoomNumber());
        session.setScreeningRoom(room);

        LocalDateTime exhibitionDate = createExhibitionDate(sessionDTO);
        session.setExhibitionDate(exhibitionDate);

        return session;

    }

    private ScreeningRoom createScreeningRoom(Integer roomNumber){
        ScreeningRoom room = new ScreeningRoom();
        room.setRoomNumber(roomNumber);

        return room;
    }

    private LocalDateTime createExhibitionDate(SessionMinDTO sessionDTO){
        return LocalDateTime.of(sessionDTO.getExhibitionDate(), sessionDTO.getExhibitionHour());
    }
}
