package sort;
import java.util.*;

class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class CoordinateSorting2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Coordinate> clist = new ArrayList<Coordinate>();
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			clist.add(new Coordinate(x,y));
		}
		
		Collections.sort(clist, new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate arg0, Coordinate arg1) {
				// TODO Auto-generated method stub
				if(arg0.y > arg1.y) {
					return 1;
				}else if(arg0.y < arg1.y) {
					return -1;
				}else {
					if(arg0.x > arg1.x) {
						return 1;
					}else if(arg0.x == arg1.x) {
						return 0;
					}else {
						return -1;
					}
				}
			}
			
		});
		
		for(Coordinate c : clist) {
			System.out.println(c.x+" "+c.y);
		}
	}
}
