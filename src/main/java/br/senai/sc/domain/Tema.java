package br.senai.sc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tema;
	private String cor_toalha;
	private String valor_tema;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tema")
	private List<Festa>festas = new ArrayList<Festa>();
	
	@ElementCollection
	@CollectionTable(name="ITENS")
	private Set<String> itens = new HashSet<>();

	public Tema() {
	}


	public Tema(Integer id, String tema, String cor_toalha, String valor_tema) {
		super();
		this.id = id;
		this.tema = tema;
		this.cor_toalha = cor_toalha;
		this.valor_tema = valor_tema;
	}

	

	public Set<String> getItens() {
		return itens;
	}


	public void setItens(Set<String> itens) {
		this.itens = itens;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTema() {
		return tema;
	}


	public void setTema(String tema) {
		this.tema = tema;
	}


	public String getCor_toalha() {
		return cor_toalha;
	}


	public void setCor_toalha(String cor_toalha) {
		this.cor_toalha = cor_toalha;
	}


	public String getValor_tema() {
		return valor_tema;
	}


	public void setValor_tema(String valor_tema) {
		this.valor_tema = valor_tema;
	}


	public List<Festa> getFestas() {
		return festas;
	}


	public void setFestas(List<Festa> festas) {
		this.festas = festas;
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
		Tema other = (Tema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	

}
