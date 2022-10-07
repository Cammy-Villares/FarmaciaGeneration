package com.generation.farmacia.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="O nome do produto é obrigatório!")
	@Size(min=5, max=100, message="O nome deve conter entre 5 e 100 caracteres")
	private String nome;
	
	@NotBlank(message="A descrição do produto é obrigatório!")
	@Size(min=100, max=2500, message="A descrição deve conter entre 100 a 2500 caracteres")
	private String descricao;
	
	@NotNull
	private int quantidade;
	
	@JsonFormat (shape=JsonFormat.Shape.STRING)
	@NotNull(message="Preço é obrigatório!")
	@Positive(message="O preço deve ser maior que zero")
	private BigDecimal preco;
	
	@NotBlank (message="É obrigatório informar o laboratório farmacêutico!")
	private String laboratorio;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categorization categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Categorization getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorization categoria) {
		this.categoria = categoria;
	}
}
