package EC2.JOAQUINGONZALES.HOSPITALIDAT.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import EC2.JOAQUINGONZALES.HOSPITALIDAT.modelo.Recepcionista;

@Repository
public interface RecepcionistaRepositorio extends JpaRepository<Recepcionista, Integer> {
	
	

}
