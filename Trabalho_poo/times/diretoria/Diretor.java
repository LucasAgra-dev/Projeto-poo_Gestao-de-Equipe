package times.diretoria;

public class Diretor extends CorpoDiretoria {
    private double verbaAlocada;

    public Diretor(int id, String nome, int idade, double salarioBase, String departamento, double verbaAlocada) {
        super(id, nome, idade, salarioBase, departamento);
        this.verbaAlocada = verbaAlocada;
    }

    public double getVerbaAlocada() {
        return verbaAlocada;
    }

    public void setVerbaAlocada(double verbaAlocada) {
        this.verbaAlocada = verbaAlocada;
    }

    @Override
    public double calcularSalarioTotal() {
        return salarioBase * 1.15;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Cargo: Diretor Executivo");
        System.out.printf("Verba sob Gestão: R$ %.2f\n", verbaAlocada);
    }
}