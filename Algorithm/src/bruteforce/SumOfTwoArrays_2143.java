package bruteforce;

import java.util.*;
public class SumOfTwoArrays_2143 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++){
            b[i] = sc.nextInt();
        }

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += a[j];
                first.add(sum);
            }
        }

        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=i; j<m; j++){
                sum += b[j];
                second.add(sum);
            }
        }


        Collections.sort(first);
        Collections.sort(second);

        long ans = 0;
        int left = 0;
        int right = second.size()-1;
        while (left < first.size() && right >= 0){
            //System.out.println(left+"/"+right);
            int temp = first.get(left) + second.get(right);
            if(temp == t){
                //System.out.println("same");
                long c1 = 1;
                long c2 = 1;
                while (left < first.size()-1 && first.get(left).equals(first.get(left + 1))){
                    c1 += 1;
                    left += 1;
                }
                while (right > 0 && second.get(right).equals(second.get(right - 1))){
                    c2 += 1;
                    right -= 1;
                }
                ans += c1*c2;
                left += 1;
                right -= 1;
            }else if(temp > t){
                //System.out.println("over");
                right -= 1;
            }else{
                //System.out.println("less");
                left += 1;
            }
        }

        System.out.println(ans);


    }
}
