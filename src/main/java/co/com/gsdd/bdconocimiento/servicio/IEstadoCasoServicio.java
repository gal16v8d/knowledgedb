package co.com.gsdd.bdconocimiento.servicio;

import java.util.List;

import co.com.gsdd.bdconocimiento.dominio.EstadoCaso;

public interface IEstadoCasoServicio {

    /**
     * Permite obtener una lista de todos los estado caso con estado activo en
     * BD.
     * 
     * @return
     */
    List<EstadoCaso> listarActivos();

    /**
     * Permite obtener el estado caso mediante el id.
     * 
     * @param id
     * @return
     */
    EstadoCaso obtener(Long id);

}
