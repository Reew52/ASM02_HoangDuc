/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.approject;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author hduc2
 */
public class PC extends Hardware {
    private List<String> hardwareList = new ArrayList<>();
    private String brandName;
    private String price;
    private String code;
    private String name;
     public List<String> getHardwareList() {
        return hardwareList;
    }

    public void setHardwareList(String hardwareName) {
        hardwareList.add(hardwareName);
    }

    public String getBrand() {
        return brandName;
    }

    public void setBrand(String brand) {
        this.brandName = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
     public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
