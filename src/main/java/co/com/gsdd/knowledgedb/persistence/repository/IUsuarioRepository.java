package co.com.gsdd.knowledgedb.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.com.gsdd.knowledgedb.persistence.entity.UsuarioEntidad;

@Repository
@Transactional
public interface IUsuarioRepository extends GenericRepository<UsuarioEntidad, Long> {

}
