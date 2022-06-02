package Model;

import java.time.LocalDate;

public class EmprestimoLivro {
	
	private String id;
	
	private String nomeDaReserva;
	
	private LocalDate dataSaida;
	
	private LocalDate dataDevolucao;
	
	private String nomeLivro;

	public EmprestimoLivro(String id, String nomeDaReserva, LocalDate dataSaida, LocalDate dataDevolucao,
			String nomeLivro) {
		super();
		this.id = id;
		this.nomeDaReserva = nomeDaReserva;
		this.dataSaida = dataSaida;
		this.dataDevolucao = dataDevolucao;
		this.nomeLivro = nomeLivro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeDaReserva() {
		return nomeDaReserva;
	}

	public void setNomeDaReserva(String nomeDaReserva) {
		this.nomeDaReserva = nomeDaReserva;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	
	

}
