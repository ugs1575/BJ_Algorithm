package divideConquer.binarySearch;

import java.io.*;

public class WritingNumber2_1790 {
    static long get_boundary(long[] aBound, long p, long n, int t){
        long boundary = aBound[t-1]+(n-p+1)*t;
        //System.out.println("t : "+t+" p : "+p+" boundary : "+boundary);
        return aBound[t-1]+(n-p+1)*t;
    }

    static int binary_search(long[] aBound, long start, long end, long k){
        int ans = -1;
        if(start < end){
            long mid = (start+end)/2;
            int t = String.valueOf(mid).length();
            long p = (long) Math.pow(10,t-1);
            long boundary = get_boundary(aBound, p, mid, t);
            long low_bound = boundary-t+1;
            if(k > boundary){
                int temp = binary_search(aBound, mid+1, end, k);
                if(temp != -1){
                    ans = temp;
                }
            }else if(k < low_bound){
                int temp = binary_search(aBound, start, mid, k);
                if(temp != -1){
                    ans = temp;
                }
            }else{
                int diff = (int) (boundary-k);
                int length = String.valueOf(mid).length();
                int index = length-diff-1;
                char num = String.valueOf(mid).charAt(index);
                return num-'0';
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] a = br.readLine().split(" ");
        long n = Long.parseLong(a[0]);
        long k = Long.parseLong(a[1]);

        long[] aBound = new long[10];
        aBound[1] = 9;
        for(int i=2; i<=9; i++){
            int next = (int) Math.pow(10, i);
            int current = (int) Math.pow(10, i-1);
            int total = i*(next-current);
            aBound[i] = aBound[i-1]+total;
        }

        //n의 자릿
        int t = String.valueOf(n).length();
        long p = (long) Math.pow(10,t-1);
        long boundary = get_boundary(aBound, p, n, t);
        long low_bound = boundary-t+1;

        if(k > boundary){
            System.out.println(-1);
        }else if(k >= low_bound && k <= boundary){
            int diff = (int) (boundary-k);
            int length = String.valueOf(n).length();
            int index = length-diff-1;
            char num = String.valueOf(n).charAt(index);
            System.out.println(num-'0');
        }else{
            int ans = binary_search(aBound, 1, n, k);
            System.out.println(ans);
        }

    }
}
