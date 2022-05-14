package com.gsdd.knowledgedb.converter;

import com.gsdd.knowledgedb.domain.TipoCaso;
import com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TipoCasoConverter implements GenericConverter<TipoCasoEntidad, TipoCaso> {

  @Override
  public TipoCaso convertToDomain(TipoCasoEntidad entidad) {
    return Optional.ofNullable(entidad).map(TipoCaso::new).orElse(null);
  }

  @Override
  public TipoCasoEntidad convertToEntity(TipoCaso dominio) {
    return Optional.ofNullable(dominio).map(TipoCasoEntidad::new).orElse(null);
  }
}
