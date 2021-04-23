import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class ProblemSet11 {

    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start >= end) {
            return null;
        }

        ArrayList<String> answer = new ArrayList<String>();
        for (int i = start; i < end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                answer.add("Fizz");
            }
            else if (i % 5 == 0) {
                answer.add("Buzz");
            }
            else {
                answer.add(Integer.toString(i));
            }
        }

        return answer;
    }

    public int maxSpan(ArrayList<Integer> numbers) {
        if(numbers == null){
            return -1;
        }

        int maxSpan = 0;
        while (numbers.size() > 0){
            for(int i = 1; i< numbers.size(); i ++){
                if(numbers.get(0).equals(numbers.get(i))) {
                    if(i + 1 > maxSpan){
                        maxSpan = i + 1;
                    }
                }
            }
            int tempBool = 0;
            int removingVal = numbers.get(0);
            while(tempBool >= 0){
                tempBool=numbers.remove(removingVal);
            }
        }

        return maxSpan;
    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        if(numbers == null){
            return null;
        }

        int threeCount = 0;
        ArrayList<Integer> threeIndexes = new ArrayList<>();
        int fourCount = 0;

        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == 3){
                if(numbers.get(i + 1) == 4){
                    return null;
                }

                threeCount++;
                threeIndexes.add(i);
            }
            if(numbers.get(i) == 4){
                if(threeCount == 0){
                    return null;
                }

                fourCount++;
            }
        }
        if(threeCount != fourCount){
            return null;
        }
        int[] arr = new int[numbers.size()];
        for(int j : threeIndexes){
            arr[j] = 3;
            arr[j+1] = 4;
        }
        for(int k : numbers){
            for(int l = 0; l < arr.length; l++){
                if(arr[l] == 0 && k !=3 && k !=4){
                    arr[l] = k;
                }
            }
        }
        ArrayList<Integer> finalarr = new ArrayList<>();
        for(int i : arr){
            finalarr.add(i);
        }
        return finalarr;
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return null;
        }

        int fourValues = 0;
        int fiveValues = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 4) {
                if (i != numbers.size()-1 && numbers.get(i+1) == 4) {
                    return null;
                }
                fourValues++;
            } else if (numbers.get(i) == 5) {
                fiveValues++;
            }
        }

        if (fourValues == 0 && fiveValues == 0) {
            return null;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 5) {
                for (int k = 0; k < numbers.size(); k++) {
                    if (numbers.get(k) == 4 && numbers.get(k+1) != 5) {
                        int t = numbers.get(k+1);
                        numbers.set(k+1, numbers.get(i));
                        numbers.set(i, t);
                    }
                }
            }
        }

        return numbers;
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            return false;
        }

        int leftBalance = 0;
        int rightBalance = 0;



        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i; j >= 0; j--) {
                leftBalance += numbers.get(j);
            }
            for (int k = i+1; k < numbers.size(); k++) {
                rightBalance += numbers.get(k);
            }
            if (rightBalance == leftBalance) {
                return true;
            }

            leftBalance = 0;
            rightBalance = 0;
        }

        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {
        if (outer == null || inner == null || outer.size() == 0 || inner.size() == 0) {
            return false;
        }

        for (int i = 0; i< outer.size()-1; i++) {
            if (outer.get(i) > outer.get(i+1)) {
                return false;
            }
        }

        for (int k = 0; k < inner.size()-1; k++) {
            if (inner.get(k) > inner.get(k+1)) {
                return false;
            }
        }

        boolean found = true;
        for (int j = 0; j < inner.size(); j++) {
            int test = 0;

            for (int m = 0; m < outer.size(); m++) {
                if (outer.get(m) == inner.get(j)) {
                    test += 1;
                }
            }

            if (test == 0) {
                return false;
            }
        }

        return true;
    }

    public ArrayList<Integer> squareUp(int n) {
        if(n < 0){
            return null;
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int[] smallarr = new int[n];
            int numadditions = 0;
            for(int j = n - 1; j >=0; j--){
                if(numadditions < i + 1){
                    smallarr[j] = numadditions + 1;
                    numadditions++;
                }
            }
            for(int x : smallarr){
                answer.add(x);
            }
        }

        return answer;
    }

    public ArrayList<Integer> seriesUp(int n) {
        if (n < 0) {
            return null;
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            for (int h = 0; h < i; h++) {
                answer.add(h+1);
            }
        }

        return answer;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        }

        int lowIdx = 0;
        int highIdx = 0;
        int currentMirror = 0;
        int maxMirror = 0;

        for (int i = 0; i < numbers.size(); i++) {
            for (int k = numbers.size() - 1; k >= 0; k--) {
                if (numbers.get(i) == numbers.get(k)) {
                    currentMirror = 1;
                    lowIdx = i + 1;
                    highIdx = k - 1;

                    while
                    ((lowIdx <= numbers.size() - 1 && highIdx >= 0) &&
                            (numbers.get(lowIdx) == numbers.get(highIdx))) {
                        highIdx-=1;

                        lowIdx+=1;

                        currentMirror+=1;
                    }

                    if (currentMirror > maxMirror) {
                        maxMirror = currentMirror;
                    }
                }
            }
        }

        return maxMirror;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        }
        int clumps = 0;

        boolean inClump = false;

        for (int i = 0; i < numbers.size()-1; i++) {
            if ((numbers.get(i) == numbers.get(i+1)) && !inClump) {
                clumps+=1;
                inClump = true;
            }
            else if (inClump && (numbers.get(i) != numbers.get(i-1))) {
                inClump = false;
            }
        }

        return clumps;
    }

    public static void main(String[] args) {

    }
}