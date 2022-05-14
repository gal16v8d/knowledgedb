package com.gsdd.knowledgedb.controller;

import com.gsdd.knowledgedb.constants.ServiceConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IndexControllerTest {

  @Test
  void testShouldGetIndexPage() {
    Assertions.assertEquals(ServiceConstants.INDEX, new IndexController().index(null));
  }
}
