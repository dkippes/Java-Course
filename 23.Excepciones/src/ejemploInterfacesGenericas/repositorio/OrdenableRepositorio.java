package ejemploInterfacesGenericas.repositorio;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> lista(String campo, Direccion dir);
}
