/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlyanphamthuvien.action;

/**
 *
 * @author Admin
 */
import com.mycompany.quanlyanphamthuvien.entity.MuonTra;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class QuanLyMuonTra {

    private static final String FILE_PATH = "danhsachmuontra.txt";
    private List<MuonTra> danhSachMuonTra;

    public QuanLyMuonTra() {
        danhSachMuonTra = new ArrayList<>();
        docDanhSachMuonTra();
    }

    public void themMuonTra(MuonTra muonTra) {
        danhSachMuonTra.add(muonTra);
        luuDanhSachMuonTra();
    }

    public List<MuonTra> getDanhSachMuonTra() {
        return danhSachMuonTra;
    }

    public void luuDanhSachMuonTra() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        for (MuonTra mt : danhSachMuonTra) {
            String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                mt.getIdSachBao(),
                mt.getTenSachBao(),
                mt.getMssv(),
                mt.getTenNguoiMuon(),
                dateFormat.format(mt.getNgayMuon()),
                mt.getNgayTra() != null ? dateFormat.format(mt.getNgayTra()) : "", 
                mt.isDaTra() ? "true" : "false" // Sửa thứ tự
            );
            writer.write(line + "\n");
        }
    } catch (IOException e) {
        System.err.println("Lỗi khi lưu file: " + e.getMessage());
    }
    }    
    public void docDanhSachMuonTra() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                MuonTra muonTra = MuonTra.fromString(line);
                if (muonTra != null) {
                    danhSachMuonTra.add(muonTra);
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
