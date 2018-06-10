package sv.com.inventario.servicios;

import sv.com.inventario.modelo.entity.Inventario;

import java.util.List;

public interface InventarioService {

    List<Inventario> consTodoExistencias(Integer cantidad);

    Boolean elimInventario(Long id);


}
