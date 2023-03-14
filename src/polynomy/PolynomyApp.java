package polynomy;

import java.util.Arrays;

/**
 *
 * @author Lilian Luca
 */
public class PolynomyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] coefficients1 = {9, 5, 2, 0, -1}; //9x^4+5x^3+2x^2-1
        double[] coefficients2 = {1, 5, -6}; //x^2+5x-6

        Polynom p1 = new Polynom(coefficients1);
        Polynom p2 = new Polynom(coefficients2);

        Polynom p3 = Polynomy.sumTwoPolynomials(p1, p2); //výsledek po sečtení 2 polynomů.
        System.out.println(p3);
        Polynom p4 = Polynomy.multiplyTwoPolynomials(p1, p2); //výsledek po násobení 2 polynomů.
        System.out.println(p4);
    }

}
