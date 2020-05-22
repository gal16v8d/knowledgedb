package co.com.gsdd.bdconocimiento.persistencia.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.gsdd.bdconocimiento.persistencia.entidad.CasoEntidad;

@Repository
@Transactional
public interface ICasoRepositorio extends JpaRepository<CasoEntidad, Long> {

	List<CasoEntidad> findByEstado(Boolean estado);
	
}
