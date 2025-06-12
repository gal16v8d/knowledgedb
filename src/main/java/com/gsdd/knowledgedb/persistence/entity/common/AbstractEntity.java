package com.gsdd.knowledgedb.persistence.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
public class AbstractEntity implements Serializable {

  @Serial private static final long serialVersionUID = 1256501001903199589L;

  @Column(name = "status", nullable = false)
  private Boolean status;

  @PrePersist
  public void prePersist() {
    log.debug("Saving...");
    statusCheck();
  }

  @PreUpdate
  public void preUpdate() {
    log.debug("Updating...");
    statusCheck();
  }

  private void statusCheck() {
    if (status == null) {
      status = true;
    }
  }
}
