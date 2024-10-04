package br.com.fiap.ecommerce.service;

import br.com.fiap.ecommerce.dtos.cliente.ClienteRequestUpdateDto;
import br.com.fiap.ecommerce.model.Cliente;
import br.com.fiap.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        String cep = cliente.getCep();

        Map<String, String> bairrosPorCep = Map.of(
                "0", "Campo Limpo",
                "1", "Capão Redondo",
                "2", "Jardim Lidia",
                "3", "Paraisópolis",
                "4", "Marconi",
                "5", "Helipe",
                "6", "Jardim Piracuama",
                "7", "Ipiranga",
                "8", "Ibirapuera",
                "9", "Paulista"
        );

        String ultimoDigito = cep.substring(cep.length() - 1);
        cliente.setBairro(bairrosPorCep.getOrDefault(ultimoDigito, "Centro"));

        return clienteRepository.save(cliente);
    }

    public Cliente update(ClienteRequestUpdateDto request, Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        Cliente clienteEditado = cliente.get();

        clienteEditado.setCep(request.getCep());

        return clienteRepository.save(clienteEditado);
    }

    public boolean existsById(Long id) {
        return !clienteRepository.existsById(id);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
}
