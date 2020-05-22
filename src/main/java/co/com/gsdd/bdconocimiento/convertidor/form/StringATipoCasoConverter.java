package co.com.gsdd.bdconocimiento.convertidor.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.com.gsdd.bdconocimiento.dominio.TipoCaso;
import co.com.gsdd.bdconocimiento.servicio.ITipoCasoServicio;

@Component
public class StringATipoCasoConverter implements Converter<String, TipoCaso> {

    /**
     * Definici\u00F3n del servicio
     */
    @Autowired
    private ITipoCasoServicio tipoCasoServicio;


    @Override
    public TipoCaso convert(String arg0) {
        return tipoCasoServicio.obtener(Long.valueOf(arg0));
    }

}
