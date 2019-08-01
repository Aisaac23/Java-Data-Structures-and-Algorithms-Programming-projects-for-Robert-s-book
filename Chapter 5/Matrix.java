//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

package LinkedLists;

import Links.DoubleLink;

public class Matrix extends DoublyLinkedList{
    
    private Cell current;
    private long rows;
    private long columns;

    public Matrix(long rows, long columns) {
        this.rows = rows;
        this.columns = columns;
        
        for (int i = 0; i < rows; i++)
            this.insertLast(new Row (i+1, columns) );
    }

    public long getRows() {
        return rows;
    }

    public long getColumns() {
        return columns;
    }
    
    public void displayMatrix()
    {
        
        Row current = (Row)this.getFirst();
        while(current != null)
        {
            System.out.print("|" + current.getiData() + "| ");
            current.displayRow();
            current = (Row)current.getNext();
            System.out.println("");
        }
        
    }
    
    public void displayAsSpreadsheet()
    {
        
        Row current = (Row)this.getFirst();
        System.out.print("|v| ");
        for (int i = 0; i < this.columns; i++) 
            System.out.print("| " + Character.toString( (char) (i + 65) ) +"|");
        System.out.println("");
        while(current != null)
        {
            System.out.print("|" + current.getiData() + "| ");
            current.displayCells();
            current = (Row)current.getNext();
            System.out.println("");
        }
        
    }
    
    
    public Cell navigate(long row, long col)
    {
        if( !this.isEmpty() )
        {
            Row rowlst = (Row) this.getFirst();
            for (int i = 1; i < row; i++)
                rowlst = (Row)rowlst.getNext();
            
            Cell temp = (Cell)rowlst.getRowLst().getFirst();
            for (int i = 1; i < col; i++)
                temp = (Cell)temp.getNext();
            return temp;
        }    
        return null;
    }
    
    
    public boolean InsertInCell(long row, long col, Object Value)
    {
        if( !this.isEmpty() )
        {
            Row rowlst = (Row) this.getFirst();
            for (int i = 1; i < row; i++)
                rowlst = (Row)rowlst.getNext();
            
            Cell temp = (Cell)rowlst.getRowLst().getFirst();
            for (int i = 1; i < col; i++)
                temp = (Cell)temp.getNext();
            temp.setValue(Value);
            return true;
        }    
        return false;
    }

    @Override
    public boolean insertAfter(DoubleLink newLink, long key) {
        Row rowlst = (Row) this.getFirst();
            for (int i = 0; i < this.rows; i++)
            {
                if(rowlst.getiData() > key)
                    rowlst.incrementRow();
                rowlst = (Row)rowlst.getNext();
            }
            this.rows++;
        return super.insertAfter(newLink, key);
    }
    
    
    
    
    public static void main(String[] args)
    {
        System.out.println("Matrix");
        long rows = 100;
        int cols = 20;
        Matrix matrixInstance = new Matrix(rows, cols);

        System.out.println("Display indexed matrix:"); 
        
        matrixInstance.displayMatrix();
        System.out.println("Display matrix as Spreadsheet:");
        matrixInstance.displayAsSpreadsheet();
       
        System.out.println("");
        System.out.println("Inserting Strings at random:");
        
        for (int i = 0; i < rows; i++) 
            matrixInstance.InsertInCell( (long)(Math.random()*rows + 1), 
                    (long)(Math.random()*cols + 1), "$"+(long)(Math.random()*rows));
        
        System.out.println("Display matrix as Spreadsheet:");
        matrixInstance.displayAsSpreadsheet();
        
        System.out.println("Navigating cells at random:");
        for (int i = 0; i < rows; i++){
            matrixInstance.navigate( (long)(Math.random()*rows + 1), 
                    (long)(Math.random()*cols + 1) ).displayLink();
            System.out.println("");
        }
        
        System.out.println("Inserting rows at random:");
        for (int i = 0; i < rows; i++)
        {
            long newRow = (long)(Math.random()*rows + 1);
            matrixInstance.insertAfter(new Row( newRow+1, matrixInstance.getColumns() ), newRow);
        }
        System.out.println("Display matrix as Spreadsheet:");
        matrixInstance.displayAsSpreadsheet();
        
        System.out.println("Inserting Longs at random:");
        
        for (int i = 0; i < matrixInstance.getRows(); i++) 
            matrixInstance.InsertInCell( (long)(Math.random()*matrixInstance.getRows() + 1), 
                    (long)(Math.random()*cols + 1),  (long)(Math.random()*matrixInstance.getRows())  );
        
        System.out.println("Display matrix as Spreadsheet:");
        matrixInstance.displayAsSpreadsheet();
        
        System.out.println("Inserting Doubles at random:");
        
        for (int i = 0; i < matrixInstance.getRows(); i++) 
            matrixInstance.InsertInCell( (long)(Math.random()*matrixInstance.getRows() + 1), 
                    (long)(Math.random()*cols + 1), (Math.random()*matrixInstance.getRows())  );
       
        System.out.println("Display matrix as Spreadsheet:");
        matrixInstance.displayAsSpreadsheet();
        
    }
}
