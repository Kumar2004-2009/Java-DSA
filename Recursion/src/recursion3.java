import java.util.*;
public class recursion3 {
    // Palindrome
    static boolean isPalindrome(String s,int l,int r){
        if(l>=r) return true;
        return(s.charAt(l)==s.charAt(r) && isPalindrome(s, l+1, r+1) );
    }


    // Remove Occurence
    static String removeA2(String s){
        if(s.length()==0) return "";
        String smallAns= removeA2(s.substring(1));
        char currChar=s.charAt(0);
        if(currChar!='a'){
            return currChar+smallAns;
        }else{
            return smallAns;
        }
    }

    static String removeA(String s,int idx){
        if(idx==s.length()) return "";
        String smallAns=removeA(s,idx+1);
        char currChar=s.charAt(idx);
        if(currChar!='a'){
            return currChar+ smallAns;
        }else{
            return smallAns;
        }
    }



    // Reverse
    static String reverse(String s,int idx){
        if(idx==s.length())  return "";
        String smallAns=reverse(s,idx+1);
        return smallAns+s.charAt(idx);
    }


    public static void main(String[] args) {

        // Palindrome
        // Scanner sc=new Scanner(System.in);
        // String s= sc.nextLine();
        // System.out.println(isPalindrome(s, 0, s.length()-1));


        // RemoveOcuurence
        // Scanner sc=new Scanner(System.in);
        // String s= sc.nextLine();
        // System.out.println(removeA(s,0));
        // System.out.println(removeA2(s));


        // Reverse
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        String rev=reverse(s,0);
        if(rev.equals(s)){
            System.out.printf("%s is Palindrome",s);
        }else{
            System.out.printf("%s is not palindrome",s);
        }
    }
}
