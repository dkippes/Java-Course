package ejemploGenericos.ejemploInterfacesGenericas.repositorio.lista;

import ejemploGenericos.ejemploInterfacesGenericas.modelo.ClienteG;
import ejemploGenericos.ejemploInterfacesGenericas.repositorio.AbstractaListRepositorio;
import ejemploGenericos.ejemploInterfacesGenericas.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<ClienteG> {

    @Override
    public void editar(ClienteG cliente) {
        ClienteG c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<ClienteG> lista(String campo, Direccion dir) {
        List<ClienteG> listaOrdenada = new ArrayList<>(this.dataSource);
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

    public static int ordenar(String campo, ClienteG a, ClienteG b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

}
