package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Song implements Comparable<Song>{
    int order;
    int playTime;
    String title;
    String songInfo;

    public Song(int order, int playTime, String title, String songInfo) {
        this.order = order;
        this.playTime = playTime;
        this.title = title;
        this.songInfo = songInfo;
    }

    @Override
    public int compareTo(Song that) {
        if(this.playTime > that.playTime){
            return -1;
        }else if(this.playTime == that.playTime){
            if(this.order < that.order){
                return -1;
            }else if(this.order == that.order){
                return 0;
            }else{
                return 1;
            }
        }else {
            return 1;
        }
    }
}

public class ThatSong {
    static ArrayList<Song> matchSongs;
    static HashMap<String, Character> map;
    public int[] preprocessing(String p){
        int m = p.length();
        int[] pi = new int[m];
        pi[0] = 0;
        int j = 0;
        for(int i=1; i<m; i++){
            while (j>0 && p.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }
            if(p.charAt(i) == p.charAt(j)){
                pi[i] = j+1;
                j += 1;
            }else{
                pi[i] = 0;
            }
        }

        return pi;
    }
    public boolean findPattern(String t, String p){
        int[] pi = preprocessing(p);
        int n = t.length();
        int m = p.length();
        int j = 0;
        for(int i=0; i<n; i++){
            while (j>0 && t.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }
            if(t.charAt(i) == p.charAt(j)){
                if(j == m-1){
                    return true;
                }else{
                    j += 1;
                }

            }
        }

        return false;
    }
    public String changeSharp(String s){
        StringBuilder sb = new StringBuilder();
        char[] tone = s.toCharArray();
        for(int j=0; j<tone.length; j++){
            char c = tone[j];
            if(j != tone.length-1) {
                if(tone[j+1] == '#'){
                    String key = "";
                    key += tone[j]+"#";
                    c = map.get(key);
                    j += 1;
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
    public String solution(String m, String[] musicinfos) {
        matchSongs = new ArrayList<>();
        map = new HashMap<>();
        map.put("C#", 'H');
        map.put("D#", 'I');
        map.put("F#", 'J');
        map.put("G#", 'K');
        map.put("A#", 'L');

        m = changeSharp(m);

        //song 타입 배열로 바꿔 준다.
        Song[] songs = new Song[musicinfos.length];
        for(int i=0; i< musicinfos.length; i++){
            String info = musicinfos[i];
            String[] temp = info.split(",");
            String startTime = temp[0];
            String endTime = temp[1];
            int startHour = Integer.parseInt(startTime.substring(0,2)) * 60;
            int startMin = Integer.parseInt(startTime.substring(3));
            int endHour = Integer.parseInt(endTime.substring(0,2)) * 60;
            int endMin = Integer.parseInt(endTime.substring(3));

            int start = startHour+startMin;
            int end = endHour+endMin;

            String songInfo = changeSharp(temp[3]);

            songs[i] = new Song(i, end-start, temp[2], songInfo);
        }

        for(Song s : songs){
            int playTime = s.playTime;
            if(playTime == 0) continue;
            String songInfo = s.songInfo;
            int songLength = songInfo.length();
            StringBuilder sb = new StringBuilder();

            if(playTime > songLength){
                //m길이와 맞추기
                int x = playTime/songLength;
                int y = playTime%songLength;
                for(int i=0; i<x; i++){
                    sb.append(songInfo);
                }

                if(y > 0){
                    String left = songInfo.substring(0, y);
                    sb.append(left);
                }
            }else if(playTime < songLength){
                //m길이에 맞춰 자르기
                String left = songInfo.substring(0, playTime);
                sb.append(left);
            }else{
                sb.append(songInfo);
            }

            System.out.println("sb.toString() = " + sb.toString() + " length : " + sb.toString().length());
            //패턴 찾기
            boolean res = findPattern(sb.toString(), m);
            if(res) matchSongs.add(s);
        }

        String answer = "(None)";
        if(matchSongs.size() > 0){
            Collections.sort(matchSongs);
            answer = matchSongs.get(0).title;
        }

        return answer;
    }

    public static void main(String[] args) {
        ThatSong t = new ThatSong();
        //String m = "ABC";
        String m = "C#";
        //String m = "CC#BCC#BCC#BCC#B";
//        String m = "ABCDEFG";
       //String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:38,BAR,CC#BCC#BCC#B"};
//        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] musicinfos = {"12:00,12:01,HELLO,C#DEFGAB", "13:00,13:01,WORLD,ABCDEF"};
        System.out.println(t.solution(m, musicinfos));

    }
}
