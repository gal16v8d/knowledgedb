package co.com.gsdd.bdconocimiento.convertidor;

import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.gsdd.bdconocimiento.dominio.Usuario;
import co.com.gsdd.bdconocimiento.persistencia.entidad.UsuarioEntidad;

@Component
public class UsuarioConvertidor implements ConvertidorGenerico<UsuarioEntidad, Usuario> {

    @Override
    public Usuario convertirADominio(UsuarioEntidad entidad) {
    	return Optional.ofNullable(entidad).map(Usuario::new).orElse(null);
    }

    @Override
    public UsuarioEntidad convertirAEntidad(Usuario dominio) {
    	return Optional.ofNullable(dominio).map(UsuarioEntidad::new).orElse(null);
    }

}
