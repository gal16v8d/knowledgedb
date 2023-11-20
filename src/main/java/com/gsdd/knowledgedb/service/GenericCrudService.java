package com.gsdd.knowledgedb.service;

import java.util.List;

public interface GenericCrudService<D, ID> extends GenericService<D, ID> {

  D save(D data);

  D update(D data);

  void logicalDelete(ID id);

  void physicalDelete(ID id);

  List<D> findAll();
}
