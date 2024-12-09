package org.senac.aula01.model;

import org.springframework.data.annotation.Id;

public class Produto {

    @Id
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private String imagemString;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImagemString() {
        return imagemString;
    }

    public void setImagemString(String imagemString) {
        this.imagemString = imagemString;
    }
}