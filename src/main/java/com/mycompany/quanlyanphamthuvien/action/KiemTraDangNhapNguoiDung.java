package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.NguoiDung;
import com.mycompany.quanlyanphamthuvien.entity.NguoiDungXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;

public class KiemTraDangNhapNguoiDung {

    private ArrayList<NguoiDung> dsNguoiDung;

    public void ghiDSNguoiDung(ArrayList<NguoiDung> dsNguoiDung) {
        NguoiDungXML nguoiDungXML = new NguoiDungXML();
        nguoiDungXML.setXmlNguoiDung(dsNguoiDung);
        FileUtils.writeXMLtoFile("NguoiDung.xml", nguoiDungXML);
    }

    public ArrayList<NguoiDung> docDsNguoiDung() {
        ArrayList<NguoiDung> listNguoiDung = new ArrayList<>();
        NguoiDungXML nguoiDungXML = (NguoiDungXML) FileUtils.readXMLFile("NguoiDung.xml", NguoiDungXML.class);
        if (nguoiDungXML != null) {
            listNguoiDung = new ArrayList<>(nguoiDungXML.getXmlNguoiDung());
        }
        return listNguoiDung;
    }
}
