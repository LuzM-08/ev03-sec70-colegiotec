package cl.ipss.api.eva03.apieva03.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String rubro;
    private String direccion;
    private long number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jefe")
    private Jefe jefe;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Practica> practica;


    public Empresa(String nombre, String rubro, String direccion, long number) {
        this.nombre = nombre;
        this.rubro = rubro;
        this.direccion = direccion;
        this.number = number;
    }

    public Empresa() {
    }

}
