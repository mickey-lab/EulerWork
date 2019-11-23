public class Euler39 {

    public static void main(String[] args) {
        int maxC = 0;
        int maxP = 0;
        int combinations;
        for (int i = 3; i <= 1000; i++) {
            combinations = combCount(i);
            if(combinations>maxC){
                maxC = combinations;
                maxP = i;
            }
        }
        System.out.println(maxP);
    }

    public static int combCount(int p){
        int n = 0;
        int k;
        for (int i = p/3; i < p/2; i++) {
            for(int j = p/3; j < i; j++){
                k = p-i-j;
                if(i+j>k && i+k>j && j+k>i && i==Math.sqrt(j*j+k*k)){
                    n++;
                }
            }
        }
        return n;
    }

    
}
