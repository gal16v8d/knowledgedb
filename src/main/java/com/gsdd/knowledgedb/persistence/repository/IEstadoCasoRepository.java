package com.gsdd.knowledgedb.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;

@Repository
@Transactional
public interface IEstadoCasoRepository extends GenericRepository<EstadoCasoEntidad, Long> {

}
