package cl.ipss.api.eva03.apieva03.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Jefe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jefe_id;
    private String nombreCompleto;
    private String correo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jefe", cascade = { CascadeType.ALL })
    private List<Empresa> empresa;

}
