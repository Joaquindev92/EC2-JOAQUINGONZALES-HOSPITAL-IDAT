package EC2.JOAQUINGONZALES.HOSPITALIDAT.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.HospitalDTORequest;
import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.HospitalDTOResponse;

import EC2.JOAQUINGONZALES.HOSPITALIDAT.modelo.Hospital;

import EC2.JOAQUINGONZALES.HOSPITALIDAT.repositorio.HospitalRepositorio;

@Service
public class HospitalesServicioImpl implements HospitalServicio {

	
	@Autowired
	public HospitalRepositorio repositorio;
	
	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		Hospital e = new Hospital();
		e.setIdHospital(hospital.getIdHospitalDTO());
		e.setNombre(hospital.getNombreDTO());
		e.setDescripcion(hospital.getDescripcionDTO());
		e.setDistrito(hospital.getDistritoDTO());
				repositorio.save(e);
		
	}

	@Override
	public void editarHospital(HospitalDTORequest hospital) {
		Hospital e = new Hospital();
		e.setIdHospital(hospital.getIdHospitalDTO());
		e.setNombre(hospital.getNombreDTO());
		e.setDescripcion(hospital.getDescripcionDTO());
		e.setDistrito(hospital.getDistritoDTO());
		repositorio.saveAndFlush(e);
		
	}

	@Override
	public void eliminarHospital(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
		List<HospitalDTOResponse> lista = new ArrayList<HospitalDTOResponse>();
		HospitalDTOResponse e = null;
		
		
		for (Hospital hospital : repositorio.findAll()) {
			
			e = new HospitalDTOResponse();
			
			e.setIdHospitalDTO(hospital.getIdHospital());
			e.setNombreDTO(hospital.getNombre());
			e.setDescripcionDTO(hospital.getDescripcion());
			e.setDistritoDTO(hospital.getDistrito());
			
			lista.add(e);
		}
		
		return lista ;
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
		Hospital hospital = repositorio.findById(id).orElse(null);
		
		HospitalDTOResponse  e = new HospitalDTOResponse();
				
		e.setIdHospitalDTO(hospital.getIdHospital());
		e.setNombreDTO(hospital.getNombre());
		e.setDescripcionDTO(hospital.getDescripcion());
		e.setDistritoDTO(hospital.getDistrito());

				
				return e;
	}

}
