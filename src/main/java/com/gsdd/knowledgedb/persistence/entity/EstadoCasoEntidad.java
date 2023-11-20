package com.gsdd.knowledgedb.persistence.entity;

import com.gsdd.knowledgedb.domain.EstadoCaso;
import com.gsdd.knowledgedb.persistence.entity.common.AbstraccionEntidad;
import com.gsdd.knowledgedb.persistence.entity.enums.EstadoCasoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "EstadoCaso")
public class EstadoCasoEntidad extends AbstraccionEntidad {

  private static final long serialVersionUID = 1L;

  @Id
  @GenericGenerator(
      name = "codigoEstGen",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "estado_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
      })
  @GeneratedValue(generator = "codigoEstGen")
  @Column(name = "codigoestado", nullable = false)
  private Long codigoEstado;

  @Enumerated(EnumType.STRING)
  @Column(name = "estadocaso", unique = true)
  private EstadoCasoEnum descripcion;

  public EstadoCasoEntidad(EstadoCaso estadoCaso) {
    this.codigoEstado = estadoCaso.getCodigoEstado();
    this.descripcion = estadoCaso.getDescripcion();
  }
}
