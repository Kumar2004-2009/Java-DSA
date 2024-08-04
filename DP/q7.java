// ninja's Trainig
import java.util.*;
public class q7 {
    public static void main(String[] args) {
        int[][] a={{10,50,1},{5,100,11}};

        System.out.println(rec(a,a.length-1,3));
        int[][] dp=new int[a.length][4];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<=3;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(mem(a,a.length-1,3,dp));


        // Tabulation
        int[][] dp1=new int[a.length][4];
        dp1[0][0]=Math.max(a[0][1],a[0][2]);
        dp1[0][1]=Math.max(a[0][0],a[0][2]);
        dp1[0][2]=Math.max(a[0][0],a[0][1]);
        dp1[0][3]=Math.max(Math.max(a[0][1],a[0][2]),a[0][0]);

        for(int days=1;days<a.length;days++){
            for(int last=0;last<4;last++){
                dp1[days][last]=0;
                
                for(int task=0;task<3;task++){
                    if(task!=last){
                        int point=a[days][task]+dp1[days-1][task];
                        dp1[days][last]=Math.max(dp1[days][last], point);
                    }
                }
            }
        }
        System.out.println(dp1[a.length-1][3]);


        // Space Optimization
        int[] prev=new int[4];
        prev[0]=Math.max(a[0][1],a[0][2]);
        prev[1]=Math.max(a[0][0],a[0][2]);
        prev[2]=Math.max(a[0][0],a[0][1]);
        prev[3]=Math.max(Math.max(a[0][1],a[0][2]),a[0][0]);

        for(int days=1;days<a.length;days++){
            int[] temp=new int[4];
            for(int last=0;last<4;last++){
                temp[last]=0;
                
                for(int task=0;task<3;task++){
                    if(task!=last){
                        int point=a[days][task]+prev[task];
                        temp[last]=Math.max(temp[last], point);
                    }
                }
            }
            prev=temp;
        }
        System.out.println(prev[3]);

    }
    public static int mem(int[][] a,int day,int last,int[][] dp){
        if(day==0){
            int max=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    max=Math.max(max,a[0][i]);
                }
            }
            return max;
        }
        if(dp[day][last]!=-1) return dp[day][last];
        int max=0;
        for(int i=0;i<3;i++){
            int points=-1;
            if(i!=last){
                points=a[day][i]+mem(a, day-1, i,dp);
            }
            max=Math.max(points,max);
        }
        return dp[day][last]=max;
    }
    public static int rec(int[][] a,int days,int last){
        if(days==0){
            int max=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    max=Math.max(max,a[0][i]);
                }
            }
            return max;
        }

        int max=0;
        for(int i=0;i<3;i++){
            int points=-1;
            if(i!=last){
                points=a[days][i]+rec(a, days-1, i);
            }
            max=Math.max(points,max);
        }
        return max;
    }
}
