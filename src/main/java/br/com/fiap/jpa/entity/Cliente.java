package br.com.fiap.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {
	
	@Id
	@Column(name="cd_cliente")
	@GeneratedValue(generator = "cliente", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_cliente", nullable = false, length = 50)
	private String nome;
	
	@Column(name="nr_cpf", nullable = false, precision = 14)
	private Integer cpf;
	
	@Column(name="nr_cartao_credito", nullable = false , precision = 16)
	private Integer cartaoCredito;
	
	@Column(name="nr_codigo_seguranca", nullable = false, precision = 3)
	private Integer cdSeguranca;
	
	@Column(name= "dt_validade_cartao", nullable = false)
	private LocalDateTime dtValidadeCartao;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
	private List<Locacao> locacao = new ArrayList<Locacao>();
	
	public List<Locacao> getLocacao() {
		return locacao;
	}

	public void setLocacao(List<Locacao> locacao) {
		this.locacao = locacao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(Integer cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public Integer getCdSeguranca() {
		return cdSeguranca;
	}

	public void setCdSeguranca(Integer cdSeguranca) {
		this.cdSeguranca = cdSeguranca;
	}

	public LocalDateTime getDtValidadeCartao() {
		return dtValidadeCartao;
	}

	public void setDtValidadeCartao(LocalDateTime dtValidadeCartao) {
		this.dtValidadeCartao = dtValidadeCartao;
	}

	public Cliente () {}
	
	public Cliente(String nome, Integer cpf, Integer cartaoCredito, Integer cdSeguranca,
			LocalDateTime dtValidadeCartao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cartaoCredito = cartaoCredito;
		this.cdSeguranca = cdSeguranca;
		this.dtValidadeCartao = dtValidadeCartao;
	}
	
	

}
