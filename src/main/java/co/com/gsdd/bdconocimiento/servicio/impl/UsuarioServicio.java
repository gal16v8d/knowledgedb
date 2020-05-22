package co.com.gsdd.bdconocimiento.servicio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.gsdd.bdconocimiento.convertidor.UsuarioConvertidor;
import co.com.gsdd.bdconocimiento.dominio.Usuario;
import co.com.gsdd.bdconocimiento.persistencia.entidad.UsuarioEntidad;
import co.com.gsdd.bdconocimiento.persistencia.repositorio.IUsuarioRepositorio;
import co.com.gsdd.bdconocimiento.servicio.IUsuarioServicio;

@Service
public class UsuarioServicio implements IUsuarioServicio {

	/**
	 * Definici\u00F3n del modelo/repositorio
	 */
	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;

	@Autowired
	private UsuarioConvertidor usuarioConvertidor;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void agregar(Usuario usuario) {
		usuarioRepositorio.save(usuarioConvertidor.convertirAEntidad(usuario));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actualizar(Usuario usuario) {
		usuarioRepositorio.save(usuarioConvertidor.convertirAEntidad(usuario));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eliminarL(Long id) {
		usuarioRepositorio.findById(id).ifPresent((UsuarioEntidad entidad) -> {
			entidad.setEstado(false);
			usuarioRepositorio.save(entidad);
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eliminarF(Long id) {
		usuarioRepositorio.deleteById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Usuario> listar() {
		return usuarioRepositorio.findAll().stream().map(usuarioConvertidor::convertirADominio)
				.collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Usuario> listarActivos() {
		return usuarioRepositorio.findByEstado(true).stream().map(usuarioConvertidor::convertirADominio)
				.collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Usuario obtener(Long id) {
		return usuarioConvertidor.convertirADominio(usuarioRepositorio.getOne(id));
	}

}
