package com.gestao.models;

public class veiculos {
    
    private String nome;
    private int placa;
    private double kmrodados;
    private boolean disponivel;
    private String marca;
    private String modelo;
    private int ano;

    public veiculos() {}

    public veiculos(double kmrodados, int placa, String nome, boolean disponivel, String marca, String modelo, int ano) {
        this.nome = nome;
        this.kmrodados = kmrodados;
        this.placa = placa;
        this.disponivel = disponivel;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
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
        public String getMarca() {
            return marca;
        }
        public String getModelo() {
            return modelo;
        }
        public int getAno() {
            return ano;
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
        public void setMarca(String marca) {
            this.marca = marca;
        }
        public void setModelo(String modelo) {
            this.modelo = modelo;
        }
        public void setAno(int ano) {
            this.ano = ano;
        }
}   
