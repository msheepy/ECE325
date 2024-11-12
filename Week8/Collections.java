import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Collections {
    public static <T> void filter(Collection<T> c) {
        for(Iterator<T> it = c.iterator(); it.hasNext(); ) {
            T str = it.next();
            if(condition){
                it.remove();
            }
        }
    }
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        Set<Integer> s3 = s1;
        s3.addAll(s2);
        Set<Integer> union = s3;
        s1.retainAll(s2);
        Set<Integer> intersection = s1;
        s3.removeAll(s1);
        Set<Integer> difference = s3;
    }

}
