package co.com.gsdd.bdconocimiento.constantes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConstantesGenerales {

    // Configuraci\u00F3n
    public static final String UTF_8 = "UTF-8";
    public static final String C_MENSAJES = "classpath:i18n/mensajes";
    public static final String C_LANG = "lang";

    // Configuraci\u00F3n Spring
    public static final String PACK_PPAL = "co.com.gsdd.bdconocimiento";
    public static final String PACK_CONTROL = PACK_PPAL + ".controlador";
    public static final String PACK_REPO =
            PACK_PPAL + ".persistencia.repositorio";
    public static final String PACK_SERV = PACK_PPAL + ".servicio.impl";
    public static final String PACK_CONF = PACK_PPAL + ".persistencia.inicializador";
    public static final String PACK_COMP = PACK_PPAL + ".convertidor";

}
