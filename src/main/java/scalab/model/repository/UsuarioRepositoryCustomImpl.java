package scalab.model.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import scalab.model.dto.UsuarioRequest;
import scalab.model.entity.Usuario;
import java.util.List;

public class UsuarioRepositoryCustomImpl implements UsuarioRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getAllUsuarios() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> cursos = criteriaQuery.from(Usuario.class);

        criteriaQuery.select(cursos);
        List<Usuario> resultados = entityManager.createQuery(criteriaQuery).getResultList();

        return resultados;
    }

    @Override
    public Usuario getUsuarioByCorreo(String correo) {
        //SELECT * FROM usuarios WHERE correo = 'correo';

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> cursos = criteriaQuery.from(Usuario.class);

        criteriaQuery.select(cursos).where(criteriaBuilder.equal(cursos.get("correo"), correo));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

}
