
package com.mycompany.quanlyanphamthuvien.entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SachXML")
@XmlAccessorType(XmlAccessType.FIELD)
public class SachXML {
    @XmlElementWrapper(name = "DanhSachSach")
    @XmlElement(name = "Sach")
    private ArrayList<Sach> xmlSach;

    public ArrayList<Sach> getXmlSach() {
        return xmlSach;
    }

    public void setXmlSach(ArrayList<Sach> xmlSach) {
        this.xmlSach = xmlSach;
    }
    
}
