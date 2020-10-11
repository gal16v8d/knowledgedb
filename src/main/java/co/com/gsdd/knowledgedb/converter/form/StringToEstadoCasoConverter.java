package co.com.gsdd.knowledgedb.converter.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.com.gsdd.knowledgedb.domain.EstadoCaso;
import co.com.gsdd.knowledgedb.service.IEstadoCasoService;

@Component
public class StringToEstadoCasoConverter implements Converter<String, EstadoCaso> {

    private final IEstadoCasoService estadoCasoService;
    
    @Autowired
    public StringToEstadoCasoConverter(IEstadoCasoService estadoCasoService) {
		this.estadoCasoService = estadoCasoService;
    }

    @Override
    public EstadoCaso convert(String arg0) {
        return estadoCasoService.findById(Long.valueOf(arg0));
    }

}
