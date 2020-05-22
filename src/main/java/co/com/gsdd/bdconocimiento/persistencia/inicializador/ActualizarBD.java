package co.com.gsdd.bdconocimiento.persistencia.inicializador;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import co.com.gsdd.bdconocimiento.persistencia.entidad.EstadoCasoEntidad;
import co.com.gsdd.bdconocimiento.persistencia.entidad.TipoCasoEntidad;
import co.com.gsdd.bdconocimiento.persistencia.entidad.enums.EstadoCasoEnum;
import co.com.gsdd.bdconocimiento.persistencia.entidad.enums.TipoCasoEnum;
import co.com.gsdd.bdconocimiento.persistencia.repositorio.IEstadoCasoRepositorio;
import co.com.gsdd.bdconocimiento.persistencia.repositorio.ITipoCasoRepositorio;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ActualizarBD implements ApplicationRunner {

    private ITipoCasoRepositorio tipoCasoRepositorio;
    private IEstadoCasoRepositorio estadoCasoRepositorio;

    @Autowired
    public ActualizarBD(ITipoCasoRepositorio tipoCasoRepositorio, IEstadoCasoRepositorio estadoCasoRepositorio) {
        this.tipoCasoRepositorio = tipoCasoRepositorio;
        this.estadoCasoRepositorio = estadoCasoRepositorio;
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
    	if (tipoCasoRepositorio.findById(id).isPresent()) {
    		log.debug("El tipoCaso {} ya existe en BD", valor);
    	} else {
    		TipoCasoEntidad tipoCaso = new TipoCasoEntidad();
        	tipoCaso.setCodigoTipo(id);
        	tipoCaso.setEstado(true);
        	tipoCaso.setDescripcion(valor);
        	tipoCasoRepositorio.save(tipoCaso);
    	}
    }
    
    private void verificarEstadoCasoEnBD(Long id, EstadoCasoEnum valor) {
    	if (estadoCasoRepositorio.findById(id).isPresent()) {
    		log.debug("El estadoCaso {} ya existe en BD", valor);
    	} else {
    		EstadoCasoEntidad estadoCaso = new EstadoCasoEntidad();
    		estadoCaso.setCodigoEstado(id);
        	estadoCaso.setEstado(true);
        	estadoCaso.setDescripcion(valor);
        	estadoCasoRepositorio.save(estadoCaso);
    	}
    }

}
