package scalab.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scalab.model.entity.Telefono;
import scalab.model.entity.Usuario;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioRequest {

    @NotEmpty(message = "El nombre del usuario es obligatorio")
    private String nombre;
    @NotEmpty(message = "El correo del usuario es obligatorio")
    private String correo;
    @NotEmpty(message = "La contraseña del usuario es obligatorio")
    private String pass;
    @Valid
    private Telefono telefono;

    public static UsuarioRequest mapToDto(Usuario entity){
        UsuarioRequest dto = new UsuarioRequest();
        dto.setNombre(entity.getNombre());
        dto.setCorreo(entity.getCorreo());
        dto.setPass(entity.getPass());
        dto.setTelefono(entity.getTelefono());

        return dto;
    }

    public static Usuario mapToEntity(UsuarioRequest dto){
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setNombre(dto.getNombre());
        usuarioEntity.setCorreo(dto.getCorreo());
        usuarioEntity.setPass(dto.getPass());
        usuarioEntity.setTelefono(dto.getTelefono());

        return usuarioEntity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsuarioRequest{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", correo='").append(correo).append('\'');
        sb.append(", pass='").append(pass).append('\'');
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRequest that = (UsuarioRequest) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(correo, that.correo) && Objects.equals(pass, that.pass) && Objects.equals(telefono, that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, correo, pass, telefono);
    }

}
