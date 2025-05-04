package com.raven.chart;

import javax.swing.*;
import java.awt.*;

public class ThongKeUI extends JFrame {

    public ThongKeUI() {
        super("Library Publication Statistics");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());


        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        
    
        ThongKeTextPanel textPanel = new ThongKeTextPanel();
        ThongKeChartPanel chartPanel = new ThongKeChartPanel();


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, textPanel, chartPanel);
        splitPane.setDividerLocation(350);
        splitPane.setResizeWeight(0.35);
        splitPane.setBorder(BorderFactory.createEmptyBorder()); 
        splitPane.setDividerSize(5); 

        add(splitPane, BorderLayout.CENTER);

        pack();
        setSize(1000, 650);
        setLocationRelativeTo(null);
    }
}
