package com.gestao;

import java.util.List;
import java.util.Scanner;

import com.gestao.models.Cliente;
import com.gestao.models.veiculos;
import com.gestao.services.funcoes;
import com.gestao.services.verificacoes;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite 1 para alugar, 2 pra devolver e 3 pra consultar");
        int metodo = scanner.nextInt();
        scanner.nextLine(); // limpa buffer

        if (metodo == 1) {

            System.out.println("Digite seu cpf:");
            int cpf = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            // ADMIN
            if (cpf == 234) {
                System.out.println("Modo administrador");
                System.out.println("voce deseja fazer o que: 1 cadastrar alguem 2 cadastrar um carro 3 consultar todos os carros disponiveis e clientes da loja ");
                int metodoadm = scanner.nextInt();
                    if(metodoadm == 1) {

                    }
                    if(metodoadm == 2) {

                    } else {
                        System.out.println("Digite a placa:");
                int placa = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite o nome:");
                String nome = scanner.nextLine();

                System.out.println("Está disponível? (true/false)");
                boolean disponivel = scanner.nextBoolean();
                scanner.nextLine();

                veiculos novoVeiculo = new veiculos(120.21, placa, nome, disponivel);
                String mensagem = verificacoes.salvar(novoVeiculo);
                System.out.println(mensagem);
                    }



                
            }

            Cliente encontrado = verificacoes.buscar(cpf);

            if (encontrado != null) {

                System.out.println("--- LISTA DE VEÍCULOS ---");
                List<veiculos> listaDisponiveis = verificacoes.buscarDisponiveis();

                int i = 1;
                for (veiculos v : listaDisponiveis) {
                    System.out.println("---------- Veículo " + i + " ----------");
                    System.out.println("Nome: " + v.getNome());
                    System.out.println("Quilometros rodados: " + v.getKmrodados());
                    System.out.println("Placa: " + v.getPlaca());
                    System.out.println("Status: " + (v.getDisponivel() ? "Disponível" : "Alugado"));
                    i++;
                }

                System.out.println("Digite o nome do veículo que você quer:");
                String nomecarro = scanner.nextLine();
                
                veiculos escolhido = null;

                for (veiculos v : listaDisponiveis) {
                    if (nomecarro.equalsIgnoreCase(v.getNome())) {
                        escolhido = v;
                        break;
                    }
                }

                if (escolhido == null) {
                    System.out.println("Não existe veículo com esse nome.");
                    scanner.close();
                    return;
                }

                Cliente cliente = verificacoes.buscarPorCpf(cpf);

                if (!"bloqueado".equalsIgnoreCase(cliente.getBloq())) {

                    System.out.println("Quantos dias deseja ficar com o carro? (Diária 90 reais)");
                    int dias = scanner.nextInt();
                    scanner.nextLine();

                    int valor = funcoes.diasprapagar(dias);

                    System.out.println("Você irá pagar: R$ " + valor);
                    System.out.println("Resumo do pedido:");
                    System.out.println("Veículo: " + nomecarro);
                    System.out.println("Dias: " + dias);

                    System.out.println("Se o pedido está errado digite 1 para cancelar");
                    int pedido = scanner.nextInt();
                    scanner.nextLine();

                    if (pedido == 1) {
                        System.out.println("Pedido cancelado.");
                        scanner.close();
                        return;
                    }

                    System.out.println("Método de pagamento:");
                    System.out.println("1 - PIX");
                    System.out.println("2 - CARTÃO");

                    int metodoPagamento = scanner.nextInt();
                    scanner.nextLine();

                    if (metodoPagamento == 1) {
                        System.out.println("Gerando QR Code...");
                    } else {
                        System.out.println("Use a maquininha.");
                    }

                    System.out.println("Aluguel realizado com sucesso!");

                } else {
                    System.out.println("Você está bloqueado no sistema.");
                }

            } else {
                System.out.println("Nenhum cliente cadastrado com este CPF.");
            }
        }

        scanner.close();
    }
}