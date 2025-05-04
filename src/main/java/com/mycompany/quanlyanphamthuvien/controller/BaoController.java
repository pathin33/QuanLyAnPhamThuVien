package com.mycompany.quanlyanphamthuvien.controller;

import com.mycompany.quanlyanphamthuvien.action.QuanLyBao;
import com.mycompany.quanlyanphamthuvien.entity.Bao;
import com.mycompany.quanlyanphamthuvien.view.QLbao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BaoController {

    private QLbao qlBaoView;
    private QuanLyBao qlBao;

    public BaoController(QLbao qlBaoView) {
        this.qlBao = QuanLyBao.getInstance();
        this.qlBaoView = qlBaoView;

        qlBaoView.buttonAddBao(new addControllerBao());
        qlBaoView.bangDsBao(new chonHangLayChiSo());
        qlBaoView.xoaDt(new xoaDtBao());
        qlBaoView.suaDt(new suaDtBao());
        qlBaoView.sapXepTheoTen(new sapxepTenBao());
        qlBaoView.sapXepTheoGiaTien(new sapxepGiaTienBao());
        qlBaoView.sapXepTheoNam(new sapxepNamBao());
        qlBaoView.sapXepTheoSoLuong(new sapxepSoLuongBao());
    }

    public void bangBao() {
        ArrayList<Bao> bao = qlBao.docDanhSachBao();
        qlBaoView.setVisible(true);
        qlBaoView.khoiTaoBangBao(bao);
    }

    class addControllerBao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Bao bao = qlBaoView.checkDuLieuHopLe();
            if (bao != null) {
                qlBao.themDtVaoDsBao(bao);
                ArrayList<Bao> dsBao = qlBao.docDanhSachBao();
                qlBaoView.khoiTaoBangBao(dsBao);
                qlBaoView.showMessage("Thêm báo thành công!");
            }
        }
    }

    class chonHangLayChiSo implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                qlBaoView.layChiSo();
            } catch (ParseException ex) {
                Logger.getLogger(BaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class xoaDtBao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = qlBaoView.xoaDt();
            if (id != null) {
                boolean result = qlBao.xoaBao(id);
                if (result) {
                    ArrayList<Bao> dsBao = qlBao.docDanhSachBao();
                    qlBaoView.khoiTaoBangBao(dsBao);
                    qlBaoView.showMessage("Xóa báo thành công!");
                } else {
                    qlBaoView.showMessage("Không tìm thấy báo để xóa!");
                }
            }
        }
    }

    class suaDtBao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Bao bao = qlBaoView.checkDuLieuTruID();
            if (bao != null) {
                qlBao.suaDtDsBao(bao);
                ArrayList<Bao> dsBao = qlBao.docDanhSachBao();
                qlBaoView.khoiTaoBangBao(dsBao);
                qlBaoView.showMessage("Sửa báo thành công!");
            }
        }
    }

    class sapxepTenBao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Bao> danhSachMoi = qlBao.docDanhSachBao();
            qlBao.getQlBao().clear();
            qlBao.getQlBao().addAll(danhSachMoi);
            qlBao.sapXepTenBao();
            qlBaoView.khoiTaoBangBao(qlBao.getQlBao());
        }
    }

    class sapxepGiaTienBao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Bao> danhSachMoi = qlBao.docDanhSachBao();
            qlBao.getQlBao().clear();
            qlBao.getQlBao().addAll(danhSachMoi);
            qlBao.sapxepGiaBao();
            qlBaoView.khoiTaoBangBao(qlBao.getQlBao());
        }
    }

    class sapxepNamBao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Bao> danhSachMoi = qlBao.docDanhSachBao();
            qlBao.getQlBao().clear();
            qlBao.getQlBao().addAll(danhSachMoi);
            qlBao.sapxepNamBao();
            qlBaoView.khoiTaoBangBao(qlBao.getQlBao());
        }
    }

    class sapxepSoLuongBao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Bao> danhSachMoi = qlBao.docDanhSachBao();
            qlBao.getQlBao().clear();
            qlBao.getQlBao().addAll(danhSachMoi);
            qlBao.sapXepSoLuongBao();
            qlBaoView.khoiTaoBangBao(qlBao.getQlBao());
        }
    }

}
