package ejemploInterfacesGenericas.repositorio.lista;

import ejemploInterfacesGenericas.modelo.Producto;
import ejemploInterfacesGenericas.repositorio.AbstractaListRepositorio;
import ejemploInterfacesGenericas.repositorio.Direccion;
import ejemploInterfacesGenericas.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        producto.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> lista(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort(((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, a, b);
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        }));
        return listaOrdenada;
    }

    public static int ordenar(String campo, Producto a, Producto b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
