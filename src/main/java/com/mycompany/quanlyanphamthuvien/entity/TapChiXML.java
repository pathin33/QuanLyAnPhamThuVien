package com.mycompany.quanlyanphamthuvien.entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TapChiXMl")
@XmlAccessorType(XmlAccessType.FIELD)
public class TapChiXML {
    @XmlElementWrapper(name = "DanhSachTapChi")
    @XmlElement(name = "TapChi")
    private ArrayList<TapChi> xmlTapChi;

    public ArrayList<TapChi> getXmlTapChi() {
        return xmlTapChi;
    }

    public void setXmlTapChi(ArrayList<TapChi> xmlTapChi) {
        this.xmlTapChi = xmlTapChi;
    }
    
}
