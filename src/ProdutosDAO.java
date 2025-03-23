/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        try {

              conn = new conectaDAO().connectDB();

              //Inserindo no banco de dados
              String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
              prep = conn.prepareStatement(sql);
              prep.setString(1, produto.getNome());
              prep.setInt(2, produto.getValor());
              prep.setString(3, produto.getStatus());

              //Executa a inserção
              prep.executeUpdate();
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto: " + e.getMessage());
          } finally {

              new conectaDAO().desconectar(conn);
          }
  
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

