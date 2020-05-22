package co.com.gsdd.bdconocimiento.servicio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.gsdd.bdconocimiento.convertidor.EstadoCasoConvertidor;
import co.com.gsdd.bdconocimiento.dominio.EstadoCaso;
import co.com.gsdd.bdconocimiento.persistencia.repositorio.IEstadoCasoRepositorio;
import co.com.gsdd.bdconocimiento.servicio.IEstadoCasoServicio;

@Service
public class EstadoCasoServicio implements IEstadoCasoServicio {

	/**
	 * Definici\u00F3n del modelo/repositorio
	 */
	@Autowired
	private IEstadoCasoRepositorio estadoCasoRepositorio;

	@Autowired
	private EstadoCasoConvertidor estadoCasoConvertidor;

	@Override
	public List<EstadoCaso> listarActivos() {
		return estadoCasoRepositorio.findByEstado(true).stream().map(estadoCasoConvertidor::convertirADominio)
				.collect(Collectors.toList());
	}

	@Override
	public EstadoCaso obtener(Long id) {
		return estadoCasoRepositorio.findById(id).map(estadoCasoConvertidor::convertirADominio).orElse(null);
	}

}
