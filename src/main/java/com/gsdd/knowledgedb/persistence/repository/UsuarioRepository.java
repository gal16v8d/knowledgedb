package com.gsdd.knowledgedb.persistence.repository;

import com.gsdd.knowledgedb.persistence.entity.UsuarioEntidad;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UsuarioRepository extends GenericRepository<UsuarioEntidad, Long> {}
