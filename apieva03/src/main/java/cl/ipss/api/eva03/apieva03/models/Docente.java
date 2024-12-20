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
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreCompleto;
    private String correo;
    private String carrera;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "docente", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Practica> practica;
}
