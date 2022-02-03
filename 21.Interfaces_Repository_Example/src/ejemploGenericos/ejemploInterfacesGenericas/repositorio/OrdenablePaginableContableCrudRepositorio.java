package ejemploGenericos.ejemploInterfacesGenericas.repositorio;

public interface OrdenablePaginableContableCrudRepositorio<T> extends OrdenableRepositorio<T>, PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio {
}
