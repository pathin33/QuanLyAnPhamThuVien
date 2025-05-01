package com.mycompany.quanlyanphamthuvien.controller;

import com.mycompany.quanlyanphamthuvien.action.QuanLyTapChi;
import com.mycompany.quanlyanphamthuvien.entity.TapChi;
import com.mycompany.quanlyanphamthuvien.view.QLtapchi;
import com.mycompany.quanlyanphamthuvien.view.timkiemsach;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TapChiController {

    private QLtapchi qlTapChiView;
    private QuanLyTapChi qlTapChi;
    private timkiemsach tkTapcChi;

    public TapChiController(QLtapchi qlTapChiView) {
        this.qlTapChi = new QuanLyTapChi();
        this.qlTapChiView = qlTapChiView;
        this.tkTapcChi = new timkiemsach();
        tkTapcChi.buttonTimKiem(new timKiemTapChi());
        qlTapChiView.buttonAddTapChi(new addControllerTapChi());
        qlTapChiView.bangDsTapChi(new chonHangLayChiSo());
        qlTapChiView.xoaDt(new xoaDtTapChi());
        qlTapChiView.suaDt(new suaDtTapChi());
        qlTapChiView.sapXepTheoTen(new sapxepTenTapChi());
        qlTapChiView.sapXepTheoSoLuong(new sapxepSoLuongTapChi());
        qlTapChiView.sapXepTheoGiaTien(new sapxepGiaTienTapChi());
        qlTapChiView.sapXepTheoNam(new sapxepNamTapChi());
    }

    public void bangTapChi() {
        ArrayList<TapChi> tapChi = new ArrayList<>();
        tapChi = qlTapChi.docDanhSachTapChi();
        qlTapChiView.setVisible(true);
        qlTapChiView.khoiTaoBangTapChi(tapChi);
    }

    class addControllerTapChi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TapChi tapChi = qlTapChiView.checkDuLieuHopLe();
            if (tapChi != null) {
                qlTapChi.themDtVaoDsTapChi(tapChi);
                ArrayList<TapChi> dsTapChi = qlTapChi.docDanhSachTapChi();

                qlTapChiView.khoiTaoBangTapChi(dsTapChi);

                qlTapChiView.showMessage("Thêm tạp chí thành công!");
            }
        }
    }

    class chonHangLayChiSo implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                qlTapChiView.layChiSo();
            } catch (ParseException ex) {
                Logger.getLogger(TapChiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class xoaDtTapChi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            qlTapChiView.xoaDt();
        }

    }

    class suaDtTapChi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TapChi tapChi = qlTapChiView.checkDuLieuTruID();
            if (tapChi != null) {
                qlTapChi.suaDtDsTapChi(tapChi);
                ArrayList<TapChi> dsTapChi = qlTapChi.docDanhSachTapChi();

                qlTapChiView.khoiTaoBangTapChi(dsTapChi);

                qlTapChiView.showMessage("Sửa tạp chí thành công!");

            }
        }

    }

    class sapxepTenTapChi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList<TapChi> danhSachMoi = qlTapChi.docDanhSachTapChi();


            qlTapChi.getQlTapChi().clear();
            qlTapChi.getQlTapChi().addAll(danhSachMoi);

            // Sắp xếp
            qlTapChi.sapXepTenTapChi();

            qlTapChiView.khoiTaoBangTapChi(qlTapChi.getQlTapChi());
        }
    }

    class sapxepSoLuongTapChi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<TapChi> danhSachMoi = qlTapChi.docDanhSachTapChi();

 
            qlTapChi.getQlTapChi().clear();
            qlTapChi.getQlTapChi().addAll(danhSachMoi);

            qlTapChi.sapXepSoLuongTapChi();


            qlTapChiView.khoiTaoBangTapChi(qlTapChi.getQlTapChi());
        }
    }

    class sapxepGiaTienTapChi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<TapChi> danhSachMoi = qlTapChi.docDanhSachTapChi();


            qlTapChi.getQlTapChi().clear();
            qlTapChi.getQlTapChi().addAll(danhSachMoi);


            qlTapChi.sapxepGiatapchi();

            qlTapChiView.khoiTaoBangTapChi(qlTapChi.getQlTapChi());
        }
    }

    class sapxepNamTapChi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList<TapChi> danhSachMoi = qlTapChi.docDanhSachTapChi();

            qlTapChi.getQlTapChi().clear();
            qlTapChi.getQlTapChi().addAll(danhSachMoi);

            qlTapChi.sapxepNamtapchi();

            qlTapChiView.khoiTaoBangTapChi(qlTapChi.getQlTapChi());
        }
    }

    class timKiemTapChi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }

    }

}
