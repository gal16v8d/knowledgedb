package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.converter.UsuarioConverter;
import com.gsdd.knowledgedb.domain.Usuario;
import com.gsdd.knowledgedb.persistence.entity.UsuarioEntidad;
import com.gsdd.knowledgedb.persistence.repository.IUsuarioRepository;
import com.gsdd.knowledgedb.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends AbstractCRUDService<UsuarioEntidad, Usuario, Long>
    implements IUsuarioService {

  @Autowired
  public UsuarioService(IUsuarioRepository usuarioRepository, UsuarioConverter usuarioConverter) {
    super(usuarioRepository, usuarioConverter);
  }
}
