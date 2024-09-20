package main;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        int id = 1;
        char continuar;

        do {
            System.out.println("┌──────────────────────────────────────────┐");
            System.out.println("│-----------Cadastro Pessoas-------------- │");
            System.out.println("├──────────────────────────────────────────┤");
            System.out.println("│                                          │");
            System.out.println("│1- Adicionar uma pessoa                   │");
            System.out.println("│2- Listagem de pessoas                    │");
            System.out.println("│3- Buscar telefone de uma pessoa          │");
            System.out.println("│4- Editar telefone de uma pessoa          │");
            System.out.println("│0- Sair do sistema                        │");
            System.out.println("│                                          │");
            System.out.println("└──────────────────────────────────────────┘");
            System.out.print("Escolha uma das opções: ");

            int opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    sc.nextLine();
                    System.out.println("Digite o endereço: ");
                    String endereco = sc.nextLine();
                    System.out.println("Digite o email: ");
                    String email = sc.nextLine();
                    System.out.println("Digite o telefone: ");
                    String telefone = sc.nextLine();
                    System.out.println("Link da foto: ");
                    String foto = sc.nextLine();
                    System.out.println("Digite o nome da pessoa: ");
                    String name = sc.nextLine();
                    System.out.println("Digite a data de nascimento (DD/MM/YYYY): ");
                    String dataStr = sc.nextLine(); 
                    System.out.println("Digite o sexo: ");
                    String sexo = sc.nextLine();
                    System.out.println("Digite o nome da mãe: ");
                    String mae = sc.nextLine();
                    System.out.println("Digite o nome do pai: ");
                    String pai = sc.nextLine();

                    
                    SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");
                    Date data = format.parse(dataStr);

                    Pessoa novaPessoa = new Pessoa(id, name, data, sexo, mae, pai, endereco, email, telefone, foto);
                    pessoas.add(novaPessoa);
                    System.out.println("Pessoa adicionada");
                    id = id + 1;
                }
                break;
                case 2: {
                    System.out.println("Lista de pessoas");
                    if (pessoas.isEmpty()) {
                        System.out.println("Lista vazia");
                    } else {
                        for (Pessoa pe : pessoas) {
                            System.out.println("ID: " + pe.pes_id);
                            System.out.println("Nome: " + pe.pes_nome);
                            System.out.println("Data de nascimento: " + pe.pes_data_nascimento);
                            System.out.println("Telefone: " + pe.getTelefone());
                        }
                    }
                }
                break;
                case 3: {
                    sc.nextLine();
                    System.out.println("Digite o telefone da pessoa : ");
                    String procurar = sc.nextLine();
                    boolean found = false;
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa.getTelefone().contains(procurar)) {
                            System.out.println("Pessoa encontrada");
                            System.out.println("Nome: " + pessoa.pes_nome);
                            System.out.println("Telefone: " + pessoa.getTelefone());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Pessoa inexistente.");
                    }
                }
                break;
                case 4: {
                    System.out.println("ID para edita: ");
                    int procurar = sc.nextInt();
                    boolean found = false;
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa.pes_id == procurar) {
                            System.out.println("Pessoa encontrada");
                            System.out.println("Nome: " + pessoa.pes_nome);
                            System.out.println("Telefone: " + pessoa.getTelefone());

                            System.out.println("Um novo número de telefone da pessoa: ");
                            sc.nextLine();
                            String newTelefone = sc.nextLine();

                            pessoa.setTelefone(newTelefone);
                            System.out.println("Nome: " + pessoa.pes_nome);
                            System.out.println("Novo telefone: " + pessoa.getTelefone());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Pessoa não encontrada.");
                    }
                }
                break;
                case 0:
                    System.out.println("Saindo!");
                    break;
                default:
                    System.out.println("Inválido!.");
                    break;
            }

            if (opcao != 0) {
                System.out.println("Deseja continuar no sistema? (S/N)");
                continuar = sc.next().charAt(0);
            } else {
                continuar = 'N'; 
            }

        } while (continuar == 's' || continuar == 'S');

        sc.close();
    }
}