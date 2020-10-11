package co.com.gsdd.knowledgedb.converter.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.com.gsdd.knowledgedb.domain.Usuario;
import co.com.gsdd.knowledgedb.service.IUsuarioService;

@Component
public class StringToUsuarioConverter implements Converter<String, Usuario> {

    private final IUsuarioService usuarioService;
    
    @Autowired
    public StringToUsuarioConverter(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
    }

    @Override
    public Usuario convert(String arg0) {
        return usuarioService.findById(Long.valueOf(arg0));
    }

}
