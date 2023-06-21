package scalab.model.repository;

import scalab.model.entity.Usuario;
import java.util.List;

public interface UsuarioRepositoryCustom {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioByCorreo(String correo);

}
