import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boolean result = Search(Integer.parseInt(st.nextToken()));
            if (result)
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    private static boolean Search(int num){
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while(left <= right){
            mid = (left + right) / 2;
            if(arr[mid] < num)
                left = mid + 1;
            else if(arr[mid] > num)
                right = mid - 1;
            else
                return true;
        }
        return false;
    }
}