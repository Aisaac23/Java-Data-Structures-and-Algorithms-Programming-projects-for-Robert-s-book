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
public class CustomDoubleLink extends DoubleLink{
    
    double dData;
    
    public CustomDoubleLink(long id, double dData) {
        super(id);
        this.dData = dData;
    }

    public double getdData() {
        return dData;
    }

    public void setdData(double dData) {
        this.dData = dData;
    }
    
    
    
    @Override
    public void displayLink() {
        System.out.print("{" + this.getiData() + ":" + this.dData + "}");
    }
}
