package co.com.gsdd.bdconocimiento.servicio;

import java.util.List;

import co.com.gsdd.bdconocimiento.dominio.TipoCaso;

public interface ITipoCasoServicio {

    /**
     * Permite obtener una lista de todos los tipos caso con estado activo en
     * BD.
     * 
     * @return
     */
    public List<TipoCaso> listarActivos();

    /**
     * Permite obtener el tipo caso mediante el id.
     * 
     * @param id
     * @return
     */
    public TipoCaso obtener(Long id);

}
