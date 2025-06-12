package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.mappers.GenericMapper;
import com.gsdd.knowledgedb.persistence.entity.common.AbstractEntity;
import com.gsdd.knowledgedb.persistence.repository.GenericRepository;
import com.gsdd.knowledgedb.service.GenericCrudService;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractCrudService<T extends AbstractEntity, D, ID>
    extends AbstractGenericService<T, D, ID> implements GenericCrudService<D, ID> {

  protected AbstractCrudService(GenericRepository<T, ID> repository, GenericMapper<T, D> mapper) {
    super(repository, mapper);
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
    getRepository()
        .findById(id)
        .ifPresent(
            (T entity) -> {
              entity.setStatus(false);
              getRepository().save(entity);
            });
  }

  @Override
  public void physicalDelete(ID id) {
    getRepository().deleteById(id);
  }

  @Override
  public List<D> findAll() {
    return getRepository().findAll().stream()
        .map(getConverter()::convertToDomain)
        .collect(Collectors.toList());
  }
}
