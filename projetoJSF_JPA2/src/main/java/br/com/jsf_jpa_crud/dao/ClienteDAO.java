package br.com.jsf_jpa_crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.jsf_jpa_crud.model.Cliente;
import br.com.jsf_jpa_crud.model.JPAUtil;

public class ClienteDAO {

	EntityManager em = JPAUtil.getEntityManager();
	
	public ClienteDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(Cliente cliente) {
		this.em.getTransaction().begin();
		this.em.persist(cliente);
		this.em.getTransaction().commit();
	}

	public void editar(Cliente cliente) {
		this.em.getTransaction().begin();
		this.em.merge(cliente);
		this.em.getTransaction().commit();
	}
	
	public void excluir(Long id) {
		Cliente c = new Cliente();
		c= em.find(Cliente.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
	}
	
	public Cliente buscar(Long id) {
		Cliente cliente = this.em.find(Cliente.class, id);
		return cliente;
	}
	
	public List<Cliente> listar(){
		String jpql = "SELECT c from Cliente c";
		List<Cliente> listaClientes = this.em.createQuery(jpql, Cliente.class)
		.getResultList();
		return listaClientes;
	}
	
	
}
