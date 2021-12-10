package com.gsdd.knowledgedb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.gsdd.knowledgedb.converter.GenericConverter;
import com.gsdd.knowledgedb.persistence.entity.common.AbstraccionEntidad;
import com.gsdd.knowledgedb.persistence.repository.GenericRepository;
import com.gsdd.knowledgedb.service.IGenericCRUDService;

public abstract class AbstractCRUDService<T extends AbstraccionEntidad, D, ID>
    extends AbstractGenericService<T, D, ID> implements IGenericCRUDService<D, ID> {

  protected AbstractCRUDService(GenericRepository<T, ID> repository,
      GenericConverter<T, D> converter) {
    super(repository, converter);
  }

  @Override
  public D save(D data) {
    T entity = getConverter().convertToEntity(data);
    return getConverter().convertToDomain(getRepository().save(entity));
  }

  @Override
  public D update(D data) {
    return save(data);
  }

  @Override
  public void logicalDelete(ID id) {
    getRepository().findById(id).ifPresent((T entity) -> {
      entity.setEstado(false);
      getRepository().save(entity);
    });
  }

  @Override
  public void physicalDelete(ID id) {
    getRepository().deleteById(id);
  }

  @Override
  public List<D> findAll() {
    return getRepository().findAll().stream().map(getConverter()::convertToDomain)
        .collect(Collectors.toList());
  }

}
