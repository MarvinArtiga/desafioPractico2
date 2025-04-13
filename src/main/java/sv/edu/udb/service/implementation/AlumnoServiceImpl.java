package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.AlumnoRequest;
import sv.edu.udb.controller.response.AlumnoResponse;
import sv.edu.udb.repository.AlumnoRepository;
import sv.edu.udb.repository.domain.Alumno;
import sv.edu.udb.service.AlumnoService;
import sv.edu.udb.service.mapper.AlumnoMapper;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {
    @NonNull
    private final AlumnoRepository alumnoRepository;
    @NonNull
    private final AlumnoMapper alumnoMapper;
    @Override
    public List<AlumnoResponse> findAll() {
        return alumnoMapper.toAlumnoResponseList(alumnoRepository.findAll());
    }
    @Override
    public AlumnoResponse findById(final Long id) {
        return alumnoMapper.toAlumnoResponse(
                alumnoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Resource not found id " + id)));
    }



        @Override
    public AlumnoResponse save(final AlumnoRequest alumnoRequest) {
        final Alumno alumno = alumnoMapper.toAlumno(alumnoRequest);
        return alumnoMapper.toAlumnoResponse(alumnoRepository.save(alumno));
    }
    @Override
    public AlumnoResponse update(final Long id, final AlumnoRequest alumnoRequest) {
        final Alumno alumnoToUpdate = alumnoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Resource not found id " + id));
        alumnoToUpdate.setNombre(alumnoRequest.getNombre());
        alumnoToUpdate.setApellido(alumnoRequest.getApellido());
//        alumnoToUpdate.setIdMateria(alumnoRequest.getIdMateria());
        alumnoRepository.save(alumnoToUpdate);
        alumnoRepository.save(alumnoToUpdate);
        return alumnoMapper.toAlumnoResponse(alumnoToUpdate);
    }
    @Override
    public void delete(final Long id) {
        alumnoRepository.deleteById(id);
    }
}
