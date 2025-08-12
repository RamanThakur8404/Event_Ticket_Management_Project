package com.Project.tickets.repositories;

import com.Project.tickets.domain.entities.Event;
import com.Project.tickets.domain.entities.EventStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {


   @Query("SELECT e FROM Event e LEFT JOIN FETCh e.ticketTypes WHERE e.organizer.id = :organizerId")
    Page<Event> findByOrganizerId(@Param("organizerId") UUID organizerId, Pageable pageable);
   @Query ("SELECT e FROM Event e LEFT JOIN FETCh e.ticketTypes WHERE e.id = :id AND e.organizer.id = :organizerId")
   Optional<Event> findByIdAndOrganizerId(@Param("id") UUID id, @Param("organizerId") UUID organizerId);
    Page<Event> findByStatus(EventStatusEnum status, Pageable pageable);

    @Query(value = "SELECT * FROM events WHERE " +
            "status = 'PUBLISHED' AND " +
            "MATCH(name, venue) AGAINST(:searchTerm IN NATURAL LANGUAGE MODE)",
            countQuery = "SELECT count(*) FROM events WHERE " +
                    "status = 'PUBLISHED' AND " +
                    "MATCH(name, venue) AGAINST(:searchTerm IN NATURAL LANGUAGE MODE)",
            nativeQuery = true)
    Page<Event> searchEvents(@Param("searchTerm") String searchTerm, Pageable pageable);

    Optional<Event> findByIdAndStatus(UUID id, EventStatusEnum status);

}
