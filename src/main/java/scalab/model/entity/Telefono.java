package scalab.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "telefonos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String telefono_id;
    @Column(nullable = false)
    @NotEmpty(message = "El numero es obligatorio")
    private String numero;
    @Column(nullable = false)
    @NotEmpty(message = "El codigo ciudad es obligatorio")
    private String codCiudad;
    @Column(nullable = false)
    @NotEmpty(message = "El codigo pais es obligatorio")
    private String codPais;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return telefono_id == telefono.telefono_id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Telefono{");
        sb.append("id=").append(telefono_id);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", codCiudad='").append(codCiudad).append('\'');
        sb.append(", codPais='").append(codPais).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono_id);
    }
}
