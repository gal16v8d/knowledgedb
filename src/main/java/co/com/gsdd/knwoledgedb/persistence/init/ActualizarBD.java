package co.com.gsdd.knwoledgedb.persistence.init;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import co.com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;
import co.com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;
import co.com.gsdd.knowledgedb.persistence.entity.enums.EstadoCasoEnum;
import co.com.gsdd.knowledgedb.persistence.entity.enums.TipoCasoEnum;
import co.com.gsdd.knowledgedb.persistence.repository.IEstadoCasoRepository;
import co.com.gsdd.knowledgedb.persistence.repository.ITipoCasoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ActualizarBD implements ApplicationRunner {

	private final ITipoCasoRepository tipoCasoRepository;
	private final IEstadoCasoRepository estadoCasoRepository;

	@Autowired
	public ActualizarBD(ITipoCasoRepository tipoCasoRepositorio, IEstadoCasoRepository estadoCasoRepositorio) {
		this.tipoCasoRepository = tipoCasoRepositorio;
		this.estadoCasoRepository = estadoCasoRepositorio;
	}

	@Override
	public void run(ApplicationArguments args) {
		AtomicLong contadorTipoCaso = new AtomicLong(1);
		Stream.of(TipoCasoEnum.values()).forEach((TipoCasoEnum tipoCaso) -> {
			verificarTipoCasoEnBD(contadorTipoCaso.get(), tipoCaso);
			contadorTipoCaso.addAndGet(1L);
		});
		AtomicLong contadorEstadoCaso = new AtomicLong(1);
		Stream.of(EstadoCasoEnum.values()).forEach((EstadoCasoEnum estadoCaso) -> {
			verificarEstadoCasoEnBD(contadorEstadoCaso.get(), estadoCaso);
			contadorEstadoCaso.addAndGet(1L);
		});
	}

	private void verificarTipoCasoEnBD(Long id, TipoCasoEnum valor) {
		if (tipoCasoRepository.findById(id).isPresent()) {
			log.debug("El tipoCaso {} ya existe en BD", valor);
		} else {
			TipoCasoEntidad tipoCaso = new TipoCasoEntidad();
			tipoCaso.setCodigoTipo(id);
			tipoCaso.setEstado(true);
			tipoCaso.setDescripcion(valor);
			tipoCasoRepository.save(tipoCaso);
		}
	}

	private void verificarEstadoCasoEnBD(Long id, EstadoCasoEnum valor) {
		if (estadoCasoRepository.findById(id).isPresent()) {
			log.debug("El estadoCaso {} ya existe en BD", valor);
		} else {
			EstadoCasoEntidad estadoCaso = new EstadoCasoEntidad();
			estadoCaso.setCodigoEstado(id);
			estadoCaso.setEstado(true);
			estadoCaso.setDescripcion(valor);
			estadoCasoRepository.save(estadoCaso);
		}
	}

}
