package sv.edu.udb.controller.response;

import lombok.*;
import lombok.experimental.FieldNameConstants;
@Getter
@Setter
@Builder(toBuilder = true) //Es para poder modificar el objeto luego de creado
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants //Para generar constantes con los nombres de las propiedades
public class AlumnoResponse {
    private String Nombre;
    private String Apellido;
//    private Long idMateria;
}