package co.com.gsdd.knowledgedb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.com.gsdd.knowledgedb.constants.ServiceConstants;
import co.com.gsdd.knowledgedb.domain.Usuario;
import co.com.gsdd.knowledgedb.service.IUsuarioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = ServiceConstants.U_USUARIO)
public class UsuarioController {

	private static final String USU_OBJ = "usuario";
    private static final String USU_LISTA = "usuarios";

    private final IUsuarioService usuarioService;
    
    /**
     * Permite mapear a vista la lista de usuarios.
     * 
     * @return
     */
    @GetMapping(ServiceConstants.M_LISTAR)
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView(USU_LISTA);
        mav.addObject(USU_LISTA, usuarioService.listEnabled());
        return mav;
    }

    @GetMapping(ServiceConstants.F_USUARIO)
    public String goToForm(@RequestParam(name = ServiceConstants.P_ID,
            required = false) Long id, Model model) {
        Usuario usuario = new Usuario();
        if (id != null) {
        	usuario = usuarioService.findById(id);
        }
        model.addAttribute(USU_OBJ, usuario);
        return ServiceConstants.F_USUARIO;
    }

    @PostMapping(value = ServiceConstants.M_GUARDAR)
    public String save(@ModelAttribute(USU_OBJ) Usuario usuario, Model model) {
        if (usuario.getCodigo() == null) {
        	usuarioService.save(usuario);
        } else {
        	usuarioService.update(usuario);
        }
        return seeList();
    }

    @GetMapping(value = ServiceConstants.M_ELIMINAR)
    public ModelAndView delete(@RequestParam(name = ServiceConstants.P_ID,
            required = true) Long id) {
    	usuarioService.logicalDelete(id);
        return list();
    }

    private String seeList() {
        StringBuilder sb =
                new StringBuilder().append(ServiceConstants.REDIRECT)
                        .append(ServiceConstants.U_USUARIO)
                        .append(ServiceConstants.SLASH)
                        .append(ServiceConstants.M_LISTAR);
        return sb.toString();
    }

}
