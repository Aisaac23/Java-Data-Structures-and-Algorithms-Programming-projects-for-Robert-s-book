//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////
package Queue;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isaac.huerta
 */
/*********** Programming Projects: 4.5 ***********************/

public class SuperMarket extends Thread {

    private final int Ncashiers = 8;
    private final int custPerLine = 20;
    private final int hrs = 15*1000*60*60;
    private long secs;
    private final Queue[] lines;
    private final Thread[] checkers;
    private boolean closing;
    private final long NewCustTime = 1000*5;
    private final long groceryPass = 2;
    private final long otherTransac = 1000*60*2;
    
    public SuperMarket(String string) {
        super(string);
        secs = 0;
        this.lines = new Queue[Ncashiers];
        closing = false;
        this.checkers = new Thread[Ncashiers];
    }

    @Override
    public void run() {
       
        for (int i = 0; i < Ncashiers; i++) 
        {
            final int index;
            
            index = i;
            lines[i] = new Queue(this.custPerLine);
            checkers[i] = new Thread()
            {
                @Override
                public void run() {
                    while(true)
                    {
                        if( !lines[index].isEmpty() )
                            try {
                                Thread.sleep(lines[index].peekFront() * groceryPass + otherTransac );
                                System.out.println("From checker " + index + " Removing: " + lines[index].remove());
                             
                            } catch (InterruptedException ex) {
                                Logger.getLogger(SuperMarket.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        else
                            try 
                            {
                                Thread.sleep(NewCustTime);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(SuperMarket.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                }
                
            };
            checkers[i].start();
        }
            int best; 
            long groseries;
            
            while(!closing)
            {
                best = this.pickTheBest();
                if( !this.lines[best].isFull() )
                    try {
                        Thread.sleep(this.NewCustTime);
                        secs+=5;
                        groseries = (long)(Math.random()*custPerLine) * 2;
                        this.lines[best].insert( groseries );
                        System.out.println("Checker " + best + ": " + groseries);
                        
                        for (int i = 0; i < this.Ncashiers; i++)
                            if(!lines[i].isEmpty())
                                this.lines[i].displayQueue();
                        closing = secs>hrs;

                    } catch (InterruptedException ex) {
                        Logger.getLogger(SuperMarket.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
    }

    private int pickTheBest()
    {
        int temp = this.lines[0].size(), pos = 0;
        
        for (int i = 0; i < this.lines.length; i++)
            if(this.lines[i].size() < temp)
            {
                temp = this.lines[i].size();
                pos = i; 
            }
        return pos;
    }   
}
/*****************************************************************/
