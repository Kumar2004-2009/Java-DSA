import java.util.ArrayList;
import java.util.List;

public class LargestPalindromicNo {
    public static void main(String[] args) {
        String number="00001105";
        List<Integer> frequency=new ArrayList<>();
        for(int i=0;i<10;i++){
            frequency.add(0);
        }
        int n=number.length();
        for(int i=0;i<n;i++){   //O(n)
            int digit=number.charAt(i)-'0';
            frequency.set(digit, frequency.get(digit)+1);
        }
        if(!validates(frequency)){
            System.out.println("Not palinndrome possible");
            return;
        }
        String firsthalf="";
        for(int i=9;i>=0;i--){  //O(n)
//            first half creation
            while(frequency.get(i)>1){
                firsthalf+=i;   //+ operator apne aap convert kardega int ko string
                frequency.set(i,frequency.get(i)-2);
            }
        }
        StringBuilder sb=new StringBuilder(firsthalf);
        sb.reverse();
        String secondhalf=sb.toString();
        for(int i=9;i>=0;i--){
            if(frequency.get(i)==1){
                firsthalf+=i;
            }
        }
        String result=firsthalf+secondhalf;
        System.out.println(result);
    }

    private static boolean validates(List<Integer> frequency) {
        boolean isOdd=false;
        for(int i=0;i<frequency.size();i++){
            if(frequency.get(i)%2!=0){
                if(isOdd==true){
                    return false;
                }
                isOdd=true;
            }
        }
        return true;
    }
}
