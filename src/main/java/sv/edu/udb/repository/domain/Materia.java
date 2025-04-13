package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public void setNombre(String geografía) {
    }

    public Object getId() {
        return null;
    }
}
