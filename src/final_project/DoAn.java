/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package final_project;

import edu.emory.mathcs.nlp.component.template.util.NLPMode;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    Color colorNER = new Color(255, 51, 51);

    //List 
    List<Token> nounWords = new ArrayList<>();
    List<Token> verbWords = new ArrayList<>();
    List<Token> adjWords = new ArrayList<>();
    List<Token> npWords = new ArrayList<>();
    
    List<Token> PERWords = new ArrayList<>();
    List<Token> LOCWords = new ArrayList<>();
    List<Token> ORGWords = new ArrayList<>();
    List<Token> MISCWords = new ArrayList<>();
    List<Token> lst = new ArrayList<Token>();
    // Extract words from annotation
    List<Token> tokens = new ArrayList<>();

    //Class
    Utilities uti = new Utilities();

    //check 
    int checkN = 0;
    int checkV = 0;
    int checkA = 0;
    int checkNp = 0;

    public DoAn() {
        initComponents();
        Color color = new Color(51, 102, 255);
        //getContentPane().setBackground(new Color.red);
    }

    public void highlighteLoaiTu(List<Token> patterns, Color colorN, int check) {
        Highlighter hl = areaInput.getHighlighter();
        //hl.removeAllHighlights();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(colorN);

        for (Token pattern : patterns) {
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
        String loaiTu = "";
        if (patterns.get(1).getPOS().equals("N")) {
            loaiTu = "danh từ";
        } else if (patterns.get(1).getPOS().equals("A")) {
            loaiTu = "tính từ";
        } else if (patterns.get(1).getPOS().equals("V")) {
            loaiTu = "động từ";
        } else if (patterns.get(1).getPOS().equals("Np")) {
            loaiTu = "danh từ riêng";
        } else {
            loaiTu = "loại từ không xác định";
        }

        for (Token pattern : patterns) {
            Token conceptInfo = new Token(pattern.getWord(), pattern.getStartPos(), pattern.getEndPos(), loaiTu);
            if (check == 0) {
                lst.add(conceptInfo);
                sortList(lst);
                updateTable();
            }
        }
    }
    /// NER
    public void highlighNER(List<Token> patterns, Color colorN, int check) {
        Highlighter hl = areaInput.getHighlighter();
        //hl.removeAllHighlights();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(colorN);

        for (Token pattern : patterns) {
            try {
                int start = pattern.getStartPos();
                int end = pattern.getEndPos() + 1; // End position should be inclusive
                hl.addHighlight(start, end, painter);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }

        // Lấy nhãn NER của phần tử đầu tiên (hoặc một phần tử bất kỳ khác tùy logic của bạn)
        String loaiTu;
        String nerLabel = patterns.get(0).getNER_Label(); // Lấy nhãn của phần tử đầu tiên

        switch (nerLabel) {
            case "PER":
                loaiTu = "Tên người";
                break;
            case "LOC":
                loaiTu = "Tên địa điểm";
                break;
            case "ORG":
                loaiTu = "Tên tổ chức";
                break;
            case "MISC":
                loaiTu = "Tên các thực thể khác";
                break;
            default:
                loaiTu = "loại từ không xác định";
                break;
        }

        // Thêm các từ đã được đánh dấu vào danh sách ngoài vòng lặp
        if (check == 0) {
            for (Token pattern : patterns) {
                Token conceptInfo = new Token(pattern.getWord(), pattern.getStartPos(), pattern.getEndPos(), loaiTu);
                lst.add(conceptInfo);
            }
            sortList(lst);
            updateTable();
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
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaInput = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnSelectDocument = new javax.swing.JButton();
        txtTenFile = new javax.swing.JTextField();
        ButtonPanel = new javax.swing.JPanel();
        POSPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnHNoun = new javax.swing.JButton();
        btnHVerb = new javax.swing.JButton();
        btnHAdj = new javax.swing.JButton();
        btnNER = new javax.swing.JButton();
        btnHiglihtAll = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        NERPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnHPER = new javax.swing.JButton();
        btnHLOC = new javax.swing.JButton();
        btnHORG = new javax.swing.JButton();
        btnHMISC = new javax.swing.JButton();
        btnHiglihtAll1 = new javax.swing.JButton();
        btnClear1 = new javax.swing.JButton();
        btnExport1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel1.setText("Tiêu đề");

        jButton2.setText("NER >> ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("POS >> ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnSelectDocument.setText("Select Document ");
        btnSelectDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectDocumentActionPerformed(evt);
            }
        });

        txtTenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnSelectDocument)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        ButtonPanel.setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("HIglight POS");

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

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout POSPanelLayout = new javax.swing.GroupLayout(POSPanel);
        POSPanel.setLayout(POSPanelLayout);
        POSPanelLayout.setHorizontalGroup(
            POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(POSPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(POSPanelLayout.createSequentialGroup()
                        .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnHVerb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(btnHNoun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHAdj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNER, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnHiglihtAll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnExport))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        POSPanelLayout.setVerticalGroup(
            POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(POSPanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(POSPanelLayout.createSequentialGroup()
                        .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHNoun)
                            .addComponent(btnHAdj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHVerb)
                            .addComponent(btnNER))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, POSPanelLayout.createSequentialGroup()
                        .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(POSPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(POSPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(POSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnHiglihtAll, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28))))
        );

        btnHNoun.getAccessibleContext().setAccessibleName("Noun ");

        ButtonPanel.add(POSPanel, "card2");

        NERPanel.setName(""); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Highlight NER");

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

        btnHiglihtAll1.setText("Higlight All");
        btnHiglihtAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHiglihtAll1ActionPerformed(evt);
            }
        });

        btnClear1.setText("Clear");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        btnExport1.setText("Export");
        btnExport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExport1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NERPanelLayout = new javax.swing.GroupLayout(NERPanel);
        NERPanel.setLayout(NERPanelLayout);
        NERPanelLayout.setHorizontalGroup(
            NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NERPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NERPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(630, Short.MAX_VALUE))
                    .addGroup(NERPanelLayout.createSequentialGroup()
                        .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnHLOC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(btnHPER, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHORG, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(btnHMISC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(btnHiglihtAll1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExport1)
                        .addGap(26, 26, 26))))
        );
        NERPanelLayout.setVerticalGroup(
            NERPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NERPanelLayout.createSequentialGroup()
                .addComponent(jLabel3)
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
                        .addComponent(btnHiglihtAll1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExport1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        ButtonPanel.add(NERPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
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
            // set dữ liệu lại 
            nounWords.clear();
            verbWords.clear();
            adjWords.clear();
            npWords.clear();
            PERWords.clear();
            LOCWords.clear();
            ORGWords.clear();
            MISCWords.clear();
            lst.clear();
            tokens.clear();
            checkN = 0;
            checkV = 0;
            checkA = 0;
            checkNp = 0;

            // xóa higlight
            Highlighter hl2 = areaInput.getHighlighter();
            hl2.removeAllHighlights();
            // xóa bảng 
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            //phân tích 
            String str = areaInput.getText();

            uti.PhanTachLoaiTu(str, nounWords, verbWords, adjWords, npWords);
            uti.PhanTichNER(str, PERWords, LOCWords, ORGWords, MISCWords);
        }
    }//GEN-LAST:event_btnSelectDocumentActionPerformed

    private void btnHNounActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHNounActionPerformed
        //btnHNoun.setEnabled(false);
        if (nounWords.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No noun words found.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            highlighteLoaiTu(nounWords, colorN, checkN);
            checkN = 1;
        }
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

        //System.out.println("word :"+lst.get(i).getWord(););
        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        System.out.println("Table updated with " + data.length + " rows.");
    }
    private void btnHVerbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHVerbActionPerformed
        // TODO add your handling code here:
