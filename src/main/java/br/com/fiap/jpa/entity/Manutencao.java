package br.com.fiap.jpa.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MANUTENCAO")
@SequenceGenerator(name = "manutencao", sequenceName = "SQ_TB_MANUTENCAO", allocationSize = 1)
public class Manutencao {

	@Id
	@Column(name = "cd_manutencao")
	@GeneratedValue(generator = "manutencao", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Enumerated(EnumType.STRING)
	@Column(name = "st_manutencao", nullable = false, length = 20)
	private StatusManutencao stManutencao;

	@Column(name = "vl_total", nullable = false, precision = 10, scale = 2)
	private BigDecimal vlTotal;

	public StatusManutencao getStManutencao() {
		return stManutencao;
	}

	public void setStManutencao(StatusManutencao stManutencao) {
		this.stManutencao = stManutencao;
	}

	public BigDecimal getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}

	public Manutencao() {
	}

	public Manutencao(StatusManutencao stManutencao, BigDecimal vlTotal) {
		super();
		this.stManutencao = stManutencao;
		this.vlTotal = vlTotal;
	}

}
