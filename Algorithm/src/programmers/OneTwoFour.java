package programmers;

public class OneTwoFour {
    public static void main(String[] args) {
        int n = 21;
        int m = 30;
        long[] a = new long[m];
        int[] group = {4,1,2,4};
        a[0] = 1;
        a[1] = 3;
        int max = 1;
        if(n > 3){
            for(int i=2; i<=m-1; i++){
                a[i] = (long) (a[i-1]+ Math.pow(3, i));
                if(max == 1 && n <= a[i]) max = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(max >= 2){
            for(int i=max-1; i>=1; i--){
                long num = a[max-1];
                int j = 1;
                long bound = (long) Math.pow(3, i) * (long)j;
                while (bound <= a[max]){
                    bound += num;
                    //System.out.println(i+"/"+bound+"/"+j);
                    if(n <= bound){
                        sb.append(group[j%3]);
                        break;
                    }
                    j+=1;
                    bound = (long) Math.pow(3, i) * (long)j;
                }
            }
        }


        long mod = n%3;
        if(mod == 0){
            sb.append(4);
        }else{
            sb.append(mod);
        }

        String answer = sb.toString();
        System.out.println(answer);
    }
}
