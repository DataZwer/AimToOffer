package CompanyTest.Vivo;

public class Test2 {
    public static void main(String[] args) {
        int a, b, c, d;
        a = 9;
        b = a++; // b = 9; a = 10
        c = ++a; // c = 11; a = 11
        d = 10*a++; // d = 110, a = 12
        System.out.println(a + " " + b + " " + c + " " + d);
    }

}
