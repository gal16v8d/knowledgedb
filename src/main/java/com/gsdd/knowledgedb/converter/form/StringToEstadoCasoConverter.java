package com.gsdd.knowledgedb.converter.form;

import com.gsdd.knowledgedb.domain.EstadoCaso;
import com.gsdd.knowledgedb.service.IEstadoCasoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StringToEstadoCasoConverter implements Converter<String, EstadoCaso> {

  private final IEstadoCasoService estadoCasoService;

  @Override
  public EstadoCaso convert(String arg0) {
    return estadoCasoService.findById(Long.valueOf(arg0));
  }
}
