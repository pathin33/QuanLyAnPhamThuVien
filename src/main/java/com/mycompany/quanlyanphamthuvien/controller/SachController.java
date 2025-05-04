package com.mycompany.quanlyanphamthuvien.controller;

import com.mycompany.quanlyanphamthuvien.action.QuanLySach;
import com.mycompany.quanlyanphamthuvien.entity.Sach;
import com.mycompany.quanlyanphamthuvien.view.QLsach;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SachController {

    private QLsach qlSachView;
    private QuanLySach qlSach;

    public SachController(QLsach qlSachView) {
        this.qlSach = QuanLySach.getInstance();
        this.qlSachView = qlSachView;

        qlSachView.buttonAddSach(new AddControllerSach());
        qlSachView.bangDsSach(new ChonHangLayChiSo());
        qlSachView.xoaDt(new XoaDtSach());
        qlSachView.suaDt(new SuaDtSach());
        qlSachView.sapXepTheoTen(new SapXepTenSach());
        qlSachView.sapXepTheoSoLuong(new SapXepSoLuongSach());
        qlSachView.sapXepTheoGiaTien(new SapXepGiaTienSach());
        qlSachView.sapXepTheoNam(new SapXepNamSach());
        qlSachView.cancelSearch(new CancelSearch());
    }

    public void bangSach() {
        ArrayList<Sach> sach = qlSach.docDanhSachSach();
        qlSachView.setVisible(true);
        qlSachView.khoiTaoBangSach(sach);
    }

    class AddControllerSach implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Sach sach = qlSachView.checkDuLieuHopLe();
            if (sach != null) {
                if (qlSach.kiemTraTrungID(sach)) {
                    qlSach.themDtVaoDsSach(sach);
                    ArrayList<Sach> dsSach = qlSach.docDanhSachSach();
                    qlSachView.khoiTaoBangSach(dsSach);
                    qlSachView.showMessage("Book added successfully!");
                } else {
                    qlSachView.showMessage("Book ID already exists!");
                }
            }
        }
    }

    class ChonHangLayChiSo implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                qlSachView.layChiSo();
            } catch (ParseException ex) {
                Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class XoaDtSach implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            qlSachView.xoaDt();
        }
    }

    class SuaDtSach implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Sach sach = qlSachView.checkDuLieuTruID();
            if (sach != null) {
                qlSach.suaDtDsSach(sach);
                ArrayList<Sach> dsSach = qlSach.docDanhSachSach();
                qlSachView.khoiTaoBangSach(dsSach);
                qlSachView.showMessage("Book updated successfully!");
            }
        }
    }

    class SapXepTenSach implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Sach> danhSachMoi = qlSach.docDanhSachSach();
            qlSach.getQlSach().clear();
            qlSach.getQlSach().addAll(danhSachMoi);
            qlSach.sapXepTenSach();
            qlSachView.khoiTaoBangSach(qlSach.getQlSach());
        }
    }

    class SapXepSoLuongSach implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Sach> danhSachMoi = qlSach.docDanhSachSach();
            qlSach.getQlSach().clear();
            qlSach.getQlSach().addAll(danhSachMoi);
            qlSach.sapXepSoLuongSach();
            qlSachView.khoiTaoBangSach(qlSach.getQlSach());
        }
    }

    class SapXepGiaTienSach implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Sach> danhSachMoi = qlSach.docDanhSachSach();
            qlSach.getQlSach().clear();
            qlSach.getQlSach().addAll(danhSachMoi);
            qlSach.sapxepGiasach();
            qlSachView.khoiTaoBangSach(qlSach.getQlSach());
        }
    }

    class SapXepNamSach implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Sach> danhSachMoi = qlSach.docDanhSachSach();
            qlSach.getQlSach().clear();
            qlSach.getQlSach().addAll(danhSachMoi);
            qlSach.sapxepNamsach();
            qlSachView.khoiTaoBangSach(qlSach.getQlSach());
        }
    }

    class CancelSearch implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Sach> dsSach = qlSach.docDanhSachSach();
            qlSachView.khoiTaoBangSach(dsSach);
        }
    }

}
