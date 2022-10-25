package br.com.fiap.jpa.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CarroDao;
import br.com.fiap.jpa.dao.ClienteDao;
import br.com.fiap.jpa.dao.LocacaoDao;
import br.com.fiap.jpa.dao.ManutencaoDao;
import br.com.fiap.jpa.dao.NotaFiscalDao;
import br.com.fiap.jpa.dao.impl.CarroDaoImpl;
import br.com.fiap.jpa.dao.impl.ClienteDaoImpl;
import br.com.fiap.jpa.dao.impl.LocacaoDaoImpl;
import br.com.fiap.jpa.dao.impl.ManutencaoDaoImpl;
import br.com.fiap.jpa.dao.impl.NotaFiscalDaoImpl;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Locacao;
import br.com.fiap.jpa.entity.Manutencao;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.entity.StatusCarro;
import br.com.fiap.jpa.entity.StatusLocacao;
import br.com.fiap.jpa.entity.StatusManutencao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Cadastro {
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("antoniel", 1454814442, 44445565, 011, LocalDateTime.now());
		
		NotaFiscal nota = new NotaFiscal (new BigDecimal("1000"), LocalDateTime.now(), new BigDecimal("1900"), 81144122, 123456); 
		
		Locacao locacao = new Locacao(LocalDateTime.now(), new BigDecimal("1900"), StatusLocacao.ESPERANDO_PAGAMENTO);
		
		Carro carro = new Carro("audi rs6", "Audi", "EQJ-7880", StatusCarro.LIVRE, new BigDecimal("3000"));
		
		Manutencao manutencao = new Manutencao(StatusManutencao.FINALIZADO, new BigDecimal("8000"));


		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ClienteDao dao = new ClienteDaoImpl(em);
		NotaFiscalDao notaDao = new NotaFiscalDaoImpl(em);
		LocacaoDao locacaoDao = new LocacaoDaoImpl(em);	
		ManutencaoDao manutencaoDao = new ManutencaoDaoImpl(em);
		CarroDao carroDao = new CarroDaoImpl(em);
	
		try {
			dao.cadastrar(cliente);
			dao.commit();
			
			notaDao.cadastrar(nota);
			notaDao.commit();
			
			locacaoDao.cadastrar(locacao);
			locacaoDao.commit();
			
			carroDao.cadastrar(carro);
			carroDao.commit();
			
			manutencaoDao.cadastrar(manutencao);
			manutencaoDao.commit();
			
			
		}catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
