package co.com.gsdd.bdconocimiento.convertidor;

import co.com.gsdd.bdconocimiento.persistencia.entidad.comun.AbstraccionEntidad;

public interface ConvertidorGenerico<T extends AbstraccionEntidad, D> {

	/**
	 * Convierte una entidad a dominio/modelo
	 * 
	 * @param entidad
	 * @return objeto de dominio
	 */
	D convertirADominio(T entidad);

	/**
	 * Convierte un objeto de dominio a entidad.
	 * 
	 * @param dominio
	 * @return entidad
	 */
	T convertirAEntidad(D dominio);

}
