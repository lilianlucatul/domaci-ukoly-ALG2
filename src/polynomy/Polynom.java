package polynomy;

/**
 * Třída, která reprezentuje polynom.
 *
 * @author Lilian Luca
 */
public class Polynom {

    //koeficienty polynomu reprezentovány jako pole typu double
    private double[] coefficients;

    /**
     * Konstruktor s parametrem pole.
     *
     * @param coefficients
     */
    public Polynom(double[] coefficients) {
        this.coefficients = coefficients;
    }

    /**
     * Konstruktor pro vytváření polynomu nultého stupně.
     *
     * @param a1 -> koeficient 1. členu.
     */
    public Polynom(double a1) {
        this.coefficients = new double[1];
        this.coefficients[0] = a1;
    }

    /**
     * Konstruktor pro vytvoření polynomu prvního stupně.
     *
     * @param a1 -> koeficient 1. členu.
     * @param a2 -> koeficient 2. členu.
     */
    public Polynom(double a1, double a2) {
        this.coefficients = new double[2];
        this.coefficients[0] = a1;
        this.coefficients[1] = a2;
    }

    /**
     * Konstruktor pro vytvoření polynomu druhého stupně.
     *
     * @param a1 -> koeficient 1. členu.
     * @param a2 -> koeficient 2. členu.
     * @param a3 -> koeficient 3. členu.
     */
    public Polynom(double a1, double a2, double a3) {
        this.coefficients = new double[3];
        this.coefficients[0] = a1;
        this.coefficients[1] = a2;
        this.coefficients[2] = a3;
    }

    /**
     * Metoda která vrátí stupeň polynomu.
     *
     * @return
     */
    public int getDegreeOfPolynomial() {
        return coefficients.length - 1;
    }

    /**
     * Metoda (getter), která vrátí koeficienty polynomu.
     *
     * @return
     */
    public double[] getCoefficients() {
        return coefficients;
    }

    /**
     * Metoda, která vrátí požadovaný koeficient.
     *
     * @param coefficientIndex -> index požadovaného koeficientu.
     * @return
     */
    public double getSpecifiedCoefficient(int coefficientIndex) {
        if (coefficientIndex < coefficients.length) {
            return coefficients[coefficientIndex];
        } else {
            return 0;
        }
    }

    /**
     * Metoda pro výpočet hodnoty polynomu (hornerovo schéma).
     *
     * @param x -> pro která se má vypočítat hodnota polynomu.
     * @return
     */
    public double horner(int x) {
        double result = coefficients[0];

        for (int i = 1; i < coefficients.length; i++) {
            result = result * x + coefficients[i];
        }
        return result;
    }

    /**
     * Metoda pro derivaci polynomu.
     *
     * @return
     */
    public double[] derivate() {
        double[] newCoefficients = new double[coefficients.length - 1];
        for (int i = 0; i < coefficients.length - 1; i++) {
            newCoefficients[i] = (coefficients.length - i - 1) * coefficients[i];
        }
        coefficients = newCoefficients;
        return coefficients;
    }

    /**
     * Metoda, která poskytuje polynom ve vhodném tvaru.
     *
     * @return
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < coefficients.length - 1; i++) {
            String symbol;
            if (coefficients[i + 1] < 0) {
                symbol = "";
            } else {
                symbol = "+";
            }

            int n = coefficients.length - i - 1;
            switch (n) {
                case 1:
                    str += coefficients[i] + "x";
                    break;
                default:
                    str += coefficients[i] + "x^" + n + symbol;
                    break;
            }
        }
        if (coefficients[coefficients.length - 1] < 0) {
            str += coefficients[coefficients.length - 1];
        } else {
            str += "+" + coefficients[coefficients.length - 1];
        }
        return str;
    }
}
