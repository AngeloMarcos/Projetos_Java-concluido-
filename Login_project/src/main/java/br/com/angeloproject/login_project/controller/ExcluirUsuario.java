/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.angeloproject.login_project.controller;

import br.com.angeloproject.controller.modelo.conexao.ConexaoMySql;
import static br.com.angeloproject.controller.modelo.conexao.ConexaoMySql.getConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author angel
 */
public class ExcluirUsuario {
      public void deletaPessoa(String cpf){
        
          try (Connection conexao = getConexao()){
             
               String sql = "DELETE FROM USUARIO WHERE CPF = ?";
               
               
            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                pstmt.setString(1, cpf);
                pstmt.executeUpdate();
            }
          } catch (Exception e) {
               System.out.println("Erro ao excluir a pessoa: " + e.getMessage());
          }
      }
}
