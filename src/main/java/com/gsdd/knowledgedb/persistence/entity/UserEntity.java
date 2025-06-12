package com.gsdd.knowledgedb.persistence.entity;

import com.gsdd.knowledgedb.persistence.entity.common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity(name = "db_user")
public class UserEntity extends AbstractEntity {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @UuidGenerator
  @Column(nullable = false)
  private UUID userCode;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false, unique = true)
  private String alias;

  @Column(nullable = false)
  private String password;
}
