package br.com.fiap.ecommerce.dtos.cliente;

import br.com.fiap.ecommerce.model.Cliente;
import org.modelmapper.ModelMapper;

public class ClienteRequestUpdateDto {
    private String cep;
    private static final ModelMapper modelMapper = new ModelMapper();

    public Cliente toModel(Long id) {
        Cliente result = modelMapper.map(this, Cliente.class);
        result.setId(id);

        return result;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
