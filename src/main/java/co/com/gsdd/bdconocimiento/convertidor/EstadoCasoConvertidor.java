package co.com.gsdd.bdconocimiento.convertidor;

import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.gsdd.bdconocimiento.dominio.EstadoCaso;
import co.com.gsdd.bdconocimiento.persistencia.entidad.EstadoCasoEntidad;

@Component
public class EstadoCasoConvertidor implements ConvertidorGenerico<EstadoCasoEntidad, EstadoCaso> {

	@Override
	public EstadoCaso convertirADominio(EstadoCasoEntidad entidad) {
		return Optional.ofNullable(entidad).map(EstadoCaso::new).orElse(null);
	}

	@Override
	public EstadoCasoEntidad convertirAEntidad(EstadoCaso dominio) {
		return Optional.ofNullable(dominio).map(EstadoCasoEntidad::new).orElse(null);
	}

}
