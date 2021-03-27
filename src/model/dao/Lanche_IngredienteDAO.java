/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import maniClass.Lanche;

/**
 *
 * @author nesks
 */
public class Lanche_IngredienteDAO {
     public void create(Lanche l, Ingredientes i, int p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement("INSERT INTO lanche_ingrediente (ingredientesID,donoLanche,pedidosID) VALUES(?,?,?) ");
            stmt.setInt(1,i.getCod());
            stmt.setString(2, l.getDonoLanche());
            stmt.setInt(3, p  );
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir lanche_ingrediente"+ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
     
     public void delete(int cod) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM lanche_ingrediente WHERE pedidosID = ?");
            stmt.setInt(1,cod);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar lanche_ingrediente" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }
     
    public int readNumVendas(String ultLanche, int id){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs=null;
        int numVendas=0;
        
        
        try {
            stmt = con.prepareStatement("SELECT COUNT(*) FROM lanche_Ingrediente l, pedidos p WHERE l.pedidosID=p.id and p.horario LIKE '" + ultLanche + "%' and l.ingredientesID="+id+"");
            rs=stmt.executeQuery();
            if (rs != null && rs.next()) {
                numVendas = Integer.parseInt(rs.getString("COUNT(*)"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);
            
        }
        return numVendas;
    }

}
