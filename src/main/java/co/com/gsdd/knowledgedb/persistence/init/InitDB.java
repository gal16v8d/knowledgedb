package co.com.gsdd.knowledgedb.persistence.init;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import co.com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;
import co.com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;
import co.com.gsdd.knowledgedb.persistence.entity.enums.EstadoCasoEnum;
import co.com.gsdd.knowledgedb.persistence.entity.enums.TipoCasoEnum;
import co.com.gsdd.knowledgedb.persistence.repository.IEstadoCasoRepository;
import co.com.gsdd.knowledgedb.persistence.repository.ITipoCasoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class InitDB implements ApplicationRunner {

	private final ITipoCasoRepository tipoCasoRepository;
	private final IEstadoCasoRepository estadoCasoRepository;

	@Override
	public void run(ApplicationArguments args) {
		AtomicLong countTipoCaso = new AtomicLong(1);
		Stream.of(TipoCasoEnum.values()).forEach((TipoCasoEnum tipoCaso) -> {
			validateTipoCasoInDB(countTipoCaso.get(), tipoCaso);
			countTipoCaso.addAndGet(1L);
		});
		AtomicLong countEstadoCaso = new AtomicLong(1);
		Stream.of(EstadoCasoEnum.values()).forEach((EstadoCasoEnum estadoCaso) -> {
			validateEstadoCasoInDB(countEstadoCaso.get(), estadoCaso);
			countEstadoCaso.addAndGet(1L);
		});
	}

	private void validateTipoCasoInDB(Long id, TipoCasoEnum valor) {
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

	private void validateEstadoCasoInDB(Long id, EstadoCasoEnum valor) {
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
