import java.util.List;

class Solution {
    StringBuilder answer = new StringBuilder();

    List<List<String>> keypad = List.of(
            List.of("1", "2", "3"),
            List.of("4", "5", "6"),
            List.of("7", "8", "9"),
            List.of("*", "0", "#")
    );
    List<String> left = List.of("1", "4", "7");
    List<String> right = List.of("3", "6", "9");
    Point Rrecent = new Point(3, 0);
    Point Lrecent = new Point(3, 2);
    String hand = "";

    public String solution(int[] numbers, String hand) {
        if (hand.equals("right")) {
            this.hand = "R";
        } else {
            this.hand = "L";
        }

        for (int number : numbers) {
            String num = String.valueOf(number);
            if (left.contains(num)) {
                answer.append("L");
                int x = left.indexOf(num);
                int y = keypad.get(x).indexOf(num);
                Lrecent = new Point(x, y);
            } else if (right.contains(num)) {
                answer.append("R");
                int x = right.indexOf(num);
                int y = keypad.get(x).indexOf(num);
                Rrecent = new Point(x, y);
            } else {
                calculate(number);                
            }
        }
            return answer.toString();
    }
    
    public void calculate(int number) {
        int x = 0, y = 1;
        for (int i = 0; i < 4; i++) {
            if (keypad.get(i).contains(String.valueOf(number))) {
                x = i;;
                break;
            }
        }
        // 거리 계산
        int Ldistance = Math.abs(Lrecent.x - x) + Math.abs(Lrecent.y - y);
        int Rdistance = Math.abs(Rrecent.x - x) + Math.abs(Rrecent.y - y);
        if (Ldistance < Rdistance) {
            answer.append("L");
            Lrecent = new Point(x, y);
        } else if (Ldistance > Rdistance) {
            answer.append("R");
            Rrecent = new Point(x, y);
        } else {
            if (hand.equals("R")) {
                answer.append("R");
                Rrecent = new Point(x, y);
            } else {
                answer.append("L");
                Lrecent = new Point(x, y);
            }
        }
    }
    public class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}