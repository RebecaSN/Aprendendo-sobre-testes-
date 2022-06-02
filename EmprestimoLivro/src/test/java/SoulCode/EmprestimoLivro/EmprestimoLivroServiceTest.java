package SoulCode.EmprestimoLivro;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import Model.EmprestimoLivro;
import Repository.EmprestimoLivroRepository;
import Sevice.EmprestimoLivroService;

@RunWith(SpringRunner.class)//faz a ponte entre o spring boot o JUnit, mesmo sendo uma classe de teste, temo que rodar o springboot
public class EmprestimoLivroServiceTest {//teste com a camada de testes

	@TestConfiguration//configuraç~eos de como vai ser feita os nossos testes
	static class EmprestimoLivroServicetestConfig{//vamos crirar um metodo que vai retornar um emprestimo livro service, é como se estivessemos fazendo a instanciação do emprestimo livro service
		
		@Bean//vai ser usado dentro do teste, para executar os testes
		public EmprestimoLivroService emprestimoLivroService(){
			return new EmprestimoLivroService();//n usamos a classe original, criamos outra, uma instancia da original para poder fazer o teste
		}
	}
	//temos que fazer essa injeção de dependencia para ser criado o fake
	@Autowired
	EmprestimoLivroService emprestimoLivroService;
	
	@MockBean //serve para adiconar objetos simulados(fakes) ao nossos testes//permite clonar uma classe ou interface
     EmprestimoLivroRepository emprestimoLivroRepository;

	@Test//abaixo é o nosso metodo de teste, para vericar se o metodo que faz o cauculo de dias esta funcionando//imular dados de emprestimo
	public void EmprestimoLivroServiceCauculoDeDias() {
		
		String nomeReserva="Tatiana";
		int dias = emprestimoLivroService.cauculoDeDias(nomeReserva);//testando o metodo cauculo de dias que a gente ja tem
		
		Assertions.assertEquals(dias,10);      //eu sei que o resultado tem que ser 10, então vou comprar com esse resultado
	}
	
	//tem que ser executado antes do teste, ja que eu preciso instanciar o objeto livro que temm os dados que eu quero testar
	@Before
	public void setup(){//preparação para fazer o teste, n temos os dados para fazer o teste já que n lincamos uma tabela a ele, por isso vamos simular os dados aqui, para pegar os dados do objeto e aplicarmos o teste
 
		LocalDate dataSaida = LocalDate.parse("2022-05-10");//vai transofrmar a string em uma data
	    LocalDate dataDevolução = LocalDate.parse("2022-05-20");
	
	    EmprestimoLivro emprestimoLivro = new EmprestimoLivro("1","Tatiana",dataSaida,dataDevolução,"Kafka");
	
	    //quando eu for executar o teste e eu precisar de um dado ficticio, eu tenho que buscar atraves da função que eu tenho empretarlivrorepository, e executar os metodos seguintes
	   Mockito.when(emprestimoLivroRepository.findByNomeDaReserva(emprestimoLivro.getNomeDaReserva()))
	   .thenReturn(Optional.of(emprestimoLivro));
	
	}

}
//mocs:simular cenarios para testar as logicas que temos dentro da aplicação dublê dos dados verdadeiros , n fasemos testes nos dados reais da aplocação
//esses testes são feitos com os dados ficticios, os dados mocados da aplicação