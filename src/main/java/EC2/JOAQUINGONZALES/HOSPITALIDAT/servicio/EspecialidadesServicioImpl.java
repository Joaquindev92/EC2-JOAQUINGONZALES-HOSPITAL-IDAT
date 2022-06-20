package EC2.JOAQUINGONZALES.HOSPITALIDAT.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.EspecialidadDTOResponse;
import EC2.JOAQUINGONZALES.HOSPITALIDAT.modelo.Especialidad;

import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.EspecialidadDTORequest;
import EC2.JOAQUINGONZALES.HOSPITALIDAT.repositorio.EspecialidadRepositorio;

@Service
public class EspecialidadesServicioImpl implements EspecialidadServicio {

	
	@Autowired
	public EspecialidadRepositorio repositorio;

	@Override
	public void guardarEspecialidad(EspecialidadDTORequest especialidad) {
		Especialidad e = new Especialidad();
		e.setIdEspecialidad(especialidad.getIdEspecialidadDTO());
		e.setEspecialidad(especialidad.getEspecialidadDTO());
		e.setDiasAtiende(especialidad.getDiasAtiendeDTO());
				repositorio.save(e);
		
	}

	@Override
	public void editarEspecialidad(EspecialidadDTORequest especialidad) {
		Especialidad e = new Especialidad();
		e.setIdEspecialidad(especialidad.getIdEspecialidadDTO());
		e.setEspecialidad(especialidad.getEspecialidadDTO());
		e.setDiasAtiende(especialidad.getDiasAtiendeDTO());
		repositorio.saveAndFlush(e);
		
	}

	@Override
	public void eliminarEspecialidad(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
		
	}

	@Override
	public List<EspecialidadDTOResponse> listarEspecialidad() {
		List<EspecialidadDTOResponse> lista = new ArrayList<EspecialidadDTOResponse>();
		EspecialidadDTOResponse e = null;
		
		
		for (Especialidad especialidad : repositorio.findAll()) {
			
			e = new EspecialidadDTOResponse();
			
			e.setIdEspecialidadDTO(especialidad.getIdEspecialidad());
			e.setEspecialidadDTO(especialidad.getEspecialidad());
			e.setDiasAtiendeDTO(especialidad.getDiasAtiende());
			
			lista.add(e);
		}
		
		return lista ;
	}

	@Override
	public EspecialidadDTOResponse obtenerEspecialidadId(Integer id) {
Especialidad especialidad = repositorio.findById(id).orElse(null);
		
EspecialidadDTOResponse  e = new EspecialidadDTOResponse();
		
		e.setIdEspecialidadDTO(especialidad.getIdEspecialidad());
		e.setEspecialidadDTO(especialidad.getEspecialidad());
		e.setDiasAtiendeDTO(especialidad.getDiasAtiende());

		
		return e;
	}
	
	
}
