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

import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.EspecialidadDTORequest;
import EC2.JOAQUINGONZALES.HOSPITALIDAT.dto.EspecialidadDTOResponse;

import EC2.JOAQUINGONZALES.HOSPITALIDAT.servicio.EspecialidadServicio;

@RestController
@RequestMapping("/especialidad/v1")
public class EspecialidadControlador {
	
	@Autowired
	private EspecialidadServicio servicio;
	
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<EspecialidadDTOResponse>>  listarProductos(){
		return new ResponseEntity<List<EspecialidadDTOResponse>>(servicio.listarEspecialidad(), HttpStatus.OK); 
	}
	
	@RequestMapping(path="/guardar", method=RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody EspecialidadDTORequest especialidad){
		
		servicio.guardarEspecialidad(especialidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity <EspecialidadDTOResponse> listarPorId(@PathVariable Integer id) {
		
		EspecialidadDTOResponse p = servicio.obtenerEspecialidadId(id);
		if (p != null) 
			return new ResponseEntity<EspecialidadDTOResponse>(p, HttpStatus.OK);
		
					return new ResponseEntity<EspecialidadDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT )
	public ResponseEntity<Void> editar(@RequestBody EspecialidadDTORequest especialidad){
		
		EspecialidadDTOResponse p = servicio.obtenerEspecialidadId(especialidad.getIdEspecialidadDTO());
		
		if (p !=null) {
		servicio.editarEspecialidad(especialidad);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		EspecialidadDTOResponse p = servicio.obtenerEspecialidadId(id);
		if(p !=null) {
			servicio.eliminarEspecialidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
}
}