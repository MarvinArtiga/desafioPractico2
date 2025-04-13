package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.MateriaRequest;
import sv.edu.udb.controller.response.MateriaResponse;
import sv.edu.udb.repository.domain.Materia;
import java.util.List;
@Mapper(componentModel = "spring")
public interface MateriaMapper {
    MateriaResponse toMateriaResponse(final Materia data);
    List<MateriaResponse> toMateriaResponseList(final List<Materia> MateriaList);
    Materia toMateria(final MateriaRequest materiaRequest);
}