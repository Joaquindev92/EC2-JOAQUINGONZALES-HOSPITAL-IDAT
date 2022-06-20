package EC2.JOAQUINGONZALES.HOSPITALIDAT.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.HospitalDTORequest;
import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.HospitalDTOResponse;

import EC2.JOAQUINGONZALES.HOSPITALIDAT.servicio.HospitalServicio;

@RestController
@RequestMapping("/hospital/v1")
public class HospitalControlador {
	
	@Autowired
	private HospitalServicio servicio;
	
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<HospitalDTOResponse>>  listarHospital(){
		return new ResponseEntity<List<HospitalDTOResponse>>(servicio.listarHospital(), HttpStatus.OK); 
	}
	
	@RequestMapping(path="/guardar", method=RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody HospitalDTORequest hospital){
		
		servicio.guardarHospital(hospital);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity <HospitalDTOResponse> listarPorId(@PathVariable Integer id) {
		
		HospitalDTOResponse p = servicio.obtenerHospitalId(id);
		if (p != null) 
			return new ResponseEntity<HospitalDTOResponse>(p, HttpStatus.OK);
		
					return new ResponseEntity<HospitalDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT )
	public ResponseEntity<Void> editar(@RequestBody HospitalDTORequest hospital){
		
		HospitalDTOResponse p = servicio.obtenerHospitalId(hospital.getIdHospitalDTO());
		
		if (p !=null) {
		servicio.editarHospital(hospital);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		HospitalDTOResponse p = servicio.obtenerHospitalId(id);
		if(p !=null) {
			servicio.eliminarHospital(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
}
}