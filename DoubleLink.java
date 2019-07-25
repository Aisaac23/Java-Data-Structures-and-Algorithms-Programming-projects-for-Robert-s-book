/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Links;

/**
 *
 * @author isaac.huerta
 */
public class DoubleLink extends Link
{
    private DoubleLink previous;

    public DoubleLink(long id) {
        super(id);
    }
    
    public DoubleLink getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLink previous) {
        this.previous = previous;
    }
}
