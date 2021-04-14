package programmers;

import java.util.*;

class Truck{
    int weight, move;
    Truck(int weight, int move){
        this.weight = weight;
        this.move = move;
    }

    public void move(){
        move += 1;
    }
}

public class TruckPassingBridge {
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for(int w: truck_weights){
            waitQ.add(new Truck(w, 0));
        }

        int sec = 0;
        int curWeight = 0;
        while (!waitQ.isEmpty() || !moveQ.isEmpty()){
            sec += 1;

            if(!waitQ.isEmpty()){
                Truck t = waitQ.peek();
                if(curWeight + t.weight <= weight){
                    Truck t1 = waitQ.remove();
                    moveQ.add(t1);
                    curWeight += t.weight;
                }
            }

            for(Truck t1 : moveQ){
                t1.move();
            }

            if(!moveQ.isEmpty() && moveQ.peek().move >= bridge_length){
                Truck t = moveQ.remove();
                curWeight -= t.weight;
            }

        }

        return sec+1;
    }

    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
