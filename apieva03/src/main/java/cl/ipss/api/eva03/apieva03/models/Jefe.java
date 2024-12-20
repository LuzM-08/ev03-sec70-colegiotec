package cl.ipss.api.eva03.apieva03.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jefe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreCompleto;
    private String correo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jefe", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Empresa> empresa;

    public Jefe(String nombreCompleto, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    public Jefe() {
    }
}
