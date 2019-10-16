package com.company.lab0;

public class Variant17 {

    /**
     *
     * Three points A, B, C are given on the numerical axis.
     * Find the lengths of the segments AC and BC and their sum.
     * @params a, b, c
     * @return
     */
    public int[] inputOutputTask(int a, int b, int c) {
        assert a < b && b < c: "A < B < C should be";

        int firstInterval = c-a;
        int secondInterval = c-b;
        return new int[]{firstInterval, secondInterval, firstInterval+secondInterval};
    }

    /**
     * Given an integer greater than 999. // 1 [2] 54 // 12% 10 = 2 -> number: 100% 10 375 [4] 87
     *Using one whole division operation and one operation to take the remainder of the division,
     *find the number corresponding to the category of hundreds in the record of this number.
     * @param a
     * @return
     */
    public int integerNumbersTask(int a) {
        assert a > 999:"a>999 should be";

        int b = a/100;
        int c = b%10;
        return  c;

    }

    /**
     * . An integer in the range of 10–40 is given, which determines the number of training tasks on a certain topic.
     * Display a description string of the specified number of tasks, ensuring the correct coordination of the number
     * with the words “educational task”, for example: 18 - “eighteen educational tasks”, 23 - “twenty three educational tasks”,
     * 31 - “thirty one educational tasks”.
     * @param number
     * @return
     */
    public String switchTask(int number) {
        assert number >= 10 && number<= 40:"number>=10 && number<= 40 should be";

        if(number==10){
            return "ten task";
        }
        if(number==11){
            return "eleven task";
        }
        if(number==12){
            return "twelve task";
        }
        if(number==13){
            return "thirteen task";
        }
        String result = "";
        int n1= number/10;
        switch(n1){
            case 1: result= "teen"; break;
            case 2: result= "twenty "; break;
            case 3: result= "thirty ";
        }
        int n2= number%10;
        switch(n2){
            case 1: result+= "one"; break;
            case 2: result+= "two";break;
            case 3: result+= "three"; break;
            case 4: result= result.equals("teen") ? "four"+ result : result + "four"; break;
            case 5: result= result.equals("teen") ? "five"+ result : result + "five"; break;
            case 6: result = additionalMethod("six", result); break;
            case 7: result = additionalMethod("seven", result); break;
            case 8: result = additionalMethod("eight", result); break;
            case 9: result = additionalMethod("nine", result);
        }
        return result + " task";
    }

    private String additionalMethod(String number, String string){
        if (string.equals("teen")) return number+ string;
        return string + number;
    }

    /**
     *
     * Three points A, B, C are given on the numerical axis.
     * Find the lengths of the segments AC and BC and their sum.
     * @params number
     * @return
     */
    public String whileTask(int number) {
        assert (number >0 ): "Argument should be more than zero";
        String result= "";
        while (number>0){
            result+= Integer.toString(number%10);
            number=number/10;
        }
        return result;
    }

    /**
     *Given a matrix of size M x N and an integer K (1 Ј K Ј M).
     * Find the sum and product of the elements of the K-th row of this matrix.
     * @params k,array
     * @return
     */
    public int[] twoDimensionArrayTask(int[][] array, int k) {
        assert (k < array.length ): "Argument should be more than zero";
        int sum=0;
        int prod=1;
        for(int i=0;i<array[0].length;i++){
            sum+=array[k][i];
            prod*=array[k][i];
        }
        return new int[]{sum, prod};
    }

    /**
     *
     *  An array A of size N is given. Output its elements in the following order:
     *     A1, A2, AN, AN – 1, A3, A4, AN – 2, AN – 3, .....
     * @params array
     * @return
     */
    public int[] arrayTask(int[] array) {
        int i=0;
        int count = 0;
        int[] result = new int[array.length];
        int resCurrentIndex=0;

        while (count < array.length/4)    {
            result[resCurrentIndex++] = array[i];
            result[resCurrentIndex++] = array[i+1];
            result[resCurrentIndex++] = array[array.length-1-i];
            result[resCurrentIndex++] = array[array.length-2-i];
            i+=2;
            count++;
        }

        int rest=array.length-count*4;
        while(rest > 0){
            result[resCurrentIndex++] = array[i];
            i++;
            rest--;
        }

        return result;
    }

    /**
     *Three variables of the real type are given: A, B, C.
     *  If their values ​​are ordered in ascending or descending order,
     *  then double them; otherwise, replace the value of
     *  each variable with the opposite. Print new values ​​of variables A, B, C.
     * @params A,B,C
     * @return
     */
 public int[] ifTask(int a, int b, int c) {
      assert (a < b && b < c) || (a > b && b > c) : "A < B < C || A > B > C should be";
        if ((a < b < c) || (a > b  > c)) {
           int  a1 = a*2;
           int  b1 = b*2;/           int  c1 = c*2;
        else()
               a1 = -a;
               b1 = -b;
               c1 = -c;

           return new int[]{a1, b1, c1};
        }
    }

    /**
     *Given a positive integer. Check the truth of the statement:
     * "This number is an odd three-digit."
     * @params A
     * @return
     */
    public boolean booleanTask(int a) {
        if(a%2!=0 && a>=100 && a<=999)
            return true;
        else
            return false;
    }
    /**
     *Given a real number A and an integer N (> 0). Using one cycle, find the
     * sum 1 + A + A2 + A3 + ... + AN.
     * @params n,a
     * @return
     */
    public double forTask( double a,int n) {
        assert n >0: "Argument should be more than zero";
        double sum=0;
        for (int i = 1; i <= n; i++) {
            sum+=a;
            a*=a;
        }
        return sum;
    }
}



