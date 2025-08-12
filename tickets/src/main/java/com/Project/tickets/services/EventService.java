package com.Project.tickets.services;


import com.Project.tickets.domain.CreateEventRequest;
import com.Project.tickets.domain.UpdateEventRequest;
import com.Project.tickets.domain.dtos.*;
import com.Project.tickets.domain.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface EventService {

    Event createEvent(UUID organizerId, CreateEventRequest event);

    @Transactional(readOnly = true)
    Page<ListEventResponseDto> listEventsForOrganizer(UUID organizerId, Pageable pageable);
//    @Transactional(readOnly = true)
    Optional<GetEventDetailsResponseDto> getEventForOrganizer(UUID organizerId, UUID id);

    UpdateEventResponseDto updateEventForOrganizer(UUID organizerId, UUID id, UpdateEventRequest event);

    void deleteEventForOrganizer(UUID organizerId, UUID eventId);

    Page<ListPublishedEventResponseDto> listPublishedEvents(Pageable pageable);

    Page<ListPublishedEventResponseDto> searchPublishedEvents(String query, Pageable pageable);

    Optional<GetPublishedEventDetailsResponseDto> getPublishedEvent(UUID id);
}
