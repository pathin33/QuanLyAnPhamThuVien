package com.mycompany.quanlyanphamthuvien.controller;

import com.mycompany.quanlyanphamthuvien.action.QuanLyBao;
import com.mycompany.quanlyanphamthuvien.action.QuanLySach;
import com.mycompany.quanlyanphamthuvien.action.QuanLyTapChi;
import com.mycompany.quanlyanphamthuvien.entity.Bao;
import com.mycompany.quanlyanphamthuvien.entity.Sach;
import com.mycompany.quanlyanphamthuvien.entity.TapChi;
import com.mycompany.quanlyanphamthuvien.view.NguoiDungView;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import com.mycompany.quanlyanphamthuvien.action.QuanLyMuonTra;
import com.mycompany.quanlyanphamthuvien.entity.MuonTra;

public class NguoiDungController {

    private QuanLyMuonTra qlMuonTra = new QuanLyMuonTra();
    private NguoiDungView userview;
    private QuanLySach qlSach;
    private QuanLyBao qlBao;
    private QuanLyTapChi qltapchi;

    public NguoiDungController(NguoiDungView view) {
        this.userview = view;
        this.qlSach = QuanLySach.getInstance();
        this.qlBao = QuanLyBao.getInstance();
        this.qltapchi = QuanLyTapChi.getInstance();
    }

    public void bangSachUser() {
        ArrayList<Sach> sachList = qlSach.docDanhSachSach();
        DefaultTableModel model = userview.getTableModel();
        model.setRowCount(0);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat formatter = new DecimalFormat("#,###", symbols);

        for (Sach s : sachList) {
            Object[] row = new Object[]{
                s.getID(),
                s.getTenAnPham(),
                s.getNhaXuatBan(),
                s.getNamXuatBan(),
                formatter.format(s.getGiaTien()),
                s.getSoLuong(),
                s.tinhTrang()
            };
            model.addRow(row);
        }
    }

    public void bangBaoUser() {
        ArrayList<Bao> baoList = qlBao.docDanhSachBao();
        DefaultTableModel model = userview.getTableModel();
        model.setRowCount(0);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat formatter = new DecimalFormat("#,###", symbols);

        for (Bao s : baoList) {
            Object[] row = new Object[]{
                s.getID(),
                s.getTenAnPham(),
                s.getNhaXuatBan(),
                s.getNamXuatBan(),
                formatter.format(s.getGiaTien()),
                s.getSoLuong(),
                s.tinhTrang()
            };
            model.addRow(row);
        }
    }

    public void bangtapchiUser() {
        ArrayList<TapChi> tapchiList = qltapchi.docDanhSachTapChi();
        DefaultTableModel model = userview.getTableModel();
        model.setRowCount(0);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat formatter = new DecimalFormat("#,###", symbols);

        for (TapChi s : tapchiList) {
            Object[] row = new Object[]{
                s.getID(),
                s.getTenAnPham(),
                s.getNhaXuatBan(),
                s.getNamXuatBan(),
                formatter.format(s.getGiaTien()),
                s.getSoLuong(),
                s.tinhTrang()
            };
            model.addRow(row);
        }
    }

    public void luuThongTinMuon(String id, String title, String mssv, String userName, Date borrowDate) {
        try {
            FileWriter writer = new FileWriter("Muon.xml", true);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String record = String.format(
                    "ID: %s | Tên: %s | MSSV: %s | Người mượn: %s | Ngày mượn: %s\n",
                    id, title, mssv, userName, dateFormat.format(borrowDate)
            );
            writer.write(record);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void capNhatSoLuong(String id, int soLuongMoi) {
        if (userview.getRadioSach().isSelected()) {
            capNhatSoLuongSach(id, soLuongMoi);
        } else if (userview.getRadioBao().isSelected()) {
            capNhatSoLuongBao(id, soLuongMoi);
        } else if (userview.getRadioTapChi().isSelected()) {
            capNhatSoLuongTapChi(id, soLuongMoi);
        }
    }

    private void capNhatSoLuongSach(String id, int soLuongMoi) {
        ArrayList<Sach> danhSachSach = qlSach.docDanhSachSach();
        for (Sach sach : danhSachSach) {
            if (sach.getID().equals(id)) {
                sach.setSoLuong(soLuongMoi);
                qlSach.ghiDanhSachSach(danhSachSach);
                qlSach.suaDtDsSach(sach);
                break;
            }
        }
    }

    private void capNhatSoLuongBao(String id, int soLuongMoi) {
        ArrayList<Bao> danhSachBao = qlBao.docDanhSachBao();
        for (Bao bao : danhSachBao) {
            if (bao.getID().equals(id)) {
                bao.setSoLuong(soLuongMoi);
                qlBao.ghiDanhSachBao(danhSachBao);
                qlBao.suaDtDsBao(bao);
                break;
            }
        }
    }

    private void capNhatSoLuongTapChi(String id, int soLuongMoi) {
        ArrayList<TapChi> danhSachTapChi = qltapchi.docDanhSachTapChi();
        for (TapChi tapChi : danhSachTapChi) {
            if (tapChi.getID().equals(id)) {
                tapChi.setSoLuong(soLuongMoi);
                qltapchi.ghiDanhSachTapChi(danhSachTapChi);
                qltapchi.suaDtDsTapChi(tapChi);
                break;
            }
        }
    }

    public void xuLyMuon(String idSachBao, String tenSachBao, String mssv, String tenNguoiMuon, Date ngayMuon) {
        MuonTra muonTra = new MuonTra(idSachBao, tenSachBao, mssv, tenNguoiMuon, ngayMuon);
        qlMuonTra.themMuonTra(muonTra);
    }
    public void xuLyTra(String idSachBao, String mssv) {
        for (MuonTra mt : qlMuonTra.getDanhSachMuonTra()) {
            if (mt.getIdSachBao().equals(idSachBao)
                    && mt.getMssv().equals(mssv)
                    && !mt.isDaTra()) {
                mt.setNgayTra(new Date());
                mt.setDaTra(true);
                qlMuonTra.luuDanhSachMuonTra();
                capNhatSoLuong(idSachBao, (int) userview.getJTable1().getValueAt(
                        userview.getJTable1().getSelectedRow(), 5) + 1);
                JOptionPane.showMessageDialog(userview, "Trả thành công!");
                break;
            }
        }
    }
}
