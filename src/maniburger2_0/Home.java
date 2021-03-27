/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maniburger2_0;

import maniburgerFinanceiro2_0.entradaNoite;
import javax.swing.JOptionPane;
import maniClass.ButtonTabComponent;
import maniClass.Pedidos;
import maniburgerFinanceiro2_0.Relatorio;
import maniburgerFinanceiro2_0.panelEntrada;
import maniburgerFinanceiro2_0.panelSaida;
import model.dao.PedidosDAO;
import model.dao.IngredientesDAO;

/**
 *
 * @author lanna
 */
public class Home extends javax.swing.JFrame {

    int i;
    int numPedidosDaNoite;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        i = 0;
        this.setExtendedState(MAXIMIZED_BOTH);
        numPedidosDaNoite = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            paneHome =(javax.swing.JTabbedPane)java.beans.Beans.instantiate(getClass().getClassLoader(), "maniburger2_0.Home_paneHome");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMIRota = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Pedidos");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Adicionar Pedido");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMIRota.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jMIRota.setText("Rota");
        jMIRota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRotaActionPerformed(evt);
            }
        });
        jMenu1.add(jMIRota);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Estoque");

        jMenuItem2.setText("Controle de Estoque");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Gastos do dia");
        jMenu2.add(jMenuItem3);

        jMenuItem6.setText("Inserir Ingrediente");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Atualizar Ingrediente");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Financeiro");

        jMenuItem5.setText("Entrada e Saida da Noite");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem4.setText("Movimentação C/D");
        jMenu3.add(jMenuItem4);

        jMenuItem8.setText("Relatorios");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Nova Conta / Pagamento Conta");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Nova Entrada");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneHome, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneHome, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        IngredientesDAO ing = new IngredientesDAO();
        ing.readCod(12);

        //   PedidosDAO ped= new PedidosDAO();
        //  System.out.println(""+ped.readMaxCod());
        String nome = null;
        if (nome == null || nome.equals("")) {

            nome = JOptionPane.showInputDialog("Qual o nome do cliente?");
            if (nome != null || nome.equals("")) {
                numPedidosDaNoite++;
                addPedidos p = new addPedidos(numPedidosDaNoite);

                p.numPedido = numPedidosDaNoite;
                p.setName(nome);
                p.txtNomePedido.setText(nome);
                paneHome.add(p);
                paneHome.setSelectedComponent(p);
                Pedidos pedido = new Pedidos(nome);

                int j = paneHome.getSelectedIndex();
                paneHome.setTabComponentAt(j, new ButtonTabComponent(paneHome));

                p.setVisible(true);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        estoque e = new estoque();

        paneHome.add(e);
        paneHome.setSelectedComponent(e);

        int j = paneHome.getSelectedIndex();
        paneHome.setTabComponentAt(j, new ButtonTabComponent(paneHome));

        e.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        entradaNoite en = new entradaNoite();

        paneHome.add(en);
        paneHome.setSelectedComponent(en);

        int j = paneHome.getSelectedIndex();
        paneHome.setTabComponentAt(j, new ButtonTabComponent(paneHome));

        en.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        addIngredientes i = new addIngredientes();

        paneHome.add(i);
        paneHome.setSelectedComponent(i);

        int j = paneHome.getSelectedIndex();
        paneHome.setTabComponentAt(j, new ButtonTabComponent(paneHome));

        i.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        attIngredientes i = new attIngredientes();

        paneHome.add(i);
        paneHome.setSelectedComponent(i);

        int j = paneHome.getSelectedIndex();
        paneHome.setTabComponentAt(j, new ButtonTabComponent(paneHome));

        i.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMIRotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRotaActionPerformed

        Rota i = new Rota();
        i.setName("ROTA");
        paneHome.add(i);
        paneHome.setSelectedComponent(i);

        int j = paneHome.getSelectedIndex();
        paneHome.setTabComponentAt(j, new ButtonTabComponent(paneHome));

        i.setVisible(true);
    }//GEN-LAST:event_jMIRotaActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Relatorio i = new Relatorio();
        i.setName("RELATORIOS");
        paneHome.add(i);
        paneHome.setSelectedComponent(i);

        int j = paneHome.getSelectedIndex();
        paneHome.setTabComponentAt(j, new ButtonTabComponent(paneHome));

        i.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        panelSaida i = new panelSaida();
        i.setName("Pagamento Conta");
        paneHome.add(i);
        paneHome.setSelectedComponent(i);

        int j = paneHome.getSelectedIndex();
        paneHome.setTabComponentAt(j, new ButtonTabComponent(paneHome));

        i.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        panelEntrada i = new panelEntrada();
        i.setName("Pagamento Conta");
        paneHome.add(i);
        paneHome.setSelectedComponent(i);

        int j = paneHome.getSelectedIndex();
        paneHome.setTabComponentAt(j, new ButtonTabComponent(paneHome));

        i.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMIRota;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JTabbedPane paneHome;
    // End of variables declaration//GEN-END:variables
}
