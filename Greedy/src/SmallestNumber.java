import java.util.*;
public class SmallestNumber {
    public static void main(String[] args) {
        int S=19;
        int D=4;
        if(S==0||S>D*9){
            System.out.println("hamse na hopayega");
            return;
        }
        S-=1;
        List<Integer> number=new ArrayList<>();
        for(int i=0;i<D;i++){
            number.add(0);
        }

        // right to left chalo
        for(int i=D-1;i>=0;i--){
            if(S>9){
                number.set(i,9);
                S-=9;
            }
            else{
                number.set(i,S);
                S=0;
                break;
            }
        }
        number.set(0,number.get(0)+1);
        System.out.println(number);

        String ans="";
        for(int i=0;i<number.size();i++){
            ans+=number.get(i);
        }
        int res=Integer.parseInt(ans);
        System.out.println(res);

        int pow=1;
        int result=0;
        for(int i=number.size()-1;i>=0;i--){
            result+= number.get(i)*pow;
            pow*=10;
        }
        System.out.println(result);
    }
}
