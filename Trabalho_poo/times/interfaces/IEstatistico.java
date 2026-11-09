package times.interfaces;

public interface IEstatistico {
    void registrarPartida(int minutos);
    void registrarGol();
    void registrarAssistencia();
    void registrarCartaoAmarelo();
    void registrarCartaoVermelho();
    void exibirRelatorioEstatistico();
}