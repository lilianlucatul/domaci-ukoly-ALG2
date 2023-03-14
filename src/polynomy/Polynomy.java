package polynomy;

/**
 *
 * @author Lilian Luca
 */
public class Polynomy {

    private Polynomy() {
    }

    /**
     * Metoda, která sčítá 2 polynomy.
     *
     * @param p1 -> 1. polynom.
     * @param p2 -> 2. polynom.
     * @return
     */
    static Polynom sumTwoPolynomials(Polynom p1, Polynom p2) {
        Polynom resPolynom;
        int maxLength = Math.max(p1.getCoefficients().length, p2.getCoefficients().length);
        int minLength = Math.min(p1.getCoefficients().length, p2.getCoefficients().length);
        double[] sumCoefficients = new double[maxLength];
        for (int i = p1.getCoefficients().length - 1; i >= 0; i--) {
            sumCoefficients[i] = p1.getCoefficients()[i];
        }
        int pos = 0;
        for (int i = sumCoefficients.length - 1; i >= maxLength - minLength; i--) {
            sumCoefficients[i] += p2.getCoefficients()[p2.getCoefficients().length - 1 - pos];
            pos++;
        }
        resPolynom = new Polynom(sumCoefficients);
        return resPolynom;
    }

    /**
     * Metoda, která násobí 2 polynomy.
     *
     * @param p1 -> 1. polynom.
     * @param p2 -> 2. polynom.
     * @return
     */
    static Polynom multiplyTwoPolynomials(Polynom p1, Polynom p2) {
        Polynom resPolynom;
        int newLength = p1.getCoefficients().length + p2.getCoefficients().length - 1;
        double[] newCoefficients = new double[newLength];
        for (int i = 0; i < p1.getCoefficients().length; i++) {
            for (int j = 0; j < p2.getCoefficients().length; j++) {
                newCoefficients[i + j] += p1.getCoefficients()[i] * p2.getCoefficients()[j];
            }
        }
        resPolynom = new Polynom(newCoefficients);
        return resPolynom;
    }

}
