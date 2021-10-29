package com.freitas.dev.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> list = new ArrayList<>();
	private static List<Usuario> listUser = new ArrayList<>();
	
	private static Integer chave = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("FreitasDev");
		empresa.setId(chave++);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Autbank");
		empresa2.setId(chave++);
		list.add(empresa2);
		list.add(empresa);
		
		Usuario user1 = new Usuario();
		user1.setLogin("Freitas");
		user1.setSenha("123456");
		
		listUser.add(user1);
	}

	public void add(Empresa empresa) {
		list.add(empresa);
		empresa.setId(Banco.chave++);
	}
	
	public void remove(int id) {
		
		Iterator<Empresa> it = list.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId()== id) {
				it.remove();
			}
		}
		
	}
	
	public List<Empresa> getEmpresa(){
		return Banco.list;
	}

	public Empresa buscaId(int id) {
		for (Empresa empresa : list) {
			if(empresa.getId()==id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario buscaUser(String login, String senha) {
		for (Usuario user : listUser) {
			if(user.auth(login, senha)) {
				return user;
			}
		}
		return null;
	}

}
