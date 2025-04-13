package sv.edu.udb.service;

import sv.edu.udb.controller.request.AlumnoRequest;
import sv.edu.udb.controller.response.AlumnoResponse;

import java.util.List;
public interface AlumnoService {
    List<AlumnoResponse> findAll();
    AlumnoResponse findById(final Long id);
    AlumnoResponse save(final AlumnoRequest alumnoRequest);
    AlumnoResponse update(final Long id, final AlumnoRequest alumnoRequest);
    void delete(final Long id);
}
