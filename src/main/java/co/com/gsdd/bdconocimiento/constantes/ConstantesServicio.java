package co.com.gsdd.bdconocimiento.constantes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConstantesServicio {

	// Url
	public static final String U_INDEX = "/";
	public static final String U_CASO = "/caso";
	public static final String U_USUARIO = "/usuario";
	
	// Form
	public static final String F_USUARIO = "usuarioForm";
	public static final String F_CASO = "casoForm";

	// Mapeo
	public static final String M_GUARDAR = "guardar";
	public static final String M_ELIMINAR = "eliminar";
	public static final String M_LISTAR = "listar";

	// Parametros
	public static final String P_ID = "id";
	public static final String P_NOMBRE = "nombre";
	public static final String P_APELLIDO = "apellido";
	public static final String P_ALIAS = "alias";

	// Util
	public static final String REDIRECT = "redirect:";
	public static final String SLASH = "/";
	public static final String INDEX = "index";

}
