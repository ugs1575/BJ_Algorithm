package Math;

public class Pow1 {
    static int calc(int a, int b){
        if(b == 0){
            return 1;
        }else if(b == 1){
            return a;
        }else if(b%2 == 0){
            int temp = calc(a, b/2);
            return temp * temp;
        }else{
            return a * calc(a, b-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(calc(2,7));
    }
}
