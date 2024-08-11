package preparation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class practise {

    public static void main(String[] args) {

        //18) Reverse each word of a string using Java 8 streams?

        String str = "java concept";
        String reverseStr= Arrays.stream(str.split(" ")).map(word-> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println(reverseStr);
  //19) How do you find sum of first 10 natural numbers?
        int sum = IntStream.range(1,11).sum();
        System.out.println(sum);
        /*int sumNo=0;
        for(int i=0;i<=10;i++){
            //sumNo =sumNo+i;
            sumNo +=i;
        }
        System.out.println(sumNo);*/
//20) Reverse an integer array

      int[] arr=new int[] {5,1,7,3,9,6};
      int[] reverseArr=IntStream.rangeClosed(1,arr.length).map(i->arr[arr.length-i]).toArray();
        System.out.println(Arrays.toString(reverseArr));
        int[] reverArr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            reverArr[i] =arr[arr.length-1-i];
        }
        System.out.println(Arrays.toString(reverArr));
      //21) Print first 10 even numbers
        int[] evenNumbers = new int[10];

        for (int i = 0; i < 10; i++) {
            evenNumbers[i] = 2 * (i + 1);
        }

        System.out.println(Arrays.toString(evenNumbers));
        IntStream.rangeClosed(1,10).map(i->i*2).forEach(i-> System.out.print(i+" "));
        System.out.println("\n"+"odd numbers by using stream");
//        30) First 10 odd numbers
        Stream.iterate(new int[]{1,3},f->new int[]{f[1],f[1]+2}).limit(10).map(f->f[0]).forEach(i-> System.out.print(i+" "));
        System.out.println("\n");
        int number =1;
          for(int i=0;i<10;i++){
              System.out.print(number+" ");
              number +=2;
          }
        //22) How do you find the most repeated element in an array?
        List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        Map<String ,Long> countEle= listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Map.Entry<String,Long> fqCount=countEle.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("\n"+"most repeated element is : "+fqCount.getKey()+ " ;frequencey is : " + fqCount.getValue());
        //23) Palindrome program using Java 8 streams
        String strr="ROTATOR";
        boolean isPalindrome=IntStream.range(0,strr.length()/2).noneMatch(i->strr.charAt(i) !=strr.charAt(strr.length() -i -1));
        if(isPalindrome){
            System.out.println(strr+" is a palindrome");
        }
        else {
            System.out.println(strr+" is not a palindrome");
        }
       //24) Given a list of strings, find out those strings which start with a number?
        List<String> listOfStr = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        listOfStr.stream().filter(s -> Character.isDigit(s.charAt(0))).forEach(System.out::println);
        //25) How do you extract duplicate elements from an array?
        Set<String> uniqueElements1= new HashSet<>(listOfStrings);
        System.out.println(uniqueElements1);
        Set<String> uniqueElements = new HashSet<>();
        Set<String> dupElemnts=listOfStrings.stream().filter(i->!uniqueElements.add(i)).collect(Collectors.toSet());
        System.out.println(dupElemnts);
        //26) Print duplicate characters in a string?
        String inputStr= "java concept of the day".replaceAll("\\s+", "").toLowerCase();
        Set<String> uniqueChars = new HashSet<>();
        Set<String> duplicateChars= Arrays.stream(inputStr.split("")).filter(ch->!uniqueChars.add(ch)).collect(Collectors.toSet());
        System.out.println(duplicateChars);
        //27) Find first repeated character in a string?
        Map<String,Long> repStr=Arrays.stream(inputStr.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        String firstRepeatChar=repStr.entrySet().stream().filter(i->i.getValue()>1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(firstRepeatChar);
        //28) Find first non-repeated character in a string?
       // String nonRepChar=repStr1.entrySet().stream().filter(i->i.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
       //get output "p",because hashmap doesnot maintain insertion order,while linked hashmap maintain insertion order as follows and we get output as j in below
        Map<String,Long> repStr2=Arrays.stream(inputStr.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

        String nonRepChar=repStr2.entrySet().stream().filter(i->i.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(nonRepChar);
       //29) Fibonacci series
        Stream.iterate(new int[] {0,1}, f -> new int[] {f[1],f[0]+f[1]}).limit(10).map(f->f[0]).forEach(i-> System.out.print(i+" "));
        System.out.println("\n"+ "fibanocci series by swaping below is the output");
        //fibonacci series by swaping
       int num1=0, num2 =1;
       for(int i=0;i<10;i++){
           System.out.print(num1+" ");

           //swap
           int num3=num2+num1;
           num1=num2;
           num2 =num3;
       }
        //by dynamic
        int[] fib = new int[10];

        fib[0] = 0; // first Fibonacci number
        fib[1] = 1; // second Fibonacci number

        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2]; // generate the next Fibonacci number

        }
        System.out.println("\n"+"fibanocci series by dynamic below is the output");
        for (int i = 0; i < fib.length; i++) {
            System.out.print(fib[i] + " ");
        }
        //31) How do you get last element of an array?
        String lastElement =listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get();
        System.out.println("\nlast element of array is "+lastElement);
//32) Find the age of a person in years if the birthday has given?
        LocalDate birthday =LocalDate.of(2000,06,30);
        LocalDate today=LocalDate.now();
        System.out.println(ChronoUnit.YEARS.between(birthday,today));

    }

}
