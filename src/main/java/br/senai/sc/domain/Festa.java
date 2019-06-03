package br.senai.sc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Festa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String endereco;
	private Date data_festa;
	private Date hora_ini;
	private Date hora_fim;
	private Double valor_cobrado;
	
	@ManyToOne
	@JoinColumn(name = "tema_id")
	private Tema tema;
	
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public Festa() {
	}

	

	public Festa(Integer id, String endereco, Date data_festa, Date hora_ini, Date hora_fim, Double valor_cobrado,
			Tema tema, Cliente cliente) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.data_festa = data_festa;
		this.hora_ini = hora_ini;
		this.hora_fim = hora_fim;
		this.valor_cobrado = valor_cobrado;
		this.tema = tema;
		this.cliente = cliente;
	}


	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_festa() {
		return data_festa;
	}

	public void setData_festa(Date data_festa) {
		this.data_festa = data_festa;
	}

	public Date getHora_ini() {
		return hora_ini;
	}

	public void setHora_ini(Date hora_ini) {
		this.hora_ini = hora_ini;
	}

	public Date getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(Date hora_fim) {
		this.hora_fim = hora_fim;
	}

	public Double getValor_cobrado() {
		return valor_cobrado;
	}

	public void setValor_cobrado(Double valor_cobrado) {
		this.valor_cobrado = valor_cobrado;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Festa other = (Festa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
