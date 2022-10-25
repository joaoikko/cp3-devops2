package br.com.fiap.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOCACAO")
@SequenceGenerator(name = "locacao", sequenceName = "SQ_TB_LOCACAO", allocationSize = 1)
public class Locacao {

	@Id
	@Column(name = "cd_locacao")
	@GeneratedValue(generator = "locacao", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name = "dt_locacao", nullable = false)
	private LocalDateTime data;

	@Column(name = "vl_total", nullable = false, precision = 10, scale = 2)
	private BigDecimal vlTotal;

	@Enumerated(EnumType.STRING)
	@Column(name = "st_locacao", nullable = false, length = 20)
	private StatusLocacao status;
	
	@ManyToMany(mappedBy = "locacao")
	private List<Carro> carro;
	
	@OneToOne(mappedBy = "locacao")
	private NotaFiscal notaFiscal;
	
	@ManyToOne
	@JoinColumn(name="cd_cliente")
	private Cliente cliente;

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public BigDecimal getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}

	public StatusLocacao getStatus() {
		return status;
	}

	public void setStatus(StatusLocacao status) {
		this.status = status;
	}

	public Locacao() {
	}

	public Locacao(LocalDateTime data, BigDecimal vlTotal, StatusLocacao status) {
		super();
		this.data = data;
		this.vlTotal = vlTotal;
		this.status = status;
	}

	
}
