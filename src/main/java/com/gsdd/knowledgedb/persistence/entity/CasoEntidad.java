package com.gsdd.knowledgedb.persistence.entity;

import com.gsdd.knowledgedb.domain.Caso;
import com.gsdd.knowledgedb.persistence.entity.common.AbstraccionEntidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Caso")
public class CasoEntidad extends AbstraccionEntidad {

  private static final long serialVersionUID = 1L;

  @Id
  @GenericGenerator(
      name = "codigoCasoGen",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "caso_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
      })
  @GeneratedValue(generator = "codigoCasoGen")
  @Column(name = "codigocaso", nullable = false)
  private Long codigoCaso;

  @Column(name = "resumen", nullable = false, length = 32)
  private String resumen;

  @Column(name = "descripcion", nullable = false, length = 512)
  private String descripcion;

  @ManyToOne
  @JoinColumn(name = "tipocaso", nullable = false)
  private TipoCasoEntidad tipoCaso;

  @ManyToOne
  @JoinColumn(name = "estadocaso", nullable = false)
  private EstadoCasoEntidad estadoCaso;

  @ManyToOne
  @JoinColumn(name = "reportadopor", nullable = false)
  private UsuarioEntidad reportadoPor;

  @ManyToOne
  @JoinColumn(name = "responsable", nullable = true)
  private UsuarioEntidad responsable;

  @Column(name = "nota", nullable = true, length = 512)
  private String nota;

  public CasoEntidad(Caso caso, UsuarioEntidad reportadoPor, UsuarioEntidad responsable) {
    this.codigoCaso = caso.getCodigoCaso();
    this.descripcion = caso.getDescripcion();
    this.estadoCaso = caso.getEstadoCaso();
    this.nota = caso.getNota();
    this.reportadoPor = reportadoPor;
    this.responsable = responsable;
    this.resumen = caso.getResumen();
    this.tipoCaso = caso.getTipoCaso();
  }
}
