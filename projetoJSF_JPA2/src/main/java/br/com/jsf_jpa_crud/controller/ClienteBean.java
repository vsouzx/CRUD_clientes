package br.com.jsf_jpa_crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.com.jsf_jpa_crud.dao.ClienteDAO;
import br.com.jsf_jpa_crud.model.Cliente;
import br.com.jsf_jpa_crud.model.JPAUtil;

@ManagedBean
@SessionScoped
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private List<Cliente> lista = new ArrayList<>();
	
	EntityManager em = JPAUtil.getEntityManager();
	ClienteDAO clienteDAO =new ClienteDAO(em);
	
	
	public List<Cliente> listarClientes(){
		lista = clienteDAO.listar();
		return lista;
	}
	
	public void inserir(){
		clienteDAO.salvar(cliente);
		cliente = new Cliente();
		lista = clienteDAO.listar();
		
	}
	
	public void excluir(Long id){
		clienteDAO.excluir(id);
		lista = clienteDAO.listar();
		cliente = new Cliente();
	}
	
	public void editar(Cliente c){
		cliente = c;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}
	
	

}
