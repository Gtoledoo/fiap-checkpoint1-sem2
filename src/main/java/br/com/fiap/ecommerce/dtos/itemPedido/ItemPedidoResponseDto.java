package br.com.fiap.ecommerce.dtos.itemPedido;

import br.com.fiap.ecommerce.model.ItemPedido;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

public class ItemPedidoResponseDto {
    private Long idItemPedido;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;
    private static final ModelMapper modelMapper = new ModelMapper();

    public ItemPedidoResponseDto toDto(ItemPedido itemPedido){
        return modelMapper.map(itemPedido, ItemPedidoResponseDto.class);
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

    public Long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(Long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }
}
