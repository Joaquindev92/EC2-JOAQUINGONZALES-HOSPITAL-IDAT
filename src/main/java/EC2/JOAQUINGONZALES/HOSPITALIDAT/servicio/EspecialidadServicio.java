package EC2.JOAQUINGONZALES.HOSPITALIDAT.servicio;

import java.util.List;
import java.util.Optional;

import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.EspecialidadDTORequest;
import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.EspecialidadDTOResponse;
import EC2.JOAQUINGONZALES.HOSPITALIDAT.modelo.Especialidad;

public interface EspecialidadServicio {

	public void guardarEspecialidad(EspecialidadDTORequest especialidad);

	public void editarEspecialidad(EspecialidadDTORequest especialidad);

	public void eliminarEspecialidad(Integer id);

	public List<EspecialidadDTOResponse> listarEspecialidad();

	public EspecialidadDTOResponse obtenerEspecialidadId(Integer id);
}
