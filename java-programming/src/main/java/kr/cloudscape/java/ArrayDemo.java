package kr.cloudscape.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ArrayDemo {

    public static void main(String[] args) {
        double[] arr = new double[]{1, 2.489, 3.2, 4, 5.8743598};

        for (double d : arr)
            System.out.println(d);

        System.out.println("\n--------------------------------------------------\n");

        String[] str = new String[3];
        Arrays.fill(str, "-1");

        for (String s : str)
            System.out.println(s);

        System.out.println("\n--------------------------------------------------\n");

        // ArrayList - 초기화 시 사이즈 표시하지 않음. 추가시 메모리를 재할당하기 때문에 (살짝) 느리다. 다차원 불가능.
//        ArrayList<Integer> myArrayList = new ArrayList<>();
//        myArrayList.add(1);
//        myArrayList.add(898);
//        myArrayList.add(38483288);
//        for (int ii : myArrayList)
//            System.out.println(ii);

        int[][] a2 = new int[4][5];

        System.out.println(a2.length);
        System.out.println(a2[0].length);

        System.out.println("\n--------------------------------------------------\n");

        // Stack 출력해보기.
        Stack<String> stack = new Stack<>();
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");

        List<String> list = new ArrayList<>(stack);
//        ArrayList<String> list = new ArrayList<>(stack);

        for (String x : list)
            System.out.println(x);

        System.out.println("\n--------------------------------------------------\n");

        // https://stackoverflow.com/questions/2137755/how-do-i-reverse-an-int-array-in-java
        // https://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
        int[] i_arr = {0,19,29,39,49,100,110,120,130,140,900,910,920,930,940};
        System.out.println(Arrays.toString(i_arr));
        int temp=0;
        for (int i=0; i < i_arr.length / 2; i++) {
            temp = i_arr[i];
            i_arr[i] = i_arr[i_arr.length - 1 - i];
            i_arr[i_arr.length - i - 1] = temp;
        }

        System.out.println(String.join(",", Arrays.toString(i_arr)));

        System.out.println("\n--------------------------------------------------\n");

        List<String> list_test = Arrays.asList("C", "C++", "Java");
        // http://asuraiv.blogspot.com/2015/06/java-list-toarray.html
        String[] array_test = list_test.toArray(new String[0]);
        System.out.println(Arrays.toString(array_test));

        List<String> realArgs = Arrays.asList("customerFile=/input/customer_mini.csv");
//        realArgs.add("Test Arg 1");  // java.lang.UnsupportedOperationException 발생.

//        System.out.println(realArgs.toArray(new String[0]));
        System.out.println(Arrays.toString(realArgs.toArray(new String[0])));

        System.out.println("\n--------------------------------------------------\n");
    }
}
