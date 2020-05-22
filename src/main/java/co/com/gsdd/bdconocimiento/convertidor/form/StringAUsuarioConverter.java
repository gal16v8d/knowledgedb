package co.com.gsdd.bdconocimiento.convertidor.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.com.gsdd.bdconocimiento.dominio.Usuario;
import co.com.gsdd.bdconocimiento.servicio.IUsuarioServicio;

@Component
public class StringAUsuarioConverter implements Converter<String, Usuario> {

    /**
     * Definici\u00F3n del servicio
     */
    @Autowired
    private IUsuarioServicio usuarioServicio;


    @Override
    public Usuario convert(String arg0) {
        return usuarioServicio.obtener(Long.valueOf(arg0));
    }

}
