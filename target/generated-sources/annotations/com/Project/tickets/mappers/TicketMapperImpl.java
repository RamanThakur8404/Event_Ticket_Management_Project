package com.Project.tickets.mappers;

import com.Project.tickets.domain.dtos.GetTicketResponseDto;
import com.Project.tickets.domain.dtos.ListTicketResponseDto;
import com.Project.tickets.domain.dtos.ListTicketTicketTypeResponseDto;
import com.Project.tickets.domain.entities.Event;
import com.Project.tickets.domain.entities.Ticket;
import com.Project.tickets.domain.entities.TicketType;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-03T11:26:48+0530",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.50.v20250628-1110, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class TicketMapperImpl implements TicketMapper {

    @Override
    public ListTicketTicketTypeResponseDto toListTicketTicketTypeResponseDto(TicketType ticketType) {
        if ( ticketType == null ) {
            return null;
        }

        ListTicketTicketTypeResponseDto listTicketTicketTypeResponseDto = new ListTicketTicketTypeResponseDto();

        listTicketTicketTypeResponseDto.setId( ticketType.getId() );
        listTicketTicketTypeResponseDto.setName( ticketType.getName() );
        listTicketTicketTypeResponseDto.setPrice( ticketType.getPrice() );

        return listTicketTicketTypeResponseDto;
    }

    @Override
    public ListTicketResponseDto toListTicketResponseDto(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }

        ListTicketResponseDto listTicketResponseDto = new ListTicketResponseDto();

        listTicketResponseDto.setId( ticket.getId() );
        listTicketResponseDto.setStatus( ticket.getStatus() );
        listTicketResponseDto.setTicketType( toListTicketTicketTypeResponseDto( ticket.getTicketType() ) );

        return listTicketResponseDto;
    }

    @Override
    public GetTicketResponseDto toGetTicketResponseDto(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }

        GetTicketResponseDto getTicketResponseDto = new GetTicketResponseDto();

        getTicketResponseDto.setPrice( ticketTicketTypePrice( ticket ) );
        getTicketResponseDto.setDescription( ticketTicketTypeDescription( ticket ) );
        getTicketResponseDto.setEventName( ticketTicketTypeEventName( ticket ) );
        getTicketResponseDto.setEventVenue( ticketTicketTypeEventVenue( ticket ) );
        getTicketResponseDto.setEventStart( ticketTicketTypeEventStart( ticket ) );
        getTicketResponseDto.setEventEnd( ticketTicketTypeEventEnd( ticket ) );
        getTicketResponseDto.setId( ticket.getId() );
        getTicketResponseDto.setStatus( ticket.getStatus() );

        return getTicketResponseDto;
    }

    private Double ticketTicketTypePrice(Ticket ticket) {
        TicketType ticketType = ticket.getTicketType();
        if ( ticketType == null ) {
            return null;
        }
        return ticketType.getPrice();
    }

    private String ticketTicketTypeDescription(Ticket ticket) {
        TicketType ticketType = ticket.getTicketType();
        if ( ticketType == null ) {
            return null;
        }
        return ticketType.getDescription();
    }

    private String ticketTicketTypeEventName(Ticket ticket) {
        TicketType ticketType = ticket.getTicketType();
        if ( ticketType == null ) {
            return null;
        }
        Event event = ticketType.getEvent();
        if ( event == null ) {
            return null;
        }
        return event.getName();
    }

    private String ticketTicketTypeEventVenue(Ticket ticket) {
        TicketType ticketType = ticket.getTicketType();
        if ( ticketType == null ) {
            return null;
        }
        Event event = ticketType.getEvent();
        if ( event == null ) {
            return null;
        }
        return event.getVenue();
    }

    private LocalDateTime ticketTicketTypeEventStart(Ticket ticket) {
        TicketType ticketType = ticket.getTicketType();
        if ( ticketType == null ) {
            return null;
        }
        Event event = ticketType.getEvent();
        if ( event == null ) {
            return null;
        }
        return event.getStart();
    }

    private LocalDateTime ticketTicketTypeEventEnd(Ticket ticket) {
        TicketType ticketType = ticket.getTicketType();
        if ( ticketType == null ) {
            return null;
        }
        Event event = ticketType.getEvent();
        if ( event == null ) {
            return null;
        }
        return event.getEnd();
    }
}
