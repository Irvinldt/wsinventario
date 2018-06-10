package sv.com.inventario.servicios;

import java.util.List;

import sv.com.inventario.controladores.dto.request.InventarioRequestDTO;
import sv.com.inventario.modelo.entity.Inventario;

public interface InventarioDTOService {

	List<InventarioRequestDTO> consTodo();
	
    InventarioRequestDTO actuInventario(InventarioRequestDTO request);

    InventarioRequestDTO guarInventario(InventarioRequestDTO request);
	
}
