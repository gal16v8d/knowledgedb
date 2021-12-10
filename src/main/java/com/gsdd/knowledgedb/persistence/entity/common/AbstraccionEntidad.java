package com.gsdd.knowledgedb.persistence.entity.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

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
