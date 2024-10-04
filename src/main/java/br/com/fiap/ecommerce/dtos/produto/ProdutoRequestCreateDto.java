package br.com.fiap.ecommerce.dtos.produto;

import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.Produto;

import java.math.BigDecimal;

public class ProdutoRequestCreateDto {
    private String nome;
    private BigDecimal valorProduto;
    private static final ModelMapper modelMapper = new ModelMapper();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Produto toModel() {
        return modelMapper.map(this, Produto.class);
    }
    
}
