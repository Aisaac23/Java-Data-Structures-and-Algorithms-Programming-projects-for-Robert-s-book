//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

package LinkedLists;

import Links.DoubleLink;

public class Cell extends DoubleLink{
    
    
    long column;
    Object value;
    
    public Cell(long id, long column) {
        super(id);
        this.column = column;
        this.value = "  ";
    }

    @Override
    public void displayLink() {
        System.out.print("[" + this.value + "]@" + "(" + this.getiData() + "," + this.column + ")");
    }
    
    public void displayCell() {
        System.out.print("[" + this.value + "]");
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
