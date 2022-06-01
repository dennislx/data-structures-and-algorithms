import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {

    private ArrayDequeSolution<Integer> ads;
    private StudentArrayDeque<Integer> sad;
    private Integer[] arr = new Integer[10];

    @Test(timeout=2000)
    public void testWhereDisagree(){
        while (true){
            ads = new ArrayDequeSolution<>();
            sad = new StudentArrayDeque<>();
            for (int i=0; i<10; i++){
                arr[i] = (int) (StdRandom.uniform() * 100);
            }
            String output = "";
            for (Integer val : arr){
                double prob = 4 * StdRandom.uniform();
                if (prob < 1){
                    ads.addFirst(val); sad.addFirst(val);
                    Integer v_ads = ads.get(0), v_sad = sad.get(0);
                    output += String.format("\naddFirst(%d)",val);
                    assertEquals(output, v_ads, v_sad);
                } else if (prob < 2){
                    ads.addLast(val); sad.addLast(val);
                    Integer v_ads = ads.get(ads.size()-1), v_sad = sad.get(sad.size()-1);
                    output += String.format("\naddLast(%d)",val);
                    assertEquals(output, v_ads, v_sad);
                } else if (prob < 3){
                    Integer v_ads = ads.removeFirst(); 
                    Integer v_sad = sad.removeFirst();
                    output += String.format("\nremoveFirst()",val);
                    assertEquals(output, v_ads, v_sad);
                } else {
                    Integer v_ads = ads.removeLast(); 
                    Integer v_sad = sad.removeLast();
                    output += String.format("\nremoveLast()",val);
                    assertEquals(output, v_ads, v_sad);
                }
            }
        }
    }
}
