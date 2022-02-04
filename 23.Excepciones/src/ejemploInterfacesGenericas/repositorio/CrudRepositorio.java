package ejemploInterfacesGenericas.repositorio;

import ejemploInterfacesGenericas.repositorio.excepciones.AccesoDatoException;
import ejemploInterfacesGenericas.repositorio.excepciones.EscrituraAccesoDatoException;
import ejemploInterfacesGenericas.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AccesoDatoException;
    void crear(T t) throws AccesoDatoException;
    void editar(T t) throws LecturaAccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;
}
