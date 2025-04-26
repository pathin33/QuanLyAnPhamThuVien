package com.mycompany.quanlyanphamthuvien.controller;

import com.mycompany.quanlyanphamthuvien.view.Login;
import com.mycompany.quanlyanphamthuvien.view.QLbao;
import com.mycompany.quanlyanphamthuvien.view.QLsach;
import com.mycompany.quanlyanphamthuvien.view.QLtapchi;
import com.raven.chart.ThongKeUI;
import javax.swing.JFrame;

public class DieuKhienCacQuanLy {


    public void moGiaoDienSach(JFrame currentFrame) {
        QLsach qlSach = new QLsach();
        qlSach.setLocationRelativeTo(null);
        qlSach.setVisible(true);
        currentFrame.dispose();
    }


    public void moGiaoDienBao(JFrame currentFrame) {
        QLbao qlBao = new QLbao();
        qlBao.setLocationRelativeTo(null);
        qlBao.setVisible(true);
        currentFrame.dispose();
    }


    public void moGiaoDienTapChi(JFrame currentFrame) {
        QLtapchi qlTapChi = new QLtapchi();
        qlTapChi.setLocationRelativeTo(null);
        qlTapChi.setVisible(true);
        currentFrame.dispose();
    }


    public void moGiaoDienThongKe(JFrame currentFrame) {
        ThongKeUI thongKeUI = new ThongKeUI();
        thongKeUI.setLocationRelativeTo(null);
        thongKeUI.setVisible(true);
        currentFrame.dispose();
    }


    public void quayVeDangNhap(JFrame currentFrame) {
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        currentFrame.dispose();
    }
}
