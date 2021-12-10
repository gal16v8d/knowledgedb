package com.gsdd.knowledgedb.service;

import java.util.List;

public interface IGenericCRUDService<D, ID> extends IGenericService<D, ID> {

  D save(D data);

  D update(D data);

  void logicalDelete(ID id);

  void physicalDelete(ID id);

  List<D> findAll();
}
