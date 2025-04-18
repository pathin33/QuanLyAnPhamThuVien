
package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.Bao;
import com.mycompany.quanlyanphamthuvien.entity.BaoXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;


public class QuanLyBao {
    private ArrayList<Bao> qlBao;

    public ArrayList<Bao> getQlBao() {
        return qlBao;
    }

    public void setQlBao(ArrayList<Bao> qlBao) {
        this.qlBao = qlBao;
    }
    public void ghiDanhSachBao(ArrayList<Bao> qlBao){
        BaoXML baoXML = new BaoXML();
        baoXML.setXmlBao(qlBao);
        FileUtils.writeXMLtoFile("Bao.xml", baoXML);
    }
    public ArrayList<Bao> docDanhSachBao(){
        ArrayList<Bao> listBao = new ArrayList<>();
        BaoXML baoXML = (BaoXML) FileUtils.readXMLFile("Bao.xml", BaoXML.class);
        if(baoXML!=null){
            listBao = new ArrayList<>(baoXML.getXmlBao());
        }
        return listBao;
    }
    public void themDtVaoDsBao(Bao baoMoi){
        qlBao.add(baoMoi);
        ghiDanhSachBao(qlBao);
    }
    public boolean xoaDtVaoDsBao(Bao baoXoa){
        if(baoXoa==null){
            return false;
        }
         for(int i = 0 ;i<qlBao.size();i++){
            if(qlBao.get(i).getID()==baoXoa.getID()){
                qlBao.remove(i);
                ghiDanhSachBao(qlBao);
                return true;
            }
        }
        return false;
    }
    public void suaDtDsBao(Bao baoSua)
    {
        for(int i = 0 ;i<qlBao.size();i++){
            if(qlBao.get(i).getID()==baoSua.getID()){
                qlBao.get(i).setTenAnPham(baoSua.getTenAnPham());
                qlBao.get(i).setSoLuong(baoSua.getSoLuong());
                qlBao.get(i).setNamXuatBan(baoSua.getNamXuatBan());
                qlBao.get(i).setNhaXuatBan(baoSua.getNhaXuatBan());
                qlBao.get(i).setGiaTien(baoSua.getGiaTien());
                qlBao.get(i).setNgayPhatHanh(baoSua.getNgayPhatHanh());
                qlBao.get(i).setBienTapVien(baoSua.getBienTapVien());
                ghiDanhSachBao(qlBao);
                break;
                
            }
        }
    }
    public void sapxepNambao(){
        Collections.sort(qlBao, (Bao o1, Bao o2) -> Integer.compareUnsigned(o1.getNamXuatBan(), o2.getNamXuatBan()));
    }
    public void sapxepGiabao(){
        Collections.sort(qlBao, (Bao o1,Bao o2)-> Double.compare(o1.getGiaTien(), o2.getGiaTien()));
    }
}
