package com.mycompany.quanlyanphamthuvien.main;

import com.mycompany.quanlyanphamthuvien.view.Login;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception fallbackEx) {
                fallbackEx.printStackTrace();
            }
        }

        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            updateLookAndFeel(login);
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        });
    }

    public static void updateLookAndFeel(JFrame frame) {
        SwingUtilities.updateComponentTreeUI(frame);
        frame.pack();
    }

    public static void updateLookAndFeel(JPanel panel) {
        SwingUtilities.updateComponentTreeUI(panel);
        panel.revalidate();
        panel.repaint();
    }
}
