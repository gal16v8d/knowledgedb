package com.gsdd.knowledgedb.domain;

import com.gsdd.knowledgedb.persistence.entity.enums.TicketStatusEnum;
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
public class TicketStatus {

  private UUID statusCode;
  private TicketStatusEnum name;
}
