package com.raven.chart;

import javax.swing.*;
import java.awt.*;

public class ThongKeUI extends JFrame {

    public ThongKeUI() {
        super("Library Publication Statistics");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set background color
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        // Initialize components
        ThongKeTextPanel textPanel = new ThongKeTextPanel();
        ThongKeChartPanel chartPanel = new ThongKeChartPanel();

        // Create split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, textPanel, chartPanel);
        splitPane.setDividerLocation(350);
        splitPane.setResizeWeight(0.35);
        splitPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(splitPane, BorderLayout.CENTER);

        pack();
        setSize(1000, 650);
        setLocationRelativeTo(null);
    }
}