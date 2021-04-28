package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

class File {
    String head;
    int number;
    String tail;
    int index;

    public File(String head, int number, String tail, int index) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.index = index;
    }

}

class sortFile implements Comparator<File>{

    @Override
    public int compare(File f1, File f2) {
        int res = f1.head.compareTo(f2.head);
        if(res < 0){
            return -1;
        }else if(res == 0){
            if(f1.number < f2.number){
                return -1;
            }else if(f1.number == f2.number){
                if(f1.index < f2.index){
                    return -1;
                }else if(f1.index == f2.index){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}

public class SortingFileName {
    public String[] solution(String[] files) {
        ArrayList<File> fileList = new ArrayList<>();

        //파일 분리하기
        for(int k=0; k<files.length; k++){
            String file = files[k];
            int j = 0;
            //head 찾기
            for(int i=0; i<file.length(); i++){
                int c = file.charAt(i);
                if(48<=c && c<=57){
                    j = i; //처음으로 숫자가 나오는 인덱스
                    break;
                }
            }

            String head = file.substring(0, j).toLowerCase(Locale.ROOT);

            //number 찾기
            int t = j+5;
            if(j+5 >= file.length()){
                t = file.length();
            }
            for(int i=j; i<t; i++){
                int c = file.charAt(i);
                if(c<48 || c>57){
                    t = i; //number의 끝
                    break;
                }
            }

            int number = Integer.parseInt(file.substring(j, t));
            String tail = file.substring(t, file.length());
            fileList.add(new File(head, number, tail, k));

        }

        Collections.sort(fileList, new sortFile());

        String[] answer = new String[files.length];
        for(int i=0; i< files.length; i++){
            int index = fileList.get(i).index;
            answer[i] = files[index];
        }
        return answer;
    }

    public static void main(String[] args) {
        SortingFileName s = new SortingFileName();
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        //String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        s.solution(files);
    }
}
