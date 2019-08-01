//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

package LinkedLists;

import Links.DoubleLink;


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
