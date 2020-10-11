package co.com.gsdd.knowledgedb.domain;

import co.com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;
import co.com.gsdd.knowledgedb.persistence.entity.enums.EstadoCasoEnum;
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
