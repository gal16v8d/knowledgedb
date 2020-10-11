package co.com.gsdd.knowledgedb.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import co.com.gsdd.knowledgedb.domain.EstadoCaso;
import co.com.gsdd.knowledgedb.persistence.entity.common.AbstraccionEntidad;
import co.com.gsdd.knowledgedb.persistence.entity.enums.EstadoCasoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "EstadoCaso")
public class EstadoCasoEntidad extends AbstraccionEntidad {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "codigoEstGen", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "estado_sequence"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "codigoEstGen")
	@Column(name = "codigoestado", nullable = false)
	private Long codigoEstado;

	@Enumerated(EnumType.STRING)
	@Column(name = "estadocaso", unique = true)
	private EstadoCasoEnum descripcion;
	
	public EstadoCasoEntidad(EstadoCaso estadoCaso) {
		this.codigoEstado = estadoCaso.getCodigoEstado();
		this.descripcion = estadoCaso.getDescripcion();
	}

}
