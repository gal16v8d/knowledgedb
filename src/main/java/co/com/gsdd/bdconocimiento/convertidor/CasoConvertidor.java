package co.com.gsdd.bdconocimiento.convertidor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.gsdd.bdconocimiento.dominio.Caso;
import co.com.gsdd.bdconocimiento.persistencia.entidad.CasoEntidad;

@Component
public class CasoConvertidor implements ConvertidorGenerico<CasoEntidad, Caso> {

	@Autowired
	private UsuarioConvertidor usuarioConvertidor;

	@Override
	public Caso convertirADominio(CasoEntidad casoEntidad) {
		return Optional.ofNullable(casoEntidad).map((CasoEntidad entidad) -> {
			return new Caso(casoEntidad, usuarioConvertidor.convertirADominio(casoEntidad.getReportadoPor()),
					usuarioConvertidor.convertirADominio(casoEntidad.getResponsable()));
		}).orElse(null);
	}

	@Override
	public CasoEntidad convertirAEntidad(Caso caso) {
		return Optional.ofNullable(caso).map((Caso dominio) -> {
			return new CasoEntidad(dominio, usuarioConvertidor.convertirAEntidad(dominio.getReportadoPor()),
					usuarioConvertidor.convertirAEntidad(dominio.getResponsable()));
		}).orElse(null);
	}

}
