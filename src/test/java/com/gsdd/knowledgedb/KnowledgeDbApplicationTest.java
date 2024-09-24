package com.gsdd.knowledgedb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = KnowledgeDbApplication.class)
@ActiveProfiles("test")
class KnowledgeDbApplicationTest {

  @Test
  void contextLoads() {}
}
