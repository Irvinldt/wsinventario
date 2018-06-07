package sv.com.inventario.modelo.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public String toString() {
        return super.toString();
    }

    //public String reflect() {return ToStringBuilder.reflectionToString( this)}
}
