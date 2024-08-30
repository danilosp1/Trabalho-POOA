package org.example;

import com.enums.*;
import com.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> usuarios = new ArrayList<>();
    private static List<SystemRPG> sistemasDisponiveis = new ArrayList<>();
    private static List<Campaign> campanhas = new ArrayList<>();
    private static User usuarioLogado = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    if (usuarioLogado instanceof Admin) {
                        menuAdmin();
                    } else if (usuarioLogado instanceof Player) {
                        menuPlayer();
                    } else if (usuarioLogado instanceof Master) {
                        menuMaster();
                    } else {
                        System.out.println("Nenhum usuário logado.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Criar usuário");
        System.out.println("2. Login");
        System.out.println("3. Ações do usuário logado");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarUser() {
        System.out.print("Digite o tipo de usuário (administrador, jogador, mestre): ");
        String tipo = scanner.nextLine();
        if(tipo.equalsIgnoreCase("administrador") || tipo.equalsIgnoreCase("jogador") || tipo.equalsIgnoreCase("mestre")) {
            System.out.print("Digite o nome: ");
            String name = scanner.nextLine();
            System.out.println("Digite o curso (ENGENHARIA, CIENCIAS, MATEMATICA, FISICA, LETRAS, DIREITO, CIENCIA_COMPUTACAO): ");
            CourseType course = CourseType.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Digite o RA: ");
            String ra = scanner.nextLine();
            System.out.print("Digite o gênero (masculino, feminino, outro): ");
            GenderType genre = GenderType.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Digite a idade: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite a descrição: ");
            String description = scanner.nextLine();
            User user = UserFactory.createUser(tipo, name, course, ra, genre, age, description);
            usuarios.add(user);
        } else {
            System.out.println("Tipo de usuário inválido.");
        }
    }

    private static void loginUser() {
        System.out.print("Digite o ID do usuário: ");
        String id = scanner.nextLine();

        for (User usuario : usuarios) {
            if (usuario.getId().toString().equals(id)) {
                usuarioLogado = usuario;
                System.out.println("Login realizado com sucesso!");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    private static void menuAdmin() {
        int opcao;
        do {
            System.out.println("=== Menu Admin ===");
            System.out.println("1. Criar sistema RPG");
            System.out.println("2. Deletar sistema RPG");
            System.out.println("3. Gerenciar usuário");
            System.out.println("0. Logout");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarSystemRPG();
                    break;
                case 2:
                    deletarSystemRPG();
                    break;
                case 3:
                    gerenciarUser();
                    break;
                case 0:
                    usuarioLogado = null;
                    System.out.println("Logout realizado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void criarSystemRPG() {
        System.out.print("Digite o nome do sistema RPG: ");
        String nome = scanner.nextLine();
        System.out.print("Digite as regras do sistema RPG: ");
        String regras = scanner.nextLine();

        SystemRPG sistemaRPG = new SystemRPG(nome, regras);
        sistemasDisponiveis.add(sistemaRPG);

        ((Admin) usuarioLogado).createSystem(sistemaRPG);
    }

    private static void deletarSystemRPG() {
        System.out.print("Digite o nome do sistema RPG a ser deletado: ");
        String nome = scanner.nextLine();

        for (SystemRPG sistema : sistemasDisponiveis) {
            if (sistema.getName().equals(nome)) {
                ((Admin) usuarioLogado).deleteSystem(sistema);
                sistemasDisponiveis.remove(sistema);
                return;
            }
        }
        System.out.println("Sistema RPG não encontrado.");
    }

    private static void gerenciarUser() {
        System.out.print("Digite o ID do usuário a ser gerenciado: ");
        String id = scanner.nextLine();

        for (User usuario : usuarios) {
            if (usuario.getId().toString().equals(id)) {
                System.out.print("Escolha uma ação (suspender, reativar, deletar): ");
                String acao = scanner.nextLine();
                ((Admin) usuarioLogado).manageUser(usuario, acao);
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    private static void menuPlayer() {
        int opcao;
        do {
            System.out.println("=== Menu Player ===");
            System.out.println("1. Criar ficha de personagem");
            System.out.println("2. Solicitar inscrição em campanha");
            System.out.println("0. Logout");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarFichaPersonagem();
                    break;
                case 2:
                    solicitarInscricaoCampaign();
                    break;
                case 0:
                    usuarioLogado = null;
                    System.out.println("Logout realizado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void criarFichaPersonagem() {
        System.out.print("Digite o nome do personagem: ");
        String name = scanner.nextLine();
        System.out.print("Digite o nível do personagem: ");
        int level = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite a idade do personagem: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o gênero do personagem (masculino, feminino, outro): ");
        GenderType genre = GenderType.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Digite a classe do personagem (GUERREIRO, MAGO, LADINO, CLERIGO, CURANDEIRO): ");
        CharacterClassType classe = CharacterClassType.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Digite a raça do personagem (HUMANO, ELFO, ANAO, ORC): ");
        RaceType race = RaceType.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Digite a descrição do personagem: ");
        String description = scanner.nextLine();
        scanner.nextLine();

        ((Player) usuarioLogado).createCharacter(name, level,genre, age, classe, race, description);

        System.out.println("Ficha de personagem criada com sucesso!");
    }

    private static void solicitarInscricaoCampaign() {
        System.out.print("Digite o nome da campanha para inscrição: ");
        String nomeCampaign = scanner.nextLine();

        for (Campaign campanha : campanhas) {
            if (campanha.getName().equals(nomeCampaign)) {
                System.out.print("Digite o nome da ficha de personagem para inscrição: ");
                String nomeFicha = scanner.nextLine();

                for (CharacterSheet ficha : ((Player) usuarioLogado).getCharacterSheet()) {
                    if (ficha.getName().equals(nomeFicha)) {
                        ((Player) usuarioLogado).requestSubscription(campanha, ficha);
                        return;
                    }
                }
                System.out.println("Ficha de personagem não encontrada.");
                return;
            }
        }
        System.out.println("Campaign não encontrada.");
    }

    private static void menuMaster() {
        int opcao;
        do {
            System.out.println("=== Menu Master ===");
            System.out.println("1. Criar campanha");
            System.out.println("2. Iniciar sessão de campanha");
            System.out.println("0. Logout");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarCampaign();
                    break;
                case 2:
                    iniciarSessaoCampaign();
                    break;
                case 0:
                    usuarioLogado = null;
                    System.out.println("Logout realizado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void criarCampaign() {
        System.out.print("Digite o nome do sistema de RPG: ");
        String systemName = scanner.nextLine();

        for(SystemRPG system : sistemasDisponiveis){
            if(system.getName().equals(systemName)){
                System.out.print("Digite o nome da campanha: ");
                String name = scanner.nextLine();
                System.out.print("Digite o número máximo de players: ");
                int maxPlayers = Integer.parseInt(scanner.nextLine());
                System.out.print("Digite o número mínimo de players: ");
                int minPlayers = Integer.parseInt(scanner.nextLine());
                System.out.print("Digite o número de sessões: ");
                int sessionsNumber = Integer.parseInt(scanner.nextLine());
                System.out.print("Digite a data de início da campanha: ");
                String startDate = scanner.nextLine();
                System.out.print("Digite a data de finalização da campanha: ");
                String endDate = scanner.nextLine();
                System.out.print("Digite a descrição da campanha: ");
                String description = scanner.nextLine();

                Campaign campaign = new Campaign(name, maxPlayers, minPlayers, (Master) usuarioLogado, sessionsNumber, description, StatusType.ATIVA, startDate, endDate, system);

                campanhas.add(campaign);
                System.out.println("Camapnha criada com sucesso!");
                return;
            }
        }
        System.out.println("Sistema não encontrado.");
    }

    private static void iniciarSessaoCampaign() {
        System.out.print("Digite o nome da campanha: ");
        String nomeCampaign = scanner.nextLine();

        for (Campaign campanha : campanhas) {
            if (campanha.getName().equals(nomeCampaign)) {
                System.out.print("Digite a data da sessão: ");
                String date = scanner.nextLine();
                System.out.print("Digite a descrição da sessão: ");
                String description = scanner.nextLine();

                Session sessao = new Session(date, description);

                campanha.addSession(sessao);
                campanha.startSession(sessao);
                return;
            }
        }
        System.out.println("Campaign não encontrada.");
    }
}