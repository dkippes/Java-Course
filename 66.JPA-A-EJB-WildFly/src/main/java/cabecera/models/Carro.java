package cabecera.models;

import cabecera.configs.CarroCompra;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CarroCompra
public class Carro implements Serializable {
    private List<ItemCarro> items;

    @Inject
    private transient Logger log; // Inyecta el log pero no es parte de la session del carro

    @PostConstruct
    public void inicializar() {
        this.items = new ArrayList<>();
        log.info("Inicializando el carro compra");
    }

    @PreDestroy
    public void destruir() {
        log.info("Destruyendo el carro compra");
    }

    public void addItemCarro(ItemCarro itemCarro) {
        if (this.items.contains(itemCarro)) {
            Optional<ItemCarro> optionalItemCarro = items.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findAny();
            if (optionalItemCarro.isPresent()) {
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad() + 1);
            }
        } else {
            this.items.add(itemCarro);
        }
    }

    public List<ItemCarro> getItems() {
        return items;
    }

    public int getTotal() {
        return items.stream()
                .mapToInt(ItemCarro::getImporte)
                .sum();
    }
}
