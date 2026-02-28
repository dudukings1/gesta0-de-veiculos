package com.gestao.services;

public class funcoes {

        public String number;

        
        public static int diasprapagar(int dias) {
        return dias * 90;
        }
        public static String validardados(String nome, int cpf, int cnh, int pontoscnh, String email,String senha) {
        
                
                if(nome.length() < 3) {
                        return "Nome inválido";
                }
                if(cpf < 11) {
                        return "CPF inválido";
                } else if (cnh < 9) {
                        return "CNH inválida";
                } else if (pontoscnh < 0 || pontoscnh > 20) {
                        return "Pontuação da CNH inválida";
                } else if (!email.contains("@") || !email.contains(".")) {
                        return "Email inválido";
                } else if (senha.length() < 6) {
                        return "Senha deve conter pelo menos 6 caracteres";
                } else {
                        return "Dados válidos";
                }  
        }
        public static int calculartaxa(int dias, int diasf) {
                return (diasf - dias) * 30;
        }
}
