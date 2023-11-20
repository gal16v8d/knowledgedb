package com.gsdd.knowledgedb.persistence.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@MappedSuperclass
public class AbstraccionEntidad implements Serializable {

  private static final long serialVersionUID = 1256501001903199589L;

  @Column(name = "estado", nullable = false)
  private Boolean estado;

  @PrePersist
  public void prePersist() {
    log.debug("Guardando...");
    verificarEstado();
  }

  @PreUpdate
  public void preUpdate() {
    log.debug("Actualizando...");
    verificarEstado();
  }

  private void verificarEstado() {
    if (estado == null) {
      estado = true;
    }
  }
}
