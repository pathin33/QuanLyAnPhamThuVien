/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlyanphamthuvien.controller;

import com.mycompany.quanlyanphamthuvien.entity.Sach;
import com.mycompany.quanlyanphamthuvien.view.Login;
import com.mycompany.quanlyanphamthuvien.view.QLsach;
import com.mycompany.quanlyanphamthuvien.view.QuanLyMain;
import com.mycompany.quanlyanphamthuvien.view.SignUpUser;
import com.mycompany.quanlyanphamthuvien.view.User;
import com.mycompany.quanlyanphamthuvien.view.timkiemsach;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.mycompany.quanlyanphamthuvien.action.QuanLySach;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Admin
 */
public class SachController {
    private ArrayList<Sach> book;
    private QLsach qlsachview;
    private QuanLySach quanlySach;

    public SachController(QLsach qlsachview) {
        this.quanlySach = new QuanLySach();
        this.qlsachview = qlsachview;
        addEventListeners();
    }

    private void addEventListeners() {
        qlsachview.addUndoListener(new UndoListener());
        qlsachview.addAddListener(new AddBookListener());      
        qlsachview.addEditListener(new suaDtSach());
        qlsachview.addDeleteListener(new xoaDtSach());
        qlsachview.addListSelectionListener(new chonHangLayChiSo());
        qlsachview.addSortTitleListener(new sapxepTenSach());
        qlsachview.addSortQuantityListener(new sapxepSoLuongSach());
        qlsachview.addSortPriceListener(new sapxepGiatien());
        qlsachview.addSortYearListener(new sapxepNam());
        
    }
    public void bangSach() {
        ArrayList<Sach> sach = new ArrayList<>();
        sach = quanlySach.docDanhSachSach();
        qlsachview.setVisible(true);
        qlsachview.khoiTaoBangSach(sach);
    }
    class UndoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            qlsachview.dispose();
            new DieuKhienCacQuanLy().showMainView();
        }
    }
    class AddBookListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
            Sach newsach = qlsachview.getSachInfo();
            if (newsach != null) {
                quanlySach.themDtVaoDsSach(newsach);
                ArrayList<Sach> dssach = new ArrayList<>();
                dssach = quanlySach.docDanhSachSach();
                qlsachview.khoiTaoBangSach(dssach); 
                qlsachview.showMessage("Thêm sách thành công!");
            } else {
                qlsachview.showMessage("Vui lòng nhập đầy đủ thông tin sách!");
            }
        }
    }
    class chonHangLayChiSo implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            try {
                qlsachview.laychiso();
            } catch (ParseException ex) {
                Logger.getLogger(SachController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class xoaDtSach implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            qlsachview.xoaDt();
        }

    }

    class suaDtSach implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Sach sach = qlsachview.getSachInfo2();
            if (sach != null) {
                quanlySach.suaDtDsSach(sach);
                ArrayList<Sach> dsSach = quanlySach.docDanhSachSach();

                qlsachview.khoiTaoBangSach(dsSach);

                qlsachview.showMessage("Sửa Sách thành công!");

            }
        }

    }

    class sapxepTenSach implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList<Sach> danhSachMoi = quanlySach.docDanhSachSach();
            quanlySach.getListSach().clear();
            quanlySach.getListSach().addAll(danhSachMoi);
            quanlySach.sapXepTenSach();
            qlsachview.khoiTaoBangSach(quanlySach.getListSach());
        }
    }

    class sapxepSoLuongSach implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Sach> danhSachMoi = quanlySach.docDanhSachSach();
            quanlySach.getListSach().clear();
            quanlySach.getListSach().addAll(danhSachMoi);
            quanlySach.sapxepSoLuong();
            qlsachview.khoiTaoBangSach(quanlySach.getListSach());
        }
    }

    class sapxepGiatien implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Sach> danhSachMoi = quanlySach.docDanhSachSach();
            quanlySach.getListSach().clear();
            quanlySach.getListSach().addAll(danhSachMoi);
            quanlySach.sapxepGiasach();
            qlsachview.khoiTaoBangSach(quanlySach.getListSach());
        }
    }

    class sapxepNam implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Sach> danhSachMoi = quanlySach.docDanhSachSach();


            quanlySach.getListSach().clear();
            quanlySach.getListSach().addAll(danhSachMoi);
            quanlySach.sapxepNamsach();
            qlsachview.khoiTaoBangSach(quanlySach.getListSach());
        }
    }

    class timKiem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }

}