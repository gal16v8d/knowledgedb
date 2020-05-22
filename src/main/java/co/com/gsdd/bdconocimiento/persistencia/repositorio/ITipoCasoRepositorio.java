package co.com.gsdd.bdconocimiento.persistencia.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.gsdd.bdconocimiento.persistencia.entidad.TipoCasoEntidad;

@Repository
@Transactional
public interface ITipoCasoRepositorio extends JpaRepository<TipoCasoEntidad, Long> {

    List<TipoCasoEntidad> findByEstado(Boolean estado);

}
