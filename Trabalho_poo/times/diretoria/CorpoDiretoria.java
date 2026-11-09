package times.diretoria;

import times.Membro;

public abstract class CorpoDiretoria extends Membro {
    protected String departamento;

    public CorpoDiretoria(int id, String nome, int idade, double salarioBase, String departamento) {
        super(id, nome, idade, salarioBase);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Departamento: " + departamento);
    }
}