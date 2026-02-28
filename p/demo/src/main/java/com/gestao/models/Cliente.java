package com.gestao.models;

public class Cliente {
    
    private String nome;
    private String cpf;
    private int cnh;
    private int pontoscnh;
    private String email;
    private String senha;
    private String bloq;


    public Cliente() {}
    
    public Cliente(String nome, String cpf, int cnh, int pontoscnh, String email,String senha, String bloq) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.pontoscnh = pontoscnh; 
        this.email = email;
        this.senha = senha;
        this.bloq = bloq;
    }
    public int getCnh() {
    return cnh;
}

public int getPontoscnh() {
    return pontoscnh;
}

public String getEmail() {
    return email;
}

public String getSenha() {
    return senha;
}

public String getBloq() {
    return bloq;
}
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    // SETTERS

public void setCnh(int cnh) {
    this.cnh = cnh;
}

public void setPontoscnh(int pontoscnh) {
    this.pontoscnh = pontoscnh;
}

public void setEmail(String email) {
    this.email = email;
}

public void setSenha(String senha) {
    this.senha = senha;
}

public void setBloq(String bloq) {
    this.bloq = bloq;
}
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
}
@Override
public String toString() {
    return "Cliente{" +
            "nome='" + nome + '\'' +
            ", cpf='" + cpf + '\'' +
            ", cnh=" + cnh +
            ", pontoscnh=" + pontoscnh +
            ", email='" + email + '\'' +
            ", senha='" + senha + '\'' +
            ", bloq='" + bloq + '\'' +
            '}';
}
}