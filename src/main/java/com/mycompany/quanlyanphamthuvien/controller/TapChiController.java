package com.mycompany.quanlyanphamthuvien.controller;

import com.mycompany.quanlyanphamthuvien.action.QuanLyTapChi;
import com.mycompany.quanlyanphamthuvien.entity.TapChi;
import com.mycompany.quanlyanphamthuvien.view.QLtapchi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TapChiController {

    private QLtapchi qlTapChiView;
    private QuanLyTapChi qlTapChi;

    public TapChiController(QLtapchi qlTapChiView) {
        this.qlTapChi = new QuanLyTapChi();
        this.qlTapChiView = qlTapChiView;
        qlTapChiView.buttonAddTapChi(new addControllerTapChi());
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
}
