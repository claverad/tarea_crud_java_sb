package scalab.service;

import scalab.model.dto.UsuarioRequest;
import scalab.model.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<UsuarioRequest> getUsuarios();

    //UsuarioRequest getUsuarios(int id);

    //UsuarioRequest getUsuarios(String id);

    UsuarioRequest getUsuarios(String id);

    UsuarioRequest insertarUsuario(UsuarioRequest request);

    //Usuario eliminarUsuario(int id);

    boolean eliminarUsuario(String id);

    Usuario actualizarUsuario(Usuario curso);

    UsuarioRequest actualizarUsuario(UsuarioRequest usuario);


    UsuarioRequest getUsuarioByCorreo(String correo);


}
