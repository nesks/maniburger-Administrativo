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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import maniClass.Ingredientes;
import maniClass.Lanche;

/**
 *
 * @author indigente
 */
public class LancheDAO {

    public void create(Lanche i, int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO lanches (pedidosID,donoLanche,preco,formaPg) VALUES(?,?,?,?) ");
            stmt.setInt(1, id);
            stmt.setString(2, i.getDonoLanche());
            stmt.setDouble(3, i.getPreco());
            stmt.setInt(4, i.getFormaPg());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir lanche" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }

    public void delete(int cod) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM lanches WHERE pedidosID = ?");
            stmt.setInt(1, cod);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar lanche" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }

    public double readEntrada(String ultLanche) throws SQLException {
        System.out.println("oi");
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Double entradaTotal = 0.00;
        try {
            stmt = con.prepareStatement("SELECT SUM(preco) FROM lanches l, pedidos p WHERE l.pedidosID=p.id and p.horario LIKE '" + ultLanche + "%'");
            rs = stmt.executeQuery();
            if (rs!= null && rs.next()&& !String.valueOf(rs.getString("SUM(preco)")).equals("null")) {
                entradaTotal = Double.parseDouble(rs.getString("SUM(preco)"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return entradaTotal;
    }

    public double readEntradaCartao(String ultLanche) throws SQLException {
        System.out.println("oi");

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Double entradaTotal = 0.00;
    try{
            stmt = con.prepareStatement("SELECT SUM(preco) FROM lanches l, pedidos p WHERE l.formaPg=1 and l.pedidosID=p.id and p.horario LIKE '" + ultLanche + "%'");
            rs = stmt.executeQuery();
            
          if (rs!= null && rs.next()&& !String.valueOf(rs.getString("SUM(preco)")).equals("null")) {
                entradaTotal = Double.parseDouble(rs.getString("SUM(preco)"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return entradaTotal;
    }

    public double readEntradaDinheiro(String ultLanche) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Double entradaTotal = 0.00;
        try{
            stmt = con.prepareStatement("SELECT SUM(preco) FROM lanches l, pedidos p WHERE l.pedidosID=p.id  and l.formaPG=2 and p.horario LIKE '" + ultLanche + "%'");
            rs = stmt.executeQuery();
            
         if (rs!= null && rs.next() && !String.valueOf(rs.getString("SUM(preco)")).equals("null")) {
               entradaTotal = Double.parseDouble(rs.getString("SUM(preco)"));
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
     return entradaTotal;
    }

}
