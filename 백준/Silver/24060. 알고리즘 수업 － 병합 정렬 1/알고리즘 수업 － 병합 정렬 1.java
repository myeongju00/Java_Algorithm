import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] tmp; //정렬 후 저장하는 배열
    static int result = -1;
    static int cnt = 0;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){ //배열의 요소 입력 받기
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, N - 1);

        System.out.println(result);
    }

    //오름차순 정렬
    static void merge_sort(int[] arr, int p, int r){
        //저장 횟수가 진행 횟수보다 넘어가게 되면 더이상 분해 or 병합 진행X
        if(cnt > K) return;
        if(p < r){
            int q = (p + r) / 2;
            merge_sort(arr, p, q);   //전반부 정렬
            merge_sort(arr, q + 1, r); //후반부 정렬
            merge(arr, p, q, r);
        }
    }
    static void merge(int[] arr, int startIdx, int midIdx, int endIdx){
        int i = startIdx;
        int j = midIdx + 1; //쪼갠 배열(2번째) 시작 인덱스
        int t = 0;

        //시작 인덱스가 중간 인덱스(1번쨰)보다 작고,
        //중간인덱스(2번째)가 마지막인덱스보다 작을 경우 반복
        while (i <= midIdx && j <= endIdx) {
            if (arr[i] < arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        //다 정렬하고도 남은 경우
        while(i <= midIdx){ //왼쪽
            tmp[t++] = arr[i++]; //tmp배열에 저장
        }
        while(j <= endIdx){ //오른쪽
            tmp[t++] = arr[j++]; //tmp배열에 저장
        }

        i = startIdx;
        t = 0;
        while(i <= endIdx){
            //결과를 배열 A에 저장. i(시작), r(끝)
            cnt++;
            if(cnt == K){ //저장횟수가 같다면
                result = tmp[t]; //해당 증가한 만큼의 t인덱스의 값을 result변수에 담고
                break;
            }
            arr[i++] = tmp[t++]; //A에 순서대로 정렬된 값을 저장
        }
    }
}