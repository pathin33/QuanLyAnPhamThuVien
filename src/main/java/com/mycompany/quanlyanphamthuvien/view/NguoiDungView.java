/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.quanlyanphamthuvien.view;

import com.mycompany.quanlyanphamthuvien.controller.NguoiDungController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NguoiDungView extends JFrame {

    private NguoiDungController controller;

    public NguoiDungView() {
        initComponents();
        initTable();
        controller = new NguoiDungController(this);
        RadioSach.addActionListener(e -> {
            if (RadioSach.isSelected()) {
                controller.bangSachUser();
                RadioSach.setEnabled(false);
                RadioBao.setEnabled(true);
                RadioTapchi.setEnabled(true);
            }
        });
        RadioBao.addActionListener(e -> {
            if (RadioBao.isSelected()) {
                controller.bangBaoUser();
                RadioBao.setEnabled(false);
                RadioSach.setEnabled(true);
                RadioTapchi.setEnabled(true);
            }
        });
        RadioTapchi.addActionListener(e -> {
            if (RadioTapchi.isSelected()) {
                controller.bangtapchiUser();
                RadioTapchi.setEnabled(false);
                RadioSach.setEnabled(true);
                RadioBao.setEnabled(true);
            }
        });
        borrowButton.addActionListener(e -> {
            // Kiểm tra MSSV
            String mssv = MSSVUser.getText().trim();
            if (mssv.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập MSSV!");
                return;
            }

            // Kiểm tra MSSV phải là số
            if (!mssv.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "MSSV phải là số!");
                return;
            }

            if (UserA.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên người dùng!");
                return;
            }

            if (jDateChooser1.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày mượn!");
                return;
            }

            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một mục để mượn!");
                return;
            }

            int quantity = (int) jTable1.getValueAt(selectedRow, 5);
            if (quantity <= 1) {
                JOptionPane.showMessageDialog(this, "Không thể mượn! Số lượng ấn phẩm đã ở mức tối thiểu.");
                return;
            }

            String id = (String) jTable1.getValueAt(selectedRow, 0);
            String title = (String) jTable1.getValueAt(selectedRow, 1);

            controller.xuLyMuon(
                    id,
                    title,
                    MSSVUser.getText().trim(),
                    UserA.getText().trim(),
                    jDateChooser1.getDate()
            );

            int newQuantity = quantity - 1;
            jTable1.setValueAt(newQuantity, selectedRow, 5);
            boolean newStatus = newQuantity > 0;
            jTable1.setValueAt(newStatus, selectedRow, 6);
        });
        Returnbutton.addActionListener(e -> {
            String mssv = MSSVUser.getText().trim();
            if (mssv.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập MSSV!");
                return;
            }

            if (!mssv.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "MSSV phải là số!");
                return;
            }

            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một mục để trả!");
                return;
            }

            String id = (String) jTable1.getValueAt(selectedRow, 0);
            controller.xuLyTra(id, mssv);

            int quantity = (int) jTable1.getValueAt(selectedRow, 5);
            jTable1.setValueAt(quantity + 1, selectedRow, 5);
            boolean newStatus = (quantity + 1) > 0;
            jTable1.setValueAt(newStatus, selectedRow, 6);
        });

        ListButton.addActionListener(e -> {
            String mssv = MSSVUser.getText().trim();
            if (mssv.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập MSSV!");
                return;
            }

            if (!mssv.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "MSSV phải là số!");
                return;
            }

            controller.hienThiDanhSachDangMuon(mssv);
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
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
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        borrowButton = new com.mycompany.quanlyanphamthuvien.view.Button();
        jLabel7 = new javax.swing.JLabel();
        Returnbutton = new com.mycompany.quanlyanphamthuvien.view.Button();
        ListButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        UserA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PhoneUser = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        MSSVUser = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        RadioSach = new javax.swing.JRadioButton();
        RadioBao = new javax.swing.JRadioButton();
        RadioTapchi = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UserView");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButton2.setText("Quit");

        borrowButton.setText("BORROW");
        borrowButton.setBorderColor(new java.awt.Color(153, 153, 153));
        borrowButton.setColor(new java.awt.Color(255, 255, 204));
        borrowButton.setRadius(50);
        borrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowButtonActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/logo2.png"))); // NOI18N
        jLabel7.setText("jLabel7");

        Returnbutton.setText("RETURN");
        Returnbutton.setBorderColor(new java.awt.Color(153, 153, 153));
        Returnbutton.setColor(new java.awt.Color(255, 255, 204));
        Returnbutton.setRadius(50);
        Returnbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnbuttonActionPerformed(evt);
            }
        });

        ListButton.setText("LIST HISTORY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Returnbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(borrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ListButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(38, 38, 38)
                .addComponent(borrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Returnbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(ListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 590));

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("User Account:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, 30));

        UserA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserAActionPerformed(evt);
            }
        });
        getContentPane().add(UserA, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 160, 30));

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 204));
        jLabel4.setText("Phone Number:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 140, 30));
        getContentPane().add(PhoneUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 160, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Title", "Publisher", "Publication Year", "Price", "Quantity", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 820, 270));

        jLabel5.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 204));
        jLabel5.setText("MSSV:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        MSSVUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSSVUserActionPerformed(evt);
            }
        });
        getContentPane().add(MSSVUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 160, 30));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 120, 30));

        jLabel6.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Borrowing Date:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 140, 30));

        buttonGroup1.add(RadioSach);
        RadioSach.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        RadioSach.setForeground(new java.awt.Color(255, 255, 204));
        RadioSach.setText("Book");
        RadioSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioSachActionPerformed(evt);
            }
        });
        getContentPane().add(RadioSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        buttonGroup1.add(RadioBao);
        RadioBao.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        RadioBao.setForeground(new java.awt.Color(255, 255, 204));
        RadioBao.setText("Newspaper");
        RadioBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBaoActionPerformed(evt);
            }
        });
        getContentPane().add(RadioBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        buttonGroup1.add(RadioTapchi);
        RadioTapchi.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        RadioTapchi.setForeground(new java.awt.Color(255, 255, 204));
        RadioTapchi.setText("Magazine");
        RadioTapchi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioTapchiActionPerformed(evt);
            }
        });
        getContentPane().add(RadioTapchi, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/quanlyanphamthuvien/Icon/fontUser.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 588));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MSSVUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSSVUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MSSVUserActionPerformed

    private void borrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_borrowButtonActionPerformed

    private void RadioSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioSachActionPerformed

    private void ReturnbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReturnbuttonActionPerformed

    private void RadioBaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioBaoActionPerformed

    private void RadioTapchiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioTapchiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioTapchiActionPerformed

    private void UserAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserAActionPerformed
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
            java.util.logging.Logger.getLogger(NguoiDungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(
                    NguoiDungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NguoiDungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NguoiDungView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NguoiDungView().setVisible(true);
            }
        });
    }

    private void initTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Title");
        model.addColumn("Publisher");
        model.addColumn("Publication Year");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Status");
        jTable1.setModel(model);
        jTable1.setDefaultEditor(Object.class, null);
    }

    public javax.swing.JTable getJTable1() {
        return jTable1;
    }

    public javax.swing.table.DefaultTableModel getTableModel() {
        return (DefaultTableModel) jTable1.getModel();
    }

    public void borrowBtn() {
        borrowButton.addActionListener(e
                -> {
            // Kiểm tra ngày mượn
            if (jDateChooser1.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày mượn!");
                return;
            }

            // Kiểm tra hàng được chọn
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một mục để mượn!");
                return;
            }

            // Lấy thông tin từ hàng được chọn
            String id = (String) jTable1.getValueAt(selectedRow, 0);
            String title = (String) jTable1.getValueAt(selectedRow, 1);
            int quantity = (int) jTable1.getValueAt(selectedRow, 5); // Lấy số lượng hiện tại
            boolean status = (boolean) jTable1.getValueAt(selectedRow, 6);

            // Kiểm tra số lượng và trạng thái
            if (quantity <= 0 || !status) {
                JOptionPane.showMessageDialog(this, "Mục này không thể mượn!");
                return;
            }

            // Giảm số lượng đi 1
            quantity--;

            // Cập nhật trạng thái mới
            boolean newStatus = (quantity > 0);

            jTable1.setValueAt(quantity, selectedRow, 5); // Cập nhật số lượng
            jTable1.setValueAt(newStatus, selectedRow, 6); // Cập nhật trạng thái
            controller.luuThongTinMuon(
                    id,
                    title,
                    MSSVUser.getText(),
                    UserA.getText(),
                    jDateChooser1.getDate()
            );
            controller.capNhatSoLuong(id, quantity);
            // Cập nhật dữ liệu gốc (ví dụ: trong danh sách Sach/Bao/TapChi)
            JOptionPane.showMessageDialog(this, "Mượn thành công!");
        }
        );
    }

    public JRadioButton getRadioSach() {
        return RadioSach;
    }

    public JRadioButton getRadioBao() {
        return RadioBao;
    }

    public JRadioButton getRadioTapChi() {
        return RadioTapchi;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ListButton;
    private javax.swing.JTextField MSSVUser;
    private javax.swing.JTextField PhoneUser;
    private javax.swing.JRadioButton RadioBao;
    private javax.swing.JRadioButton RadioSach;
    private javax.swing.JRadioButton RadioTapchi;
    private com.mycompany.quanlyanphamthuvien.view.Button Returnbutton;
    private javax.swing.JTextField UserA;
    private com.mycompany.quanlyanphamthuvien.view.Button borrowButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
