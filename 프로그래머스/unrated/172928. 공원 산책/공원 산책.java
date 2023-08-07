class Solution {
    int X, Y;
    char[][] map;
    Robot robot;
    
    public int[] solution(String[] park, String[] routes) {
        Y = park.length;
        X = park[0].length();
        map = new char[Y][X];
        
        for (int i = 0; i < park.length; i++) {
            map[i] = park[i].toCharArray();

            if(park[i].contains("S")){
                robot = new Robot(i, park[i].indexOf("S"));
            }
        }

        for(String route : routes) {
            move(route.charAt(0), Integer.parseInt(route.substring(2)));
//            System.out.println(Arrays.toString(new int[] {robot.getY(), robot.getX()}));
        }
        return new int[] {robot.getY(), robot.getX()};
    }

    public void move(char direction, int num) {
        int nx = robot.getX();
        int ny = robot.getY();

        for (int i = 0; i < num; i++) {
            if(direction == 'E') {
                nx++;
            } else if(direction == 'W') {
                nx--;
            } else if(direction == 'S') {
                ny++;
            } else if(direction == 'N') {
                ny--;
            }
            
            if (nx >= 0 && ny >= 0 && ny < Y && nx < X) {
                if(map[ny][nx] == 'X') {
                    return;
                }
                
                if(i == num - 1) {
                    robot.setX(nx);
                    robot.setY(ny);
                }
            }
        }
    }

    class Robot {
        int y;
        int x;

        public Robot(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}