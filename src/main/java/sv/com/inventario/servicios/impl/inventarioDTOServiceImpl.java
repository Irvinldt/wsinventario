package sv.com.inventario.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.inventario.controladores.dto.request.InventarioRequestDTO;
import sv.com.inventario.modelo.entity.Inventario;
import sv.com.inventario.modelo.repo.InventarioDTORepo;
import sv.com.inventario.servicios.InventarioDTOService;

@Service("inventarioDtoService")
public class inventarioDTOServiceImpl implements InventarioDTOService{

	@Autowired
	private InventarioDTORepo inventariodtorepo;
	
	@Override
	public List<InventarioRequestDTO> consTodo() {
		
		return inventariodtorepo.findAll();
	}

	@Override
	public InventarioRequestDTO actuInventario(InventarioRequestDTO request) {
		return inventariodtorepo.save(request);
	}

	@Override
	public InventarioRequestDTO guarInventario(InventarioRequestDTO request) {
		return inventariodtorepo.save(request);
	}

}
