package org.senac.aula01.respository;

import org.senac.aula01.model.Produto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 
import java.util.List;
 
@Repository
public class ProdutoRepository {
 
    private final JdbcTemplate jdbcTemplate;
 
    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
 
    public List<Produto> findAll() {
        String sql = "SELECT * FROM aula012024.produto";  // Especifica o schema
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Produto produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("description")); // A coluna 'description' do banco
            produto.setPreco(rs.getDouble("preco"));
            produto.setImagemString(rs.getString("imagem_string"));
            return produto;
        });
    }
 
    public void save(Produto produto) {
        String sql = "INSERT INTO aula012024.produto (id, description, nome, preco, imagem_string) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, produto.getId(), produto.getDescricao(), produto.getNome(), produto.getPreco(), produto.getImagemString());
    }
}