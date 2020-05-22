package co.com.gsdd.bdconocimiento.dominio;

import co.com.gsdd.bdconocimiento.persistencia.entidad.TipoCasoEntidad;
import co.com.gsdd.bdconocimiento.persistencia.entidad.enums.TipoCasoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TipoCaso {

	private Long codigoTipo;
	private TipoCasoEnum descripcion;

	public TipoCaso(TipoCasoEntidad entidad) {
		this.codigoTipo = entidad.getCodigoTipo();
		this.descripcion = entidad.getDescripcion();
	}

}
