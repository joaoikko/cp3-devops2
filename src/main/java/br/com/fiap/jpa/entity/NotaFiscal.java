package br.com.fiap.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_NOTA_FISCAL")
@SequenceGenerator(name="nota", sequenceName = "SQ_TB_NOTA_FISCAL", allocationSize = 1)
public class NotaFiscal {

	@Id
	@Column(name="cd_nota_fiscal")
	@GeneratedValue(generator = "nota", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="vl_imposto", precision = 10, scale = 2)
	private BigDecimal vlImposto;
	
	@Column(name="dt_emissao")
	private LocalDateTime dtEmissao;
	
	@Column(name="vl_nota_fiscal", nullable = false, precision = 10, scale = 2)
	private BigDecimal vlNota;
	
	@Column(name="cd_verificacao", precision = 48)
	private Integer cdVerificacao;
	
	@Column(name="nr_nota", precision = 48)
	private Integer nrNota;
	
	@OneToOne
	@JoinColumn(name="cd_locacao")
	private Locacao locacao;

		
	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getVlImposto() {
		return vlImposto;
	}

	public void setVlImposto(BigDecimal vlImposto) {
		this.vlImposto = vlImposto;
	}

	public LocalDateTime getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(LocalDateTime dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public BigDecimal getVlNota() {
		return vlNota;
	}

	public void setVlNota(BigDecimal vlNota) {
		this.vlNota = vlNota;
	}

	public Integer getCdVerificacao() {
		return cdVerificacao;
	}

	public void setCdVerificacao(Integer cdVerificacao) {
		this.cdVerificacao = cdVerificacao;
	}

	public Integer getNrNota() {
		return nrNota;
	}

	public void setNrNota(Integer nrNota) {
		this.nrNota = nrNota;
	}

	public NotaFiscal () {}
	
	public NotaFiscal(BigDecimal vlImposto, LocalDateTime dtEmissao, BigDecimal vlNota, Integer cdVerificacao,
			Integer nrNota) {
		super();
		this.vlImposto = vlImposto;
		this.dtEmissao = dtEmissao;
		this.vlNota = vlNota;
		this.cdVerificacao = cdVerificacao;
		this.nrNota = nrNota;
	}
	
	
	
	
}
