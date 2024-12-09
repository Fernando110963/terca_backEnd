package org.senac.aula01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.senac.aula01.model.Produto;
import org.senac.aula01.respository.ProdutoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> get(
            @RequestParam(value = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(value = "order", defaultValue = "asc") String order
    ) {
        List<Produto> produtos = produtoRepository.findAll();

        Comparator<Produto> comparator;
        switch (sortBy.toLowerCase()) {
            case "value":
                comparator = Comparator.comparing(Produto::getPreco);
                break;
            case "name":
            default:
                comparator = Comparator.comparing(Produto::getNome);
                break;
        }

        if ("desc".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        return produtos.stream().sorted(comparator).collect(Collectors.toList());
    }
}
