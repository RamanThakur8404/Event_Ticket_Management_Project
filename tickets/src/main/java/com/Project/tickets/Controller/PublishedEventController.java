package com.Project.tickets.Controller;

import com.Project.tickets.domain.dtos.GetPublishedEventDetailsResponseDto;
import com.Project.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.Project.tickets.domain.entities.Event;
import com.Project.tickets.mappers.EventMapper;
import com.Project.tickets.services.EventService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/published-events")
@RequiredArgsConstructor
public class PublishedEventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @GetMapping
    public ResponseEntity<Page<ListPublishedEventResponseDto>> listPublishedEvents(
            @RequestParam(required = false) String q,
            Pageable pageable) {

        Page<ListPublishedEventResponseDto> eventsDtoPage;
        if (null != q && !q.trim().isEmpty()) {
            eventsDtoPage = eventService.searchPublishedEvents(q, pageable);
        } else {
            eventsDtoPage = eventService.listPublishedEvents(pageable);
        }

        return ResponseEntity.ok(eventsDtoPage);
    }

    @GetMapping(path = "/{eventId}")
    public ResponseEntity<GetPublishedEventDetailsResponseDto> getPublishedEventDetails(
            @PathVariable UUID eventId
    ) {
        return eventService.getPublishedEvent(eventId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
