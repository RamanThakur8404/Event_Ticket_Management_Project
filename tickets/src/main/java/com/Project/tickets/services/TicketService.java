package com.Project.tickets.services;

import com.Project.tickets.domain.dtos.GetTicketResponseDto;
import com.Project.tickets.domain.dtos.ListTicketResponseDto;
import com.Project.tickets.domain.entities.Ticket;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
  Page<ListTicketResponseDto> listTicketsForUser(UUID userId, Pageable pageable);

  Optional<GetTicketResponseDto> getTicketForUser(UUID userId, UUID ticketId);
}
