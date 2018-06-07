package sv.com.inventario.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sv.com.inventario.controladores.dto.request.InventarioRequestDTO;
import sv.com.inventario.modelo.entity.Inventario;
import sv.com.inventario.servicios.InventarioDTOService;
import sv.com.inventario.servicios.InventarioService;

@RequestMapping("inventario")
@RestController
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private InventarioDTOService inventariodtoService;
    
    
    @GetMapping(value = "/")
    public ResponseEntity<?> consTodo() {
        try {
        	
            return new ResponseEntity<>(inventariodtoService.consTodo(), HttpStatus.OK);
        }
        catch (Exception ex) {
            System.out.printf(ex.getMessage());
            return new ResponseEntity<>("ERROR INESPERADO EN EL SERVIDOR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> consUno(@PathVariable(value = "id") Long Id) {
        try {
            return new ResponseEntity<>(inventarioService.consInventario(Id), HttpStatus.OK);
        }
        catch (Exception ex) {
            System.out.printf(ex.getMessage());
            return new ResponseEntity<>("ERROR INESPERADO EN EL SERVIDOR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> guar(@RequestBody InventarioRequestDTO request) {
        try {
            return new ResponseEntity<>(inventarioService.guarInventario(request), HttpStatus.OK);
        }
        catch (Exception ex) {
            System.out.printf(ex.getMessage());
            return new ResponseEntity<>("ERROR INESPERADO EN EL SERVIDOR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> elimi(@PathVariable(value = "id") Long Id) {
        try {
            return new ResponseEntity<>(inventarioService.elimInventario(Id), HttpStatus.OK);
        }
        catch (Exception ex) {
            System.out.printf(ex.getMessage());
            return new ResponseEntity<>("ERROR INESPERADO EN EL SERVIDOR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/")
    public ResponseEntity<?> modi(@RequestBody Inventario inventario) {
        try {
            Inventario obje = inventarioService.actuInventario(inventario);
            if (obje.getId()!=null) {
                return new ResponseEntity<>(obje, HttpStatus.OK);
            }
            return new ResponseEntity<>("Error al modificar", HttpStatus.CONFLICT);
        }
        catch (Exception ex) {
            System.out.printf(ex.getMessage());
            return new ResponseEntity<>("ERROR INESPERADO EN EL SERVIDOR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
