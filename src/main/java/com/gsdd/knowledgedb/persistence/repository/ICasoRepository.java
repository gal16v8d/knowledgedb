package com.gsdd.knowledgedb.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gsdd.knowledgedb.persistence.entity.CasoEntidad;

@Repository
@Transactional
public interface ICasoRepository extends GenericRepository<CasoEntidad, Long> {

}
