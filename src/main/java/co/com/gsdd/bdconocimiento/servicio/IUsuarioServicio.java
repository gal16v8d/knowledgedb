package co.com.gsdd.bdconocimiento.servicio;

import java.util.List;

import co.com.gsdd.bdconocimiento.dominio.Usuario;

public interface IUsuarioServicio {

	/**
	 * Permite agregar un usuario mediante POST.
	 * 
	 * @param usuario
	 */
	 void agregar(Usuario usuario);

	/**
	 * Permite actualizar un usuario mediante POST.
	 * 
	 * @param usuario
	 */
	 void actualizar(Usuario usuario);

	/**
	 * Permite eliminar(l\u00F3gico) un usuario mediante POST.
	 * 
	 * @param id
	 */
	 void eliminarL(Long id);

	/**
	 * Permite eliminar(f\u00EDsico) un usuario mediante POST.
	 * 
	 * @param usuario
	 */
	 void eliminarF(Long id);

	/**
	 * Permite obtener una lista de todos los usuarios disponibles en BD.
	 * 
	 * @return
	 */
	 List<Usuario> listar();

	/**
	 * Permite obtener una lista de todos los usuarios con estado activo en BD.
	 * 
	 * @return
	 */
	 List<Usuario> listarActivos();

	/**
	 * Permite obtener el usuario mediante el id.
	 * 
	 * @param id
	 * @return
	 */
	 Usuario obtener(Long id);

}
