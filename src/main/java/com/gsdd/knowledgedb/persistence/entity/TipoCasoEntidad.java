package com.gsdd.knowledgedb.persistence.entity;

import com.gsdd.knowledgedb.domain.TipoCaso;
import com.gsdd.knowledgedb.persistence.entity.common.AbstraccionEntidad;
import com.gsdd.knowledgedb.persistence.entity.enums.TipoCasoEnum;
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
@Entity(name = "TipoCaso")
public class TipoCasoEntidad extends AbstraccionEntidad {

  private static final long serialVersionUID = -7835592396239156369L;

  @Id
  @GenericGenerator(
      name = "codigoTipoGen",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "tipo_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
      })
  @GeneratedValue(generator = "codigoTipoGen")
  @Column(name = "codigotipo", nullable = false)
  private Long codigoTipo;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipocaso", unique = true)
  private TipoCasoEnum descripcion;

  public TipoCasoEntidad(TipoCaso tipoCaso) {
    this.codigoTipo = tipoCaso.getCodigoTipo();
    this.descripcion = tipoCaso.getDescripcion();
  }
}
