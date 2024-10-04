package br.com.fiap.ecommerce.dtos.pedido;

import br.com.fiap.ecommerce.model.Pedido;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

public class PedidoRequestCreateDto {
    private Long IdCliente;
    private String formaPagamento;
    private BigDecimal valorTotal;
    private static final ModelMapper modelMapper = new ModelMapper();

    public Pedido toModel(){
        return modelMapper.map(this, Pedido.class);
    }

    public Long getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Long idCliente) {
        IdCliente = idCliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
