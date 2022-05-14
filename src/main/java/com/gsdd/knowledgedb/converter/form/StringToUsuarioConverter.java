package com.gsdd.knowledgedb.converter.form;

import com.gsdd.knowledgedb.domain.Usuario;
import com.gsdd.knowledgedb.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StringToUsuarioConverter implements Converter<String, Usuario> {

  private final IUsuarioService usuarioService;

  @Override
  public Usuario convert(String arg0) {
    return usuarioService.findById(Long.valueOf(arg0));
  }
}
