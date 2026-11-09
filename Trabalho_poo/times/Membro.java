package times;

import times.interfaces.IContratavel;

public abstract class Membro implements IContratavel {
    protected int id;
    protected String nome;
    protected int idade;
    protected double salarioBase;
    protected boolean contratoAtivo;

    public Membro(int id, String nome, int idade, double salarioBase) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.salarioBase = salarioBase;
        this.contratoAtivo = true;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public boolean isContratoAtivo() {
        return contratoAtivo;
    }

    public abstract double calcularSalarioTotal();

    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.printf("Salário Base: R$ %.2f\n", salarioBase);
        System.out.printf("Salário Total: R$ %.2f\n", calcularSalarioTotal());
        System.out.println("Status Contratual: " + (contratoAtivo ? "Ativo" : "Rescindido"));
    }

    @Override
    public void renovarContrato(int mesesAdicionais) {
        if (contratoAtivo) {
            System.out.println("Contrato de " + nome + " renovado por mais " + mesesAdicionais + " meses.");
        } else {
            System.out.println("Não é possível renovar: contrato rescindido.");
        }
    }

    @Override
    public void rescindirContrato() {
        if (contratoAtivo) {
            this.contratoAtivo = false;
            System.out.println("Contrato de " + nome + " foi rescindido.");
        } else {
            System.out.println("O contrato já se encontra rescindido.");
        }
    }
}