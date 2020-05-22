package co.com.gsdd.bdconocimiento.convertidor.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.com.gsdd.bdconocimiento.dominio.EstadoCaso;
import co.com.gsdd.bdconocimiento.servicio.IEstadoCasoServicio;

@Component
public class StringAEstadoCasoConverter implements Converter<String, EstadoCaso> {

    /**
     * Definici\u00F3n del servicio
     */
    @Autowired
    private IEstadoCasoServicio estadoCasoServicio;


    @Override
    public EstadoCaso convert(String arg0) {
        return estadoCasoServicio.obtener(Long.valueOf(arg0));
    }

}
