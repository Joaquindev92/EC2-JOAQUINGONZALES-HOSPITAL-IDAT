package EC2.JOAQUINGONZALES.HOSPITALIDAT.servicio;

import java.util.List;
import java.util.Optional;

import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.HospitalDTORequest;
import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.HospitalDTOResponse;
import EC2.JOAQUINGONZALES.HOSPITALIDAT.modelo.Hospital;

public interface HospitalServicio {

	public void guardarHospital(HospitalDTORequest hospital);

	public void editarHospital(HospitalDTORequest hospital);

	public void eliminarHospital(Integer id);

	public List<HospitalDTOResponse> listarHospital();

	public HospitalDTOResponse obtenerHospitalId(Integer id);
}
