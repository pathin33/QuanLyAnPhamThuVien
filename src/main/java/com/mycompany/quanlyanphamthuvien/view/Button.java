package com.mycompany.quanlyanphamthuvien.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.*;  // Thêm để sử dụng BeanInfo
import javax.swing.JButton;

public class Button extends JButton {
    
    private boolean shadow = false; // Hiệu ứng đổ bóng có bật hay không
    private int shadowOffsetX = 3; // Độ lệch bóng theo chiều ngang
    private int shadowOffsetY = 3; // Độ lệch bóng theo chiều dọc
    private int shadowOpacity = 50; // Độ trong suốt của bóng (0-255)
    
    public Button(){
        setFont(new Font("Segoe UI", Font.BOLD, 16));
        setColor(Color.WHITE);
        colorOver = new Color(179, 250, 160);
        colorClick = new Color(152, 104, 144);
        borderColor = new Color(30, 136, 56);
        setContentAreaFilled(false);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                over = true;
                setBackground(colorOver);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                over = false;
                setBackground(color);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (over) {
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }
        });
    }
    
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;

    public boolean isShadow() {
        return shadow; // Getter cho shadow
    }

    public void setShadow(boolean shadow) {
        this.shadow = shadow;
        repaint(); // Khi thay đổi shadow, gọi repaint để cập nhật giao diện
    }

    public int getShadowOffsetX() {
        return shadowOffsetX; // Getter cho độ lệch theo chiều ngang
    }

    public void setShadowOffsetX(int shadowOffsetX) {
        this.shadowOffsetX = shadowOffsetX;
        repaint();
    }

    public int getShadowOffsetY() {
        return shadowOffsetY; // Getter cho độ lệch theo chiều dọc
    }

    public void setShadowOffsetY(int shadowOffsetY) {
        this.shadowOffsetY = shadowOffsetY;
        repaint();
    }

    public int getShadowOpacity() {
        return shadowOpacity; // Getter cho độ trong suốt của bóng
    }

    public void setShadowOpacity(int shadowOpacity) {
        this.shadowOpacity = shadowOpacity;
        repaint();
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // === VẼ BÓNG nếu shadow = true ===
        if (shadow) {
            Color shadowColor = new Color(0, 0, 0, shadowOpacity); // Sử dụng opacity cho độ trong suốt
            g2.setColor(shadowColor);
            g2.fillRoundRect(shadowOffsetX, shadowOffsetY, getWidth() - shadowOffsetX, getHeight() - shadowOffsetY, radius, radius);
        }

        // === VẼ VIỀN ===
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // === VẼ PHẦN BÊN TRONG ===
        g2.setColor(getBackground());
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);

        g2.dispose();
        super.paintComponent(g);
    }
}
