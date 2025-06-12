package com.gsdd.knowledgedb.persistence.entity;

import com.gsdd.knowledgedb.persistence.entity.common.AbstractEntity;
import com.gsdd.knowledgedb.persistence.entity.enums.TicketTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.io.Serial;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UuidGenerator;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ticket_type")
public class TicketTypeEntity extends AbstractEntity {

  @Serial private static final long serialVersionUID = -7835592396239156369L;

  @Id
  @UuidGenerator
  @Column(nullable = false)
  private UUID typeCode;

  @Enumerated(EnumType.STRING)
  @Column(unique = true)
  private TicketTypeEnum name;
}
