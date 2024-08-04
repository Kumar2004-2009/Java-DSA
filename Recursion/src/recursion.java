public class recursion {
    // print 1 to n
    static void printNumber(int n){
        if(n==1){
            System.out.println(1);
        }
        printNumber(n-1);
        System.out.println(n);
    }


    // print n to 1
    static void printRever(int n){
        if(n==1) System.out.println(1);
        System.out.println(n);
        printRever(n-1);
    }




    // find the factorial
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        int fact=n*factorial(n-1);
        return fact;
    }



    // print the fibonacci series
    //  static int fib(int n){
    //     if(n<=1){
    //         System.out.println(n);
    //     }else{
    //         return (fib(n-1)+fib(n-2));
    //     }
    // }


    // find the sum of the digits using recursion
    static int func(int n){
        if(n==0){
            return 0;
        }
        return (n%10+func(n/10));
    }




    // find the vlaue of a^b  O(b)
    static int power(int a, int b){
        if(b==0){
            return 1;
        }
        if(a==0){
            return 0;
        }
        return(a*power(a, b-1));
    }



    // power efficient approach  O(logb)

    static int power2(int a, int b){
        if(b==0){
            return 1;
        }
        if(a==0){
            return 0;
        }
        if(b%2==0){
            int result=power2(a, b/2);
            return result*result;
        }
        else{
            int result=power(a, (b-1)/2);
            return result*result;
        }
    }

//    for b== negative number
    public static double pow(double x,int b){
        if(b<0){
            x=1/x;
        }
        double po=1;
        while(b!=0){
            if((b%2)!=0)
                po*=x;
            x*=x;
            b=b/2;
        }
        return po;
    }



    // calculate GCD of two numbers
    static int iGCD(int x,int y){
        while(x%y!=0){
            int rem=x%y;
            x=y;
            y=rem;
        }
        return y;
    }

    // method 2
    static int gcd(int x,int y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }



    // print all the elements of the array
    static void printArray(int[] a,int idx){
        if(idx==a.length){
            return;
        }
        System.out.println(a[idx]);
        printArray(a, idx+1);
    }
    public static void main(String[] args) {
        // printNumber(5);
        // printRever(5);
        // System.out.println(factorial(5));
        // System.out.println(fib(8));
        System.out.println(func(1234));
    }
}


