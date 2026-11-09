package times.corpotecnico;

public class Tecnico extends CorpoTecnico {
    private double bonusVitoria;
    private int vitoriasNoAno;

    public Tecnico(int id, String nome, int idade, double salarioBase, String especialidade, double bonusVitoria) {
        super(id, nome, idade, salarioBase, especialidade);
        this.bonusVitoria = bonusVitoria;
        this.vitoriasNoAno = 0;
    }

    public double getBonusVitoria() {
        return bonusVitoria;
    }

    public void setBonusVitoria(double bonusVitoria) {
        this.bonusVitoria = bonusVitoria;
    }

    public int getVitoriasNoAno() {
        return vitoriasNoAno;
    }

    public void registrarVitoria() {
        vitoriasNoAno++;
        System.out.println("Vitória registrada para o técnico " + nome + "! Total: " + vitoriasNoAno);
    }

    @Override
    public double calcularSalarioTotal() {
        return salarioBase + (vitoriasNoAno * bonusVitoria);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Cargo: Técnico Principal");
        System.out.println("Vitórias no Ano: " + vitoriasNoAno);
    }
}