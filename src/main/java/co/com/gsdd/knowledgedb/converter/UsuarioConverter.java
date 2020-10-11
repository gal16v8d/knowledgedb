package co.com.gsdd.knowledgedb.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.gsdd.knowledgedb.domain.Usuario;
import co.com.gsdd.knowledgedb.persistence.entity.UsuarioEntidad;

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
