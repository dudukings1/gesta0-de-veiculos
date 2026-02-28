package com.gestao.services;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestao.models.Cliente;
import com.gestao.models.veiculos;
import com.gestao.models.Alugar;
public class verificacoes {

    // AJUSTE NO SALVAR: Ele precisa receber o objeto Cliente completo
    public static String salvar(Cliente novoCliente) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File("cliente.json");
        List<Cliente> listaClientes = new ArrayList<>();

        // 1. Se o arquivo já existir, a gente lê a lista atual primeiro
        if (arquivo.exists()) {
            listaClientes = mapper.readValue(arquivo, new TypeReference<List<Cliente>>(){});
        }

        // 2. Adiciona o novo cliente na lista (na memória)
        listaClientes.add(novoCliente);

        // 3. Salva a lista completa (com o novo) de volta no arquivo
        mapper.writeValue(arquivo, listaClientes);
        
        return "Cliente adicionado com sucesso!";
    } catch (Exception e) {
        e.printStackTrace();
        return "Erro ao adicionar cliente";
    }
}
public static Cliente buscarPorCpf(String cpf) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File("cliente.json");

        if (!arquivo.exists()) {
            return null;
        }

        List<Cliente> clientes = Arrays.asList(
                mapper.readValue(arquivo, Cliente[].class)
        );

        for (Cliente c : clientes) {
            if (c.getCpf() != null && c.getCpf().equals(cpf)) {
                return c;
            }
        }

        return null;

    } catch (Exception e) {
        System.err.println("Erro na leitura: " + e.getMessage());
        return null;
    }
}
    
    

    public static String salvar(veiculos novoVeiculos) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File("veiculos.json");
        List<veiculos> listaVeiculos = new ArrayList<>();

        // 1. Se o arquivo já existir, a gente lê a lista atual primeiro
        if (arquivo.exists()) {
            listaVeiculos = mapper.readValue(arquivo, new TypeReference<List<veiculos>>(){});
        }

        // 2. Adiciona o novo cliente na lista (na memória)
        listaVeiculos.add(novoVeiculos);

        // 3. Salva a lista completa (com o novo) de volta no arquivo
        mapper.writeValue(arquivo, listaVeiculos);
        
        return "Cliente adicionado com sucesso!";
    } catch (Exception e) {
        e.printStackTrace();
        return "Erro ao adicionar veiculo";
    }
}
public static List<veiculos> buscarDisponiveis() {
    try {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File("veiculos.json");
        if (arquivo.exists()) {
            List<veiculos> todos = mapper.readValue(arquivo, new TypeReference<List<veiculos>>(){});
            List<veiculos> disponiveis = new ArrayList<>();
            for (veiculos v : todos) {
                if (v.getDisponivel()) { // Verifique se o nome do método no seu modelo é esse
                    disponiveis.add(v);
                }
            }
            return disponiveis;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return new ArrayList<>();
}
public static List<Cliente> buscarClientes() {
    try {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File("cliente.json");

        if (arquivo.exists()) {

            List<Cliente> todos =
                mapper.readValue(arquivo, new TypeReference<List<Cliente>>() {});

            for (Cliente v : todos) {
                System.out.println("Nome: " + v.getNome());
                System.out.println("CPF: " + v.getCpf());
                System.out.println("CNH: " + v.getCnh());
                System.out.println("Email: " + v.getEmail());
                System.out.println("Senha: " + v.getSenha());
                System.out.println("Pontos CNH: " + v.getPontoscnh());
                System.out.println("Status: " + v.getBloq());
                System.out.println("----------------------");
            }

            return todos; // agora está no lugar certo
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return new ArrayList<>();
}
public static List<veiculos> buscarDevolver(String nome) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File("veiculos.json");

        if (arquivo.exists()) {

            List<veiculos> todos =
                mapper.readValue(arquivo, new TypeReference<List<veiculos>>() {});

            List<veiculos> disponiveis = new ArrayList<>();
            boolean encontrou = false;

            for (veiculos v : todos) {

                if (nome.equals(v.getNome())) {
                    encontrou = true;

                    if (!v.getDisponivel()) {
                        disponiveis.add(v);
                    }
                }
            }

            if (!encontrou) {
                System.out.println("Não há veículos com esse nome.");
            } else if (disponiveis.isEmpty()) {
                System.out.println("Não há veículos para devolver.");
            }

            return disponiveis;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return new ArrayList<>();
}
 
public static String salvarcalguram(Alugar novoAluguel) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File("calugaram.json");
        List<Alugar> listaAlugueis = new ArrayList<>();

        // 1. Se o arquivo já existir, a gente lê a lista atual primeiro
        if (arquivo.exists()) {
            listaAlugueis = mapper.readValue(arquivo, new TypeReference<List<Alugar>>(){});
        }

        // 2. Adiciona o novo cliente na lista (na memória)
        listaAlugueis.add(novoAluguel);

        // 3. Salva a lista completa (com o novo) de volta no arquivo
        mapper.writeValue(arquivo, listaAlugueis);
        
        return "Aluguel registrado com sucesso!";
    } catch (Exception e) {
        e.printStackTrace();
        return "Erro ao registrar aluguel";
    }
}
public static List<Integer> verificarDias(int diasProcurado, String nomev) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File("calugaram.json");

        if (arquivo.exists()) {

            List<Alugar> todos =
                mapper.readValue(arquivo, new TypeReference<List<Alugar>>() {});

            List<Integer> filtrados = new ArrayList<>();

            for (Alugar a : todos) {
                if (nomev.equals(a.getNomec()) && a.getDias() <= diasProcurado) {
                    filtrados.add(a.getDias());
                }
            }
        
            return filtrados;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return new ArrayList<>();
}
public static String salvardevolucao(String placa) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File("veiculos.json");

        if (!arquivo.exists()) {
            return "Arquivo não encontrado.";
        }

        List<veiculos> listaAlugueis =
            mapper.readValue(arquivo, new TypeReference<List<veiculos>>() {});

        for (veiculos v : listaAlugueis) {
            if (placa.equals(v.getNome())) {
                v.setDisponivel(true); // MUDA DE FALSE PRA TRUE
                break;
            }
        }

        mapper.writeValue(arquivo, listaAlugueis);

        return "Devolução registrada com sucesso!";

    } catch (Exception e) {
        e.printStackTrace();
        return "Erro ao registrar devolução";
    }
}
public static String salvardevolucao2(String placa) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        File arquivo = new File("veiculos.json");

        if (!arquivo.exists()) {
            return "Arquivo não encontrado.";
        }

        List<veiculos> listaAlugueis =
            mapper.readValue(arquivo, new TypeReference<List<veiculos>>() {});

        for (veiculos v : listaAlugueis) {
            if (placa.equals(v.getNome())) {
                v.setDisponivel(false); // MUDA DE FALSE PRA TRUE
                break;
            }
        }

        mapper.writeValue(arquivo, listaAlugueis);

        return "Devolução registrada com sucesso!";

    } catch (Exception e) {
        e.printStackTrace();
        return "Erro ao registrar devolução";
    }
}
}