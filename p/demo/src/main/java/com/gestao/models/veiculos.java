package com.gestao.models;

public class veiculos {
    
    private String nome;
    private int placa;
    private double kmrodados;
    private boolean disponivel;

    public veiculos() {}

    public veiculos(double kmrodados, int placa, String nome, boolean disponivel) {
        this.nome = nome;
        this.kmrodados = kmrodados;
        this.placa = placa;
        this.disponivel = disponivel;
    }
    
    // GET
        
    public boolean getDisponivel() {
            return disponivel;
        }
        public String getNome() {
            return nome;
        }
        public int getPlaca() {
            return placa;
        }
        public double getKmrodados() {
            return kmrodados;
        }
    
        // SET
        
    public void setDisponivel(boolean disponivel) {
            this.disponivel = disponivel;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public void setPlaca(int placa) {
            this.placa = placa;
        }
        public void setKmrodados(double kmrodados) {
            this.kmrodados = kmrodados;
        }
}
