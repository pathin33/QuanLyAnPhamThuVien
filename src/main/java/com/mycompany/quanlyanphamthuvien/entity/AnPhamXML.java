
package com.mycompany.quanlyanphamthuvien.entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AnPhamXML")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnPhamXML {
    @XmlElementWrapper(name = "DanhSachAnPham")
    @XmlElement(name = "AnPham")
    private ArrayList<AnPham> xmlAnPham;

    public ArrayList<AnPham> getXmlAnPham() {
        return xmlAnPham;
    }

    public void setXmlAnPham(ArrayList<AnPham> xmlAnPham) {
        this.xmlAnPham = xmlAnPham;
    }
    
}
