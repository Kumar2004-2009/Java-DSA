// valid parenthesis
public class q11 {
    public static void main(String[] args) {
        String s="()";
        boolean ans=valid(s);
        System.out.println(ans);
    }
    private static boolean valid(String s){
        int min=0;
        int max=0;
        int n=s.length();

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }
            else if(s.charAt(i)==')'){
                min--;
                max--;
            }
            else{
                min=min-1;
                max=max+1;
            }
            if(min<0) min=0;

            if(max<0) return false;
        }
        if(min==0) return true;
        return false;
    }
}
