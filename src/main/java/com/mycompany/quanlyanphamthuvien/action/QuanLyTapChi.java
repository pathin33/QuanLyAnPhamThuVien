
package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.TapChi;
import com.mycompany.quanlyanphamthuvien.entity.TapChiXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;

public class QuanLyTapChi {
    private ArrayList<TapChi> qlTapChi;

    public ArrayList<TapChi> getQlTapChi() {
        return qlTapChi;
    }

    public void setQlTapChi(ArrayList<TapChi> qlTapChi) {
        this.qlTapChi = qlTapChi;
    }
    public void ghiDanhSachTapChi(ArrayList<TapChi> qlTapChi){
        TapChiXML tapChiXML = new TapChiXML();
        tapChiXML.setXmlTapChi(qlTapChi);
        FileUtils.writeXMLtoFile("TapChi.xml", tapChiXML);
    }
    public ArrayList<TapChi> docDanhSachTapChi(){
        ArrayList<TapChi> listTapChi = new ArrayList<>();
        TapChiXML tapChiXML = (TapChiXML) FileUtils.readXMLFile("TapChi.xml", TapChiXML.class);
        if(tapChiXML != null){
            listTapChi = new ArrayList<>(tapChiXML.getXmlTapChi());
        }
        return listTapChi;
    }
    
}
