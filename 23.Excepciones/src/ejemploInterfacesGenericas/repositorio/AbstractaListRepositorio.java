package ejemploInterfacesGenericas.repositorio;

import ejemploInterfacesGenericas.modelo.BaseEntity;
import ejemploInterfacesGenericas.repositorio.excepciones.EscrituraAccesoDatoException;
import ejemploInterfacesGenericas.repositorio.excepciones.LecturaAccesoDatoException;
import ejemploInterfacesGenericas.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;

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
    public T porId(Integer id) throws LecturaAccesoDatoException {
        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoException("Id invalido debe ser > 0");
        }
        T tResultado = dataSource.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        if (tResultado == null) {
            throw new LecturaAccesoDatoException("No existe el registro con id: " + id);
        }
        return tResultado;
    }


    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if(t == null) {
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null");
        }
        if(this.dataSource.contains(t)) {
            throw new RegistroDuplicadoAccesoDatoException("Error el objeto con id: " + t.getId() + " existe en el repositorio");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
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
