/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.angeloproject.login_project.controller;

import static br.com.angeloproject.controller.modelo.conexao.ConexaoMySql.getConexao;
import br.com.angeloproject.login_project.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author angel
 */
public class AdicionaUsuario {
    
    public static void criarUsuario(Usuario usuario) throws SQLException {
     
        try (Connection conexao = getConexao()) {
            String sql = "INSERT INTO usuario (nome, cpf, senha) VALUES (?, ?, ?)";

            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getCpf());
                ps.setString(3, usuario.getSenha());

                int linhasAfetadas = ps.executeUpdate();

                if (linhasAfetadas > 0) {
                    System.out.println("Usuário inserido com sucesso!");
                } else {
                    System.out.println("Falha ao inserir usuário.");
                }
            }
        }
    }
    
}
