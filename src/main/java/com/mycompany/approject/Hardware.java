/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.approject;


/**
 *
 * @author hduc2
 */
public class Hardware extends ClassBase {

    private String code;
    private String name;
    private String brandName;
    private String type;
    private String capacity;
    private String price;
    public Hardware() {
        super(ClassBase.create().getId());
        
    }
    
    public String getBrand() {
        return brandName;
    }
     
    public void setBrand(String brand) {
        this.brandName = brand;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
