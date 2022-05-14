package com.gsdd.knowledgedb.converter;

import com.gsdd.knowledgedb.domain.EstadoCaso;
import com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class EstadoCasoConverter implements GenericConverter<EstadoCasoEntidad, EstadoCaso> {

  @Override
  public EstadoCaso convertToDomain(EstadoCasoEntidad entidad) {
    return Optional.ofNullable(entidad).map(EstadoCaso::new).orElse(null);
  }

  @Override
  public EstadoCasoEntidad convertToEntity(EstadoCaso dominio) {
    return Optional.ofNullable(dominio).map(EstadoCasoEntidad::new).orElse(null);
  }
}
