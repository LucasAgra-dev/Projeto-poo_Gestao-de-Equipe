package times.corpotecnico;

import times.Membro;

public abstract class CorpoTecnico extends Membro {
    protected String especialidade;

    public CorpoTecnico(int id, String nome, int idade, double salarioBase, String especialidade) {
        super(id, nome, idade, salarioBase);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Especialidade: " + especialidade);
    }
}