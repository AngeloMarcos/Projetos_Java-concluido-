/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.angeloproject.login_project.controller;

import static br.com.angeloproject.controller.modelo.conexao.ConexaoMySql.getConexao;
import br.com.angeloproject.login_project.model.Pessoas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class ConsultaUsuario {
    
    public static List<Pessoas> consultarUsuario() {
        List<Pessoas> pessoas =  new ArrayList<>();
        
        
        String sql = "select * from usuario ;";

        try (Connection conexao = getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                //recuperando dados
                String nome = rs.getString("nome");
                String Cpf  = rs.getString("cpf");
                String Senha = rs.getString("senha");
                //inserindo dados recuperados na classe pessoas
                Pessoas pessoa = new Pessoas();
                pessoa.setNome(nome);
                pessoa.setCpf(Cpf);
                pessoa.setSenha(Senha);
                //adicionando os valores a lista pessoa
                pessoas.add(pessoa);
                //JOptionPane.showMessageDialog(null, "Nome: " + pessoa.getNome() + ", CPF: " + pessoa.getCpf() + ", Senha: " + pessoa.getSenha());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar usuário: " + e.getMessage());
        }
        return pessoas;
    }
}
