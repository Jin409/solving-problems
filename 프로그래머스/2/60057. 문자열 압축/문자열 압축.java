class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        // 완전 탐색
        for(int n = s.length(); n>0; n--){
            String[] splitS = getSplitS(s, n);
            answer = Math.min(getAnswer(splitS), answer);
        }
        
        return answer;
    }
    
    private int getAnswer(String[] splitS){
        String before = splitS[0];
        int count = 1;
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<splitS.length; i++){
            if(before.equals(splitS[i])){
                count++;
            }else{ // 연속이 끊긴 경우
                if(count > 1){
                    sb.append(Integer.valueOf(count));
                    count = 1;
                }
                sb.append(before);
            }
            
            before = splitS[i];
        }
        
//         System.out.println("====");
//         System.out.println(splitS[0].length());
//         System.out.println(sb);
        
        if(count > 1){
            sb.append(Integer.valueOf(count));
        }
        sb.append(before);
        
        // System.out.println(sb);
        
        return sb.length();
    }
    
    private String[] getSplitS(String s, int n){
        String[] splitS = new String[(int) Math.ceil((double) s.length() / n)];
        
        int count = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            sb.append(Character.toString(s.charAt(i)));
            
            if(sb.length() == n){
                splitS[count] = sb.toString();
                count++;
                sb = new StringBuilder();
            }
        }
        
        if(sb.length() > 0){
            splitS[count] = sb.toString();
        }
        
        return splitS;
    }
}