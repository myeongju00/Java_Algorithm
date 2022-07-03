import java.io.*;
import java.util.*;


class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringBuilder sb = new StringBuilder(input);
            arr[i] = sb.reverse().toString();
        }
        // 문자열의 길이를 기준으로 내림차순 정렬
        Arrays.sort(arr, ((o1, o2) -> o2.length() - o1.length()));

        // key : 알파벳, value : 알파벳에 곱해지는 값.
        Map<Character, Integer> map = new HashMap<>();
        int start = arr[0].length() - 1; // 가장 큰 자리수.

        for (int i = start; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                // 현재 자리 수보다 문자열의 길이가 짧은 경우.
                if (i >= arr[j].length()) {
                    break;
                }

                char c = arr[j].charAt(i);

                if(!map.containsKey(c)) {
                    map.put(c, (int) Math.pow(10, i));
                } else {
                    map.put(c, map.get(c) + (int) Math.pow(10, i));
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        // list에 map value를 담기
        for (char c : map.keySet()) {
            list.add(map.get(c));
        }

        // 내림차순 정렬.
        list.sort(Collections.reverseOrder());

        int num = 9;
        int answer = 0;

        // 곱해지는 값이 가장 큰 알파벳에 큰 수 할당
        for (Integer integer : list) {
            answer += integer * num--;
        }

        System.out.println(answer);
    }
}