package co.com.gsdd.bdconocimiento.convertidor;

import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.gsdd.bdconocimiento.dominio.TipoCaso;
import co.com.gsdd.bdconocimiento.persistencia.entidad.TipoCasoEntidad;

@Component
public class TipoCasoConvertidor implements ConvertidorGenerico<TipoCasoEntidad, TipoCaso> {

	@Override
	public TipoCaso convertirADominio(TipoCasoEntidad entidad) {
		return Optional.ofNullable(entidad).map(TipoCaso::new).orElse(null);
	}

	@Override
	public TipoCasoEntidad convertirAEntidad(TipoCaso dominio) {
		return Optional.ofNullable(dominio).map(TipoCasoEntidad::new).orElse(null);
	}

}
