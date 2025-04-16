
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
    
}
