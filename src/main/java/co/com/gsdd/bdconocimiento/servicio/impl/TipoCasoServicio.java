package co.com.gsdd.bdconocimiento.servicio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.gsdd.bdconocimiento.convertidor.TipoCasoConvertidor;
import co.com.gsdd.bdconocimiento.dominio.TipoCaso;
import co.com.gsdd.bdconocimiento.persistencia.repositorio.ITipoCasoRepositorio;
import co.com.gsdd.bdconocimiento.servicio.ITipoCasoServicio;

@Service
public class TipoCasoServicio implements ITipoCasoServicio {

	/**
	 * Definici\u00F3n del modelo/repositorio
	 */
	@Autowired
	private ITipoCasoRepositorio tipoCasoRepositorio;

	@Autowired
	private TipoCasoConvertidor tipoCasoConvertidor;

	@Override
	public List<TipoCaso> listarActivos() {
		return tipoCasoRepositorio.findByEstado(true).stream().map(tipoCasoConvertidor::convertirADominio)
				.collect(Collectors.toList());
	}

	@Override
	public TipoCaso obtener(Long id) {
		return tipoCasoRepositorio.findById(id).map(tipoCasoConvertidor::convertirADominio).orElse(null);
	}

}
