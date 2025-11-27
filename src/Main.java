import java.util.Scanner;

import model.Cliente;
import service.ClienteService;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ClienteService service = new ClienteService();

        int opcao = -1;
        
        //MENU PRINCIPAL DA APLICAÇÃO
        while (opcao != 0) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Buscar Cliente por Nome");
            System.out.println("4 - Editar Cliente");
            System.out.println("5 - Remover Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            
            opcao = sc.nextInt();
            sc.nextLine();
            
            //EXECUTA A AÇÃO ESCOLHIDA PELO USUÁRIO
            switch (opcao) {
                
                case 1:
                    System.out.println("\n--- Cadastro de Cliente ---"); 
                    
                    System.out.print("Nome: "); // Cadastro de nome
                    String nome = sc.nextLine();
                    
                    System.out.print("Email: "); //Cadastro de Email
                    String email = sc.nextLine();
                    
                    System.out.print("Telefone: "); //Cadastro de Telefone
                    String telefone = sc.nextLine();
                    
                    Cliente novoCliente = new Cliente(0, nome, email, telefone);
                    service.adicionarCliente(novoCliente);

                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2: //FAZER A LISTAGEM DE CLIENTES
                    System.out.println("\n--- Lista de Clientes ---");
                    if (service.listarClientes().isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (Cliente c : service.listarClientes()) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 3: //BUSCAR CLIENTES PELO NOME
                    System.out.println("\n--- Buscar Cliente ---");
                    System.out.print("Digite o nome: ");
                    String nomeBusca = sc.nextLine();

                    Cliente encontrado = service.buscarPorNome(nomeBusca);

                    if (encontrado != null) {
                        System.out.println("Cliente encontrado:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4: //EDIÇÃO DO CLIENTE
                    System.out.println("\n--- Editar Cliente ---");
                    System.out.print("Digite o nome do cliente que deseja editar: ");
                    String nomeEditar = sc.nextLine();

                    Cliente clienteEditar = service.buscarPorNome(nomeEditar);

                    if (clienteEditar == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();

                    System.out.print("Novo telefone: ");
                    String novoTelefone = sc.nextLine();

                    boolean editado = service.editarCliente(nomeEditar, novoNome, novoEmail, novoTelefone);

                    if (editado) {
                        System.out.println("Cliente editado com sucesso!");
                    } else {
                        System.out.println("Não foi possível editar o cliente.");
                    }
                    break;

                case 5: //REMOÇÃO DE CLIENTES
                    System.out.println("\n--- Remover Cliente ---");
                    System.out.print("Digite o nome do cliente: ");
                    String nomeRemover = sc.nextLine();

                    boolean removido = service.removerCliente(nomeRemover);

                    if (removido) {
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 0: //FINALIZAÇÃO DO PROGRAMA
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        sc.close();
    }}