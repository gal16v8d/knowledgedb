package com.gsdd.knowledgedb.persistence.repository;

import com.gsdd.knowledgedb.persistence.entity.UsuarioEntidad;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IUsuarioRepository extends GenericRepository<UsuarioEntidad, Long> {}
