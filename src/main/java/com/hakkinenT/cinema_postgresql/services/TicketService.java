package com.hakkinenT.cinema_postgresql.services;

import com.hakkinenT.cinema_postgresql.dto.TicketMaxDTO;
import com.hakkinenT.cinema_postgresql.projections.TicketProjection;
import com.hakkinenT.cinema_postgresql.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Transactional(readOnly = true)
    public List<TicketMaxDTO> findTicketByOrderId(int orderId){
        List<TicketProjection> ticketProjections = ticketRepository.searchTicketsByOrderId(orderId);
        return createTicketMaxDTOList(ticketProjections);
    }

    private List<TicketMaxDTO> createTicketMaxDTOList(List<TicketProjection> ticketProjections) {
        return ticketProjections.stream().map(TicketMaxDTO::new).toList();
    }
}
