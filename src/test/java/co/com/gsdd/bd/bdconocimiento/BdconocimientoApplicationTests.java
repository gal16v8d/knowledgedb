package co.com.gsdd.bd.bdconocimiento;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import co.com.gsdd.knowledgedb.KnowledgeDBApplication;

@SpringBootTest(classes = KnowledgeDBApplication.class)
@ActiveProfiles("test")
public class BdconocimientoApplicationTests {

	@Test
	public void contextLoads() {

	}

}
