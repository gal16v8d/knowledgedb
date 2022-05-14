package com.gsdd.knowledgedb.persistence.entity;

import com.gsdd.knowledgedb.domain.Usuario;
import com.gsdd.knowledgedb.persistence.entity.common.AbstraccionEntidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Usuario")
public class UsuarioEntidad extends AbstraccionEntidad {

  private static final long serialVersionUID = 1L;

  @Id
  @GenericGenerator(
      name = "codigoUsuGen",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "usu_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
      })
  @GeneratedValue(generator = "codigoUsuGen")
  @Column(name = "codigousuario", nullable = false)
  private Long codigoUsuario;

  @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "apellido", nullable = false)
  private String apellido;

  @Column(name = "alias", nullable = false, unique = true)
  private String alias;

  @Column(name = "clave", nullable = false)
  private String clave;

  public UsuarioEntidad(Usuario dominio) {
    this.codigoUsuario = dominio.getCodigo();
    this.nombre = dominio.getNombre();
    this.apellido = dominio.getApellido();
    this.alias = dominio.getAlias();
    this.clave = dominio.getClave();
    setEstado(dominio.getEstado());
  }
}
