package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.converter.TipoCasoConverter;
import com.gsdd.knowledgedb.domain.TipoCaso;
import com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;
import com.gsdd.knowledgedb.persistence.repository.TipoCasoRepository;
import com.gsdd.knowledgedb.service.TipoCasoService;
import org.springframework.stereotype.Service;

@Service
public class TipoCasoServiceImpl extends AbstractGenericService<TipoCasoEntidad, TipoCaso, Long>
    implements TipoCasoService {

  public TipoCasoServiceImpl(
      TipoCasoRepository tipoCasoRepository, TipoCasoConverter tipoCasoConverter) {
    super(tipoCasoRepository, tipoCasoConverter);
  }
}
