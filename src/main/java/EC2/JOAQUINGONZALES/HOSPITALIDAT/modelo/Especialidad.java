package EC2.JOAQUINGONZALES.HOSPITALIDAT.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Especialidades")
@Entity
public class Especialidad implements Serializable {

	private static final long serialVersionUID = 4631194868089344564L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidad;
	private String especialidad;
	private Integer diasAtiende;
	


	@OneToOne(mappedBy = "especialidad")
	private Recepcionista recepcionista;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "especialidad_hospital", joinColumns = @JoinColumn(name = 
	"id_hospital", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(id_hospital) references clientes(id_hospital)")), inverseJoinColumns = @JoinColumn(name =
	"id_especialidad", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(id_especialidad) references especialidad(id_especialidad)"))

	)
	private List<Hospital> cliente = new ArrayList<Hospital>();
	
	public Especialidad() {
		super();
	}



	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}



	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}



	public String getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}



	public Integer getDiasAtiende() {
		return diasAtiende;
	}



	public void setDiasAtiende(Integer diasAtiende) {
		this.diasAtiende = diasAtiende;
	}
	
	

}
