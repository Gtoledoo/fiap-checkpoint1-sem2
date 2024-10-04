package br.com.fiap.ecommerce.dtos.itemPedido;

import br.com.fiap.ecommerce.model.ItemPedido;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

public class ItemPedidoRequestUpdateDto {
    private BigDecimal quantidade;
    private BigDecimal valorTotal;
    private static final ModelMapper modelMapper = new ModelMapper();

    public ItemPedido toModel(Long id){
        ItemPedido result = modelMapper.map(this, ItemPedido.class);
        result.setId(id);

        return result;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
