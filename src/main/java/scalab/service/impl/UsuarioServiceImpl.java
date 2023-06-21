package scalab.service.impl;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import scalab.model.dto.UsuarioRequest;
import scalab.model.entity.Usuario;
import scalab.model.repository.UsuarioRepository;
import scalab.service.IUsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioRequest> getUsuarios() {
        List<Usuario> usuarios = usuarioRepository.getAllUsuarios();
        List<UsuarioRequest> usuariosDto = new ArrayList<>();

        for (Usuario usuario: usuarios){
            usuariosDto.add(UsuarioRequest.mapToDto(usuario));
        }

        return usuariosDto;
    }

    @Override
    public UsuarioRequest getUsuarios(String id) {
        Optional<Usuario> usuarioOp = usuarioRepository.findById((id));

        if (!usuarioOp.isEmpty()){
            return new UsuarioRequest(usuarioOp.get().getNombre(), usuarioOp.get().getCorreo(),
                    usuarioOp.get().getPass(),usuarioOp.get().getTelefono());
        }

        return null;
    }

    @Override
    public UsuarioRequest insertarUsuario(UsuarioRequest request) {
        try {
            Usuario usuarioEntity = UsuarioRequest.mapToEntity(request);
            usuarioRepository.save(usuarioEntity);
            return request;
        } catch(DataIntegrityViolationException e) {
            System.out.println("Ya existe ese correo...");
        }
        return null;
    }

    @Override
    public boolean eliminarUsuario(String id) {

        if(getUsuarios(id) != null){
            usuarioRepository.deleteById(id);
            return true;
        }else {

            return false;
        }
    }

    @Override
    public Usuario actualizarUsuario(Usuario curso) {
        Usuario usuarioEntity = usuarioRepository.save(curso);
        return usuarioEntity;
    }

    @Override
    public UsuarioRequest actualizarUsuario(UsuarioRequest usuario) {
        Usuario usuarioEntity = UsuarioRequest.mapToEntity(usuario);
        usuarioRepository.save(usuarioEntity);
        return usuario;
    }

    @Override
    public UsuarioRequest getUsuarioByCorreo(String correo) {

        Optional<Usuario> usuarioOp = Optional.ofNullable(usuarioRepository.getUsuarioByCorreo((correo)));

        if (!usuarioOp.isEmpty()){
            return new UsuarioRequest(usuarioOp.get().getNombre(), usuarioOp.get().getCorreo(),
                    usuarioOp.get().getPass(),usuarioOp.get().getTelefono());
        }

        return null;

    }


}
