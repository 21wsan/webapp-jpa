package org.wsan.apiservlet.webapp.headers.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.wsan.apiservlet.webapp.headers.configs.Repository;
import org.wsan.apiservlet.webapp.headers.models.entities.Categoria;

import java.util.List;

@RepositoryJpa
@Repository
public class CategoriaRepositoryJpaImpl implements CrudRepository<Categoria>{

    @Inject
    private EntityManager em;

    @Override
    public List<Categoria> listar() throws Exception {
        return em.createQuery("from categoria", Categoria.class).getResultList();
    }

    @Override
    public Categoria porId(Long id) throws Exception {
        return em.find(Categoria.class, id);
    }

    @Override
    public void guardar(Categoria categoria) throws Exception {
        if(categoria.getId() != null && categoria.getId() > 0){
            em.merge(categoria);
        }else{
            em.persist(categoria);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        em.remove(porId(id));
        // codigo en una sola línea en la clase ProductoRepositoriJpaImpl se implemento en 2 líneas
    }
}
