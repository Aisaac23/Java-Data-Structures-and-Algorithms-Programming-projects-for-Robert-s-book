/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedLists;

import Links.DoubleLink;

/**
 *
 * @author Isaac
 */
public class Cell extends DoubleLink{
    
    
    long column;
    Object value;
    
    public Cell(long id, long column) {
        super(id);
        this.column = column;
        this.value = " ";
    }

    @Override
    public void displayLink() {
        System.out.print("[" + this.value + "]@" + "(" + this.getiData() + "," + this.column + ")");
    }

    public long getColumn() {
        return column;
    }

    public void setColumn(long column) {
        this.column = column;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    
    
    
    
}
