package co.com.gsdd.knowledgedb.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ServiceConstants {

	// Url
	public static final String U_INDEX = "/";
	public static final String U_CASO = "/caso";
	public static final String U_USUARIO = "/usuario";

	// Form
	public static final String F_USUARIO = "usuarioForm";
	public static final String F_CASO = "casoForm";

	// Mapping
	public static final String M_CANCELAR = "cancelar";
	public static final String M_GUARDAR = "guardar";
	public static final String M_ELIMINAR = "eliminar";
	public static final String M_LISTAR = "listar";

	// Parameters
	public static final String P_ID = "id";
	public static final String P_NOMBRE = "nombre";
	public static final String P_APELLIDO = "apellido";
	public static final String P_ALIAS = "alias";

	// Util
	public static final String REDIRECT = "redirect:";
	public static final String SLASH = "/";
	public static final String INDEX = "index";

	// status
	public static final String OK = "ok";
	public static final String BAD = "error";

}
