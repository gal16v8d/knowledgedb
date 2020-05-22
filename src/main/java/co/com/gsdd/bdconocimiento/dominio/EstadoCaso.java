package co.com.gsdd.bdconocimiento.dominio;

import co.com.gsdd.bdconocimiento.persistencia.entidad.EstadoCasoEntidad;
import co.com.gsdd.bdconocimiento.persistencia.entidad.enums.EstadoCasoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EstadoCaso {

	private Long codigoEstado;
	private EstadoCasoEnum descripcion;

	public EstadoCaso(EstadoCasoEntidad estadoCasoEntidad) {
		this.codigoEstado = estadoCasoEntidad.getCodigoEstado();
		this.descripcion = estadoCasoEntidad.getDescripcion();
	}

}
