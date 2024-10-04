package br.com.fiap.ecommerce.dtos.cliente;

import br.com.fiap.ecommerce.model.Cliente;
import org.modelmapper.ModelMapper;

public class ClienteResponseDto {
    private Long id;
    private String nome;
    private String bairro;

    private static final ModelMapper modelMapper = new ModelMapper();

    public ClienteResponseDto toDto(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponseDto.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}