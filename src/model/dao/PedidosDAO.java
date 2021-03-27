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
import maniClass.Pedidos;

/**
 *
 * @author lanna
 */
public class PedidosDAO {

    public void create(Pedidos p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pedidos (nomeCliente,endereco,horario, rota) VALUES(?,?,?,?) ");
            stmt.setString(1, p.getNomeCliente());
            stmt.setString(2, p.getEndereco());
            stmt.setString(3, p.getHorario());
            stmt.setString(4, p.getRota());
            stmt.executeUpdate();
            System.out.println("Pedido inserido com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir pedido");
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }

    }

    public int readMaxCod() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int maxCod = 0;

        try {
            stmt = con.prepareStatement("SELECT max(id) FROM pedidos");
            System.out.println("" + stmt);
            rs = stmt.executeQuery();

            while (rs.next()) {
                maxCod = (rs.getInt("max(id)"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        System.out.println("" + maxCod + "");
        return maxCod;
    }

    public List<String> readRota(int chave) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> pedidos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT rota FROM pedidos where id>=? ");
            stmt.setInt(1, chave);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String rota = rs.getString("rota");

                pedidos.add(rota);

            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);

        }
        return pedidos;
    }
    
    
    
    public void update(Pedidos p, int cod) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE pedidos SET nomeCliente = ?,endereco=?,horario=?,rota=? WHERE id = ?");
            stmt.setString(1, p.getNomeCliente());
            stmt.setString(2, p.getEndereco());
            stmt.setString(3, p.getHorario());
            stmt.setString(4, p.getRota());
            stmt.setInt(5, cod);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Pedido" + ex);
        } finally {
            ConnectionFactory.CloseConnection(con, (com.mysql.jdbc.PreparedStatement) stmt);
        }
    }

}
