package co.com.gsdd.bdconocimiento.servicio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.gsdd.bdconocimiento.convertidor.CasoConvertidor;
import co.com.gsdd.bdconocimiento.dominio.Caso;
import co.com.gsdd.bdconocimiento.persistencia.entidad.CasoEntidad;
import co.com.gsdd.bdconocimiento.persistencia.repositorio.ICasoRepositorio;
import co.com.gsdd.bdconocimiento.servicio.ICasoServicio;

@Service
public class CasoServicio implements ICasoServicio {

	/**
	 * Definici\u00F3n del modelo/repositorio
	 */
	@Autowired
	private ICasoRepositorio casoRepositorio;

	@Autowired
	private CasoConvertidor casoConvertidor;

	@Override
	public void agregar(Caso caso) {
		CasoEntidad ce = casoConvertidor.convertirAEntidad(caso);
		casoRepositorio.save(ce);
	}

	@Override
	public void actualizar(Caso caso) {
		CasoEntidad ce = casoConvertidor.convertirAEntidad(caso);
		casoRepositorio.save(ce);
	}

	@Override
	public void eliminarL(Long id) {
		casoRepositorio.findById(id).ifPresent((CasoEntidad entity) -> {
			entity.setEstado(false);
			casoRepositorio.save(entity);
		});
	}

	@Override
	public void eliminarF(Long id) {
		casoRepositorio.deleteById(id);
	}

	@Override
	public List<Caso> listar() {
		return casoRepositorio.findAll().stream().map(casoConvertidor::convertirADominio).collect(Collectors.toList());
	}

	@Override
	public List<Caso> listarActivos() {
		return casoRepositorio.findByEstado(true).stream().map(casoConvertidor::convertirADominio)
				.collect(Collectors.toList());
	}

	@Override
	public Caso obtener(Long id) {
		return casoRepositorio.findById(id).map(casoConvertidor::convertirADominio).orElse(null);
	}

}
