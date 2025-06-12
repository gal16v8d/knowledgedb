package com.gsdd.knowledgedb.domain;

import com.gsdd.knowledgedb.persistence.entity.TicketStatusEntity;
import com.gsdd.knowledgedb.persistence.entity.TicketTypeEntity;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {

  private UUID ticketCode;
  private String summary;
  private String description;
  private TicketTypeEntity type;
  private TicketStatusEntity ticketStatus;
  private User reportedBy;
  private User assignee;
  private String note;
}
