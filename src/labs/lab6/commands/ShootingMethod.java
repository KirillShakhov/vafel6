package labs.lab6.commands;
import labs.lab6.ShootingMethodMath;
import labs.models.IFuncX;
import labs.models.Point;
import labs.modules.GraphModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShootingMethod {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<IFuncX> fp = new ArrayList<>();
        ArrayList<IFuncX> fq = new ArrayList<>();
        ArrayList<IFuncX> ff = new ArrayList<>();
        System.out.println("Выберите уравнение:");
        // 1
        System.out.println("1. x^(-2) y' + x^3 y = e^x");
        fp.add(x -> Math.pow(x, -2));
        fq.add(x -> Math.pow(x, 3));
        ff.add(x -> Math.pow(Math.E, x));
        // 2
        System.out.println("2. x^2 y' + 2y  = 2x - 1");
        fp.add(x -> Math.pow(x, 2));
        fq.add(x -> 2.0);
        ff.add(x -> 2 * x - 1);
        System.out.println("3. y' = 3*e^x");
        fp.add(x -> 1.0);
        fq.add(x -> 1.0);
        ff.add(x -> 3 * Math.pow(Math.E, x));
        //
        IFuncX p, g, f;
        while (true) {
            try {
                int t = Integer.parseInt(scanner.nextLine())-1;
                p = fp.get(t);
                g = fq.get(t);
                f = ff.get(t);
                break;
            } catch (Exception e) {
                System.out.println("Нет такого уравнения");
            }
        }
        System.out.println("Введите концы промежутка через пробел (хa x_b)");
        String[] x = scanner.nextLine().split(" ");
        double x_a = Double.parseDouble(x[0]);
        double x_b = Double.parseDouble(x[1]);
        System.out.println("Введите начальные условия через пробел (y_a уb)");
        String[] y = scanner.nextLine().split(" ");
        double y_a = Double.parseDouble(y[0]);
        double y_b = Double.parseDouble(y[1]);
        System.out.println("Введите точность");
        double eps = Double.parseDouble(scanner.nextLine());
        ArrayList<Point> xy = ShootingMethodMath.solve(p, g, f, x_a, x_b, y_a, y_b, eps);
        Map<String, ArrayList<Point>> funcs = new HashMap<>();
        funcs.put("Результат", xy);
        new GraphModule(funcs);
    }
}
