package service;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;

/*
 * Classe responsável por gerenciar os clientes.
 * Contém operações de CRUD (Create, read, Update and Delete).
 */

public class ClienteService {

	private List<Cliente> clientes;
	private int contadorId = 1; // // gera IDs únicos automaticamente

	public ClienteService() {
		this.clientes = new ArrayList<>();
	}

	// CONSTRUTOR QUE INICIALIZA A LISTA DE CLIENTES
	public void adicionarCliente(Cliente cliente) {

		// Adiciona um cliente à lista gerando automaticamente um ID exclusivo
		Cliente novo = new Cliente(contadorId, cliente.getNome(), cliente.getEmail(), cliente.getTelefone());

		clientes.add(novo);
		contadorId++;
	}

	// Retorna a lista completa dos clientes
	public List<Cliente> listarClientes() {
		return clientes;
	}

	//  Busca um cliente pelo nome, ignorando diferenças de caixa.
	public Cliente buscarPorNome(String nome) {
		for (Cliente c : clientes) {
			if (c.getNome().equalsIgnoreCase(nome)) {
				return c;
			}
		}
		return null;
	}

	// Altera os dados de um cliente já cadastrado
	public boolean editarCliente(String nomeBusca, String novoNome, String novoEmail, String novoTelefone) {
		Cliente c = buscarPorNome(nomeBusca);

		if (c != null) {
			c.setNome(novoNome);
			c.setEmail(novoEmail);
			c.setTelefone(novoTelefone);
			return true;
		}

		return false;
	}

	// Remove um cliente da lista pelo nome.
	public boolean removerCliente(String nome) {
		Cliente c = buscarPorNome(nome);

		if (c != null) {
			clientes.remove(c);
			return true;
		}

		return false;
	}
}