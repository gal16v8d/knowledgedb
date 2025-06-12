package com.gsdd.knowledgedb.domain;

import com.gsdd.knowledgedb.persistence.entity.enums.TicketTypeEnum;
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
public class TicketType {

  private UUID typeCode;
  private TicketTypeEnum name;
}
