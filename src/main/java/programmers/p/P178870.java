package programmers.p;

class P178870 {
    public int[] solution(int[] sequence, int k) {
        int now = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int[] arr = {0,0};
        int sum = sequence[0];

        while(start <= end && end < sequence.length){
            if(sum == k){
                if(end-start+1<now){
                    now = end-start+1;
                    arr[0] = start;
                    arr[1] = end;
                }
                sum -= sequence[start];
                start++;
            }
            else if(sum < k){
                end++;
                if(end<sequence.length){
                    sum += sequence[end];
                }

            }else {
                sum -= sequence[start];
                start++;
            }

        }
        return arr;
    }
}