package Math;

public class Pow2 {
    static int calc(int a, int b){
        int ans = 1;
        while (b > 0){
            if(b%2 == 1){
                ans *= a;
            }
            a *= a;
            b /= 2;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(calc(3,5));
    }
}
