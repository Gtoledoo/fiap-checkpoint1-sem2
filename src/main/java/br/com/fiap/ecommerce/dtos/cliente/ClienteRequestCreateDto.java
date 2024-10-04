package br.com.fiap.ecommerce.dtos.cliente;

import br.com.fiap.ecommerce.model.Cliente;
import org.modelmapper.ModelMapper;

public class ClienteRequestCreateDto {
    private String nome;
    private String cep;
    private static final ModelMapper modelMapper = new ModelMapper();

    public Cliente toModel(){
        return modelMapper.map(this, Cliente.class);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
