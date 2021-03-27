/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelFinanceiro.dao;

import classeFinanceiro.Conta;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import maniClass.Ingredientes;
import classeFinanceiro.Entrada;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.IngredientesDAO;

/**
 *
 * @author lanna
 */
public class entradaDAO {

    public entradaDAO() {
    }

    public void create(Entrada e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO entrada (nome,valor,data,formato) VALUES(?,?,?,?) ");
            stmt.setString(1, e.getNome());
            stmt.setDouble(2, e.getValor());
            stmt.setString(3, e.getData());
            stmt.setInt(4, e.getFormato());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir Entrada" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }

    public List<Entrada> readEntrada() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Entrada> contas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM entrada ");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Entrada c = new Entrada();
                c.setNome(rs.getString("nome"));
                c.setValor(rs.getDouble("valor"));
                c.setData(rs.getString("data"));
                c.setFormato(rs.getInt("formato"));
                c.setId(rs.getInt("id"));
                contas.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return contas;
    }

    public List<Entrada> readEntradaCartao() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Entrada> contas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM entrada WHERE formato=1");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Entrada c = new Entrada();
                c.setNome(rs.getString("nome"));
                c.setValor(rs.getDouble("valor"));
                c.setData(rs.getString("data"));
                c.setFormato(rs.getInt("formato"));
                c.setId(rs.getInt("id"));

                contas.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return contas;
    }

    public List<Entrada> readEntradaDinheiro() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Entrada> contas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM entrada WHERE formato=2");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Entrada c = new Entrada();
                c.setNome(rs.getString("nome"));
                c.setValor(rs.getDouble("valor"));
                c.setData(rs.getString("data"));
                c.setFormato(rs.getInt("formato"));
                c.setId(rs.getInt("id"));
                contas.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return contas;
    }

    public double readTotalCartao() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double dividaTotal = 0.00;

        try {
            stmt = con.prepareStatement("SELECT SUM(valor) FROM entradacartao");
            rs = stmt.executeQuery();

            if (rs != null && rs.next() && !String.valueOf(rs.getString("SUM(valor)")).equals("null")) {
                dividaTotal = Double.parseDouble(rs.getString("SUM(valor)"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return dividaTotal;
    }

    public double readTotalDinheiro() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double dividaTotal = 0.00;

        try {
            stmt = con.prepareStatement("SELECT SUM(valor) FROM entradadinheiro");
            rs = stmt.executeQuery();

            if (rs != null && rs.next() && !String.valueOf(rs.getString("SUM(valor)")).equals("null")) {
                dividaTotal = Double.parseDouble(rs.getString("SUM(valor)"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return dividaTotal;
    }

    public double readTotalEntrada() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double dividaTotal = 0.00;

        try {
            stmt = con.prepareStatement("SELECT SUM(valor) FROM entrada");
            rs = stmt.executeQuery();

            if (rs != null && rs.next() && !String.valueOf(rs.getString("SUM(valor)")).equals("null")) {
                dividaTotal = Double.parseDouble(rs.getString("SUM(valor)"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return dividaTotal;
    }

    public void updateDinheiroEntrada(double valor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        valor += readTotalDinheiroOficial();
        try {
            stmt = con.prepareStatement("UPDATE entradadinheiro SET valor = " + valor + "");
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Ingrediente" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }

    public void updateCartaoEntrada(double valor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        valor += readTotalCartaoOficial();
        try {
            stmt = con.prepareStatement("UPDATE entradacartao SET valor = " + valor + "");
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Ingrediente" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }

    public double readTotalDinheiroOficial() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double dividaTotal = 0.00;

        try {
            stmt = con.prepareStatement("SELECT SUM(valor) FROM entradadinheiro");
            rs = stmt.executeQuery();

            if (rs != null && rs.next() && !String.valueOf(rs.getString("SUM(valor)")).equals("null")) {
                dividaTotal = Double.parseDouble(rs.getString("SUM(valor)"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return dividaTotal;
    }

    public double readTotalCartaoOficial() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double dividaTotal = 0.00;

        try {
            stmt = con.prepareStatement("SELECT SUM(valor) FROM entradacartao");
            rs = stmt.executeQuery();

            if (rs != null && rs.next() && !String.valueOf(rs.getString("SUM(valor)")).equals("null")) {
                dividaTotal = Double.parseDouble(rs.getString("SUM(valor)"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return dividaTotal;
    }

}
