package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.MateriaRequest;
import sv.edu.udb.controller.response.MateriaResponse;
import sv.edu.udb.repository.MateriaRepository;
import sv.edu.udb.repository.domain.Materia;
import sv.edu.udb.service.MateriaService;
import sv.edu.udb.service.mapper.MateriaMapper;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MateriaServiceImpl implements MateriaService {
    @NonNull
    private final MateriaRepository materiaRepository;
    @NonNull
    private final MateriaMapper materiaMapper;
    @Override
    public List<MateriaResponse> findAll() {
        return materiaMapper.toMateriaResponseList(materiaRepository.findAll());
    }
    @Override
    public MateriaResponse findById(final Long id) {
        return materiaMapper.toMateriaResponse(
                materiaRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Resource not found id " + id)));
    }



    @Override
    public MateriaResponse save(final MateriaRequest materiaRequest) {
        final Materia materia = materiaMapper.toMateria(materiaRequest);
        return materiaMapper.toMateriaResponse(materiaRepository.save(materia));
    }
    @Override
    public MateriaResponse update(final Long id, final MateriaRequest materiaRequest) {
        final Materia materiaToUpdate = materiaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Resource not found id " + id));
        materiaToUpdate.setNombre(materiaRequest.getNombre());
        materiaRepository.save(materiaToUpdate);
        materiaRepository.save(materiaToUpdate);
        return materiaMapper.toMateriaResponse(materiaToUpdate);
    }
    @Override
    public void delete(final Long id) {
        materiaRepository.deleteById(id);
    }
}
