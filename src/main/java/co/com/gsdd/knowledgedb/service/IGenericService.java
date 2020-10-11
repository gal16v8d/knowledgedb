package co.com.gsdd.knowledgedb.service;

import java.util.List;

public interface IGenericService<D, ID> {

	List<D> listEnabled();
	
	D findById(ID id);
	
}
