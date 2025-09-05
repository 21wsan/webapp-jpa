package org.wsan.apiservlet.webapp.headers.services;

import jakarta.inject.Inject;
import org.wsan.apiservlet.webapp.headers.configs.ProductoServicePrincipal;
import org.wsan.apiservlet.webapp.headers.configs.Service;
import org.wsan.apiservlet.webapp.headers.interceptors.TransactionalJpa;
import org.wsan.apiservlet.webapp.headers.models.entities.Categoria;
import org.wsan.apiservlet.webapp.headers.models.entities.Producto;
import org.wsan.apiservlet.webapp.headers.repositories.CrudRepository;
import org.wsan.apiservlet.webapp.headers.repositories.RepositoryJpa;

import java.util.List;
import java.util.Optional;

@Service
@ProductoServicePrincipal
@TransactionalJpa
public class ProductoServiceImpl implements ProductoService{

    @Inject
    @RepositoryJpa
    private CrudRepository<Producto> repositoryJdbc;

    @Inject
    @RepositoryJpa
    private CrudRepository<Categoria> repositoryCategoriaJdbc;

    @Override
    public List<Producto> listar() {
        try {
            return repositoryJdbc.listar();
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void guardar(Producto producto) {
        try{
            repositoryJdbc.guardar(producto);
        }catch (Exception throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try{
            repositoryJdbc.eliminar(id);
        }catch (Exception throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return repositoryCategoriaJdbc.listar();
        }catch (Exception throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
            }
        }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(repositoryCategoriaJdbc.porId(id));
        }catch (Exception throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
