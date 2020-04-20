package challenge;

import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        long startTime = System.currentTimeMillis();
        int iteration = 1;
        List<Integer> max = new ArrayList<>();
        List<Integer> randomNumbers = IntStream.range(1, 1001).boxed().collect(Collectors.toList());
        Collections.shuffle(randomNumbers);
        //Integer[] array = {15,78,9,34,78,101,2,90,54,2,15,26};
        //List<Integer> randomNumbers = Arrays.asList(array);
        int k = 5;
        int size = randomNumbers.size();
        int mod = size % k;
        MyLinkedList k_segements = new MyLinkedList();
        MyLinkedList queue = new MyLinkedList();
        if(mod == 0) {
            for(int i = 0; i< k; i++) {
                int data = randomNumbers.get(i);
                k_segements.insert(data);
            }
            k_segements.show();
            for(int i = k; i< size; i++) {
                int data = randomNumbers.get(i);
                queue.insert(data);
            }
            queue.show();
            System.out.println("Max element in iteration " + iteration + " is: " + k_segements.getMax());
            max.add(k_segements.getMax());
            iteration++;
            while(queue.getSize() >0) {
                k_segements.removeAtRoot();
                int data = queue.removeAtRoot();
                k_segements.insert(data);
                k_segements.show();
                queue.show();
                System.out.println("Max element in iteration " + iteration + " is: " + k_segements.getMax());
                max.add(k_segements.getMax());
                iteration++;
            }
            Optional<Integer> min = max.stream().min((i, j) -> i.compareTo(j));
            System.out.println("The min of all max is: " + min.get());
        } else {
            System.err.println("Mode is not 0. Please pick another k const.");
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time in seconds: " + elapsedTime/1000); 
    }
}
