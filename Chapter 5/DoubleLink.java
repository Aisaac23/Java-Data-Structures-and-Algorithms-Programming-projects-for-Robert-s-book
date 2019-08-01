//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////
package Links;

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
