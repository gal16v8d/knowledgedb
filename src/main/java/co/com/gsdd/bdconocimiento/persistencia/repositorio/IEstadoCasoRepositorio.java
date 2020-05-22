package co.com.gsdd.bdconocimiento.persistencia.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.gsdd.bdconocimiento.persistencia.entidad.EstadoCasoEntidad;

@Repository
@Transactional
public interface IEstadoCasoRepositorio extends JpaRepository<EstadoCasoEntidad, Long> {

    List<EstadoCasoEntidad> findByEstado(Boolean estado);

}
