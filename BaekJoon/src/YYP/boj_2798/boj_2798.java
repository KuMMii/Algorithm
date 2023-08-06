package YYP.boj_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class boj_2798{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] NandM=br.readLine().split(" ");
        String[] cardStr=br.readLine().split(" ");
        int[] cards=new int[cardStr.length];
        for(int i=0; i<cards.length;i++) {
        	cards[i]=Integer.parseInt(cardStr[i]);
        }
        
        Arrays.sort(cards);
        for(int i=cards.length-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                if(j!=i){
                    for(int k=j-1; k>=0; k--){
                        if(k!=i && k!=j){
                        	int a=cards[i];
                        	int b=cards[j];
                        	int c=cards[k];
                        	int sum=a+b+c;
                        	int target=Integer.parseInt(NandM[1]);
                            if(sum<=target){
                                System.out.println(cards[i]+cards[j]+cards[k]);
                                return;
                            }
                        }
                    }
                }
            }    
        }
    }
}
