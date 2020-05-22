package co.com.gsdd.bdconocimiento.servicio;

import java.util.List;

import co.com.gsdd.bdconocimiento.dominio.Caso;

 public interface ICasoServicio {

	/**
	 * Permite agregar un caso mediante POST.
	 * 
	 * @param caso
	 */
	 void agregar(Caso caso);

	/**
	 * Permite actualizar un caso mediante POST.
	 * 
	 * @param caso
	 */
	 void actualizar(Caso caso);

	/**
	 * Permite eliminar(l\u00F3gico) un caso mediante POST.
	 * 
	 * @param id
	 */
	 void eliminarL(Long id);

	/**
	 * Permite eliminar(f\u00EDsico) un caso mediante POST.
	 * 
	 * @param usuario
	 */
	 void eliminarF(Long id);

	/**
	 * Permite obtener una lista de todos los casos disponibles en BD.
	 * 
	 * @return
	 */
	 List<Caso> listar();

	/**
	 * Permite obtener una lista de todos los casos con estado activo en BD.
	 * 
	 * @return
	 */
	 List<Caso> listarActivos();

	/**
	 * Permite obtener el caso mediante el id.
	 * 
	 * @param id
	 * @return
	 */
	 Caso obtener(Long id);

}
