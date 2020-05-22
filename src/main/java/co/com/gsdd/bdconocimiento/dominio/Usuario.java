package co.com.gsdd.bdconocimiento.dominio;

import co.com.gsdd.bdconocimiento.persistencia.entidad.UsuarioEntidad;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    private Long codigo;
    private String nombre;
    private String apellido;
    private String alias;
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
