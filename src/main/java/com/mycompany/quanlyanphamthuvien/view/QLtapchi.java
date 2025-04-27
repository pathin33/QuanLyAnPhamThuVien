package com.mycompany.quanlyanphamthuvien.view;

import com.mycompany.quanlyanphamthuvien.controller.TapChiController;
import com.mycompany.quanlyanphamthuvien.entity.TapChi;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QLtapchi extends javax.swing.JFrame {

    /**
     * Creates new form QLtapchi
     */
    public QLtapchi() {
        initComponents();

        FieldID.setText("0");
        FieldID1.setText("           ");
        jTextField2.setText("         ");

        FieldID.setVisible(true);
        FieldID1.setVisible(true);
        jTextField2.setVisible(true);
        initTable();
        TapChiController tvc = new TapChiController(this);
        tvc.bangTapChi();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        FieldID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FieldID1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        dropGenre = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/logo2.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/book.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/cancelled.png"))); // NOI18N
        jButton2.setText("Cancel search");

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/remove.png"))); // NOI18N
        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 102));
        jButton4.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/refresh.png"))); // NOI18N
        jButton4.setText("Refresh");

        jButton5.setBackground(new java.awt.Color(0, 0, 102));
        jButton5.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/loupe.png"))); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/return.png"))); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 0, 102));
        jButton7.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/fix.png"))); // NOI18N
        jButton7.setText("Fix");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jButton6)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 740));

        FieldID.setEditable(false);
        FieldID.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        FieldID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldID.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        FieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldIDActionPerformed(evt);
            }
        });
        getContentPane().add(FieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 80, -1));
        FieldID.setOpaque(false);
        FieldID.setVisible(false);

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 100, 42));
        jLabel4.setText("The number of magazines: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 220, 30));

        FieldID.setEditable(false);
        FieldID1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        FieldID1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldID1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        FieldID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldID1ActionPerformed(evt);
            }
        });
        getContentPane().add(FieldID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));
        FieldID.setOpaque(false);
        FieldID.setVisible(false);

        jLabel5.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 100, 42));
        jLabel5.setText("Magazine title:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 130, 30));

        jLabel6.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 100, 42));
        jLabel6.setText("Magazine genre:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 140, 30));

        jLabel8.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 100, 42));
        jLabel8.setText("Publication month:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, -1, 30));

        jButton8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton8.setText("Sort by title");
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 140, 50));

        jButton9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton9.setText("Sort by quantity");
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 150, 50));

        jButton10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton10.setText("Sort by month");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 330, 150, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Magazine title", "Number of magazines", "Publication year", "Publisher", "Magazine price", "Issue number", "Publication month", "Magazine genre", " status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 890, 320));

        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 190, 30));

        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 240, 120, 30));

        jButton12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton12.setText("Sort by price");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 150, 50));

        jLabel10.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 100, 42));
        jLabel10.setText("Magazine price:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 240, 130, 30));

        dropGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lua chon 1", "Item 2", "Item 3", "Item 4" }));
        dropGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropGenreActionPerformed(evt);
            }
        });
        getContentPane().add(dropGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 190, 30));

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 100, 42));
        jLabel3.setText("ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 60, 30));

        jLabel7.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 100, 42));
        jLabel7.setText("Publisher:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 90, 30));

        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 190, 30));
        getContentPane().add(jMonthChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 140, 130, 30));
        getContentPane().add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 190, -1, 30));

        jLabel9.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 100, 42));
        jLabel9.setText("Publication year:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 150, 30));

        jLabel11.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 100, 42));
        jLabel11.setText("The issue number(TIN):");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, 30));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/fontsach.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1140, 740));

        pack();
    }// </editor-fold>                        

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        timkiemsach tk = new timkiemsach();
        tk.setVisible(true);
        tk.pack();
        tk.setLocationRelativeTo(null);
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        QuanLyMain QL = new QuanLyMain();
        QL.setVisible(true);
        QL.pack();
        QL.setLocationRelativeTo(null);
        this.dispose();
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }                                        

    private void FieldIDActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here: 
    }                                       

    private void FieldID1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void dropGenreActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

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
            java.util.logging.Logger.getLogger(QLtapchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLtapchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLtapchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLtapchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLtapchi().setVisible(true);
            }
        });
    }

    private void initTable() {
        DefaultTableModel model = new DefaultTableModel();
        //cái defaultTbleModel này là thư viện để làm việc với bảng trong javaSwing với chức năng thêm xoá sửa
        model.addColumn("ID");
        model.addColumn("Magazine Title");
        model.addColumn("Quantity");
        model.addColumn("Publication Year");
        model.addColumn("Publisher");
        model.addColumn("Price");
        model.addColumn("Issue Number");
        model.addColumn("Publication Month");
        model.addColumn("Topic");
        model.addColumn("Status");

        jTable1.setModel(model);
        jTable1.setDefaultEditor(QLtapchi.class, null);
    }

    public void khoiTaoBangTapChi(ArrayList<TapChi> bangTapChi) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (TapChi tc : bangTapChi) {
            Object[] row = new Object[]{
                tc.getID(),
                tc.getTenAnPham(),
                tc.getSoLuong(),
                tc.getNamXuatBan(),
                tc.getNhaXuatBan(),
                tc.getGiaTien(),
                tc.getSoPhatHanh(),
                tc.getThangPhatHanh(),
                tc.getChuyenDe(),
                tc.tinhTrang()
            };
            model.addRow(row);
        }

    }

    private boolean checkID() {
        try {
            String textID = FieldID1.getText().trim();
            if (textID.isEmpty() || !textID.matches("(?i)TC\\d+")) {
                showMessage("Invalid ID must start with \"TC\" followed by digits");
                return false;
            }
        } catch (Exception e) {
            FieldID1.requestFocus();
            showMessage("ID cannot be blank");
            return false;
        }
        return true;
    }

    private boolean checkTenTapChi() {
        String name = jTextField1.getText();
        if (name == null || "".equals(name.trim())) {
            jTextField1.requestFocus();
            showMessage("Magazine title cannot be empty");
            return false;
        }
        return true;
    }

    private boolean checkSoPhatHanh() {
        String soPhatHanh = jTextField2.getText();

        if ("".equals(soPhatHanh.trim())) {
            showMessage("Số phát hành không được để trống");
        }
        try {
            int so = Integer.parseInt(soPhatHanh.trim());
            if (so <= 0) {
                showMessage("Số phát hành phải lớn hơn 0");
                return false;
            }
        } catch (NumberFormatException e) {
            showMessage("Số phát hành phải là số ");
            return false;
        }
        return true;
    }

    private boolean checkSoLuong() {
        String soLuong = FieldID.getText();
        if ("".equals(soLuong.trim())) {
            showMessage("Số lượng không được để trống");
        }
        try {
            int so = Integer.parseInt(soLuong.trim());
            if (so <= 0) {
                showMessage("Số lượng phải lớn hơn 0");
                return false;
            }
        } catch (NumberFormatException e) {
            showMessage("Số lượng phải là số ");
            return false;
        }
        return true;

    }

    private boolean checkGia() {
        String giaText = jTextField4.getText().trim();
        if (giaText.isEmpty()) {
            showMessage("Giá không được để trống");
            jTextField4.requestFocus();
            return false;
        }
        try {
            double gia = Double.parseDouble(giaText);
            if (gia <= 0) {
                showMessage("Giá phải lớn hơn 0");
                jTextField4.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            showMessage("Giá phải là số thực hợp lệ");
            jTextField4.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkNhaXuatBan() {
        String name = jTextField4.getText();
        if (name == null || "".equals(name.trim())) {
            jTextField4.requestFocus();
            showMessage("Nhà xuất bản không được để trống");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField FieldID;
    private javax.swing.JTextField FieldID1;
    private javax.swing.JComboBox<String> dropGenre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration                   
}
