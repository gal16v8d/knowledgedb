package com.gsdd.knowledgedb.persistence.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
// TODO sequence not found for some reason after update libs
@Disabled
class IUsuarioRepositoryTest {

  @Autowired private IUsuarioRepository usuarioRepositorio;

  @Test
  void testFindByEstado() {
    // given
    // when
    Long conteo = usuarioRepositorio.count();
    // then
    Assertions.assertEquals(0, conteo);
  }
}
