package co.com.gsdd.knowledgedb.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.gsdd.knowledgedb.domain.TipoCaso;
import co.com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;

@Component
public class TipoCasoConverter implements GenericConverter<TipoCasoEntidad, TipoCaso> {

	@Override
	public TipoCaso convertToDomain(TipoCasoEntidad entidad) {
		return Optional.ofNullable(entidad).map(TipoCaso::new).orElse(null);
	}

	@Override
	public TipoCasoEntidad convertToEntity(TipoCaso dominio) {
		return Optional.ofNullable(dominio).map(TipoCasoEntidad::new).orElse(null);
	}

}
