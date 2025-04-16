
package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.Sach;
import com.mycompany.quanlyanphamthuvien.entity.SachXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;

public class QuanLySach {
    private ArrayList<Sach> qlSach;

    public ArrayList<Sach> getQlSach() {
        return qlSach;
    }

    public void setQlSach(ArrayList<Sach> qlSach) {
        this.qlSach = qlSach;
    }
    public void ghiDanhSachSach(ArrayList<Sach> qlSach){
        SachXML sachXML = new SachXML();
        sachXML.setXmlSach(qlSach);
        FileUtils.writeXMLtoFile("Sach.xml", qlSach);
    }
    public ArrayList<Sach> docDanhSachSach(){
        ArrayList<Sach> listSach = new ArrayList<>();
        SachXML sachXML = (SachXML) FileUtils.readXMLFile("Sach.xml", SachXML.class);
        if(sachXML!=null){
            listSach = new ArrayList<>(sachXML.getXmlSach());
        }
        return listSach;
    }    
}
