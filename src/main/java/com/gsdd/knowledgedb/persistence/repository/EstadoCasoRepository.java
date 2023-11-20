package com.gsdd.knowledgedb.persistence.repository;

import com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface EstadoCasoRepository extends GenericRepository<EstadoCasoEntidad, Long> {}
