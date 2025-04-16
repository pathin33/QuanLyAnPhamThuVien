package com.mycompany.quanlyanphamthuvien.entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BaoXML")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaoXML {

    private ArrayList<Bao> xmlBao;

    public ArrayList<Bao> getXmlBao() {
        return xmlBao;
    }

    public void setXmlBao(ArrayList<Bao> xmlBao) {
        this.xmlBao = xmlBao;
    }

}
