package com.Project.tickets.mappers;

import com.Project.tickets.domain.dtos.TicketValidationResponseDto;
import com.Project.tickets.domain.entities.Ticket;
import com.Project.tickets.domain.entities.TicketValidation;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-03T11:26:48+0530",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.50.v20250628-1110, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class TicketValidationMapperImpl implements TicketValidationMapper {

    @Override
    public TicketValidationResponseDto toTicketValidationResponseDto(TicketValidation ticketValidation) {
        if ( ticketValidation == null ) {
            return null;
        }

        TicketValidationResponseDto ticketValidationResponseDto = new TicketValidationResponseDto();

        ticketValidationResponseDto.setTicketId( ticketValidationTicketId( ticketValidation ) );
        ticketValidationResponseDto.setStatus( ticketValidation.getStatus() );

        return ticketValidationResponseDto;
    }

    private UUID ticketValidationTicketId(TicketValidation ticketValidation) {
        Ticket ticket = ticketValidation.getTicket();
        if ( ticket == null ) {
            return null;
        }
        return ticket.getId();
    }
}
