package co.com.gsdd.knowledgedb.converter.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.com.gsdd.knowledgedb.domain.TipoCaso;
import co.com.gsdd.knowledgedb.service.ITipoCasoService;

@Component
public class StringToTipoCasoConverter implements Converter<String, TipoCaso> {

    private final ITipoCasoService tipoCasoService;
    
    @Autowired
    public StringToTipoCasoConverter(ITipoCasoService tipoCasoService) {
		this.tipoCasoService = tipoCasoService;
    }


    @Override
    public TipoCaso convert(String arg0) {
        return tipoCasoService.findById(Long.valueOf(arg0));
    }

}
