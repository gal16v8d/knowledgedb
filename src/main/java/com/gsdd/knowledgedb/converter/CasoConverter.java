package com.gsdd.knowledgedb.converter;

import com.gsdd.knowledgedb.domain.Caso;
import com.gsdd.knowledgedb.persistence.entity.CasoEntidad;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CasoConverter implements GenericConverter<CasoEntidad, Caso> {

  private final UsuarioConverter usuarioConverter;

  @Override
  public Caso convertToDomain(CasoEntidad casoEntidad) {
    return Optional.ofNullable(casoEntidad)
        .map(
            (CasoEntidad entidad) ->
                new Caso(
                    casoEntidad,
                    usuarioConverter.convertToDomain(casoEntidad.getReportadoPor()),
                    usuarioConverter.convertToDomain(casoEntidad.getResponsable())))
        .orElse(null);
  }

  @Override
  public CasoEntidad convertToEntity(Caso caso) {
    return Optional.ofNullable(caso)
        .map(
            (Caso dominio) ->
                new CasoEntidad(
                    dominio,
                    usuarioConverter.convertToEntity(dominio.getReportadoPor()),
                    usuarioConverter.convertToEntity(dominio.getResponsable())))
        .orElse(null);
  }
}
