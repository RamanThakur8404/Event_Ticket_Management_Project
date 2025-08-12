package com.Project.tickets.Controller;

import com.Project.tickets.domain.CreateEventRequest;
import com.Project.tickets.domain.UpdateEventRequest;
import com.Project.tickets.domain.dtos.*;
import com.Project.tickets.domain.entities.Event;
import com.Project.tickets.mappers.EventMapper;
import com.Project.tickets.services.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final EventMapper eventMapper;
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<CreateEventRequestDto> createEvent(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateEventRequestDto createEventRequestDto){
//        convert Dto to domain object
        CreateEventRequest createEventRequest = eventMapper.fromDto(createEventRequestDto);
//        Extract user ID from JWT
        UUID userId = parseUserId(jwt);
//        Create the event
        Event createdEvent = eventService.createEvent(userId,createEventRequest);
//        Convert response to DTO
        CreateEventResponseDto createEventResponseDto = eventMapper.toDto(createdEvent);

        return new ResponseEntity<>(createEventRequestDto, HttpStatus.CREATED);
    }

        @PutMapping(path = "/{eventId}")
        public ResponseEntity<UpdateEventResponseDto> updateEvent(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID eventId,
            @Valid @RequestBody UpdateEventRequestDto updateEventRequestDto) {
        UpdateEventRequest updateEventRequest = eventMapper.fromDto(updateEventRequestDto);
        UUID userId = parseUserId(jwt);
        UpdateEventResponseDto updateEventResponseDto = eventService.updateEventForOrganizer(userId,eventId,updateEventRequest);

        return ResponseEntity.ok(updateEventResponseDto);
    }

        @GetMapping
                public ResponseEntity<Page<ListEventResponseDto>> listEvents(@AuthenticationPrincipal Jwt jwt, Pageable pageable){
            UUID userId = parseUserId(jwt);
            Page<ListEventResponseDto> eventDtoPage = eventService.listEventsForOrganizer(userId,pageable);
            return ResponseEntity.ok(eventDtoPage);
        }

        @GetMapping(path = "/{eventId}")
        public ResponseEntity<GetEventDetailsResponseDto> getEvent(
                @AuthenticationPrincipal Jwt jwt,
                @PathVariable UUID eventId){

            UUID userId  = parseUserId(jwt);

            return eventService.getEventForOrganizer(userId,eventId)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

    @DeleteMapping(path = "/{eventId}")
    public ResponseEntity<Void> deleteEvent(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID eventId){
        UUID userId = parseUserId(jwt);
        eventService.deleteEventForOrganizer(userId,eventId);
        return ResponseEntity.noContent().build();
    }


        private UUID parseUserId(Jwt jwt)
        {
        return  UUID.fromString(jwt.getSubject());
        }

}
