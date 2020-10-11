package co.com.gsdd.knowledgedb.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GeneralConstants {

    // Configuraci\u00F3n
    public static final String UTF_8 = "UTF-8";
    public static final String C_MSG = "classpath:i18n/msg";
    public static final String C_LANG = "lang";

    // Configuraci\u00F3n Spring
    public static final String MAIN_PKG = "co.com.gsdd.knowledgedb";
    public static final String CONTROLLER_PKG = MAIN_PKG + ".controller";
    public static final String REPO_PKG =
            MAIN_PKG + ".persistence.repository";
    public static final String SERV_PKG = MAIN_PKG + ".service.impl";
    public static final String CONF_PKG = MAIN_PKG + ".persistence.init";
    public static final String COMP_PKG = MAIN_PKG + ".converter";

}
