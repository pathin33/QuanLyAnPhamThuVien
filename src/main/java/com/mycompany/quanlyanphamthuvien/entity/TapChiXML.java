package com.mycompany.quanlyanphamthuvien.entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TapChiXMl")
@XmlAccessorType(XmlAccessType.FIELD)
public class TapChiXML {
    private ArrayList<TapChi> xmlTapChi;

    public ArrayList<TapChi> getXmlTapChi() {
        return xmlTapChi;
    }

    public void setXmlTapChi(ArrayList<TapChi> xmlTapChi) {
        this.xmlTapChi = xmlTapChi;
    }
    
}
