package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.converter.UsuarioConverter;
import com.gsdd.knowledgedb.domain.Usuario;
import com.gsdd.knowledgedb.persistence.entity.UsuarioEntidad;
import com.gsdd.knowledgedb.persistence.repository.UsuarioRepository;
import com.gsdd.knowledgedb.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends AbstractCrudService<UsuarioEntidad, Usuario, Long>
    implements UsuarioService {

  public UsuarioServiceImpl(
      UsuarioRepository usuarioRepository, UsuarioConverter usuarioConverter) {
    super(usuarioRepository, usuarioConverter);
  }
}
