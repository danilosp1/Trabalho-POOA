package org.example;

import com.enums.*;
import com.interfaces.UserInterface;
import com.model.*;
import com.model.users.Admin;
import com.model.users.Master;
import com.model.users.Player;
import com.model.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<UserInterface> usuarios = new ArrayList<>();
    private static List<SystemRPG> sistemasDisponiveis = new ArrayList<>();
    private static List<Campaign> campanhas = new ArrayList<>();
    private static UserInterface usuarioLogado = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        main1();
//        main2();
    }

    private static void main1() {
        Admin admin = (Admin) UserFactory.createUser("administrador", "admin", CourseType.CIENCIA_COMPUTACAO, "811164", GenderType.MASCULINO, 20, "...");
        Master master1 = (Master) UserFactory.createUser("mestre", "master1", CourseType.CIENCIAS, "873182", GenderType.MASCULINO, 18, "...");
        Player player1 = (Player) UserFactory.createUser("jogador", "player1", CourseType.DIREITO, "424155", GenderType.FEMININO, 22, "...");
        Player player2 = (Player) UserFactory.createUser("jogador", "player2", CourseType.ENGENHARIA, "744556", GenderType.FEMININO, 30, "...");
        Player player3 = (Player) UserFactory.createUser("jogador", "player3", CourseType.FISICA, "955665", GenderType.MASCULINO, 17, "...");

        usuarios.add(admin);
        usuarios.add(master1);
        usuarios.add(player2);
        usuarios.add(player3);
        Admin.setUsuarios(usuarios);

        SystemRPG sistema1 = new SystemRPG("sistema1", "...");
        SystemRPG sistema2 = new SystemRPG("sistema2", "...");
        SystemRPG sistema3 = new SystemRPG("sistema3", "...");

        sistemasDisponiveis.add(sistema1);
        sistemasDisponiveis.add(sistema2);


        Campaign c1 = new Campaign("campanha1", 10, 5, master1, 3, "...", StatusType.ATIVA, "01/01/2025", "30/01/2025", sistema1);
        Campaign c2 = new Campaign("campanha2", 20, 10, master1, 5, "...", StatusType.ATIVA, "01/01/2025", "30/01/2025", sistema2);
        Campaign c3 = new Campaign("campanha3", 20, 10, master1, 5, "...", StatusType.ATIVA, "01/01/2025", "30/01/2025", sistema2);
        campanhas.add(c1);
        campanhas.add(c2);


        Admin.setAvailableSystems(sistemasDisponiveis);
        Admin.setAvailableCampaign(campanhas);

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Caso de Uso 1: Admin gerenciar Campanhas");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Admin.printAvailableCampaign();
        Admin.deleteCampaign(c1);
        Admin.createCampaign(c3);
        Admin.printAvailableCampaign();

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Caso de Uso 2: Admin gerenciar Sistemas");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Admin.printAvailableSystems();
        Admin.deleteSystem(sistema1);
        Admin.createSystem(sistema3);
        Admin.printAvailableSystems();

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Caso de Uso 3: Mestre gerenciar Campanhas");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        master1.addCampaign(c1);
        master1.addCampaign(c2);
        master1.changeStatus(c1, StatusType.FINALIZADA);
        player1.addCampaing(c1);
        master1.printCampaignPlayers(c1);
        master1.removeCampaign(c1);

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Caso de Uso 4: Player gerencia campanhas");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        player1.addCampaing(c2);
        player1.printCampaign();
        master1.changeStatus(c1, StatusType.CANCELADA);
        player1.removeCampaing(c1);
        player1.printCampaign();

    }

    private static void main2() {
        int opcao;
        do {
            System.out.println();
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarUser();
                    break;
                case 2:
                    loginUser();
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
            UserInterface user = UserFactory.createUser(tipo, name, course, ra, genre, age, description);
            usuarios.add(user);
        } else {
            System.out.println("Tipo de usuário inválido.");
        }
    }

    private static void loginUser() {
        System.out.print("Digite o RA do usuário: ");
        String ra = scanner.nextLine();

        for (UserInterface usuario : usuarios) {
            if (((User) usuario).getRa().equals(ra)) {
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
            System.out.println();
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

        SystemRPG sistema = new SystemRPG(nome, regras);
        sistemasDisponiveis.add(sistema);

        Admin.createSystem(sistema);
    }

    private static void deletarSystemRPG() {
        System.out.print("Digite o nome do sistema RPG a ser deletado: ");
        String nome = scanner.nextLine();

        for (SystemRPG sistema : sistemasDisponiveis) {
            if (sistema.getName().equals(nome)) {
                Admin.deleteSystem(sistema);
                sistemasDisponiveis.remove(sistema);
                return;
            }
        }
        System.out.println("Sistema RPG não encontrado.");
    }

    private static void gerenciarUser() {
        System.out.print("Digite o ID do usuário a ser gerenciado: ");
        String id = scanner.nextLine();

        for (UserInterface usuario : usuarios) {
            if (((User) usuario).getId().toString().equals(id)) {
                System.out.print("Escolha uma ação (suspender, reativar, deletar): ");
                String acao = scanner.nextLine();
                ((Admin) usuarioLogado).manageUser((User) usuario, acao);
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    private static void menuPlayer() {
        int opcao;
        do {
            System.out.println();
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
                        ((Player) usuarioLogado).addCampaing(campanha);
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