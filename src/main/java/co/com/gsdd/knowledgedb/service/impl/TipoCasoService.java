package co.com.gsdd.knowledgedb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.gsdd.knowledgedb.converter.TipoCasoConverter;
import co.com.gsdd.knowledgedb.domain.TipoCaso;
import co.com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;
import co.com.gsdd.knowledgedb.persistence.repository.ITipoCasoRepository;
import co.com.gsdd.knowledgedb.service.ITipoCasoService;

@Service
public class TipoCasoService extends AbstractGenericService<TipoCasoEntidad, TipoCaso, Long>
		implements ITipoCasoService {

	@Autowired
	public TipoCasoService(ITipoCasoRepository tipoCasoRepository, TipoCasoConverter tipoCasoConverter) {
		super(tipoCasoRepository, tipoCasoConverter);
	}

}
