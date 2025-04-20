
package com.mycompany.quanlyanphamthuvien.entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NguoiDungXML")
@XmlAccessorType(XmlAccessType.FIELD)
public class NguoiDungXML {
    @XmlElementWrapper(name = "DanhSachNguoiDung")
    @XmlElement(name = "NguoiDung")
    private ArrayList<NguoiDung> xmlNguoiDung;


    public NguoiDungXML() {
        xmlNguoiDung = new ArrayList<>();
    }

    public ArrayList<NguoiDung> getXmlNguoiDung() {
        return xmlNguoiDung;
    }

    public void setXmlNguoiDung(ArrayList<NguoiDung> xmlNguoiDung) {
        this.xmlNguoiDung = xmlNguoiDung;
    }
    
            
}
