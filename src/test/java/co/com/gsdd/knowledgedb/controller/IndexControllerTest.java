package co.com.gsdd.knowledgedb.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import co.com.gsdd.knowledgedb.constants.ServiceConstants;

public class IndexControllerTest {

	@Test
	public void debeRetornarLaPaginaIndexTest() {
		Assertions.assertEquals(ServiceConstants.INDEX, new IndexController().index(null));
	}

}
