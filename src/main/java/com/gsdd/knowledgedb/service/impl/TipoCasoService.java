package com.gsdd.knowledgedb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsdd.knowledgedb.converter.TipoCasoConverter;
import com.gsdd.knowledgedb.domain.TipoCaso;
import com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;
import com.gsdd.knowledgedb.persistence.repository.ITipoCasoRepository;
import com.gsdd.knowledgedb.service.ITipoCasoService;

@Service
public class TipoCasoService extends AbstractGenericService<TipoCasoEntidad, TipoCaso, Long>
    implements ITipoCasoService {

  @Autowired
  public TipoCasoService(ITipoCasoRepository tipoCasoRepository,
      TipoCasoConverter tipoCasoConverter) {
    super(tipoCasoRepository, tipoCasoConverter);
  }

}
