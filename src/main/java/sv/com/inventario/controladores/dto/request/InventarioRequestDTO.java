package sv.com.inventario.controladores.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import sv.com.inventario.modelo.entity.AbstractBaseEntity;
import sv.com.inventario.modelo.entity.Producto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name="inventario")
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventarioRequestDTO extends AbstractBaseEntity{
	
	@Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Inven")
    private Long id;

    @Column(name = "ID_Pro")
    private Long producto;

    @Column(name = "Existencias")
    private Integer existencias;

    @Column(name = "Fecha")
    private Date fecha;

    public InventarioRequestDTO() {
    }

    public InventarioRequestDTO(@NotNull Long id, Long producto, Integer existencias, Date fecha) {
		super();
		this.id = id;
		this.producto = producto;
		this.existencias = existencias;
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
