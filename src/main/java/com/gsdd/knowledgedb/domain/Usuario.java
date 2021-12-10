package com.gsdd.knowledgedb.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.gsdd.knowledgedb.persistence.entity.UsuarioEntidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Usuario {

  private Long codigo;
  @NotBlank(message = "El nombre no debe estar vacio")
  @Size(min = 4, max = 32, message = "El nombre debe tener entre 4 y 32 caracteres")
  private String nombre;
  @NotBlank(message = "El apellido no debe estar vacio")
  @Size(min = 4, max = 32, message = "El apellido debe tener entre 4 y 32 caracteres")
  private String apellido;
  @NotBlank(message = "El alias no debe estar vacio")
  @Size(min = 4, max = 32, message = "El alias debe tener entre 4 y 32 caracteres")
  private String alias;
  @NotBlank(message = "La clave no debe estar vacia")
  @Size(min = 4, max = 32, message = "La clave debe tener entre 4 y 32 caracteres")
  @Pattern(
      regexp = "^[A-Za-z\u00c1\u00c9\u00cd\u00d3\u00da\u00e1\u00e9\u00ed\u00f3\u00fa\u00d1\u00f1\u00dc\u00fc_0-9\\s]+$",
      message = "La clave debe ser alfanum\u00e9rica")
  private String clave;
  private Boolean estado;

  public Usuario(UsuarioEntidad entidad) {
    this.codigo = entidad.getCodigoUsuario();
    this.nombre = entidad.getNombre();
    this.apellido = entidad.getApellido();
    this.alias = entidad.getAlias();
    this.clave = entidad.getClave();
    this.estado = entidad.getEstado();
  }
}
