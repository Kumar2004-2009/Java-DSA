// Lemonade change Problem
public class q2 {
    public static void main(String[] args) {
        int[] bills={5,5,5,10,20};
        System.out.println(satisfies(bills));
    }

    private static boolean satisfies(int[] bills) {
       int cnt5=0;
       int cnt10=0;
       int cnt20=0;

       int i=0;
       while(i<bills.length){
        int ele=bills[i];

        if(ele==5){
            cnt5++;
        }
        else if(ele==10){
            if(cnt5<1){
                return false;
            }
            cnt5--;
            cnt10++;
        }
        else{
            cnt20++;
            if(cnt5<1){
                return false;
            }
            else if(cnt5>2){
                cnt5-=3;
            }
            else if(cnt10<1){
                return false;
            }
            else if(cnt5<2 && cnt10>1){
                cnt5-=1;
                cnt10--;
            }
        }
        i++;
       }
       return true;
    }
}
