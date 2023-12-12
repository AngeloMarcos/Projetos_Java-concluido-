package br.com.angeloproject.controller.modelo.conexao;

import br.com.angeloproject.login_project.model.Pessoas;
import br.com.angeloproject.login_project.model.Usuario;
import br.com.angeloproject.login_project.view.NovoLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConexaoMySql {
    
    public static Connection getConexao() throws SQLException{
     final String URL = "jdbc:mysql://localhost/login_teste";
     final String USUARIO = "root";
     final String SENHA = "";
     Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
     return conexao;
    }

    

     

   
}