//        Highlighter hl2 = areaInput.getHighlighter(); // để xóa higlight cũ
//        hl2.removeAllHighlights();
        //btnHVerb.setEnabled(false);
        if (verbWords.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No verb words found.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            highlighteLoaiTu(verbWords, colorV, checkV);
            checkV = 1;
        }
    }//GEN-LAST:event_btnHVerbActionPerformed

    private void btnHAdjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAdjActionPerformed
        // TODO add your handling code here:
//        Highlighter hl3 = areaInput.getHighlighter();// để xóa higlight cũ
//        hl3.removeAllHighlights();
        //btnHAdj.setEnabled(false);
        if (adjWords.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No adjective words found.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            highlighteLoaiTu(adjWords, colorA, checkA);
            checkA = 1;
        }

    }//GEN-LAST:event_btnHAdjActionPerformed

    private void btnHiglihtAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHiglihtAllActionPerformed
        // TODO add your handling code here:
        Highlighter hl2 = areaInput.getHighlighter();
        hl2.removeAllHighlights();
        // Kiểm tra và tô màu từng danh sách từ nếu không trống
        if (!adjWords.isEmpty()) {
            highlighteLoaiTu(adjWords, colorA, checkA);
        } else {
            System.out.println("adjWords trống");
        }

        if (!verbWords.isEmpty()) {
            highlighteLoaiTu(verbWords, colorV, checkV);
        } else {
            System.out.println("verbWords trống");
        }

        if (!npWords.isEmpty()) {
            highlighteLoaiTu(npWords, colorNER, checkNp);
        } else {
            System.out.println("npWords trống");
        }

        if (!nounWords.isEmpty()) {
            highlighteLoaiTu(nounWords, colorN, checkN);
        } else {
            System.out.println("nounWords trống");
        }

        checkN =1 ;
        checkA =1;
        checkV =1;
        checkNp =1;
    }//GEN-LAST:event_btnHiglihtAllActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        Highlighter hl2 = areaInput.getHighlighter();
        hl2.removeAllHighlights();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        checkN = 0;
        checkV = 0;
        checkA = 0;
        checkNp = 0;
        lst.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnNERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNERActionPerformed
        // TODO add your handling code here:

        if (npWords.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No named entity words found.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            highlighteLoaiTu(npWords, colorNER, checkNp);
            checkNp = 1;
        }

    }//GEN-LAST:event_btnNERActionPerformed

    private String generateHighlightFilePath(String inputPath) {
        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            JOptionPane.showMessageDialog(null,"Input file does not exist.");
            return null;
        }

        String directory = inputFile.getParent();
        String filename = inputFile.getName();
        int dotIndex = filename.lastIndexOf(".");
        String baseName = (dotIndex == -1) ? filename : filename.substring(0, dotIndex);
        String extension = (dotIndex == -1) ? "" : filename.substring(dotIndex);

        String newFilename = baseName + "_highlight" + extension;
        return directory + File.separator + newFilename;
    }

    private boolean exportTableData(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);

        // Write column headers
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            writer.write(jTable1.getColumnName(i) + "\t");
        }
        writer.write("\n");

        // Write rows
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                writer.write(jTable1.getValueAt(i, j).toString() + "\t");
            }
            writer.write("\n");
        }

        writer.close();
        return true;
    }
    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        String inputPath = txtTenFile.getText();
                String newFilePath = generateHighlightFilePath(inputPath);
                try {
                    if (newFilePath != null && exportTableData(newFilePath)) {
                        JOptionPane.showMessageDialog(null,"File has been created at: " + newFilePath);
                    } else {
                        JOptionPane.showMessageDialog(null,"Failed to create the new file.");
                    }
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null,"Error: " + ioException.getMessage());
                }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnHPERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHPERActionPerformed
        //btnHNoun.setEnabled(false);
        if (PERWords.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No PER words found.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            highlighNER(PERWords, colorN, checkN);
            checkN = 1;
        }
        // Ensure the areaInput component is not null and has selected text

        // Update JTable
    }//GEN-LAST:event_btnHPERActionPerformed

    private void btnHLOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHLOCActionPerformed
        // TODO add your handling code here:
        //        Highlighter hl2 = areaInput.getHighlighter(); // để xóa higlight cũ
        //        hl2.removeAllHighlights();
        //btnHVerb.setEnabled(false);
        if (LOCWords.isEmpty()) {
            JOptionPane.showMessageDialog(null,"No LOC words found.", "Information", JOptionPane.INFORMATION_MESSAGE);
            // Hoặc hiển thị thông báo hộp thoại
            // JOptionPane.showMessageDialog(null, "No LOC words found.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            highlighNER(LOCWords, colorV, checkV);
            checkV = 1;
        }
    }//GEN-LAST:event_btnHLOCActionPerformed

    private void btnHORGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHORGActionPerformed
        // TODO add your handling code here:
        //        Highlighter hl3 = areaInput.getHighlighter();// để xóa higlight cũ
        //        hl3.removeAllHighlights();
        //btnHAdj.setEnabled(false);
        if (ORGWords.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ORG words found.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            highlighNER(ORGWords, colorA, checkA);
            checkA = 1;
        }
    }//GEN-LAST:event_btnHORGActionPerformed

    private void btnHMISCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHMISCActionPerformed
        // TODO add your handling code here:
        if (MISCWords.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No MISC words found.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            highlighNER(MISCWords, colorNER,checkNp);
            checkNp = 1;
        }
        
    }//GEN-LAST:event_btnHMISCActionPerformed

    private void btnHiglihtAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHiglihtAll1ActionPerformed
        // TODO add your handling code here:
        Highlighter hl2 = areaInput.getHighlighter();
        hl2.removeAllHighlights();
        // Kiểm tra và tô màu từng danh sách từ nếu không trống
            if (!PERWords.isEmpty()) {
                highlighteLoaiTu(PERWords, colorN, checkN);
            } else {
                System.out.println("PERWords trống");
            }

            if (!LOCWords.isEmpty()) {
                highlighteLoaiTu(LOCWords, colorV, checkV);
            } else {
                System.out.println("LOCWords trống");
            }

            if (!MISCWords.isEmpty()) {
                highlighteLoaiTu(MISCWords, colorNER, checkNp);
            } else {
                System.out.println("MISCWords trống");
            }

            if (!ORGWords.isEmpty()) {
                highlighteLoaiTu(ORGWords, colorA, checkA);
            } else {
                System.out.println("ORGWords trống");
            }

            // Đặt lại các biến kiểm tra
            checkN = 1;
            checkA = 1;
            checkV = 1;
            checkNp = 1;
       
    }//GEN-LAST:event_btnHiglihtAll1ActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
        Highlighter hl2 = areaInput.getHighlighter();
        hl2.removeAllHighlights();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        int checkN = 0;
        checkV = 0;
        checkA = 0;
        checkNp = 0;
        lst.clear();
        
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NERPanel.setVisible(false);
        POSPanel.setVisible(true);
        //
        Highlighter hl2 = areaInput.getHighlighter();
        hl2.removeAllHighlights();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        int checkN = 0;
        checkV = 0;
        checkA = 0;
        checkNp = 0;
        lst.clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        POSPanel.setVisible(false);
        NERPanel.setVisible(true);
        //
        Highlighter hl2 = areaInput.getHighlighter();
        hl2.removeAllHighlights();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        int checkN = 0;
        checkV = 0;
        checkA = 0;
        checkNp = 0;
        lst.clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenFileActionPerformed

    private void btnExport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExport1ActionPerformed
        // TODO add your handling code here:
        String inputPath = txtTenFile.getText();
                String newFilePath = generateHighlightFilePath(inputPath);
                try {
                    if (newFilePath != null && exportTableData(newFilePath)) {
                        JOptionPane.showMessageDialog(null,"File has been created at: " + newFilePath);
                    } else {
                        JOptionPane.showMessageDialog(null,"Failed to create the new file.");
                    }
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null,"Error: " + ioException.getMessage());
                }
    }//GEN-LAST:event_btnExport1ActionPerformed

    private void sortList(List<Token> classWord) {
        // Sắp xếp danh sách conceptInfos theo giá trị của trường StartPosition theo thứ tự tăng dần
        classWord.sort((a, b) -> Integer.compare(a.getStartPos(), b.getEndPos()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JPanel NERPanel;
    private javax.swing.JPanel POSPanel;
    private javax.swing.JTextPane areaInput;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnExport1;
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
    private javax.swing.JButton btnSelectDocument;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtTenFile;
    // End of variables declaration//GEN-END:variables
}
