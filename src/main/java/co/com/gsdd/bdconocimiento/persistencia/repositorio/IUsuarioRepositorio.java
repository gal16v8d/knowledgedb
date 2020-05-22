package co.com.gsdd.bdconocimiento.persistencia.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.gsdd.bdconocimiento.persistencia.entidad.UsuarioEntidad;

@Repository
@Transactional
public interface IUsuarioRepositorio extends JpaRepository<UsuarioEntidad, Long> {

	List<UsuarioEntidad> findByEstado(Boolean estado);

}
