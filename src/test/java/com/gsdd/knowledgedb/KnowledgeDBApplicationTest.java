package com.gsdd.knowledgedb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = KnowledgeDBApplication.class)
@ActiveProfiles("test")
class KnowledgeDBApplicationTest {

  @Test
  void contextLoads() {}
}
