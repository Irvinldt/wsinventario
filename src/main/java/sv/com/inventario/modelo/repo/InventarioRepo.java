package sv.com.inventario.modelo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sv.com.inventario.controladores.dto.request.InventarioRequestDTO;
import sv.com.inventario.modelo.entity.Inventario;

import java.util.List;

@Repository
public interface InventarioRepo extends AbstractBaseRepository<Inventario, Long> {

	@Query("SELECT i FROM Inventario i")
    List<InventarioRequestDTO> consTodo();
	
    @Query("SELECT i FROM Inventario i WHERE i.existencias = :cantidad")
    List<Inventario> getByExistencias(@Param(value = "cantidad") Integer cantidad);
}
