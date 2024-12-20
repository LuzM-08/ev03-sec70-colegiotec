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
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreCompleto;
    private String correo;
    private String carrera;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Practica> practica;

    public Estudiante(String nombreCompleto, String correo, String carrera) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.carrera = carrera;
    }

    public Estudiante() {
    }

}
