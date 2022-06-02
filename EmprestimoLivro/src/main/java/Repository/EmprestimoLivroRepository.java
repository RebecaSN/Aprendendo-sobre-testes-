package Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.EmprestimoLivro;

public interface EmprestimoLivroRepository extends JpaRepository<EmprestimoLivro, String> {

	Optional<EmprestimoLivro>findByNomeDaReserva(String nome);
}
