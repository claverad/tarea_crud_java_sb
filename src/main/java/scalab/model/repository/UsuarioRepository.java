package scalab.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scalab.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>, UsuarioRepositoryCustom {
}
