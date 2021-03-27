package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import maniClass.Ingredientes;

public class IngredientesDAO {

    public void create(Ingredientes i) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ingredientes (nome,codigo,precoCompra,precoVenda,qtdEstoque,qtdMinEstoque,qtdGastaPorcao,lucro,tipo) VALUES(?,?,?,?,?,?,?,?,?) ");
            stmt.setString(1, i.getNome());
            stmt.setInt(2, i.getCod());
            stmt.setDouble(3, i.getPreCompraPorcao());
            stmt.setDouble(4, i.getPreVendaPorcao());
            stmt.setDouble(5, i.getQuantEmEstoque());
            stmt.setDouble(6, i.getMinimoEstoque());
            stmt.setDouble(7, i.getQuantGastaPorcao());
            stmt.setDouble(8, i.getPreVendaPorcao() - i.getPreCompraPorcao());
            stmt.setDouble(9, i.getTipo());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir Ingrediente" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }

    public void update(Ingredientes i, int cod) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Ingredientes SET nome = ?,precoCompra=?,precoVenda=?,qtdEstoque=?,qtdMinEstoque=?,qtdGastaPorcao=?,lucro=?,tipo=? WHERE codigo = ?");
            stmt.setString(1, i.getNome());
            stmt.setDouble(2, i.getPreCompraPorcao());
            stmt.setDouble(3, i.getPreVendaPorcao());
            stmt.setDouble(4, i.getQuantEmEstoque());
            stmt.setDouble(5, i.getMinimoEstoque());
            stmt.setDouble(6, i.getQuantGastaPorcao());
            stmt.setDouble(7, i.getPreVendaPorcao() - i.getPreCompraPorcao());
            stmt.setInt(8, i.getTipo());
            stmt.setInt(9, cod);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Ingrediente" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }

    public void delete(Ingredientes i) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM ingredientes WHERE codigo = ?");
            stmt.setInt(1, i.getCod());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar Ingrediente" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
    
    
    public List<Ingredientes> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs=null;
        List<Ingredientes> ingre = new ArrayList<>();
        
        
        try {
            stmt = con.prepareStatement("SELECT * FROM ingredientes");
            rs=stmt.executeQuery();
            
            while (rs.next() ){
                
                
                
                Ingredientes i = new Ingredientes();
                i.setCod(rs.getInt("codigo"));
                i.setLucro(rs.getDouble("lucro"));
                i.setQuantEmEstoque(rs.getDouble("qtdEstoque"));
                i.setMinimoEstoque(rs.getInt("qtdMinEstoque"));
                i.setNome(rs.getString("nome"));
                i.setPreCompraPorcao(rs.getDouble("precoCompra"));
                i.setPreVendaPorcao(rs.getDouble("precoVenda"));
                i.setQuantGastaPorcao(rs.getDouble("qtdGastaPorcao"));
                i.setTipo(rs.getInt("tipo"));
                ingre.add(i);
                  
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);
            
        }
        return ingre;
    }
    
    
    
     public Ingredientes readCod(int Cod){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs=null;
        Ingredientes i = new Ingredientes();        
        
        try {
            stmt = con.prepareStatement("SELECT * FROM ingredientes WHERE codigo = ?");
            stmt.setInt(1, Cod);
            rs=stmt.executeQuery();
            
            while (rs.next() ){
                
                
              
                i.setCod(rs.getInt("codigo"));
                i.setLucro(rs.getDouble("lucro"));
                i.setQuantEmEstoque(rs.getDouble("qtdEstoque"));
                i.setMinimoEstoque(rs.getInt("qtdMinEstoque"));
                i.setNome(rs.getString("nome"));
                i.setPreCompraPorcao(rs.getDouble("precoCompra"));
                i.setPreVendaPorcao(rs.getDouble("precoVenda"));
                i.setQuantGastaPorcao(rs.getDouble("qtdGastaPorcao"));
                i.setTipo(rs.getInt("tipo"));
                  
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);
            
        }
        return i;
    }
     
     
}
