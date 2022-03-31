public class Triangle {

    public static void main(String[] args) {

        tr(3, 4, 5);

    }

    public static double tr(int a, int b, int c) {

        double p = ((double)(a+b+c))/2;

        if (p <= a || p <= b || p <= c || a*b*c==0) {

            return -1;
        }
        double S = Math.sqrt(p*(p - a)*(p - b)*(p - c));


        return S;
    }

}