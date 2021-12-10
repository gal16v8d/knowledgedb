package com.gsdd.knowledgedb.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.gsdd.knowledgedb.constants.ServiceConstants;

class IndexControllerTest {

  @Test
  void testShouldGetIndexPage() {
    Assertions.assertEquals(ServiceConstants.INDEX, new IndexController().index(null));
  }

}
