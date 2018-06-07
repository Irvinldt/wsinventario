package sv.com.inventario.modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import sv.com.inventario.modelo.entity.AbstractBaseEntity;

@NoRepositoryBean
public interface AbstractBaseRepository<T extends AbstractBaseEntity, ID extends Long> extends JpaRepository<T, ID> {

}
