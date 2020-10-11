package co.com.gsdd.knowledgedb.converter;

import co.com.gsdd.knowledgedb.persistence.entity.common.AbstraccionEntidad;

public interface GenericConverter<T extends AbstraccionEntidad, D> {

	/**
	 * Convierte una entidad a dominio/modelo
	 * 
	 * @param entidad
	 * @return objeto de dominio
	 */
	D convertToDomain(T entidad);

	/**
	 * Convierte un objeto de dominio a entidad.
	 * 
	 * @param dominio
	 * @return entidad
	 */
	T convertToEntity(D dominio);

}
