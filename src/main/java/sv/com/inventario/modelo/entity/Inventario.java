package sv.com.inventario.modelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "inventario")
public class Inventario extends AbstractBaseEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Inven")
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Pro")
    private Producto producto;

    @Column(name = "Existencias")
    private Integer existencias;

    @Column(name = "Fecha")
    private Date fecha;

    public Inventario() {
    }

    public Inventario(Long id, Producto producto, Integer existencias, Date fecha) {
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

    public Producto getProducto() { return producto; }

    public void setProducto(Producto producto) { this.producto = producto; }

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

	@Override
	public String toString() {
		return "Inventario [id=" + this.id + ", producto=" + this.producto + ", existencias=" + this.existencias + ", fecha=" + this.fecha
				+ "]";
	}
    
    
}
