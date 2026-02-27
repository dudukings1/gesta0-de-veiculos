package com.gestao.services;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestao.models.Cliente;
import com.gestao.models.veiculos;

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
public static Cliente buscarPorCpf(int cpf) {
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
            if (c.getCpf() == cpf) {
                return c;
            }
        }

        return null;

    } catch (Exception e) {
        System.err.println("Erro na leitura: " + e.getMessage());
        return null;
    }
}
    // BUSCAR: Lê o arquivo e compara o CPF
    public static Cliente buscar(int cpfDigitado) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File arquivo = new File("cliente.json");

            if (arquivo.exists()) {
                // Transforma o JSON de volta em objeto para podermos ler o CPF lá dentro
                Cliente clienteNoArquivo = mapper.readValue(arquivo, Cliente.class);

                // Compara o CPF que está no arquivo com o que você digitou no buscar
                if (clienteNoArquivo.getCpf() == cpfDigitado) {
                    return clienteNoArquivo;
                } else {
                    System.out.println("CPF não confere com o salvo!");
                    return null;
                }
            } else {
                System.out.println("Nenhum dado cadastrado ainda.");
                return null;
            }

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
}