package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import times.Membro;
import times.corpotecnico.Tecnico;
import times.diretoria.Diretor;
import times.jogadores.Jogador;

public class Main {
    private static List<Membro> elenco = new ArrayList<>();
    private static int proximoId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        adicionarMembro();
                        break;
                    case 2:
                        listarMembros();
                        break;
                    case 3:
                        atualizarMembro();
                        break;
                    case 4:
                        removerMembro();
                        break;
                    case 5:
                        gerenciarEstatisticas();
                        break;
                    case 6:
                        gerenciarContrato();
                        break;
                    case 0:
                        System.out.println("\nFinalizando o Gerenciador de Futebol...");
                        break;
                    default:
                        System.out.println("\nOpção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nErro de entrada: Digite apenas um número inteiro válido.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("   GERENCIADOR DE CLUBE DE FUTEBOL");
        System.out.println("1. Adicionar Membro ao Clube");
        System.out.println("2. Listar Profissionais do Clube");
        System.out.println("3. Atualizar Dados de Membro");
        System.out.println("4. Remover Membro (Demissão)");
        System.out.println("5. Gerenciar Estatísticas do Jogador");
        System.out.println("6. Gerenciar Contrato de Membro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarMembro() {
        System.out.println("\n Adicionar Novo Membro");
        System.out.println("1. Jogador");
        System.out.println("2. Técnico (Corpo Técnico)");
        System.out.println("3. Diretor (Diretoria)");
        System.out.print("Selecione o tipo de membro: ");

        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Salário Base (R$): ");
        double salario = Double.parseDouble(scanner.nextLine());

        switch (tipo) {
            case 1:
                System.out.print("Número da Camisa: ");
                int camisa = Integer.parseInt(scanner.nextLine());
                System.out.print("Posição (ex: Goleiro, Zagueiro, Meia, Atacante): ");
                String posicao = scanner.nextLine();
                elenco.add(new Jogador(proximoId++, nome, idade, salario, camisa, posicao));
                System.out.println("Jogador cadastrado com sucesso!");
                break;
            case 2:
                System.out.print("Especialidade: ");
                String esp = scanner.nextLine();
                System.out.print("Bônus por Vitória (R$): ");
                double bonus = Double.parseDouble(scanner.nextLine());
                elenco.add(new Tecnico(proximoId++, nome, idade, salario, esp, bonus));
                System.out.println("Técnico cadastrado com sucesso!");
                break;
            case 3:
                System.out.print("Departamento: ");
                String dept = scanner.nextLine();
                System.out.print("Verba sob Gestão (R$): ");
                double verba = Double.parseDouble(scanner.nextLine());
                elenco.add(new Diretor(proximoId++, nome, idade, salario, dept, verba));
                System.out.println("Diretor cadastrado com sucesso!");
                break;
            default:
                System.out.println("Tipo inválido. Operação cancelada.");
        }
    }

    private static void listarMembros() {
        System.out.println("\n QUADRO DE PROFISSIONAIS DO CLUBE");
        System.out.println("\n------------------------------------");
        if (elenco.isEmpty()) {
            System.out.println("Nenhum membro cadastrado.");
         System.out.println("\n------------------------------------");
            return;
        }

        for (Membro m : elenco) {
            System.out.println("---------------------------------");
            m.mostrarInfo();
        }
        System.out.println("---------------------------------");
    }

    private static void atualizarMembro() {
        System.out.print("\nDigite o ID do membro que deseja atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Membro m = buscarPorId(id);
        if (m == null) {
            System.out.println("Membro com ID " + id + " não encontrado.");
            return;
        }

        System.out.println("Atualizando: " + m.getNome());
        System.out.print("Novo Nome (deixe em branco para manter): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.trim().isEmpty()) {
            m.setNome(novoNome);
        }

        System.out.print("Nova Idade (ou 0 para manter): ");
        int novaIdade = Integer.parseInt(scanner.nextLine());
        if (novaIdade > 0) {
            m.setIdade(novaIdade);
        }

        System.out.print("Novo Salário Base (ou 0 para manter): ");
        double novoSalario = Double.parseDouble(scanner.nextLine());
        if (novoSalario > 0) {
            m.setSalarioBase(novoSalario);
        }

        if (m instanceof Jogador) {
            Jogador j = (Jogador) m;
            System.out.print("Nova Posição (deixe em branco para manter): ");
            String novaPos = scanner.nextLine();
            if (!novaPos.trim().isEmpty()) {
                j.setPosicao(novaPos);
            }
            System.out.print("Novo Número de Camisa (ou 0 para manter): ");
            int novaCamisa = Integer.parseInt(scanner.nextLine());
            if (novaCamisa > 0) {
                j.setNumeroCamisa(novaCamisa);
            }
        }

        System.out.println("Dados atualizados com sucesso!");
    }

    private static void removerMembro() {
        System.out.print("\nDigite o ID do membro a ser removido: ");
        int id = Integer.parseInt(scanner.nextLine());

        Membro m = buscarPorId(id);
        if (m != null) {
            elenco.remove(m);
            System.out.println("Membro " + m.getNome() + " removido com sucesso!");
        } else {
            System.out.println("Membro com ID " + id + " não encontrado.");
        }
    }

    private static void gerenciarEstatisticas() {
        System.out.print("\nDigite o ID do jogador: ");
        int id = Integer.parseInt(scanner.nextLine());

        Membro m = buscarPorId(id);
        if (m == null) {
            System.out.println("Membro não encontrado.");
            return;
        }

        if (!(m instanceof Jogador)) {
            System.out.println("O membro selecionado (" + m.getNome() + ") não é um Jogador.");
            return;
        }

        Jogador jogador = (Jogador) m;

        System.out.println("\n GERENCIAR ESTATÍSTICAS DE " + jogador.getNome().toUpperCase());
        System.out.println("1. Exibir Relatório Estatístico");
        System.out.println("2. Registrar Partida");
        System.out.println("3. Registrar Gol");
        System.out.println("4. Registrar Assistência");
        System.out.println("5. Registrar Cartão Amarelo");
        System.out.println("6. Registrar Cartão Vermelho");
        System.out.print("Opção: ");

        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1:
                jogador.exibirRelatorioEstatistico();
                break;
            case 2:
                System.out.print("Minutos jogados: ");
                int min = Integer.parseInt(scanner.nextLine());
                jogador.registrarPartida(min);
                break;
            case 3:
                jogador.registrarGol();
                break;
            case 4:
                jogador.registrarAssistencia();
                break;
            case 5:
                jogador.registrarCartaoAmarelo();
                break;
            case 6:
                jogador.registrarCartaoVermelho();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void gerenciarContrato() {
        System.out.print("\nDigite o ID do membro: ");
        int id = Integer.parseInt(scanner.nextLine());

        Membro m = buscarPorId(id);
        if (m == null) {
            System.out.println("Membro não encontrado.");
            return;
        }

        System.out.println("\n GESTÃO CONTRATUAL: " + m.getNome().toUpperCase());
        System.out.println("1. Renovar Contrato");
        System.out.println("2. Rescindir Contrato");
        System.out.print("Opção: ");

        int op = Integer.parseInt(scanner.nextLine());
        if (op == 1) {
            System.out.print("Meses a adicionar: ");
            int meses = Integer.parseInt(scanner.nextLine());
            m.renovarContrato(meses);
        } else if (op == 2) {
            m.rescindirContrato();
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static Membro buscarPorId(int id) {
        for (Membro m : elenco) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
}