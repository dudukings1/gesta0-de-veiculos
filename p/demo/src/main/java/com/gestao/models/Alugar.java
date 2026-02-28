package com.gestao.models;

public class Alugar {

    private String nome;
    private String cpf;
    private String nomec;
    private int dias;
    public Alugar() {
    }
    public Alugar(String nome, String cpf, String nomec, int dias) {
        this.nome = nome;
        this.cpf = cpf;
        this.nomec = nomec;
        this.dias = dias;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getNomec() {
        return nomec;
    }
    public int getDias() {
        return dias;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNomec(String nomec) {
        this.nomec = nomec;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    @Override
public String toString() {
    return "Alugar{" +
            "nome='" + nome + '\'' +
            ", cpf='" + cpf + '\'' +
            ", nomec='" + nomec + '\'' +
            ", data='" + dias + '\'' +
            '}';
}
}
