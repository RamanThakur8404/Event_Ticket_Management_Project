package com.Project.tickets.domain.dtos;

import com.Project.tickets.domain.entities.TicketValidationMethodEnum;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketValidationRequestDto {
  private UUID id;
  private TicketValidationMethodEnum method;
}
