/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.approject.Operations;

import com.mycompany.approject.Brand;
import com.mycompany.approject.Hardware;
import com.mycompany.approject.PC;
import java.util.ArrayList;


/**
 *
 * @author hduc2
 */
public class Operations<T> implements IOperations<T> {
    private ArrayList<T> elements;

    public Operations(ArrayList<T> elements) {
        this.elements = elements;
    }

    @Override
    public ArrayList<T> getAll(ArrayList<T> elements){
        return elements;
    }
    @Override
    public void add(T element) {
        elements.add(element);
    }

    @Override
    public void delete(T element) {
        elements.remove(element);
    }

    @Override
    public void update(T element) {
        int index = elements.indexOf(element);
        if (index != -1) {
            elements.set(index, element);
        }
    }

    @Override
    public T findByCodeOrName(String codeOrName) {
        for (T item : elements) {
            if (item instanceof Brand) {
                Brand brandItem = (Brand) item;
                if (brandItem.getCode().equals(codeOrName) || brandItem.getName().equals(codeOrName)) {
                    return item;
                }
            } else if (item instanceof Hardware) {
                Hardware hardwareItem = (Hardware) item;
                if (hardwareItem.getCode().equals(codeOrName) || hardwareItem.getName().equals(codeOrName)) {
                    return item;
                }
            } else if (item instanceof PC) {
                PC pcItem = (PC) item;
                if (pcItem.getCode().equals(codeOrName) || pcItem.getName().equals(codeOrName)) {
                    return item;
                }
            }
        }
        return null;
    }
}
