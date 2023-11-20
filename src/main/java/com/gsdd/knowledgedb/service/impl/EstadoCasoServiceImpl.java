package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.converter.EstadoCasoConverter;
import com.gsdd.knowledgedb.domain.EstadoCaso;
import com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;
import com.gsdd.knowledgedb.persistence.repository.EstadoCasoRepository;
import com.gsdd.knowledgedb.service.EstadoCasoService;
import org.springframework.stereotype.Service;

@Service
public class EstadoCasoServiceImpl
    extends AbstractGenericService<EstadoCasoEntidad, EstadoCaso, Long>
    implements EstadoCasoService {

  public EstadoCasoServiceImpl(
      EstadoCasoRepository estadoCasoRepositorio, EstadoCasoConverter estadoCasoConvertidor) {
    super(estadoCasoRepositorio, estadoCasoConvertidor);
  }
}
