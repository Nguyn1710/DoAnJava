/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package final_project;

/**
 *
 * @author lengu
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        POSPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnHNoun = new javax.swing.JButton();
        btnHVerb = new javax.swing.JButton();
        btnHAdj = new javax.swing.JButton();
        btnNER = new javax.swing.JButton();
        btnHiglihtAll1 = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnChuyenNER = new javax.swing.JButton();
        NERPanel = new javax.swing.JPanel();
        btnHORG = new javax.swing.JButton();
        btnHMISC = new javax.swing.JButton();
        btnHiglihtAll = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnHPER = new javax.swing.JButton();
        btnHLOC = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Highlight");

        btnHNoun.setBackground(new java.awt.Color(255, 255, 51));
        btnHNoun.setText("Noun");
        btnHNoun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHNounActionPerformed(evt);
            }
        });

        btnHVerb.setBackground(new java.awt.Color(102, 255, 51));
        btnHVerb.setText("Verb");
        btnHVerb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHVerbActionPerformed(evt);
            }
        });

        btnHAdj.setBackground(new java.awt.Color(102, 102, 255));
        btnHAdj.setText("Adj");
        btnHAdj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHAdjActionPerformed(evt);
            }
        });

        btnNER.setBackground(new java.awt.Color(255, 51, 51));
        btnNER.setText("Proper Noun");
        btnNER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNERActionPerformed(evt);
            }
        });

        btnHiglihtAll1.setText("Higlight All");
        btnHiglihtAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHiglihtAll1ActionPerformed(evt);
            }
        });

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnChuyenNER.setText("NER >>");
        btnChuyenNER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenNERActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout POSPanelLayout = new javax.swing.GroupLayout(POSPanel);
        POSPanel.setLayout(POSPanelLayout);
        POSPanelLayout.setHorizontalGroup(
            POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, POSPanelLayout.createSequentialGroup()
                .addContainerGap(402, Short.MAX_VALUE)
                .addComponent(btnChuyenNER)
                .addGap(152, 152, 152))
            .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(POSPanelLayout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(POSPanelLayout.createSequentialGroup()
                            .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnHVerb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addComponent(btnHNoun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnHAdj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(POSPanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnHiglihtAll1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(POSPanelLayout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(btnExport)))
                    .addGap(52, 52, 52)))
        );
        POSPanelLayout.setVerticalGroup(
            POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, POSPanelLayout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(btnChuyenNER)
                .addGap(35, 35, 35))
            .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(POSPanelLayout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(POSPanelLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnHNoun)
                                .addComponent(btnHAdj))
                            .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(POSPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnHVerb)
                                        .addComponent(btnNER)))
                                .addGroup(POSPanelLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(btnExport))))
                        .addComponent(btnHiglihtAll1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(98, Short.MAX_VALUE)))
        );

        jPanel1.add(POSPanel, "card2");

        btnHORG.setBackground(new java.awt.Color(102, 102, 255));
        btnHORG.setText("ORG");
        btnHORG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHORGActionPerformed(evt);
            }
        });

        btnHMISC.setBackground(new java.awt.Color(255, 51, 51));
        btnHMISC.setText("MISC");
        btnHMISC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHMISCActionPerformed(evt);
            }
        });

        btnHiglihtAll.setText("Higlight All");
        btnHiglihtAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHiglihtAllActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Highlight");

        btnHPER.setBackground(new java.awt.Color(255, 255, 51));
        btnHPER.setText("PER");
        btnHPER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHPERActionPerformed(evt);
            }
        });

        btnHLOC.setBackground(new java.awt.Color(102, 255, 51));
        btnHLOC.setText("LOC");
        btnHLOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHLOCActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NERPanelLayout = new javax.swing.GroupLayout(NERPanel);
        NERPanel.setLayout(NERPanelLayout);
        NERPanelLayout.setHorizontalGroup(
            NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NERPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(NERPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(NERPanelLayout.createSequentialGroup()
                        .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(NERPanelLayout.createSequentialGroup()
                                .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnHLOC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(btnHPER, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHORG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHMISC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(35, 35, 35)
                        .addComponent(btnHiglihtAll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );
        NERPanelLayout.setVerticalGroup(
            NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NERPanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NERPanelLayout.createSequentialGroup()
                        .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHPER)
                            .addComponent(btnHORG))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHLOC)
                            .addComponent(btnHMISC)))
                    .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHiglihtAll, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addGap(0, 128, Short.MAX_VALUE))
        );

        jPanel1.add(NERPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHORGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHORGActionPerformed
        // TODO add your handling code here:
        //        Highlighter hl3 = areaInput.getHighlighter();// để xóa higlight cũ
        //        hl3.removeAllHighlights();
        //btnHAdj.setEnabled(false);
        
    }//GEN-LAST:event_btnHORGActionPerformed

    private void btnHMISCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHMISCActionPerformed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_btnHMISCActionPerformed

    private void btnHiglihtAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHiglihtAllActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnHiglihtAllActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnHPERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHPERActionPerformed
        //btnHNoun.setEnabled(false);
        
        // Ensure the areaInput component is not null and has selected text

        // Update JTable
    }//GEN-LAST:event_btnHPERActionPerformed

    private void btnHLOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHLOCActionPerformed
        // TODO add your handling code here:
        //        Highlighter hl2 = areaInput.getHighlighter(); // để xóa higlight cũ
        //        hl2.removeAllHighlights();
        //btnHVerb.setEnabled(false);
        
    }//GEN-LAST:event_btnHLOCActionPerformed

    private void btnHNounActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHNounActionPerformed
        //btnHNoun.setEnabled(false);
       
        // Update JTable
    }//GEN-LAST:event_btnHNounActionPerformed

    private void btnHVerbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHVerbActionPerformed
        // TODO add your handling code here:
        //        Highlighter hl2 = areaInput.getHighlighter(); // để xóa higlight cũ
        //        hl2.removeAllHighlights();
        //btnHVerb.setEnabled(false);
        
    }//GEN-LAST:event_btnHVerbActionPerformed

    private void btnHAdjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAdjActionPerformed
        // TODO add your handling code here:
        //        Highlighter hl3 = areaInput.getHighlighter();// để xóa higlight cũ
        //        hl3.removeAllHighlights();
        //btnHAdj.setEnabled(false);
       
    }//GEN-LAST:event_btnHAdjActionPerformed

    private void btnNERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNERActionPerformed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_btnNERActionPerformed

    private void btnHiglihtAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHiglihtAll1ActionPerformed
       
    }//GEN-LAST:event_btnHiglihtAll1ActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnChuyenNERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenNERActionPerformed
        // TODO add your handling code here:
        POSPanel.setVisible(false);
        NERPanel.setVisible(true);
    }//GEN-LAST:event_btnChuyenNERActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NERPanel.setVisible(false);
        POSPanel.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NERPanel;
    private javax.swing.JPanel POSPanel;
    private javax.swing.JButton btnChuyenNER;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnHAdj;
    private javax.swing.JButton btnHLOC;
    private javax.swing.JButton btnHMISC;
    private javax.swing.JButton btnHNoun;
    private javax.swing.JButton btnHORG;
    private javax.swing.JButton btnHPER;
    private javax.swing.JButton btnHVerb;
    private javax.swing.JButton btnHiglihtAll;
    private javax.swing.JButton btnHiglihtAll1;
    private javax.swing.JButton btnNER;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
