package jsf3.services;

import jakarta.inject.Inject;
import jsf3.entities.Producto;
import jsf3.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService {

    @Inject
    private CrudRepository<Producto> repository;

    @Override
    public List<Producto> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.of(repository.porId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
