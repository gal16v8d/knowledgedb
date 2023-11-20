package com.gsdd.knowledgedb.converter.form;

import com.gsdd.knowledgedb.domain.TipoCaso;
import com.gsdd.knowledgedb.service.TipoCasoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StringToTipoCasoConverter implements Converter<String, TipoCaso> {

  private final TipoCasoService tipoCasoService;

  @Override
  public TipoCaso convert(String arg0) {
    return tipoCasoService.findById(Long.valueOf(arg0));
  }
}
