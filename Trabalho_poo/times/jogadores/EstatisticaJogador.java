package times.jogadores;

public class EstatisticaJogador {
    private int partidas;
    private int gols;
    private int assistencias;
    private int cartoesAmarelos;
    private int cartoesVermelhos;
    private int minutosJogados;

    public EstatisticaJogador() {
        this.partidas = 0;
        this.gols = 0;
        this.assistencias = 0;
        this.cartoesAmarelos = 0;
        this.cartoesVermelhos = 0;
        this.minutosJogados = 0;
    }

    public int getPartidas() { return partidas; }
    public int getGols() { return gols; }
    public int getAssistencias() { return assistencias; }
    public int getCartoesAmarelos() { return cartoesAmarelos; }
    public int getCartoesVermelhos() { return cartoesVermelhos; }
    public int getMinutosJogados() { return minutosJogados; }

    public void adicionarPartida(int minutos) {
        this.partidas++;
        this.minutosJogados += minutos;
    }

    public void adicionarGol() { this.gols++; }
    public void adicionarAssistencia() { this.assistencias++; }
    public void adicionarCartaoAmarelo() { this.cartoesAmarelos++; }
    public void adicionarCartaoVermelho() { this.cartoesVermelhos++; }

    public double calcularMediaGolsPorPartida() {
        if (partidas == 0) return 0.0;
        return (double) gols / partidas;
    }
}