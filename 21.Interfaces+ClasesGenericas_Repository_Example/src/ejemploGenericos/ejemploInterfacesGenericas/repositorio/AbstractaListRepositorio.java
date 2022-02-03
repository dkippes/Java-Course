package ejemploGenericos.ejemploInterfacesGenericas.repositorio;

import ejemploGenericos.ejemploInterfacesGenericas.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableContableCrudRepositorio<T> {

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return this.dataSource;
    }

    @Override
    public T porId(Integer id) {
        return dataSource.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
