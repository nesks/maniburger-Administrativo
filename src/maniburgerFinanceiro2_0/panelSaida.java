/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maniburgerFinanceiro2_0;

import classeFinanceiro.Conta;
import classeFinanceiro.Entrada;
import java.util.List;
import javax.swing.JOptionPane;
import maniClass.Ingredientes;
import model.dao.IngredientesDAO;
import modelFinanceiro.dao.SaidasContasDAO;
import modelFinanceiro.dao.entradaDAO;

/**
 *
 * @author lanna
 */
public class panelSaida extends javax.swing.JPanel {

    List<Conta> contas;
    SaidasContasDAO c;
    private int index;
    int contador;
    entradaDAO e;

    public panelSaida() {
        initComponents();
        atualizaComboBox();
        contador = 0;
    }

    public void atualizaComboBox() {

        jCBNome.removeAllItems();
        jCBNome.addItem("");
        e = new entradaDAO();
        c = new SaidasContasDAO();
        contas = c.readNaoPg();
        for (index = 0; index < c.readNaoPg().size(); index++) {
            jCBNome.addItem(contas.get(index).getNome());

        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCBNome = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Saida:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor:");

        jLabel3.setText("CONTAS A PAGAR");

        jButton1.setText("Nova Conta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCBNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBNome.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jCBNomePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jCBNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBNomeMouseClicked(evt);
            }
        });
        jCBNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBNomeActionPerformed(evt);
            }
        });

        jLabel4.setText("Data vencimento:");

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("N??O PAGO");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("PAGO");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBNome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jRadioButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jCBNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void jCBNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBNomeActionPerformed

    }//GEN-LAST:event_jCBNomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Double.parseDouble(txtValor.getText()) >= 0) {
            SaidasContasDAO cont = new SaidasContasDAO();
            Conta c = new Conta();
            if (txtNome.getText() != null && txtValor.getText() != null) {
                c.setNome(txtNome.getText());
                c.setValor(Double.parseDouble(txtValor.getText()));
                c.setData(txtData.getText());
                if (jRadioButton1.isSelected()) {
                    c.setPg(0);

                    if (contador == 1) {
                        int formaPg = JOptionPane.showConfirmDialog(null, "Esse pagamento havia foi realizado com dinheiro?", "FORMA DE PAGAMENTO", JOptionPane.YES_NO_OPTION);
                        if (formaPg == JOptionPane.YES_OPTION) {
                            e.updateDinheiroEntrada(Double.parseDouble(txtValor.getText()));
                        } else if (formaPg == JOptionPane.NO_OPTION) {
                            e.updateCartaoEntrada(Double.parseDouble(txtValor.getText()));
                        }
                    }

                } else if (jRadioButton2.isSelected()) {

                    c.setPg(1);

                    if (contador == 0) {
                        int formaPg = JOptionPane.showConfirmDialog(null, "O pagamento foi feito com dinheiro?", "FORMA DE PAGAMENTO", JOptionPane.YES_NO_OPTION);
                        if (formaPg == JOptionPane.YES_OPTION) {
                            cont.updateDinheiroSaida(Double.parseDouble(txtValor.getText()));
                        } else if (formaPg == JOptionPane.NO_OPTION) {
                            cont.updateCartaoSaida(Double.parseDouble(txtValor.getText()));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione a forma de pagamento! ");
                }
            }

            if (c.getNome() != null && c.getData() != null && c.getValor() != null && c.getPg() == 1) {
                cont.create(c);
            } else if (c.getNome() != null && c.getData() != null && c.getValor() != null && c.getPg() == 0) {
                cont.create(c);
            } else {
                JOptionPane.showMessageDialog(null, "Algum campo esta em branco ");
            }        // TODO add your handling code here:
            atualizaComboBox();
            txtNome.setText(null);
            txtValor.setText(null);
            txtData.setText(null);
            contador = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Digite um valor positivo! ");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Conta con = new Conta();

        SaidasContasDAO dao = new SaidasContasDAO();
        con.setNome(txtNome.getText());
        con.setValor(Double.parseDouble(txtValor.getText()));
        con.setData(txtData.getText());

        if (jRadioButton2.isSelected()) {
             con.setPg(1);
            if (contador == 0) {
                int formaPg = JOptionPane.showConfirmDialog(null, "O pagamento foi feito com dinheiro?", "FORMA DE PAGAMENTO", JOptionPane.YES_NO_OPTION);
                if (formaPg == JOptionPane.YES_OPTION) {
                    dao.updateDinheiroSaida(Double.parseDouble(txtValor.getText()));
                } else if (formaPg == JOptionPane.NO_OPTION) {
                      dao.updateCartaoSaida(Double.parseDouble(txtValor.getText()));
                }
            }

           

        } else if (jRadioButton1.isSelected()) {
            con.setPg(0);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione a forma de pagamento! ");
        }
            dao.update(con, contas.get(index).getNome(), contas.get(index).getData());
            atualizaComboBox();

            txtNome.setText(null);
            txtValor.setText(null);
            txtData.setText(null);
            contador = 0;
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCBNomePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBNomePopupMenuWillBecomeInvisible

        index = jCBNome.getSelectedIndex() - 1;
        if (jCBNome.getSelectedItem() != "") {
            txtNome.setText(String.valueOf(contas.get(index).getNome()));
            txtValor.setText(String.valueOf(contas.get(index).getValor()));
            txtData.setText(String.valueOf(contas.get(index).getData()));
            switch (contas.get(index).getPg()) {
                case 0:
                    jRadioButton1.setSelected(true);
                    break;
                case 1:
                    jRadioButton2.setSelected(true);
                    contador = 1;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_jCBNomePopupMenuWillBecomeInvisible

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jCBNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBNomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBNomeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCBNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
