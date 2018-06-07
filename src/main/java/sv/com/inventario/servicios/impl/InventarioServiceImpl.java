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
    public Inventario consInventario(Long id) {
        return inventarioRepo.getOne(id);
    }

    @Override
    public Inventario actuInventario(Inventario inventario) {
        return inventarioRepo.save(inventario);
    }

    @Override
    public Boolean guarInventario(InventarioRequestDTO request) {
        Boolean r;
        Inventario inventario = new Inventario();
        inventario.setExistencias(request.getExistencias());
        inventario.setFecha(request.getFecha());
        Producto producto = new Producto();
        producto.setId(request.getProducto());
        inventario.setProducto(producto);
        r = inventarioRepo.save(inventario).getId() != null;
        return r;
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
