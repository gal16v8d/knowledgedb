package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.converter.CasoConverter;
import com.gsdd.knowledgedb.domain.Caso;
import com.gsdd.knowledgedb.persistence.entity.CasoEntidad;
import com.gsdd.knowledgedb.persistence.repository.ICasoRepository;
import com.gsdd.knowledgedb.service.ICasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasoService extends AbstractCRUDService<CasoEntidad, Caso, Long>
    implements ICasoService {

  @Autowired
  public CasoService(ICasoRepository casoRepository, CasoConverter casoConverter) {
    super(casoRepository, casoConverter);
  }
}
