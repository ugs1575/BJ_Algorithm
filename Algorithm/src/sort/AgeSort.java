package sort;
import java.util.*;

class User{
	int age;
	String name;
	public User(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

public class AgeSort {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<User> list = new ArrayList<User>();
		
		for(int i=0; i<n; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			list.add(new User(age, name));
		}
		
		Collections.sort(list, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				if(o1.age > o2.age) {
					return 1;
				}else if(o1.age < o2.age) {
					return -1;
				}else {
					return 0;
				}
			}
			
		});
		
		for(User u : list) {
			System.out.println(u.age+" "+u.name);
		}
	}
}
