package com.mycompany.quanlyanphamthuvien.view;

import com.mycompany.quanlyanphamthuvien.action.QuanLySach;
import com.mycompany.quanlyanphamthuvien.controller.SachController;
import com.mycompany.quanlyanphamthuvien.entity.Sach;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class QLsach extends javax.swing.JFrame {

    private ArrayList<Sach> arrSach;
    private QuanLySach qlSach;

    public QLsach() {
        initComponents();
        setResizable(false);
         ImageIcon icon = new ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/logo2.png"));
         setIconImage(icon.getImage());
        FieldID.setEnabled(true);
        FieldID.setEditable(true);
        FieldID.setVisible(true);
        initTable();

        SachController sc = new SachController(this);
        sc.bangSach();
        setLuaChonTheLoai();
        qlSach = QuanLySach.getInstance();
        arrSach = qlSach.docDanhSachSach();
    }
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
        jLabel3 = new javax.swing.JLabel();
        FieldID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FieldID1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        dropGenre = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Management");
        setResizable(false);
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

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/cancelled.png"))); // NOI18N
        jButton2.setText("Cancel search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jButton6)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 740));

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 100, 42));
        jLabel3.setText("ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 60, 30));

        FieldID.setEditable(false);
        FieldID.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        FieldID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldID.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        FieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldIDActionPerformed(evt);
            }
        });
        getContentPane().add(FieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 80, -1));
        FieldID.setOpaque(false);
        FieldID.setVisible(false);

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 100, 42));
        jLabel4.setText("The number of books: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 190, 30));

        FieldID.setEditable(false);
        FieldID1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        FieldID1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FieldID1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));
        FieldID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldID1ActionPerformed(evt);
            }
        });
        getContentPane().add(FieldID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 80, -1));
        FieldID.setOpaque(false);
        FieldID.setVisible(false);

        jLabel5.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 100, 42));
        jLabel5.setText("Book title:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 100, 30));

        jLabel6.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 100, 42));
        jLabel6.setText("Book genre:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 120, 30));

        jLabel7.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 100, 42));
        jLabel7.setText("Publisher:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 90, 30));

        jLabel8.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 100, 42));
        jLabel8.setText("Publication year:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, -1, 30));

        jButton8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton8.setText("Sort by title");
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 140, 50));

        jButton9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton9.setText("Sort by quantity");
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 150, 50));

        jButton10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton10.setText("Sort by year");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 330, 150, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Book title", "Book genre", "Author", "Publisher", "Publication year", "Price", "Quantity", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(70);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 890, 320));

        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 190, 30));

        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, 100, 30));

        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 190, 30));

        jButton12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton12.setText("Sort by price");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 150, 50));

        jLabel10.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 100, 42));
        jLabel10.setText("Book price:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 100, 30));

        dropGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lua chon 1", "Item 2", "Item 3", "Item 4" }));
        dropGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropGenreActionPerformed(evt);
            }
        });
        getContentPane().add(dropGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 240, 100, 30));

        jLabel9.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 100, 42));
        jLabel9.setText("Author:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 70, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 190, 30));
        getContentPane().add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 140, 60, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/fontsach.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 740));

        pack();
    }// </editor-fold>                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        QuanLyMain QL = new QuanLyMain();
        QL.setVisible(true);
        QL.pack();
        QL.setLocationRelativeTo(null);
        this.dispose();
    }                                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        timkiemsach tks = new timkiemsach();
        tks.setVisible(true);
        tks.pack();
        tks.setLocationRelativeTo(null);
        this.dispose();
    }                                        

    private void dropGenreActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        FieldID1.setEnabled(true);
        
        FieldID.setText("");
        FieldID1.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jButton1.setEnabled(true);

    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ArrayList<Sach> dsSach = qlSach.docDanhSachSach();
        khoiTaoBangSach(dsSach);
    }                                        
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void buttonAddSach(ActionListener listener) {
        jButton1.addActionListener(listener);
    }

    public void bangDsSach(ListSelectionListener listener) {
        jTable1.getSelectionModel().addListSelectionListener(listener);
    }

    public void xoaDt(ActionListener listener) {
        jButton3.addActionListener(listener);
    }

    public void suaDt(ActionListener listener) {
        jButton7.addActionListener(listener);
    }

    public void sapXepTheoTen(ActionListener listener) {
        jButton8.addActionListener(listener);
    }

    public void sapXepTheoGiaTien(ActionListener listener) {
        jButton12.addActionListener(listener);
    }

    public void sapXepTheoSoLuong(ActionListener listener) {
        jButton9.addActionListener(listener);
    }

    public void sapXepTheoNam(ActionListener listener) {
        jButton10.addActionListener(listener);
    }

    public void cancelSearch(ActionListener listener) {
        jButton2.addActionListener(listener);
    }

    private void setLuaChonTheLoai() {
        String[] items = {
            "Văn học", "Khoa học", "Lịch sử",
            "Kinh tế", "Công nghệ", "Nghệ thuật"
        };
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
        dropGenre.setModel(model);
    }

    private void initTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Book Title");
        model.addColumn("Genre");
        model.addColumn("Author");
        model.addColumn("Publisher");
        model.addColumn("Publication Year");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Status");

        jTable1.setModel(model);
        jTable1.setDefaultEditor(QLsach.class, null);
    }

    public void khoiTaoBangSach(ArrayList<Sach> bangSach) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');

        DecimalFormat formatter = new DecimalFormat("#,###", symbols);

        for (Sach s : bangSach) {
            Object[] row = new Object[]{
                s.getID(),
                s.getTenAnPham(),
                s.getTheLoai(),
                s.getTacGia(),
                s.getNhaXuatBan(),
                s.getNamXuatBan(),
                formatter.format(s.getGiaTien()),
                s.getSoLuong(),
                s.tinhTrang()
            };
            model.addRow(row);
        }
    }

    private boolean checkID() {
        try {
            String textID = FieldID1.getText().trim();

            if (textID.isEmpty() || !textID.toUpperCase().matches("(?i)S\\d+")) {
                showMessage("Invalid ID must start with \"S\" followed by digits!");
                return false;
            }

            arrSach = qlSach.docDanhSachSach();
            for (Sach sach : arrSach) {
                if (sach.getID().equalsIgnoreCase(textID)) {
                    showMessage("ID already exists. Please enter a unique ID!");
                    return false;
                }
            }
        } catch (Exception e) {
            FieldID1.requestFocus();
            showMessage("ID cannot be blank!");
            return false;
        }
        return true;
    }

    private boolean checkTenSach() {
        String name = jTextField1.getText();
        if (name == null || "".equals(name.trim())) {
            jTextField1.requestFocus();
            showMessage("Book title cannot be empty!");
            return false;
        }
        return true;
    }

    private boolean checkTacGia() {
        String tacGia = jTextField2.getText();
        if (tacGia == null || "".equals(tacGia.trim())) {
            jTextField2.requestFocus();
            showMessage("Author cannot be empty!");
            return false;
        }
        return true;
    }

    private boolean checkSoLuong() {
        String soLuong = FieldID.getText();
        if ("".equals(soLuong.trim())) {
            showMessage("Quantity cannot be blank!");
            FieldID.requestFocus();
            return false;
        }
        try {
            int so = Integer.parseInt(soLuong.trim());
            if (so <= 0) {
                showMessage("Quantity must be greater than 0!");
                return false;
            }
        } catch (NumberFormatException e) {
            showMessage("Quantity must be a number!");
            return false;
        }
        return true;
    }

    private boolean checkGia() {
        String giaText = jTextField3.getText().trim();
        if (giaText.isEmpty()) {
            showMessage("Price cannot be blank!");
            jTextField3.requestFocus();
            return false;
        }
        try {
            double gia = Double.parseDouble(giaText);
            if (gia <= 0) {
                showMessage("The price must be greater than 0!");
                jTextField3.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            showMessage("Price must be a valid number!");
            return false;
        }
        return true;
    }

    private boolean checkNhaXuatBan() {
        String name = jTextField4.getText();
        if (name == null || "".equals(name.trim())) {
            jTextField4.requestFocus();
            showMessage("Publisher cannot be empty!");
            return false;
        }
        return true;
    }

    private boolean checkNamXuatBan() {
        int nam = jYearChooser1.getYear();
        if (nam > 2025) {
            showMessage("Invalid publication year!");
            return false;
        }
        return true;
    }

    public static String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String[] words = input.trim().toLowerCase().split("\\s+");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return capitalized.toString().trim();
    }

    public Sach checkDuLieuHopLe() {
        if (!checkID() || !checkNhaXuatBan() || !checkGia() || !checkNamXuatBan()
                || !checkSoLuong() || !checkTenSach() || !checkTacGia()) {
            return null;
        }
        try {
            Sach sach = new Sach();
            sach.setID(FieldID1.getText().trim());
            sach.setTenAnPham(capitalizeWords(jTextField1.getText().trim()));
            sach.setTacGia(capitalizeWords(jTextField2.getText().trim()));
            sach.setNhaXuatBan(jTextField4.getText().trim());
            sach.setTheLoai((String) dropGenre.getSelectedItem());
            sach.setSoLuong(Integer.parseInt(FieldID.getText().trim()));
            sach.setNamXuatBan(jYearChooser1.getYear());
            sach.setGiaTien(Double.parseDouble(jTextField3.getText().trim()));
            return sach;
        } catch (Exception e) {
            showMessage("There was an error in data processing!");
            return null;
        }
    }

    public Sach checkDuLieuTruID() {
        if (!checkNhaXuatBan() || !checkGia() || !checkNamXuatBan()
                || !checkSoLuong() || !checkTenSach() || !checkTacGia()) {
            return null;
        }
        try {
            Sach sach = new Sach();
            sach.setID(FieldID1.getText().trim());
            sach.setTenAnPham(capitalizeWords(jTextField1.getText().trim()));
            sach.setTacGia(capitalizeWords(jTextField2.getText().trim()));
            sach.setNhaXuatBan(jTextField4.getText().trim());
            sach.setTheLoai((String) dropGenre.getSelectedItem());
            sach.setSoLuong(Integer.parseInt(FieldID.getText().trim()));
            sach.setNamXuatBan(jYearChooser1.getYear());
            sach.setGiaTien(Double.parseDouble(jTextField3.getText().trim()));
            return sach;
        } catch (Exception e) {
            showMessage("There was an error in data processing!");
            return null;
        }
    }

    public void layChiSo() throws ParseException {
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            FieldID1.setText(jTable1.getModel().getValueAt(row, 0).toString());
            FieldID1.setEnabled(false);
            jTextField1.setText(jTable1.getModel().getValueAt(row, 1).toString());
            jTextField2.setText(jTable1.getModel().getValueAt(row, 3).toString());
            jTextField4.setText(jTable1.getModel().getValueAt(row, 4).toString());
            dropGenre.setSelectedItem(jTable1.getModel().getValueAt(row, 2).toString());
            FieldID.setText(jTable1.getModel().getValueAt(row, 7).toString());
            jYearChooser1.setYear((Integer) jTable1.getModel().getValueAt(row, 5));
            jTextField3.setText(jTable1.getModel().getValueAt(row, 6).toString());
            jButton1.setEnabled(false);
        }
    }

    public void xoaDt() {
        int hangXoa = jTable1.getSelectedRow();
        if (hangXoa == -1) {
            showMessage("Please select a row to delete!");
            return;
        }

        String id = (String) jTable1.getValueAt(hangXoa, 0);
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this book?", "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (qlSach.xoaSach(id)) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(hangXoa);
                showMessage("Book deleted successfully!");
            } else {
                showMessage("Book not found for deletion!");
            }
        }
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
