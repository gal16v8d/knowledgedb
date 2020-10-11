package co.com.gsdd.knowledgedb.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.gsdd.knowledgedb.domain.Caso;
import co.com.gsdd.knowledgedb.persistence.entity.CasoEntidad;

@Component
public class CasoConverter implements GenericConverter<CasoEntidad, Caso> {

	private final UsuarioConverter usuarioConverter;
	
	@Autowired
	public CasoConverter(UsuarioConverter usuarioConvertidor) {
		this.usuarioConverter = usuarioConvertidor;
	}
	
	@Override
	public Caso convertToDomain(CasoEntidad casoEntidad) {
		return Optional.ofNullable(casoEntidad).map((CasoEntidad entidad) -> {
			return new Caso(casoEntidad, usuarioConverter.convertToDomain(casoEntidad.getReportadoPor()),
					usuarioConverter.convertToDomain(casoEntidad.getResponsable()));
		}).orElse(null);
	}

	@Override
	public CasoEntidad convertToEntity(Caso caso) {
		return Optional.ofNullable(caso).map((Caso dominio) -> {
			return new CasoEntidad(dominio, usuarioConverter.convertToEntity(dominio.getReportadoPor()),
					usuarioConverter.convertToEntity(dominio.getResponsable()));
		}).orElse(null);
	}

}
