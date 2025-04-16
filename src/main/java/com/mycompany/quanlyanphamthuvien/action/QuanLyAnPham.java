
package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.AnPham;
import com.mycompany.quanlyanphamthuvien.entity.AnPhamXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;


public class QuanLyAnPham {
    private ArrayList<AnPham> qlAnPham;

    public ArrayList<AnPham> getQlAnPham() {
        return qlAnPham;
    }

    public void setQlAnPham(ArrayList<AnPham> qlAnPham) {
        this.qlAnPham = qlAnPham;
    }
    public void ghiDanhSachAnPham(ArrayList<AnPham> qlAnPham){
        AnPhamXML anPhamXML = new AnPhamXML();
        anPhamXML.setXmlAnPham(qlAnPham);
        FileUtils.writeXMLtoFile("AnPham.xml", anPhamXML);
    }
    public ArrayList<AnPham> docDanhSachAnPham() {
    ArrayList<AnPham> listAnPham = new ArrayList<>();
    AnPhamXML anPhamXML = (AnPhamXML) FileUtils.readXMLFile("AnPham.xml", AnPhamXML.class);
    
    if (anPhamXML != null) {
        listAnPham = new ArrayList<>(anPhamXML.getXmlAnPham());
    }
    return listAnPham;
}
    
}
