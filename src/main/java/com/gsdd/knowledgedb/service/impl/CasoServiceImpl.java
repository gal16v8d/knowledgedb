package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.converter.CasoConverter;
import com.gsdd.knowledgedb.domain.Caso;
import com.gsdd.knowledgedb.persistence.entity.CasoEntidad;
import com.gsdd.knowledgedb.persistence.repository.CasoRepository;
import com.gsdd.knowledgedb.service.CasoService;
import org.springframework.stereotype.Service;

@Service
public class CasoServiceImpl extends AbstractCrudService<CasoEntidad, Caso, Long>
    implements CasoService {

  public CasoServiceImpl(CasoRepository casoRepository, CasoConverter casoConverter) {
    super(casoRepository, casoConverter);
  }
}
