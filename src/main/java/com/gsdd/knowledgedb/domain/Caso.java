package com.gsdd.knowledgedb.domain;

import java.util.Date;

import com.gsdd.knowledgedb.persistence.entity.CasoEntidad;
import com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;
import com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Caso {

  private Long codigoCaso;
  private String resumen;
  private String descripcion;
  private Date fechaReporte;
  private Date fechaActualizacion;
  private TipoCasoEntidad tipoCaso;
  private EstadoCasoEntidad estadoCaso;
  private Usuario reportadoPor;
  private Usuario responsable;
  private String nota;

  public Caso(CasoEntidad casoEntidad, Usuario reportadoPor, Usuario responsable) {
    this.codigoCaso = casoEntidad.getCodigoCaso();
    this.descripcion = casoEntidad.getDescripcion();
    this.estadoCaso = casoEntidad.getEstadoCaso();
    this.nota = casoEntidad.getNota();
    this.reportadoPor = reportadoPor;
    this.responsable = responsable;
    this.resumen = casoEntidad.getResumen();
    this.tipoCaso = casoEntidad.getTipoCaso();
  }

}
