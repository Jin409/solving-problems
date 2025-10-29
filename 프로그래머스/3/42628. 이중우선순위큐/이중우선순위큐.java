import java.util.*;

class Solution{
    public int[] solution(String[] operations) {
        
        Queue<Integer> qa = new PriorityQueue<>();
        
        // 역정렬
        Queue<Integer> qb = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1; 
            }
        });
            
        for(String operation : operations){
            String[] s = operation.split(" ");
            
            // System.out.println("=====");
            // System.out.println(operation);
            // System.out.println("최소힙: "+qa);
            // System.out.println("최대힙: "+qb);
            
            if(s[0].equals("I")){
                int number = Integer.parseInt(s[1]);
                qa.offer(number);
                qb.offer(number);
            }
            
            if(s[0].equals("D") && s[1].equals("1")){
                
                // 두 큐에 모두 있어야 유효 -> 두 큐 중 하나에라도 없으면 그냥 꺼내버리기
                while(!qb.isEmpty()){
                    int top = qb.peek();
                    
                    if(qa.isEmpty() || !qa.contains(top)){
                        qb.poll();
                    }else{
                        break;
                    }
                }
                
                if(!qb.isEmpty()){
                    qb.poll();
                }
            }
            
            if(s[0].equals("D") && s[1].equals("-1")){
                if(qa.isEmpty()){
                    continue;
                }
                
                // 두 큐에 모두 있어야 유효 -> 두 큐 중 하나에라도 없으면 그냥 꺼내버리기
                while(!qa.isEmpty()){
                    int top = qa.peek();
                    
                    if(qb.isEmpty() || !qb.contains(top)){
                        qa.poll();
                    }else{
                        break;
                    }
                }
                
                 if(!qa.isEmpty()){
                    qa.poll();
                }

            }
        }
        
        if(qa.isEmpty() && qb.isEmpty()){
            return new int[]{0,0};
        }
        
        // System.out.println("결과 최소힙: "+qa);
        // System.out.println("결과 최대힙: "+qb);
        
        int max = 0;
        while(!qb.isEmpty()){
            int top = qb.poll();
            
            if(qa.contains(top)){
                max = top;
                break;
            }
        }
        
        int min = max;
        while(!qa.isEmpty()){
            int top = qa.poll();
            
            if(qb.contains(top)){
                min = top;
                break;
            }
        }
    
        return new int[]{max, min};
    }
}

