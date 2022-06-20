package EC2.JOAQUINGONZALES.HOSPITALIDAT.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EC2.JOAQUINGONZALES.HOSPITALIDAT.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	Usuario findByUsuario(String usuario);

}
