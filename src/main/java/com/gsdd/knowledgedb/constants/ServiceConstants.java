package com.gsdd.knowledgedb.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ServiceConstants {

  // Url
  public static final String U_INDEX = "/";
  public static final String U_TICKET = "/tickets";
  public static final String U_USER = "/users";

  // Form
  public static final String FORM = "form";

  // Mapping
  public static final String M_CANCEL = "cancel";
  public static final String M_SAVE = "save";
  public static final String M_DELETE = "delete";
  public static final String M_LIST = "list";

  // Parameters
  public static final String P_ID = "id";

  // Util
  public static final String REDIRECT = "redirect:";
  public static final String SLASH = "/";
  public static final String INDEX = "index";

  // status
  public static final String OK = "ok";
  public static final String BAD = "error";
}
