package com.gsdd.knowledgedb.persistence.repository;

import com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TipoCasoRepository extends GenericRepository<TipoCasoEntidad, Long> {}
