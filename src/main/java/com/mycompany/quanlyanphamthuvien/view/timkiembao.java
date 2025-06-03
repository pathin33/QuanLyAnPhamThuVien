package com.mycompany.quanlyanphamthuvien.view;

import com.mycompany.quanlyanphamthuvien.action.QuanLyBao;
import com.mycompany.quanlyanphamthuvien.entity.Bao;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class timkiembao extends javax.swing.JFrame {

    private QLbao baoView;
    private QuanLyBao qlBao;
    private Double giaMin = null;
    private Double giaMax = null;

    public timkiembao() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/logo2.png"));
        setIconImage(icon.getImage());
        setResizable(false);
        qlBao = new QuanLyBao();

        checkbox4.addItemListener(e -> {
            boolean isSelected = checkbox4.getState();
            jTextField1.setVisible(!isSelected);

            if (isSelected) {
                try {
                    String inputMin = JOptionPane.showInputDialog(this, "Enter minimum price:");
                    String inputMax = JOptionPane.showInputDialog(this, "Enter maximum price:");

                    if (inputMin != null && !inputMin.trim().isEmpty()) {
                        giaMin = Double.valueOf(inputMin.trim());
                    }
                    if (inputMax != null && !inputMax.trim().isEmpty()) {
                        giaMax = Double.valueOf(inputMax.trim());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number!");
                    checkbox4.setState(false); 
                    jTextField1.setVisible(true);
                    giaMin = null;
                    giaMax = null;
                }
            } else {
                giaMin = null;
                giaMax = null;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ID = new java.awt.Checkbox();
        title = new java.awt.Checkbox();
        Editor = new java.awt.Checkbox();
        checkbox4 = new java.awt.Checkbox();
        button1 = new com.mycompany.quanlyanphamthuvien.view.Button();
        button2 = new com.mycompany.quanlyanphamthuvien.view.Button();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 450, 40));

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 100, 42));
        jLabel3.setText("Enter search conditions:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 330, 60));

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 100, 42));
        jLabel4.setText("Enter keyword to search:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 370, 60));

        ID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ID.setLabel("ID");
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 90, 30));

        title.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        title.setLabel("Title");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 90, 30));

        Editor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Editor.setLabel("Editor");
        getContentPane().add(Editor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 90, 30));

        checkbox4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        checkbox4.setLabel("Price");
        getContentPane().add(checkbox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 80, 30));

        button1.setText("Quit");
        button1.setColor(new java.awt.Color(204, 204, 204));
        button1.setRadius(40);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 200, 50));

        button2.setText("Search");
        button2.setColor(new java.awt.Color(204, 204, 204));
        button2.setRadius(40);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 190, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/nensearch.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 420));

        pack();
    }// </editor-fold>                        

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        baoView = new QLbao();
        baoView.setLocationRelativeTo(null);
        baoView.setVisible(true);
        dispose();
    }

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Bao> result = new ArrayList<>();

        if (checkbox4.getState()) {
            // Sử dụng giá trị đã nhập từ dialog
            result = qlBao.timKiemTheoGiaTien(giaMin, giaMax);
        } else if (ID.getState()) {
            String keyword = jTextField1.getText().trim();
            if (keyword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a search keyword!");
                return;
            }
            result = qlBao.timKiemIDBao(keyword);
        } else if (title.getState()) {
            String keyword = jTextField1.getText().trim();
            if (keyword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a search keyword!");
                return;
            }
            result = qlBao.timKiemTenBao(keyword);
        } else if (Editor.getState()) {
            String keyword = jTextField1.getText().trim();
            if (keyword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a search keyword!");
                return;
            }
            result = qlBao.timKiemBienTapVien(keyword);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a search keyword!");
            return;
        }

        if (result.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No results found!");
        } else {
            baoView = new QLbao();
            baoView.setLocationRelativeTo(null);
            baoView.khoiTaoBangBao(result);
            baoView.setVisible(true);
        }

    }

    // Variables declaration - do not modify                     
    private java.awt.Checkbox Editor;
    private java.awt.Checkbox ID;
    private com.mycompany.quanlyanphamthuvien.view.Button button1;
    private com.mycompany.quanlyanphamthuvien.view.Button button2;
    private java.awt.Checkbox checkbox4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private java.awt.Checkbox title;
    // End of variables declaration                   
}
