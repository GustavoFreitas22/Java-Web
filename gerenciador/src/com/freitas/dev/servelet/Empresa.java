package com.freitas.dev.servelet;

import java.util.Date;

/*  Entidade para ser gravada no Banco  */

public class Empresa {
	
	private int id;
	private String nome;
	private Date dataAbertura;
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
