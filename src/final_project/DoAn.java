/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package final_project;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author lengu
 */
public class DoAn extends javax.swing.JFrame {

    // Color
    Color colorN = new Color(255, 255, 51);
    Color colorV = new Color(102, 255, 51);
    Color colorA = new Color(102, 102, 255);

    //List 
    List<WordPosition> nounWords = new ArrayList<>();
    List<WordPosition> verbWords = new ArrayList<>();
    List<WordPosition> adjWords = new ArrayList<>();
    List<WordPosition> lst = new ArrayList<WordPosition>();
    // Extract words from annotation
    List<WordPosition> wordsWithPositions = new ArrayList<>();

    //Class
    Utilities uti = new Utilities();

    public DoAn() {
        initComponents();
        Color color = new Color(51, 102, 255);
        //getContentPane().setBackground(new Color.red);
    }

    public void highlighterNoun(List<WordPosition> patterns, Color colorN) {
        Highlighter hl = areaInput.getHighlighter();
        //hl.removeAllHighlights();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(colorN);

        for (WordPosition pattern : patterns) {
            try {
                int start = pattern.getStartPos();
                int end = pattern.getEndPos() + 1; // End position should be inclusive
                hl.addHighlight(start, end, painter);

                // Debugging statement to print the list size after adding
                System.out.println("List Size: " + lst.size());
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }

        // Optionally, you can add the highlighted words to the list outside the loop
        for (WordPosition pattern : patterns) {
            WordPosition conceptInfo = new WordPosition(pattern.getWord(), pattern.getStartPos(), pattern.getEndPos(), "Danh tu");
            lst.add(conceptInfo);
            sortList(lst);
            updateTable();
        }
    }

    public void highlighterVerd(List<WordPosition> patterns, Color colorV) {
        Highlighter hl = areaInput.getHighlighter();
        //hl.removeAllHighlights();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(colorV);

        for (WordPosition pattern : patterns) {
            try {
                int start = pattern.getStartPos();
                int end = pattern.getEndPos() + 1; // End position should be inclusive
                hl.addHighlight(start, end, painter);

                // Debugging statement to print the list size after adding
                System.out.println("List Size: " + lst.size());
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }

        // Optionally, you can add the highlighted words to the list outside the loop
        for (WordPosition pattern : patterns) {
            WordPosition conceptInfo = new WordPosition(pattern.getWord(), pattern.getStartPos(), pattern.getEndPos(), "Dong tu");
            lst.add(conceptInfo);
            sortList(lst);
            updateTable();

        }
    }

    public void highlighterAdj(List<WordPosition> patterns, Color colorA) {
        Highlighter hl = areaInput.getHighlighter();
//    hl.removeAllHighlights();
//    Color tim = new Color(102,102,255);
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(colorA);

        for (WordPosition pattern : patterns) {
            try {
                int start = pattern.getStartPos();
                int end = pattern.getEndPos() + 1; // End position should be inclusive
                hl.addHighlight(start, end, painter);

                // Debugging statement to print the list size after adding
                System.out.println("List Size: " + lst.size());
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }

        // Optionally, you can add the highlighted words to the list outside the loop
        for (WordPosition pattern : patterns) {
            WordPosition conceptInfo = new WordPosition(pattern.getWord(), pattern.getStartPos(), pattern.getEndPos(), "Tinh tu");
            lst.add(conceptInfo);
            sortList(lst);
            updateTable();

        }
    }

    public void highlighterAll(List<WordPosition> patterns, Color colorN, Color colorV, Color colorA) {
        Highlighter hl = areaInput.getHighlighter();
        // hl.removeAllHighlights(); // Uncomment if you want to clear previous highlights

        for (WordPosition pattern : patterns) {
            Highlighter.HighlightPainter painter = null;
            switch (pattern.getPOS()) {
                case "N":
                    painter = new DefaultHighlighter.DefaultHighlightPainter(colorN);
                    break;
                case "V":
                    painter = new DefaultHighlighter.DefaultHighlightPainter(colorV);
                    break;
                case "A":
                    painter = new DefaultHighlighter.DefaultHighlightPainter(colorA);
                    break;
                default:
                    continue; // Skip if the POS is not N, V, or A
            }

            try {
                int start = pattern.getStartPos();
                int end = pattern.getEndPos() + 1; // End position should be inclusive
                hl.addHighlight(start, end, painter);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }
    }

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
            java.util.logging.Logger.getLogger(DoAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoAn().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaInput = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnSelectDocument = new javax.swing.JButton();
        txtTenFile = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnHNoun = new javax.swing.JButton();
        btnHVerb = new javax.swing.JButton();
        btnHAdj = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnHiglihtAll = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel1.setText("Tiêu đề");

        jButton1.setText("jButton1");

        jButton2.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(areaInput);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Word", "Start", "End", "Label"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnSelectDocument.setText("Select Document ");
        btnSelectDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectDocumentActionPerformed(evt);
            }
        });

        jButton8.setText("Select Document ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSelectDocument)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectDocument))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Highlight");

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

        jButton7.setBackground(new java.awt.Color(255, 51, 51));
        jButton7.setText("jButton4");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnHVerb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(btnHNoun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHAdj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(35, 35, 35)
                .addComponent(btnHiglihtAll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHNoun)
                            .addComponent(btnHAdj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHVerb)
                            .addComponent(jButton7)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHiglihtAll, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        btnHNoun.getAccessibleContext().setAccessibleName("Noun ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectDocumentActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();

        // Add a file filter for text files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            txtTenFile.setText(filename);
            try {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);
                areaInput.read(br, null);
                br.close();
                areaInput.requestFocus();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            //phân tích 
            String str = areaInput.getText();

            uti.PhanTachLoaiTu(str, nounWords, verbWords, adjWords);
        }
    }//GEN-LAST:event_btnSelectDocumentActionPerformed

    private void btnHNounActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHNounActionPerformed
        btnHNoun.setEnabled(false);
        highlighterNoun(nounWords, colorN);
        // Ensure the areaInput component is not null and has selected text

        // Update JTable

    }//GEN-LAST:event_btnHNounActionPerformed

    private void updateTable() {
        String[] columnNames = {"Word", "Start", "End", "Label"};
        Object[][] data = new Object[lst.size()][4];

        for (int i = 0; i < lst.size(); i++) {
            data[i][0] = lst.get(i).getWord();
            data[i][1] = lst.get(i).getStartPos();
            data[i][2] = lst.get(i).getEndPos();
            data[i][3] = lst.get(i).getPOS();
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        System.out.println("Table updated with " + data.length + " rows.");
    }
    private void btnHVerbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHVerbActionPerformed
        // TODO add your handling code here:
//        Highlighter hl2 = areaInput.getHighlighter(); // để xóa higlight cũ
//        hl2.removeAllHighlights();
        btnHVerb.setEnabled(false);
        highlighterVerd(verbWords, colorV);
    }//GEN-LAST:event_btnHVerbActionPerformed

    private void btnHAdjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAdjActionPerformed
        // TODO add your handling code here:
//        Highlighter hl3 = areaInput.getHighlighter();// để xóa higlight cũ
//        hl3.removeAllHighlights();
        btnHAdj.setEnabled(false);
        highlighterAdj(adjWords, colorA);
    }//GEN-LAST:event_btnHAdjActionPerformed

    private void btnHiglihtAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHiglihtAllActionPerformed
        // TODO add your handling code here:
        Highlighter hl2 = areaInput.getHighlighter();
        hl2.removeAllHighlights();
        highlighterAll(wordsWithPositions, colorN, colorV, colorA);
    }//GEN-LAST:event_btnHiglihtAllActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        Highlighter hl2 = areaInput.getHighlighter();
        hl2.removeAllHighlights();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void sortList(List<WordPosition> classWord) {
        // Sắp xếp danh sách conceptInfos theo giá trị của trường StartPosition theo thứ tự tăng dần
        classWord.sort((a, b) -> Integer.compare(a.getStartPos(), b.getEndPos()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane areaInput;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHAdj;
    private javax.swing.JButton btnHNoun;
    private javax.swing.JButton btnHVerb;
    private javax.swing.JButton btnHiglihtAll;
    private javax.swing.JButton btnSelectDocument;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtTenFile;
    // End of variables declaration//GEN-END:variables
}
