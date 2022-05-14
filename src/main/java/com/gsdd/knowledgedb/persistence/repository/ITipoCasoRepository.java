package com.gsdd.knowledgedb.persistence.repository;

import com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ITipoCasoRepository extends GenericRepository<TipoCasoEntidad, Long> {}
