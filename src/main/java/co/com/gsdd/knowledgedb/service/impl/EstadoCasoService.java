package co.com.gsdd.knowledgedb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.gsdd.knowledgedb.converter.EstadoCasoConverter;
import co.com.gsdd.knowledgedb.domain.EstadoCaso;
import co.com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;
import co.com.gsdd.knowledgedb.persistence.repository.IEstadoCasoRepository;
import co.com.gsdd.knowledgedb.service.IEstadoCasoService;

@Service
public class EstadoCasoService extends AbstractGenericService<EstadoCasoEntidad, EstadoCaso, Long>
		implements IEstadoCasoService {

	@Autowired
	public EstadoCasoService(IEstadoCasoRepository estadoCasoRepositorio, EstadoCasoConverter estadoCasoConvertidor) {
		super(estadoCasoRepositorio, estadoCasoConvertidor);
	}

}
