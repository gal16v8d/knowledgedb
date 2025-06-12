package com.gsdd.knowledgedb.persistence.entity;

import com.gsdd.knowledgedb.persistence.entity.common.AbstractEntity;
import com.gsdd.knowledgedb.persistence.entity.enums.TicketStatusEnum;
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
@Entity(name = "ticket_status")
public class TicketStatusEntity extends AbstractEntity {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @UuidGenerator
  @Column(nullable = false)
  private UUID statusCode;

  @Enumerated(EnumType.STRING)
  @Column(unique = true)
  private TicketStatusEnum name;
}
