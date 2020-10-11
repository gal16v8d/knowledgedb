package co.com.gsdd.knowledgedb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.gsdd.knowledgedb.converter.UsuarioConverter;
import co.com.gsdd.knowledgedb.domain.Usuario;
import co.com.gsdd.knowledgedb.persistence.entity.UsuarioEntidad;
import co.com.gsdd.knowledgedb.persistence.repository.IUsuarioRepository;
import co.com.gsdd.knowledgedb.service.IUsuarioService;

@Service
public class UsuarioService extends AbstractCRUDService<UsuarioEntidad, Usuario, Long> implements IUsuarioService {

	@Autowired
	public UsuarioService(IUsuarioRepository usuarioRepository, UsuarioConverter usuarioConverter) {
		super(usuarioRepository, usuarioConverter);
	}

}
