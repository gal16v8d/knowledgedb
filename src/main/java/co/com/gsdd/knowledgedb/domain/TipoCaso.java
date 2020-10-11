package co.com.gsdd.knowledgedb.domain;

import co.com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;
import co.com.gsdd.knowledgedb.persistence.entity.enums.TipoCasoEnum;
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
