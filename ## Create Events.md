## Create Events
Post /api/v1/events
Request Body: Event

## List Events 
GET /api/v1/events

## Retrieve Event
GET /api/v1/events/{event_id}

## Update Event 
PUT /api/v1/events/{event_id}
Request Body:Event

## Delete Event
DELETE /api/v1/events/{event_id}

## Validate Ticket
POST /api/v1/events/{event_id}/ticket-validations

## List Ticket Validation
GET /api/v1/events/{event_id}/ticket-validations

## List Ticket Sales
GET /api/v1/events/{event_id}/tickets
  
## Retrieve Ticket Sale
GET /api/v1/events/{event_id}/tickets/tickets/{ticket_id}

## Partially Update Ticket
PUT /api/v1/events/{event_id}/tickets
Request Body:Partial Event
 
 ## List Ticket Type 
 GET /api/v1/events/{event_id}/ticket-types/{Ticket_type_id}

 ##  Retrieve Ticket Type
 GET /api/v1/events/{event_id}/ticket-types/{ticket_type_id}

 ## Delete Ticket Type
 DELETE /api/v1/events/{event_id}/ticket-types/{ticket_type_id}

 ## Partial Update Ticket Type
 PATCH GET /api/v1/events/{event_id}/ticket_types/{ticket_type_id}
 Request Body:
 Partial Ticket Type

 ## Search Published Events
 GET /api/v1/published-events

 ## Retrieve Published Events
 GET /api/v1/published-events/{published_event_id} 

 ## Purchase Ticket
 POST /api/v1/published-event/{published_event_id}/ticket-types/{ticket_types_id}

 ## List Tickets (for user)
 GET /api/v1/tickets

 ## Retrieve Ticket(For user)
 GET /api/v1/tickets/{ticket_id}

 ## Retrieve Ticket QR code
 GET /api/v1/tickets/{ticket_id}/qr-codes


  ## TODO: Dedicated endpoint for report data
 