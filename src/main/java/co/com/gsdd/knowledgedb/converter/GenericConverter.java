package co.com.gsdd.knowledgedb.converter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import co.com.gsdd.knowledgedb.persistence.entity.common.AbstraccionEntidad;

public interface GenericConverter<T extends AbstraccionEntidad, D> {

	D convertToDomain(T entity);

	T convertToEntity(D domain);

	default List<D> listToDomain(List<T> entity) {
		return Optional.ofNullable(entity).orElseGet(Collections::emptyList).stream().map(this::convertToDomain)
				.collect(Collectors.toList());
	}

	default List<T> listToEntity(List<D> domain) {
		return Optional.ofNullable(domain).orElseGet(Collections::emptyList).stream().map(this::convertToEntity)
				.collect(Collectors.toList());
	}
}
