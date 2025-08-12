package com.Project.tickets.services.impl;

import com.Project.tickets.domain.dtos.GetTicketResponseDto;
import com.Project.tickets.domain.dtos.ListTicketResponseDto;
import com.Project.tickets.domain.entities.Ticket;
import com.Project.tickets.mappers.TicketMapper;
import com.Project.tickets.repositories.TicketRepository;
import com.Project.tickets.services.TicketService;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

  private final TicketRepository ticketRepository;
  private final TicketMapper ticketMapper;

  @Override
  @Transactional(readOnly = true)
  public Page<ListTicketResponseDto> listTicketsForUser(UUID userId, Pageable pageable) {
    return ticketRepository.findByPurchaserId(userId, pageable)
            .map(ticketMapper::toListTicketResponseDto);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<GetTicketResponseDto> getTicketForUser(UUID userId, UUID ticketId) {
    return ticketRepository.findByIdAndPurchaserId(ticketId, userId)
            .map(ticketMapper::toGetTicketResponseDto);
  }
}
