package com.gsdd.knowledgedb.persistence.repository;

import com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IEstadoCasoRepository extends GenericRepository<EstadoCasoEntidad, Long> {}
