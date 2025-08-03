package com.Project.tickets.mappers;

import com.Project.tickets.domain.CreateEventRequest;
import com.Project.tickets.domain.CreateTicketTypeRequest;
import com.Project.tickets.domain.UpdateEventRequest;
import com.Project.tickets.domain.UpdateTicketTypeRequest;
import com.Project.tickets.domain.dtos.CreateEventRequestDto;
import com.Project.tickets.domain.dtos.CreateEventResponseDto;
import com.Project.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.Project.tickets.domain.dtos.CreateTicketTypeResponseDto;
import com.Project.tickets.domain.dtos.GetEventDetailsResponseDto;
import com.Project.tickets.domain.dtos.GetEventDetailsTicketTypesResponseDto;
import com.Project.tickets.domain.dtos.GetPublishedEventDetailsResponseDto;
import com.Project.tickets.domain.dtos.GetPublishedEventDetailsTicketTypesResponseDto;
import com.Project.tickets.domain.dtos.ListEventResponseDto;
import com.Project.tickets.domain.dtos.ListEventTicketTypeResponseDto;
import com.Project.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.Project.tickets.domain.dtos.UpdateEventRequestDto;
import com.Project.tickets.domain.dtos.UpdateEventResponseDto;
import com.Project.tickets.domain.dtos.UpdateTicketTypeRequestDto;
import com.Project.tickets.domain.dtos.UpdateTicketTypeResponseDto;
import com.Project.tickets.domain.entities.Event;
import com.Project.tickets.domain.entities.TicketType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-03T11:26:49+0530",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.50.v20250628-1110, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        CreateTicketTypeRequest createTicketTypeRequest = new CreateTicketTypeRequest();

        createTicketTypeRequest.setDescription( dto.getDescription() );
        createTicketTypeRequest.setName( dto.getName() );
        createTicketTypeRequest.setPrice( dto.getPrice() );
        createTicketTypeRequest.setTotalAvailable( dto.getTotalAvailable() );

        return createTicketTypeRequest;
    }

    @Override
    public CreateEventRequest fromDto(CreateEventRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        CreateEventRequest createEventRequest = new CreateEventRequest();

        createEventRequest.setEnd( dto.getEnd() );
        createEventRequest.setName( dto.getName() );
        createEventRequest.setSalesEnd( dto.getSalesEnd() );
        createEventRequest.setSalesStart( dto.getSalesStart() );
        createEventRequest.setStart( dto.getStart() );
        createEventRequest.setStatus( dto.getStatus() );
        createEventRequest.setTicketTypes( createTicketTypeRequestDtoListToCreateTicketTypeRequestList( dto.getTicketTypes() ) );
        createEventRequest.setVenue( dto.getVenue() );

        return createEventRequest;
    }

    @Override
    public CreateEventResponseDto toDto(Event event) {
        if ( event == null ) {
            return null;
        }

        CreateEventResponseDto createEventResponseDto = new CreateEventResponseDto();

        createEventResponseDto.setCreatedAt( event.getCreatedAt() );
        createEventResponseDto.setEnd( event.getEnd() );
        createEventResponseDto.setId( event.getId() );
        createEventResponseDto.setName( event.getName() );
        createEventResponseDto.setSalesEnd( event.getSalesEnd() );
        createEventResponseDto.setSalesStart( event.getSalesStart() );
        createEventResponseDto.setStart( event.getStart() );
        createEventResponseDto.setStatus( event.getStatus() );
        createEventResponseDto.setTicketTypes( ticketTypeListToCreateTicketTypeResponseDtoList( event.getTicketTypes() ) );
        createEventResponseDto.setUpdatedAt( event.getUpdatedAt() );
        createEventResponseDto.setVenue( event.getVenue() );

        return createEventResponseDto;
    }

    @Override
    public ListEventTicketTypeResponseDto toDto(TicketType ticketType) {
        if ( ticketType == null ) {
            return null;
        }

        ListEventTicketTypeResponseDto listEventTicketTypeResponseDto = new ListEventTicketTypeResponseDto();

        listEventTicketTypeResponseDto.setDescription( ticketType.getDescription() );
        listEventTicketTypeResponseDto.setId( ticketType.getId() );
        listEventTicketTypeResponseDto.setName( ticketType.getName() );
        listEventTicketTypeResponseDto.setPrice( ticketType.getPrice() );
        listEventTicketTypeResponseDto.setTotalAvailable( ticketType.getTotalAvailable() );

        return listEventTicketTypeResponseDto;
    }

    @Override
    public ListEventResponseDto toListEventResponseDto(Event event) {
        if ( event == null ) {
            return null;
        }

        ListEventResponseDto listEventResponseDto = new ListEventResponseDto();

        listEventResponseDto.setEnd( event.getEnd() );
        listEventResponseDto.setId( event.getId() );
        listEventResponseDto.setName( event.getName() );
        listEventResponseDto.setSalesEnd( event.getSalesEnd() );
        listEventResponseDto.setSalesStart( event.getSalesStart() );
        listEventResponseDto.setStart( event.getStart() );
        listEventResponseDto.setStatus( event.getStatus() );
        listEventResponseDto.setTicketTypes( ticketTypeListToListEventTicketTypeResponseDtoList( event.getTicketTypes() ) );
        listEventResponseDto.setVenue( event.getVenue() );

        return listEventResponseDto;
    }

    @Override
    public GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(TicketType ticketType) {
        if ( ticketType == null ) {
            return null;
        }

        GetEventDetailsTicketTypesResponseDto getEventDetailsTicketTypesResponseDto = new GetEventDetailsTicketTypesResponseDto();

        getEventDetailsTicketTypesResponseDto.setCreatedAt( ticketType.getCreatedAt() );
        getEventDetailsTicketTypesResponseDto.setDescription( ticketType.getDescription() );
        getEventDetailsTicketTypesResponseDto.setId( ticketType.getId() );
        getEventDetailsTicketTypesResponseDto.setName( ticketType.getName() );
        getEventDetailsTicketTypesResponseDto.setPrice( ticketType.getPrice() );
        getEventDetailsTicketTypesResponseDto.setTotalAvailable( ticketType.getTotalAvailable() );
        getEventDetailsTicketTypesResponseDto.setUpdatedAt( ticketType.getUpdatedAt() );

        return getEventDetailsTicketTypesResponseDto;
    }

    @Override
    public GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event) {
        if ( event == null ) {
            return null;
        }

        GetEventDetailsResponseDto getEventDetailsResponseDto = new GetEventDetailsResponseDto();

        getEventDetailsResponseDto.setCreatedAt( event.getCreatedAt() );
        getEventDetailsResponseDto.setEnd( event.getEnd() );
        getEventDetailsResponseDto.setId( event.getId() );
        getEventDetailsResponseDto.setName( event.getName() );
        getEventDetailsResponseDto.setSalesEnd( event.getSalesEnd() );
        getEventDetailsResponseDto.setSalesStart( event.getSalesStart() );
        getEventDetailsResponseDto.setStart( event.getStart() );
        getEventDetailsResponseDto.setStatus( event.getStatus() );
        getEventDetailsResponseDto.setTicketTypes( ticketTypeListToGetEventDetailsTicketTypesResponseDtoList( event.getTicketTypes() ) );
        getEventDetailsResponseDto.setUpdatedAt( event.getUpdatedAt() );
        getEventDetailsResponseDto.setVenue( event.getVenue() );

        return getEventDetailsResponseDto;
    }

    @Override
    public UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UpdateTicketTypeRequest updateTicketTypeRequest = new UpdateTicketTypeRequest();

        updateTicketTypeRequest.setDescription( dto.getDescription() );
        updateTicketTypeRequest.setId( dto.getId() );
        updateTicketTypeRequest.setName( dto.getName() );
        updateTicketTypeRequest.setPrice( dto.getPrice() );
        updateTicketTypeRequest.setTotalAvailable( dto.getTotalAvailable() );

        return updateTicketTypeRequest;
    }

    @Override
    public UpdateEventRequest fromDto(UpdateEventRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UpdateEventRequest updateEventRequest = new UpdateEventRequest();

        updateEventRequest.setEnd( dto.getEnd() );
        updateEventRequest.setId( dto.getId() );
        updateEventRequest.setName( dto.getName() );
        updateEventRequest.setSalesEnd( dto.getSalesEnd() );
        updateEventRequest.setSalesStart( dto.getSalesStart() );
        updateEventRequest.setStart( dto.getStart() );
        updateEventRequest.setStatus( dto.getStatus() );
        updateEventRequest.setTicketTypes( updateTicketTypeRequestDtoListToUpdateTicketTypeRequestList( dto.getTicketTypes() ) );
        updateEventRequest.setVenue( dto.getVenue() );

        return updateEventRequest;
    }

    @Override
    public UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType) {
        if ( ticketType == null ) {
            return null;
        }

        UpdateTicketTypeResponseDto updateTicketTypeResponseDto = new UpdateTicketTypeResponseDto();

        updateTicketTypeResponseDto.setCreatedAt( ticketType.getCreatedAt() );
        updateTicketTypeResponseDto.setDescription( ticketType.getDescription() );
        updateTicketTypeResponseDto.setId( ticketType.getId() );
        updateTicketTypeResponseDto.setName( ticketType.getName() );
        updateTicketTypeResponseDto.setPrice( ticketType.getPrice() );
        updateTicketTypeResponseDto.setTotalAvailable( ticketType.getTotalAvailable() );
        updateTicketTypeResponseDto.setUpdatedAt( ticketType.getUpdatedAt() );

        return updateTicketTypeResponseDto;
    }

    @Override
    public UpdateEventResponseDto toUpdateEventResponseDto(Event event) {
        if ( event == null ) {
            return null;
        }

        UpdateEventResponseDto updateEventResponseDto = new UpdateEventResponseDto();

        updateEventResponseDto.setEnd( event.getEnd() );
        updateEventResponseDto.setId( event.getId() );
        updateEventResponseDto.setName( event.getName() );
        updateEventResponseDto.setSalesEnd( event.getSalesEnd() );
        updateEventResponseDto.setSalesStart( event.getSalesStart() );
        updateEventResponseDto.setStart( event.getStart() );
        updateEventResponseDto.setStatus( event.getStatus() );
        updateEventResponseDto.setTicketTypes( ticketTypeListToUpdateTicketTypeResponseDtoList( event.getTicketTypes() ) );
        updateEventResponseDto.setVenue( event.getVenue() );

        return updateEventResponseDto;
    }

    @Override
    public ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event) {
        if ( event == null ) {
            return null;
        }

        ListPublishedEventResponseDto listPublishedEventResponseDto = new ListPublishedEventResponseDto();

        listPublishedEventResponseDto.setEnd( event.getEnd() );
        listPublishedEventResponseDto.setId( event.getId() );
        listPublishedEventResponseDto.setName( event.getName() );
        listPublishedEventResponseDto.setStart( event.getStart() );
        listPublishedEventResponseDto.setVenue( event.getVenue() );

        return listPublishedEventResponseDto;
    }

    @Override
    public GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(TicketType ticketType) {
        if ( ticketType == null ) {
            return null;
        }

        GetPublishedEventDetailsTicketTypesResponseDto getPublishedEventDetailsTicketTypesResponseDto = new GetPublishedEventDetailsTicketTypesResponseDto();

        getPublishedEventDetailsTicketTypesResponseDto.setDescription( ticketType.getDescription() );
        getPublishedEventDetailsTicketTypesResponseDto.setId( ticketType.getId() );
        getPublishedEventDetailsTicketTypesResponseDto.setName( ticketType.getName() );
        getPublishedEventDetailsTicketTypesResponseDto.setPrice( ticketType.getPrice() );

        return getPublishedEventDetailsTicketTypesResponseDto;
    }

    @Override
    public GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event) {
        if ( event == null ) {
            return null;
        }

        GetPublishedEventDetailsResponseDto getPublishedEventDetailsResponseDto = new GetPublishedEventDetailsResponseDto();

        getPublishedEventDetailsResponseDto.setEnd( event.getEnd() );
        getPublishedEventDetailsResponseDto.setId( event.getId() );
        getPublishedEventDetailsResponseDto.setName( event.getName() );
        getPublishedEventDetailsResponseDto.setStart( event.getStart() );
        getPublishedEventDetailsResponseDto.setTicketTypes( ticketTypeListToGetPublishedEventDetailsTicketTypesResponseDtoList( event.getTicketTypes() ) );
        getPublishedEventDetailsResponseDto.setVenue( event.getVenue() );

        return getPublishedEventDetailsResponseDto;
    }

    protected List<CreateTicketTypeRequest> createTicketTypeRequestDtoListToCreateTicketTypeRequestList(List<CreateTicketTypeRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CreateTicketTypeRequest> list1 = new ArrayList<CreateTicketTypeRequest>( list.size() );
        for ( CreateTicketTypeRequestDto createTicketTypeRequestDto : list ) {
            list1.add( fromDto( createTicketTypeRequestDto ) );
        }

        return list1;
    }

    protected CreateTicketTypeResponseDto ticketTypeToCreateTicketTypeResponseDto(TicketType ticketType) {
        if ( ticketType == null ) {
            return null;
        }

        CreateTicketTypeResponseDto createTicketTypeResponseDto = new CreateTicketTypeResponseDto();

        createTicketTypeResponseDto.setCreatedAt( ticketType.getCreatedAt() );
        createTicketTypeResponseDto.setDescription( ticketType.getDescription() );
        createTicketTypeResponseDto.setId( ticketType.getId() );
        createTicketTypeResponseDto.setName( ticketType.getName() );
        createTicketTypeResponseDto.setPrice( ticketType.getPrice() );
        createTicketTypeResponseDto.setTotalAvailable( ticketType.getTotalAvailable() );
        createTicketTypeResponseDto.setUpdatedAt( ticketType.getUpdatedAt() );

        return createTicketTypeResponseDto;
    }

    protected List<CreateTicketTypeResponseDto> ticketTypeListToCreateTicketTypeResponseDtoList(List<TicketType> list) {
        if ( list == null ) {
            return null;
        }

        List<CreateTicketTypeResponseDto> list1 = new ArrayList<CreateTicketTypeResponseDto>( list.size() );
        for ( TicketType ticketType : list ) {
            list1.add( ticketTypeToCreateTicketTypeResponseDto( ticketType ) );
        }

        return list1;
    }

    protected List<ListEventTicketTypeResponseDto> ticketTypeListToListEventTicketTypeResponseDtoList(List<TicketType> list) {
        if ( list == null ) {
            return null;
        }

        List<ListEventTicketTypeResponseDto> list1 = new ArrayList<ListEventTicketTypeResponseDto>( list.size() );
        for ( TicketType ticketType : list ) {
            list1.add( toDto( ticketType ) );
        }

        return list1;
    }

    protected List<GetEventDetailsTicketTypesResponseDto> ticketTypeListToGetEventDetailsTicketTypesResponseDtoList(List<TicketType> list) {
        if ( list == null ) {
            return null;
        }

        List<GetEventDetailsTicketTypesResponseDto> list1 = new ArrayList<GetEventDetailsTicketTypesResponseDto>( list.size() );
        for ( TicketType ticketType : list ) {
            list1.add( toGetEventDetailsTicketTypesResponseDto( ticketType ) );
        }

        return list1;
    }

    protected List<UpdateTicketTypeRequest> updateTicketTypeRequestDtoListToUpdateTicketTypeRequestList(List<UpdateTicketTypeRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<UpdateTicketTypeRequest> list1 = new ArrayList<UpdateTicketTypeRequest>( list.size() );
        for ( UpdateTicketTypeRequestDto updateTicketTypeRequestDto : list ) {
            list1.add( fromDto( updateTicketTypeRequestDto ) );
        }

        return list1;
    }

    protected List<UpdateTicketTypeResponseDto> ticketTypeListToUpdateTicketTypeResponseDtoList(List<TicketType> list) {
        if ( list == null ) {
            return null;
        }

        List<UpdateTicketTypeResponseDto> list1 = new ArrayList<UpdateTicketTypeResponseDto>( list.size() );
        for ( TicketType ticketType : list ) {
            list1.add( toUpdateTicketTypeResponseDto( ticketType ) );
        }

        return list1;
    }

    protected List<GetPublishedEventDetailsTicketTypesResponseDto> ticketTypeListToGetPublishedEventDetailsTicketTypesResponseDtoList(List<TicketType> list) {
        if ( list == null ) {
            return null;
        }

        List<GetPublishedEventDetailsTicketTypesResponseDto> list1 = new ArrayList<GetPublishedEventDetailsTicketTypesResponseDto>( list.size() );
        for ( TicketType ticketType : list ) {
            list1.add( toGetPublishedEventDetailsTicketTypesResponseDto( ticketType ) );
        }

        return list1;
    }
}
