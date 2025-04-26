package com.raven.chart;

import com.mycompany.quanlyanphamthuvien.action.ThongKeAnPham;
import com.mycompany.quanlyanphamthuvien.view.QuanLyMain;
import javax.swing.*;
import java.awt.*;

public class ThongKeTextPanel extends JPanel {

    public ThongKeTextPanel() {
        ThongKeAnPham thongKe = new ThongKeAnPham();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 102), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // Title
        JLabel title = new JLabel("PUBLICATION STATISTICS");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(0, 0, 102));

        // Add components
        add(title);
        add(Box.createRigidArea(new Dimension(0, 25)));

        add(createStatRow("Total publications:", String.valueOf(thongKe.soLuongAnPham()), true));
        add(Box.createRigidArea(new Dimension(0, 20)));

        add(createStatRow("Book titles:", String.valueOf(thongKe.soLuongSach()), true));
        add(createStatRow("  - Total books:", String.valueOf(thongKe.tongSoLuongSach()), true));
        add(Box.createRigidArea(new Dimension(0, 15)));

        add(createStatRow("Newspaper titles:", String.valueOf(thongKe.soLuongBao()), true));
        add(createStatRow("  - Total newspapers:", String.valueOf(thongKe.tongSoLuongBao()), true));
        add(Box.createRigidArea(new Dimension(0, 15)));

        add(createStatRow("Magazine titles:", String.valueOf(thongKe.soLuongTapChi()), true));
        add(createStatRow("  - Total magazines:", String.valueOf(thongKe.tongSoLuongTapChi()), true));
        add(Box.createRigidArea(new Dimension(0, 25)));

        add(createStatRow("Most common type:", thongKe.timLoaiAnPhamNhieuNhat(), true));
        add(createStatRow("Least common type:", thongKe.timLoaiAnPhamItNhat(), true));
        add(Box.createRigidArea(new Dimension(0, 30)));

        // Add back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        backButton.setBackground(new Color(0, 0, 102));
        backButton.setForeground(Color.BLACK);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setMaximumSize(new Dimension(150, 40));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 102), 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        backButton.addActionListener(e -> {
            QuanLyMain qlMain = new QuanLyMain();
            qlMain.setLocationRelativeTo(null);
            qlMain.setVisible(true);
            SwingUtilities.getWindowAncestor(ThongKeTextPanel.this).dispose();
        });
        add(backButton);
    }

    private JPanel createStatRow(String label, String value, boolean isBold) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panel.setBackground(Color.WHITE);

        JLabel lbl = new JLabel(label);
        JLabel val = new JLabel(value);

        // All text is now bold as requested
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
        val.setFont(new Font("Segoe UI", Font.BOLD, 16));

        lbl.setForeground(new Color(0, 0, 102));
        val.setForeground(Color.BLACK);

        panel.add(lbl);
        panel.add(val);
        return panel;
    }
}