package co.com.gsdd.knowledgedb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.gsdd.knowledgedb.converter.CasoConverter;
import co.com.gsdd.knowledgedb.domain.Caso;
import co.com.gsdd.knowledgedb.persistence.entity.CasoEntidad;
import co.com.gsdd.knowledgedb.persistence.repository.ICasoRepository;
import co.com.gsdd.knowledgedb.service.ICasoService;

@Service
public class CasoService extends AbstractCRUDService<CasoEntidad, Caso, Long> implements ICasoService {

	@Autowired
	public CasoService(ICasoRepository casoRepository, CasoConverter casoConverter) {
		super(casoRepository, casoConverter);
	}

}
