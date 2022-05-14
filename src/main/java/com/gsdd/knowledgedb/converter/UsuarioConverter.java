package com.gsdd.knowledgedb.converter;

import com.gsdd.knowledgedb.domain.Usuario;
import com.gsdd.knowledgedb.persistence.entity.UsuarioEntidad;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter implements GenericConverter<UsuarioEntidad, Usuario> {

  @Override
  public Usuario convertToDomain(UsuarioEntidad entidad) {
    return Optional.ofNullable(entidad).map(Usuario::new).orElse(null);
  }

  @Override
  public UsuarioEntidad convertToEntity(Usuario dominio) {
    return Optional.ofNullable(dominio).map(UsuarioEntidad::new).orElse(null);
  }
}
