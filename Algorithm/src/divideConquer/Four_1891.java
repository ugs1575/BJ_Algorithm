package divideConquer;

import java.util.Scanner;

public class Four_1891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        String s = sc.next();
        long dx = sc.nextLong();
        long dy = sc.nextLong();
        long n = (long) Math.pow(2,d);

        long from_x = 0L;
        long to_x = n;
        long from_y = 0L;
        long to_y = n;
        long temp = n;
        for(int i=0; i<s.length(); i++){
            temp /= 2;
            if(s.charAt(i) == '2'){
                to_x /= 2;
                to_y /= 2;
            }else if(s.charAt(i) == '1'){
                to_x /= 2;
                from_y += temp;
            }else if(s.charAt(i) == '3'){
                from_x += temp;
                to_y /= 2;
            }else {
                from_x += temp;
                from_y += temp;
            }
        }
        long x = from_x-dy;
        long y = from_y+dx;

        from_x = 0L;
        to_x = n;
        from_y = 0L;
        to_y = n;
        temp = n/2;
        if(x >= 0 && x < n && y >= 0 && y < n){
            StringBuilder sb = new StringBuilder();
            while (temp > 0){
                if(x >= from_x && x < from_x+temp){
                    to_x = from_x+temp;
                    if(y >= from_y && y < from_y+temp){ //2사분면
                        sb.append(2);
                        to_y = from_y+temp;
                    }else{ //1사분면
                        sb.append(1);
                        from_y += temp;
                    }
                }else{
                    from_x += temp;
                    if(y >= from_y && y < from_y+temp){ //3사분면
                        sb.append(3);
                        to_y = from_y+temp;
                    }else{ //4사분면
                        sb.append(4);
                        from_y += temp;
                    }
                }

                temp /= 2;
            }

            System.out.println(sb);
        }else{
            System.out.println(-1);
        }

    }
}
