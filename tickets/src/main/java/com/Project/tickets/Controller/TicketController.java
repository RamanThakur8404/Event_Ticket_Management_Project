package com.Project.tickets.Controller;

import static com.Project.tickets.util.JwtUtil.parseUserId;

import com.Project.tickets.domain.dtos.GetTicketResponseDto;
import com.Project.tickets.domain.dtos.ListTicketResponseDto;
import com.Project.tickets.domain.entities.Ticket;
import com.Project.tickets.mappers.TicketMapper;
import com.Project.tickets.services.QrCodeService;
import com.Project.tickets.services.TicketService;
import java.time.Duration;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

  private final TicketService ticketService;
  private final TicketMapper ticketMapper;
  private final QrCodeService qrCodeService;

  @GetMapping
  public Page<ListTicketResponseDto> listTickets(
      @AuthenticationPrincipal Jwt jwt,
      Pageable pageable
  ) {
    return ticketService.listTicketsForUser(
        parseUserId(jwt),
        pageable
    );
  }

  @GetMapping(path = "/{ticketId}")
  public ResponseEntity<GetTicketResponseDto> getTicket(
      @AuthenticationPrincipal Jwt jwt,
      @PathVariable UUID ticketId
  ) {
    return ticketService
        .getTicketForUser(parseUserId(jwt), ticketId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping(path = "/{ticketId}/qr-codes")
  public ResponseEntity<byte[]> getTicketQrCode(
      @AuthenticationPrincipal Jwt jwt,
      @PathVariable UUID ticketId
  ) {
    byte[] qrCodeImage = qrCodeService.getQrCodeImageForUserAndTicket(
        parseUserId(jwt),
        ticketId
    );

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_PNG);
    headers.setContentLength(qrCodeImage.length);

    return ResponseEntity.ok()
        .headers(headers)
        .body(qrCodeImage);
  }

}
