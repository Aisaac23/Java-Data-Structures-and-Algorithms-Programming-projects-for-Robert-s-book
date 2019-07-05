/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlist;

import Links.Link;

/**
 *
 * @author isaac.huerta
 */
public class CustomLink extends Link{
    
        double dData;
        
    public CustomLink(long id, double dd) {
        super(id);
        this.dData = dd;
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
