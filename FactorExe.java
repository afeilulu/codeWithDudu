

public class FactorExe {

    public static void main(String[] args) throws Exception {

        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        int m = Integer.parseInt(args[3]);
        int n = Integer.parseInt(args[4]);

        FactorExe exe = new FactorExe();

        switch (args[0]) {
            case "+":
                exe.plus(a,b,m,n);
                break;
            
            case "-":
                exe.minus(a,b,m,n);
                break;
                
            case "x":
                exe.multiply(a,b,m,n);
                break;

            case "/":
                exe.divide(a,b,m,n);
                break;
        }
    }

    // a/b + m/n
    private void plus(int a,int b,int m,int n){
        simplifyFraction(a*n + b*m, b*n);
    }

    // a/b - m/n
    private void minus(int a,int b,int m,int n){
        if (a*n < b*m){
            System.out.print("-");
            simplifyFraction(b*m - a*n,b*n);
        } else {
            simplifyFraction(a*n - b*m,b*n);
        }
    }

    // a/b * m/n
    private void multiply(int a,int b,int m,int n){
        simplifyFraction(a*m,b*n);
    }

    // a/b / m/n
    private void divide(int a,int b,int m,int n){
        simplifyFraction(a*n,b*m);
    }

    private int biggestFactor(int a, int b){
        int factor =1;
        int smaller = a<b? a:b;
        for (int i=1;i<=smaller;i++){
            if (a%i==0 && b%i==0){
                factor = i;
            }
        }
        return factor;
    }

    private void simplifyFraction(int a, int b){
        int factor = biggestFactor(a, b);
        if (factor ==1){
            if (a==1 && b==1){
                System.out.println("1");
            } else if (b==1){
                System.out.println(a);
            } else {
                System.out.println(a + "/" + b);
            }
            return;
        } else {
            a = a / factor;
            b = b / factor;
            simplifyFraction(a, b);
        }
    }

}