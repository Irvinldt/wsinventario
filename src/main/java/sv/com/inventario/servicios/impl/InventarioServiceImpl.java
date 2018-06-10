package sv.com.inventario.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sv.com.inventario.controladores.dto.request.InventarioRequestDTO;
import sv.com.inventario.modelo.entity.Inventario;
import sv.com.inventario.modelo.entity.Producto;
import sv.com.inventario.modelo.repo.InventarioDTORepo;
import sv.com.inventario.modelo.repo.InventarioRepo;
import sv.com.inventario.servicios.InventarioService;

import java.util.List;

@Service("inventarioService")
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepo inventarioRepo;

    @Override
    public List<Inventario> consTodoExistencias(Integer cantidad) {
        return inventarioRepo.getByExistencias(cantidad);
    }

    @Override
    public Boolean elimInventario(Long id) {
        if (inventarioRepo.existsById(id))
        {
            inventarioRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
