package times.jogadores;

import times.Membro;
import times.interfaces.IEstatistico;

public class Jogador extends Membro implements IEstatistico {
    private int numeroCamisa;
    private String posicao;
    private EstatisticaJogador estatisticas;

    public Jogador(int id, String nome, int idade, double salarioBase, int numeroCamisa, String posicao) {
        super(id, nome, idade, salarioBase);
        this.numeroCamisa = numeroCamisa;
        this.posicao = posicao;
        this.estatisticas = new EstatisticaJogador();
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public EstatisticaJogador getEstatisticas() {
        return estatisticas;
    }

    @Override
    public void registrarPartida(int minutos) {
        estatisticas.adicionarPartida(minutos);
        System.out.println("Partida registrada para " + nome + " (" + minutos + " min em campo).");
    }

    @Override
    public void registrarGol() {
        estatisticas.adicionarGol();
        System.out.println("Gol marcado por " + nome + "!");
    }

    @Override
    public void registrarAssistencia() {
        estatisticas.adicionarAssistencia();
        System.out.println("Assistência computada para " + nome + "!");
    }

    @Override
    public void registrarCartaoAmarelo() {
        estatisticas.adicionarCartaoAmarelo();
        System.out.println("Cartão amarelo aplicado a " + nome + ".");
    }

    @Override
    public void registrarCartaoVermelho() {
        estatisticas.adicionarCartaoVermelho();
        System.out.println("Cartão vermelho aplicado a " + nome + "!");
    }

    @Override
    public void exibirRelatorioEstatistico() {
        System.out.println("\n=== ESTATÍSTICAS DO JOGADOR: " + nome + " ===");
        System.out.println("Posição: " + posicao + " | Camisa: nº " + numeroCamisa);
        System.out.println("Partidas Jogadas: " + estatisticas.getPartidas());
        System.out.println("Minutos em Campo: " + estatisticas.getMinutosJogados());
        System.out.println("Gols Marcados: " + estatisticas.getGols());
        System.out.println("Assistências: " + estatisticas.getAssistencias());
        System.out.printf("Média de Gols/Jogo: %.2f\n", estatisticas.calcularMediaGolsPorPartida());
        System.out.println("Cartões Amarelos: " + estatisticas.getCartoesAmarelos());
        System.out.println("Cartões Vermelhos: " + estatisticas.getCartoesVermelhos());
    }

    @Override
    public double calcularSalarioTotal() {
        // Bônus: R$ 500 por gol e R$ 300 por assistência
        double bonusEstatistico = (estatisticas.getGols() * 500.0) + (estatisticas.getAssistencias() * 300.0);
        return salarioBase + bonusEstatistico;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Função: Jogador");
        System.out.println("Posição: " + posicao);
        System.out.println("Camisa: nº " + numeroCamisa);
        System.out.println("Gols: " + estatisticas.getGols() + " | Assistências: " + estatisticas.getAssistencias());
    }
}