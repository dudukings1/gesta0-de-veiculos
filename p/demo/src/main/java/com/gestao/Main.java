package com.gestao;

import java.util.List;
import java.util.Scanner;

import com.gestao.models.Cliente;
import com.gestao.models.Alugar;
import com.gestao.models.veiculos;
import com.gestao.services.funcoes;
import com.gestao.services.verificacoes;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite 1 para alugar, 2 pra devolver e 4 entrar admin");
        int metodo = scanner.nextInt();
        scanner.nextLine(); // limpa buffer
        System.out.println("Digite seu cpf:");
        String cpf = scanner.nextLine();

        
        

        if (metodo == 4) {
            if (cpf.equals("234")) {
                System.out.println("Modo administrador");
                System.out.println("voce deseja fazer o que: 1 cadastrar alguem 2 cadastrar um carro 3 consultar todos os carros disponiveis e clientes da loja ");
                int metodoadm = scanner.nextInt();
                    if(metodoadm == 1) {
                        System.out.println("Digite o nome");
                        String nome = scanner.next();
                        System.out.println("Digite o cpf");
                        String cpf2 = scanner.next();
                        System.out.println("Digite a cnh");
                        int cnh = scanner.nextInt();
                        System.out.println("Digite quantos pontos na cnh tem");
                        int cnhpontos = scanner.nextInt();
                        System.out.println("Digite o email");
                        String email = scanner.next();
                        System.out.println("Digite a senha");
                        String senha = scanner.next();

                        Cliente cc = new Cliente();
                        cc.setNome(nome);
                        cc.setCnh(cnh);
                        cc.setSenha(senha);
                        cc.setPontoscnh(cnhpontos);
                        cc.setCpf(cpf2);
                        cc.setEmail(email);
                        cc.setBloq("normal");

                        String validacao = funcoes.validardados(nome, Integer.parseInt(cpf2), cnh, cnhpontos, email, senha);
                        if (!validacao.equals("Dados válidos")) {
                            String vv = verificacoes.salvar(cc);
                            System.out.println(vv);
                            System.out.println(validacao);
                            scanner.close();
                            return;
                        }
                    }
                    if(metodoadm == 2) {
                        System.out.println("Modo cadastro de veículo");
                        System.out.println("Digite a marca: ");
                        String marca = scanner.next();
                        scanner.nextLine();
                        System.out.println("Digite o modelo: ");
                        String modelo = scanner.nextLine();
                        System.out.println("Digite a placa:");
                        String placaStr = scanner.nextLine();
                        int placa = Integer.parseInt(placaStr);
                        scanner.nextLine();
                        System.out.println("Digite o ano:");
                        int ano = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite os km rodados:");
                        double kmrodados = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Digite o nome:");
                        String nome = scanner.nextLine();

                        System.out.println("Está disponível? (true/false)");
                        boolean disponivel = scanner.nextBoolean();
                        scanner.nextLine();

                        veiculos novoVeiculo = new veiculos(kmrodados, placa, nome, disponivel, marca, modelo, ano);
                        String mensagem = verificacoes.salvar(novoVeiculo);
                        System.out.println(mensagem);
                    } else {
                        
                        
                        System.out.println("Consultando todos os carro e clientes disponiveis...");
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
                            System.out.println("---------- PESSOAS ----------");
                            List<Cliente> vv = verificacoes.buscarClientes();
                    }



                
            } else {
                System.out.println("Nao esxiste nenhum admin com este cpf");
            }
        }

        if (metodo == 1) {

             // limpa buffer

            // ADMIN
            
            

            Cliente encontrado = verificacoes.buscarPorCpf(cpf);
            
            System.out.println(encontrado);

            if (cpf.equals("235")) {

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

                    System.out.println("Quantos dias deseja ficar com o carro? (Diária 90 reais) caso a entrega atrase havera taxas adicionais");
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
                    String ver2 = verificacoes.salvardevolucao2(nomecarro);
                    Alugar a = new Alugar(cliente.getNome(), cliente.getCpf(), nomecarro, dias);
                    String mensagem = verificacoes.salvarcalguram(a);
                    System.out.println(mensagem);
                    System.out.println("Aluguel realizado com sucesso!");

                } else {
                    System.out.println("Você está bloqueado no sistema.");
                }

            } else {
                System.out.println("Nenhum cliente cadastrado com este CPF.");
            }
        }

        if(metodo == 2) {
            System.out.println("Digite o nome do veiculo que voce alugou: ");
            String nomev = scanner.next();
            List<veiculos> va = verificacoes.buscarDevolver(nomev);

            if(va == null) {
                System.out.println("nao a nenhum veiculos com este nome para devolver");
                scanner.close();
                return;
            }
            System.out.println("Veiculo encontrado!");
            System.out.println("Quantos dias voce ficou com o carro: ");
            int diasf = scanner.nextInt();
            List<Integer> ve = verificacoes.verificarDias(diasf, nomev);
            if(ve.get(0) != null || ve.get(0) != 0) {
            int resultado = funcoes.calculartaxa(ve.get(0), diasf);
            System.out.println("Voce tem que pagar uma taxa a mais de" + resultado);
            }
            String ver = verificacoes.salvardevolucao(nomev);
            System.out.println("Devolucao concluida");

        }
        scanner.close();
    }
}