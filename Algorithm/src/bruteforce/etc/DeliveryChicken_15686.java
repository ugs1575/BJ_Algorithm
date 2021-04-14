package bruteforce.etc;

import java.util.ArrayList;
import java.util.Scanner;


class Location{
    int x, y;
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class DeliveryChicken_15686 {
    static int n,m;
    static int getDistance(int[] a, ArrayList<Location> house, ArrayList<Location> shop){
        int sum = 0;
        for(int i=0; i<house.size(); i++){
            Location h = house.get(i);
            int min = Integer.MAX_VALUE;
            for(int j=0; j<m; j++){
                Location s = shop.get(a[j]);
                int res = Math.abs((h.x+1)-(s.x+1))+ Math.abs((h.y+1)-(s.y+1));
                min = Math.min(res, min);
            }
            sum += min;
        }

        return sum;
    }
    static int pickShop(int start, int end, ArrayList<Location> shop, ArrayList<Location> house, int[] a, int index){
        int ans = -1;
        if(index == m){
            return getDistance(a, house, shop);
        }

        for(int i=start; i<=end; i++){
            a[index] = i;
            int res = pickShop(i+1, end, shop, house, a, index+1);
            if(ans == -1) {
                ans = res;
            }else if(res != -1){
                ans = Math.min(ans, res);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] map = new int[n][n];
        int[] a = new int[m];
        ArrayList<Location> shop = new ArrayList<>();
        ArrayList<Location> house = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    house.add(new Location(i, j));
                }else if(map[i][j] == 2){
                    shop.add(new Location(i, j));
                }

            }
        }

        System.out.println(pickShop(0, shop.size()-1, shop, house, a, 0));

    }
}
