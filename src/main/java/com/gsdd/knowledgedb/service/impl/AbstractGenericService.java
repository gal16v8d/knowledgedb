package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.converter.GenericConverter;
import com.gsdd.knowledgedb.persistence.entity.common.AbstraccionEntidad;
import com.gsdd.knowledgedb.persistence.repository.GenericRepository;
import com.gsdd.knowledgedb.service.IGenericService;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class AbstractGenericService<T extends AbstraccionEntidad, D, ID>
    implements IGenericService<D, ID> {

  private final GenericRepository<T, ID> repository;
  private final GenericConverter<T, D> converter;

  @Override
  public List<D> listEnabled() {
    return getConverter().listToDomain(getRepository().findByEstado(true));
  }

  @Override
  public D findById(ID id) {
    return getRepository().findById(id).map(getConverter()::convertToDomain).orElse(null);
  }
}
