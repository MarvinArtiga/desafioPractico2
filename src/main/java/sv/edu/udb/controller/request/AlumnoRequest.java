package sv.edu.udb.controller.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) //Ignora propiedades desconocidas
@JsonInclude(JsonInclude.Include.NON_NULL) //No incluye los valoros devueltos nulos
@Data
public class AlumnoRequest {
    @NotBlank //No acepta valores nulos ni vacios
    private String nombre;
    @NotNull //No acepta valores nulos
    private String apellido;
//    private Long idMateria;
}