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
public class CoordinateSorting {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Coordinate> clist = new ArrayList<Coordinate>();
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			clist.add(new Coordinate(x,y)) ;
		}
		
		Collections.sort(clist, new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate o1, Coordinate o2) {
				// TODO Auto-generated method stub
				if(o1.x > o2.x) {
					return 1;
				}else if(o1.x < o2.x) {
					return -1;
				}else {
					if(o1.y > o2.y) {
						return 1;
					}else if(o1.y == o2.y) {
						return 0;
					}else {
						return -1;
					}
				}
				
			}
			
		});
		
		for(Coordinate o : clist ) {
			System.out.println(o.x+" "+o.y);
		}
	}
}
