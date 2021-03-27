/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelFinanceiro.dao;

import classeFinanceiro.Conta;
import classeFinanceiro.Entrada;
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
import model.dao.IngredientesDAO;

/**
 *
 * @author lanna
 */
public class SaidasContasDAO {

    public void create(Conta c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO conta (nome,valor,data,pg) VALUES(?,?,?,?) ");
            stmt.setString(1, c.getNome());
            stmt.setDouble(2, c.getValor());
            stmt.setString(3, c.getData());
            stmt.setInt(4, c.getPg());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir Entrada" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }

    public void update(Conta c, String nome, String data) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE conta SET nome = ?,valor=?,data=?,pg=? WHERE nome = ? and data = ?");
            stmt.setString(1, c.getNome());
            stmt.setDouble(2, c.getValor());
            stmt.setString(3, c.getData());
            stmt.setInt(4, c.getPg());
            stmt.setString(5, nome);
            stmt.setString(6, data);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Ingrediente" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }

    public List<Conta> readContas() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Conta> contas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM conta");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Conta c = new Conta();
                c.setNome(rs.getString("nome"));
                c.setValor(rs.getDouble("valor"));
                c.setData(rs.getString("data"));
                c.setPg(rs.getInt("pg"));
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

    public List<Conta> readNaoPg() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Conta> contas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM conta WHERE pg=0");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Conta c = new Conta();
                c.setNome(rs.getString("nome"));
                c.setValor(rs.getDouble("valor"));
                c.setData(rs.getString("data"));
                c.setPg(rs.getInt("pg"));
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

    public List<Conta> readPg() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Conta> contas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM conta WHERE pg=1");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Conta c = new Conta();
                c.setNome(rs.getString("nome"));
                c.setValor(rs.getDouble("valor"));
                c.setData(rs.getString("data"));
                c.setPg(rs.getInt("pg"));
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

    public double readValorNaoPg() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double dividaTotal = 0.00;

        try {
            stmt = con.prepareStatement("SELECT SUM(valor) FROM conta WHERE pg=0");
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

    public double readValorPg() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double dividaTotal = 0.00;

        try {
            stmt = con.prepareStatement("SELECT SUM(valor) FROM conta WHERE pg=1");
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

    public void updateDinheiroSaida(double valor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        valor = readTotalDinheiroOficial() - valor;
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

    public void updateCartaoSaida(double valor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        valor = readTotalCartaoOficial() - valor;
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
