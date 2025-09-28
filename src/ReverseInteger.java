public class ReverseInteger {
    public static int caculateRevInteger(int x) {
                 int nrev=0;
                int rev=0;
                while(x!=0)
                {
                    int r=x%10;
                    nrev=rev*10+r;
                    if((nrev-r)/10!=rev)
                        return 0;
                    rev=nrev;
                    x=x/10;
                }
                return rev;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(caculateRevInteger(x));
    }

}
