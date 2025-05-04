package com.raven.chart;

import com.mycompany.quanlyanphamthuvien.action.ThongKeAnPham;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;

public class ThongKeChartPanel extends JTabbedPane {
    
    public ThongKeChartPanel() {
        ThongKeAnPham thongKe = new ThongKeAnPham();
        setBackground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Remove border around the tabbed pane
        setBorder(BorderFactory.createEmptyBorder());
        
        // Tab 1: Publication types
        addTab("Publication Types", createChartPanel(
            "PUBLICATION TYPES COUNT",
            thongKe.soLuongSach(),
            thongKe.soLuongBao(),
            thongKe.soLuongTapChi()
        ));
        
        // Tab 2: Total quantities
        addTab("Total Quantities", createChartPanel(
            "TOTAL PUBLICATIONS COUNT",
            thongKe.tongSoLuongSach(),
            thongKe.tongSoLuongBao(),
            thongKe.tongSoLuongTapChi()
        ));
    }
    
    private ChartPanel createChartPanel(String title, int sach, int bao, int tapChi) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(sach, "Count", "Books");
        dataset.addValue(bao, "Count", "Newspapers");
        dataset.addValue(tapChi, "Count", "Magazines");
        
        JFreeChart chart = ChartFactory.createBarChart(
            title,
            "Publication Type",
            "Count",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        
        // Customize chart appearance
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 18));
        chart.getTitle().setPaint(new Color(0, 0, 102));
        
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(new Color(200, 200, 200));
        plot.setRangeGridlinePaint(new Color(200, 200, 200));
        
        plot.getDomainAxis().setLabelFont(new Font("Segoe UI", Font.BOLD, 14));
        plot.getDomainAxis().setTickLabelFont(new Font("Segoe UI", Font.BOLD, 12));
        
        plot.getRangeAxis().setLabelFont(new Font("Segoe UI", Font.BOLD, 14));
        plot.getRangeAxis().setTickLabelFont(new Font("Segoe UI", Font.BOLD, 12));
        
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 0, 102));
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.WHITE);
        // Remove the border from chart panel
        chartPanel.setBorder(BorderFactory.createEmptyBorder());
        
        return chartPanel;
    }
}
