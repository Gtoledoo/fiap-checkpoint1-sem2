package br.com.fiap.ecommerce.controller;

import br.com.fiap.ecommerce.dtos.itemPedido.ItemPedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.itemPedido.ItemPedidoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.itemPedido.ItemPedidoResponseDto;
import br.com.fiap.ecommerce.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemPedidos")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDto>> list() {
        List<ItemPedidoResponseDto> dtos = itemPedidoService.list()
                .stream()
                .map(e -> new ItemPedidoResponseDto().toDto(e))
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDto> create(@RequestBody ItemPedidoRequestCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        new ItemPedidoResponseDto().toDto(
                                itemPedidoService.save(dto.toModel()))
                );
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> update(
            @PathVariable Long id,
            @RequestBody ItemPedidoRequestUpdateDto dto) {
        if (itemPedidoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok()
                .body(
                        new ItemPedidoResponseDto().toDto(
                                itemPedidoService.save(dto.toModel(id)))
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (itemPedidoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        itemPedidoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(
                        itemPedidoService
                                .findById(id)
                                .map(e -> new ItemPedidoResponseDto().toDto(e))
                                .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );

    }
}
