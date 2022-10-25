package br.com.fiap.jpa.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CARRO")
@SequenceGenerator(name="carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro {

	
	@Id
	@Column(name="cd_carro")
	@GeneratedValue(generator = "carro", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_carro", nullable = false, length = 20)
	private String nmCarro;
	
	@Column(name="mc_marca", nullable = false, length = 20)
	private String mcMarca;
	
	@Column(name="ds_placa", nullable = false, length = 8)
	private String placa;
	
	@Enumerated(EnumType.STRING)
	@Column(name="st_carro", nullable = false, length = 20)
	private StatusCarro stCarro;
	
	@Column(name="vl_locacao", nullable = false, precision = 10, scale = 2)
	private BigDecimal vlLocacao;
	
	@ManyToMany
	@JoinTable(name="TB_CARRO_LOCACAO",
	joinColumns = @JoinColumn(name="cd_carro"),
	inverseJoinColumns = @JoinColumn(name="cd_locacao"))
	private List<Locacao> locacao;

	public String getNmCarro() {
		return nmCarro;
	}

	public void setNmCarro(String nmCarro) {
		this.nmCarro = nmCarro;
	}

	public String getMcMarca() {
		return mcMarca;
	}

	public void setMcMarca(String mcMarca) {
		this.mcMarca = mcMarca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public StatusCarro getStCarro() {
		return stCarro;
	}

	public void setStCarro(StatusCarro stCarro) {
		this.stCarro = stCarro;
	}

	public BigDecimal getVlLocacao() {
		return vlLocacao;
	}

	public void setVlLocacao(BigDecimal vlLocacao) {
		this.vlLocacao = vlLocacao;
	}
	
	public Carro () {}

	public Carro(String nmCarro, String mcMarca, String placa, StatusCarro stCarro, BigDecimal vlLocacao) {
		super();
		this.nmCarro = nmCarro;
		this.mcMarca = mcMarca;
		this.placa = placa;
		this.stCarro = stCarro;
		this.vlLocacao = vlLocacao;
	}
	
}
