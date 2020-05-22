package co.com.gsdd.bdconocimiento.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.com.gsdd.bdconocimiento.constantes.ConstantesServicio;
import co.com.gsdd.bdconocimiento.dominio.Caso;
import co.com.gsdd.bdconocimiento.servicio.ICasoServicio;
import co.com.gsdd.bdconocimiento.servicio.IEstadoCasoServicio;
import co.com.gsdd.bdconocimiento.servicio.ITipoCasoServicio;
import co.com.gsdd.bdconocimiento.servicio.IUsuarioServicio;

@Controller
@RequestMapping(value = ConstantesServicio.U_CASO)
public class CasoControlador {

    private static final String CASO_OBJ = "caso";
    private static final String CASO_LISTA = "casos";
    private static final String USU_LISTA = "usuarios";
    private static final String E_LISTA = "estados";
    private static final String T_LISTA = "tipos";
    /**
     * Definici\u00F3n del servicio
     */
    @Autowired
    private ICasoServicio casoServicio;
    @Autowired
    private IUsuarioServicio usuarioServicio;
    @Autowired
    private IEstadoCasoServicio estadoCasoServicio;
    @Autowired
    private ITipoCasoServicio tipoCasoServicio;

    /**
     * Permite mapear a vista la lista de casos.
     * 
     * @return
     */
    @GetMapping(ConstantesServicio.M_LISTAR)
    public ModelAndView listar() {
        ModelAndView mav = new ModelAndView(CASO_LISTA);
        mav.addObject(CASO_LISTA, casoServicio.listarActivos());
        return mav;
    }

    @GetMapping(ConstantesServicio.F_CASO)
    public String redireccionForm(@RequestParam(name = ConstantesServicio.P_ID,
            required = false) Long id, Model modelo) {
        Caso c = new Caso();
        if (id != null) {
            c = casoServicio.obtener(id);
        }
        modelo.addAttribute(CASO_OBJ, c);
        obtenerListaUsuario(modelo);
        obtenerListaEstado(modelo);
        obtenerListaTipo(modelo);
        return ConstantesServicio.F_CASO;
    }

    @PostMapping(value = ConstantesServicio.M_GUARDAR)
    public String guardar(@ModelAttribute(CASO_OBJ) Caso c, Model modelo) {
        if (c.getCodigoCaso() == null) {
            casoServicio.agregar(c);
        } else {
            casoServicio.actualizar(c);
        }
        return redireccionLista();
    }

    @GetMapping(value = ConstantesServicio.M_ELIMINAR)
    public ModelAndView eliminar(@RequestParam(name = ConstantesServicio.P_ID,
            required = true) Long id) {
        casoServicio.eliminarL(id);
        return listar();
    }

    /**
     * Obtiene la lista de usuarios para presentaci\u00F3n.
     * 
     * @param modelo
     * @return
     */
    public Model obtenerListaUsuario(Model modelo) {
        modelo.addAttribute(USU_LISTA, usuarioServicio.listarActivos());
        return modelo;
    }

    /**
     * Obtiene la lista de estados para presentaci\u00F3n.
     * 
     * @param modelo
     * @return
     */
    public Model obtenerListaEstado(Model modelo) {
        modelo.addAttribute(E_LISTA, estadoCasoServicio.listarActivos());
        return modelo;
    }

    /**
     * Obtiene la lista de tipos para presentaci\u00F3n
     * 
     * @param modelo
     * @return
     */
    public Model obtenerListaTipo(Model modelo) {
        modelo.addAttribute(T_LISTA, tipoCasoServicio.listarActivos());
        return modelo;
    }

    /**
     * Permite redireccionar al listado de usuario.
     * 
     * @return
     */
    private String redireccionLista() {
        StringBuilder sb =
                new StringBuilder().append(ConstantesServicio.REDIRECT)
                        .append(ConstantesServicio.U_CASO)
                        .append(ConstantesServicio.SLASH)
                        .append(ConstantesServicio.M_LISTAR);
        return sb.toString();
    }

}
