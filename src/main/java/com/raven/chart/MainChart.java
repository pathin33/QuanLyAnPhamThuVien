package com.raven.chart;

import javax.swing.*;

public class MainChart {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThongKeUI ui = new ThongKeUI();
            ui.setVisible(true);
        });
    }
}
