package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicate {
    public static void main(String[] args) {
        int[] inputArray = new int[] {111, 333, 555, 777, 333, 444, 555};
        //    //Method 1 : Brute Force Method
        for(int i=0;i<inputArray.length;i++){
            for(int j=i+1;j<inputArray.length;j++){
                if(inputArray[i]==inputArray[j]){
                    System.out.println(inputArray[i]+" ");
                }
            }

        }
        System.out.println("\n");
        //Method 2 : Sorting Method
        Arrays.sort(inputArray);
        for(int i=0;i<inputArray.length-1;i++){
            if(inputArray[i]==inputArray[i+1]){
                System.out.println("Duplicate elements by sorting is "+inputArray[i]);
            }
        }
         //Method 3 : Using HashSet
        HashSet<Integer> duplicateElement=new HashSet<>();
        System.out.println("duplicate elements using hashset");
        for(int i:inputArray){
            if(!duplicateElement.add(i)){
                System.out.println(i);
            }
        }
        //Method 4 : Using Java 8 Streams
        Set<Integer> uniqueElement=new HashSet<>();
        Set<Integer> dupElement=Arrays.stream(inputArray).filter(i->!uniqueElement.add(i)).boxed().collect(Collectors.toSet());
        System.out.println(dupElement);
    }
}
