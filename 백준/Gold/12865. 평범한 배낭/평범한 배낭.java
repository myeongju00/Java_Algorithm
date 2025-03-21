import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] weight;
    static int[] value;
    static int maxWeight;

    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        maxWeight = Integer.parseInt(st.nextToken());

        weight = new int[n+1];
        value = new int[n+1];
        dp = new Integer[n+1][maxWeight + 1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack_bu());


    }
    static int knapsack_bu(){
        for(int w = 0; w <= maxWeight; w++){
            dp[0][w] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int w = 0; w <= maxWeight; w++){
                if(weight[i] > w){
                    dp[i][w] = dp[i-1][w];
                }
                else{
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - weight[i]] + value[i]);
                }
            }
        }
        return dp[n][maxWeight];
    }
}
