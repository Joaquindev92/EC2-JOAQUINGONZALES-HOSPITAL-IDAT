package EC2.JOAQUINGONZALES.HOSPITALIDAT.modelo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="Recepcionistas")
@Entity
public class Recepcionista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Integer idRecepcionista;
	private String nombre;
	private Integer celular;
	
	@OneToOne
	@JoinColumn(name="id_especialidad", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_especialidad) references especialidades(id_especialidad)"))
	private Especialidad especialidad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	

}
