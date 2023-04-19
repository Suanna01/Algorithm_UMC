import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 입력
        long S = Long.parseLong(st.nextToken()); // 합의 판단 기준
        st = new StringTokenizer(br.readLine());
        int[] Narr = new int[N];
        for(int i = 0; i < N; i++){
            Narr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 100001, sum = 0;
        int firstPointer = 0, secondPointer = 0;
        while(true){
            if(sum >= S){ // sum(부분합)의 값이 S보다 커지면 first 포인터 움직이기
                sum -= Narr[firstPointer++];
                ans = Math.min(ans, (secondPointer - firstPointer) + 1);
            }
            else if(secondPointer == N) break; // second 포인터를 마지막까지 옮기면 멈춤
            else sum += Narr[secondPointer++]; // S보다 커질때까지 second 포인터를 옮김
        }
        if(ans == 100001){
            bw.write(0 + "\n");
        } else {
            bw.write(ans + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
