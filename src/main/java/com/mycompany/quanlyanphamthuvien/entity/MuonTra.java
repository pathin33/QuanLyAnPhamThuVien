/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlyanphamthuvien.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MuonTra {
    private String idSachBao;
    private String tenSachBao;
    private String mssv;
    private String tenNguoiMuon;
    private Date ngayMuon;
    private Date ngayTra;
    private boolean daTra;

    public MuonTra(String idSachBao, String tenSachBao, String mssv, String tenNguoiMuon, Date ngayMuon) {
        this.idSachBao = idSachBao;
        this.tenSachBao = tenSachBao;
        this.mssv = mssv;
        this.tenNguoiMuon = tenNguoiMuon;
        this.ngayMuon = ngayMuon;
        this.daTra = false;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format(
                "%s,%s,%s,%s,%s,%s,%b",
                idSachBao, 
                tenSachBao, 
                mssv, 
                tenNguoiMuon,
                sdf.format(ngayMuon),
                ngayTra != null ? sdf.format(ngayTra) : "",
                daTra
        );
    }

    public static MuonTra fromString(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length < 7) return null;
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            MuonTra mt = new MuonTra(
                    parts[0], 
                    parts[1], 
                    parts[2], 
                    parts[3], 
                    sdf.parse(parts[4])
            );
            
            if (!parts[5].isEmpty()) {
                mt.setNgayTra(sdf.parse(parts[5]));
            }
            mt.setDaTra(Boolean.parseBoolean(parts[6]));
            return mt;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public void setDaTra(boolean daTra) {
        this.daTra = daTra;
    }

    public String getIdSachBao() {
        return idSachBao;
    }

    public String getTenSachBao() {
        return tenSachBao;
    }

    public String getMssv() {
        return mssv;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public boolean isDaTra() {
        return daTra;
    }

    public String getTenNguoiMuon() {
        return tenNguoiMuon;
    }
    public Date getNgayTra() {
        return ngayTra;
    }
    
}