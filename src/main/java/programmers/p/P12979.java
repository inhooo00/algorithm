package programmers.p;

class P12979 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        for(int i=0;i<stations.length;i++){
            if(i==0) {
                //System.out.println(cal(stations[i]-w,start,w,stations));
                answer += cal(stations[i]-w,start,w,stations);
                start = stations[i]+w+1;
                continue;
            }
            //System.out.println(cal(stations[i]-w,start,w,stations));
            answer += cal(stations[i]-w,start,w,stations);
            start = stations[i]+w+1;
        }
        if(stations[stations.length-1]+w < n){
            //System.out.println(cal(stations[stations.length-1]+w,n,w,stations));
            answer += cal(n+1,stations[stations.length-1]+w+1,w,stations);
        }
        return answer;
    }
    // 시작, 마지막, w, stations
    private int cal(int front, int start, int w, int[] stations) {
        int mod = w * 2 + 1;
        int len = front - start;
        int count = 0;
        if (len <= 0) {
            count = 0;
        } else if (len % mod == 0) {
            count = len / mod;
        } else {
            count = len / mod + 1;
        }
        return count;
    }

}