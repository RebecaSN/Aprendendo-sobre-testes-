package Sevice;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.EmprestimoLivro;
import Repository.EmprestimoLivroRepository;

@Service
public class EmprestimoLivroService {
	
	@Autowired
	EmprestimoLivroRepository emprestimoRepository;
	
	public int cauculoDeDias(String nome) {
		Optional<EmprestimoLivro> emprestimo = emprestimoRepository.findByNomeDaReserva(nome);
	return Period.between(emprestimo.get().getDataSaida(),emprestimo.get().getDataDevolucao()).getDays();
	}


}
