package com.gsdd.knowledgedb.persistence.entity;

import com.gsdd.knowledgedb.persistence.entity.common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "ticket")
public class TicketEntity extends AbstractEntity {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @UuidGenerator
  @Column(nullable = false)
  private UUID ticketCode;

  @Column(nullable = false, length = 32)
  private String summary;

  @Column(nullable = false, length = 512)
  private String description;

  @ManyToOne
  @JoinColumn(nullable = false)
  private TicketTypeEntity type;

  @ManyToOne
  @JoinColumn(nullable = false)
  private TicketStatusEntity ticketStatus;

  @ManyToOne
  @JoinColumn(nullable = false)
  private UserEntity reportedBy;

  @ManyToOne @JoinColumn private UserEntity assignee;

  @Column(length = 512)
  private String note;
}
