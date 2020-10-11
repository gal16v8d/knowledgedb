package co.com.gsdd.knowledgedb.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;

@Repository
@Transactional
public interface ITipoCasoRepository extends GenericRepository<TipoCasoEntidad, Long> {

}
