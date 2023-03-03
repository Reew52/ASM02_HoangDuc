/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.approject.Operations;

import java.util.ArrayList;

/**
 *
 * @author hduc2
 */
public interface IOperations<T> {
    ArrayList<T> getAll(ArrayList<T> elements);
    void add(T element);
    void delete(T element);
    void update(T element);
    T findByCodeOrName(String codeOrName);
}
