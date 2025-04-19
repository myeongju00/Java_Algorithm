class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] now = new int[2];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    now[0] = i;
                    now[1] = j;
                }
            }
        }

        for(String route : routes) {
            String dir = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);
            int[] next = move(now, dir, distance, park);
            if(next[0] != -1 && next[1] != -1) {
                now = next;
            }
        }
        return now;
    }
    public int[] move(int[] start, String dir, int distance, String[] park) {
        int x = start[0];
        int y = start[1];
        for(int i = 0; i < distance; i++) {
            switch (dir) {
                case "N":
                    x--;
                    break;
                case "S":
                    x++;
                    break;
                case "E":
                    y++;
                    break;
                case "W":
                    y--;
                    break;
            }
            if(x < 0 || y < 0 || x >= park.length || y >= park[0].length()
                    || park[x].charAt(y) == 'X') {
                return new int[]{-1, -1};
            }
        }

        return new int[]{x, y};
    }
}