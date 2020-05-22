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
import co.com.gsdd.bdconocimiento.dominio.Usuario;
import co.com.gsdd.bdconocimiento.servicio.IUsuarioServicio;

@Controller
@RequestMapping(value = ConstantesServicio.U_USUARIO)
public class UsuarioControlador {

	private static final String USU_OBJ = "usuario";
    private static final String USU_LISTA = "usuarios";
    /**
     * Definici\u00F3n del servicio
     */
    @Autowired
    private IUsuarioServicio usuarioServicio;
    
    /**
     * Permite mapear a vista la lista de usuarios.
     * 
     * @return
     */
    @GetMapping(ConstantesServicio.M_LISTAR)
    public ModelAndView listar() {
        ModelAndView mav = new ModelAndView(USU_LISTA);
        mav.addObject(USU_LISTA, usuarioServicio.listarActivos());
        return mav;
    }

    @GetMapping(ConstantesServicio.F_USUARIO)
    public String redireccionForm(@RequestParam(name = ConstantesServicio.P_ID,
            required = false) Long id, Model modelo) {
        Usuario usuario = new Usuario();
        if (id != null) {
        	usuario = usuarioServicio.obtener(id);
        }
        modelo.addAttribute(USU_OBJ, usuario);
        return ConstantesServicio.F_USUARIO;
    }

    @PostMapping(value = ConstantesServicio.M_GUARDAR)
    public String guardar(@ModelAttribute(USU_OBJ) Usuario usuario, Model modelo) {
        if (usuario.getCodigo() == null) {
        	usuarioServicio.agregar(usuario);
        } else {
        	usuarioServicio.actualizar(usuario);
        }
        return redireccionLista();
    }

    @GetMapping(value = ConstantesServicio.M_ELIMINAR)
    public ModelAndView eliminar(@RequestParam(name = ConstantesServicio.P_ID,
            required = true) Long id) {
    	usuarioServicio.eliminarL(id);
        return listar();
    }

    /**
     * Permite redireccionar al listado de usuario.
     * 
     * @return
     */
    private String redireccionLista() {
        StringBuilder sb =
                new StringBuilder().append(ConstantesServicio.REDIRECT)
                        .append(ConstantesServicio.U_USUARIO)
                        .append(ConstantesServicio.SLASH)
                        .append(ConstantesServicio.M_LISTAR);
        return sb.toString();
    }

}
