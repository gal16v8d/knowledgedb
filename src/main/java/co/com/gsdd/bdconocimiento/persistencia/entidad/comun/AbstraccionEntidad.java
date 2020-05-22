package co.com.gsdd.bdconocimiento.persistencia.entidad.comun;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@MappedSuperclass
public class AbstraccionEntidad implements Serializable {

	/**
	 * Constante de serializaci\u00F3n.
	 */
	private static final long serialVersionUID = 1256501001903199589L;

	/**
	 * Versi\u00F3n para el optimistic lock.
	 */

	@Column(name = "estado", nullable = false)
	private Boolean estado;

	/**
	 * Se ejecuta justo antes de persistir.
	 */
	@PrePersist
	public void prePersist() {
		log.debug("Guardando...");
		verificarEstado();
	}

	/**
	 * Se ejecuta justo antes de actualizar.
	 */
	@PreUpdate
	public void preUpdate() {
		log.debug("Actualizando...");
		verificarEstado();
	}
	
	private void verificarEstado() {
		if (estado == null) {
			estado = true;
		}
	}

}
