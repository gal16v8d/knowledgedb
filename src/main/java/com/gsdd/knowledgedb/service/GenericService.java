package com.gsdd.knowledgedb.service;

import java.util.List;

public interface GenericService<D, ID> {

  List<D> listEnabled();

  D findById(ID id);
}
