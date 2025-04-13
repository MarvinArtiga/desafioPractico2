package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.AlumnoRequest;
import sv.edu.udb.controller.response.AlumnoResponse;
import sv.edu.udb.repository.domain.Alumno;
import java.util.List;
@Mapper(componentModel = "spring")
public interface AlumnoMapper {
    AlumnoResponse toAlumnoResponse(final Alumno data);
    List<AlumnoResponse> toAlumnoResponseList(final List<Alumno> AlumnoList);
    Alumno toAlumno(final AlumnoRequest alumnoRequest);
}