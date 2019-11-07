/*12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 80 70 100
Soong 50 60 90
Haebin 50 60 100
Kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Taewhan 50 60 90*/

/*Donghyuk
Sangkeun
Sunyoung
nsj
Wonseob
Sanghyun
Sei
Kangsoo
Haebin
Junkyu
Soong
Taewhan*/
package sort;
import java.util.*;

class Student{
	String name;
	int korean;
	int english;
	int math;
	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
}
public class KoreanEnglishMathSort {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Student> list = new ArrayList<Student>();
		
		for(int i=0; i<n; i++) {
			String name = sc.next();
			int korean = sc.nextInt();
			int english = sc.nextInt();
			int math = sc.nextInt();
			list.add(new Student(name, korean, english, math));
		}
		
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if(o1.korean < o2.korean) {
					return 1;
				}else if(o1.korean == o2.korean) {
					if(o1.english > o2.english) {
						return 1;
					}else if(o1.english == o2.english) {
						if(o1.math < o2.math) {
							return 1;
						}else if(o1.math == o2.math) {
							return o1.name.compareTo(o2.name);
						}else {
							return -1;
						}
					}else {
						return -1;
					}
				}else {
					return -1;
				}
			}
			
		});
		
		for(Student s : list) {
			System.out.println(s.name);
		}
	}
}
