public class Propuesto_12 {

    public static void run() {

        float h = 48;
        float h_cost = 5000f;

        float gross_salary = gross_salary_calculator(h, h_cost);
        float tax = tax_calculator(gross_salary);
        float net_salary = net_salary_calculator(gross_salary, tax);

        System.out.println("Salario bruto: $" + gross_salary);
        System.out.println("Impuestos (12.5%): $" + tax);
        System.out.println("Salario neto: $" + net_salary);
    }

    private static float gross_salary_calculator(float h, float h_cost) {
        return h * h_cost;
    }

    private static float tax_calculator(float gross_salary) {
        float taxRate = 12.5f;
        return gross_salary * taxRate / 100;
    }

    private static float net_salary_calculator(float gross_salary, float tax) {
        return gross_salary - tax;
    }
}
