package labs.lab6;
import labs.models.IFuncX;
import labs.models.Point;
import java.util.ArrayList;

public class ShootingMethodMath {
    public static ArrayList<Point> solve(IFuncX p, IFuncX q, IFuncX f, double x1, double x2, double y1, double y2, double eps) {
        ArrayList<ArrayList<Double>> y = new ArrayList<>();
        int n = (int) Math.ceil((x2 - x1)/eps);
        double h = (x2 - x1) / n;
        double D0 = y1 + h;
        double D1 = h;
        ArrayList<Double> t1 = new ArrayList<>();
        t1.add(y1);
        t1.add(D0);
        ArrayList<Double> t2 = new ArrayList<>();
        t2.add(0.0);
        t2.add(D1);
        y.add(t1);
        y.add(t2);

        ArrayList<Double> x = new ArrayList<>();
        for(double i = x1; i <= x2; i+=h){
            x.add(i);
        }

        for (int i = 1; i < n; i++) {
            y.get(0).add((Math.pow(h, 2) * f.solve(x.get(i)) - (1.0 - (h / 2) * p.solve(x.get(i))) * y.get(0).get(i - 1) - (Math.pow(h, 2) * q.solve(x.get(i)) - 2) * y.get(0).get(i))/(1 + h / 2 * p.solve(x.get(i))));
            y.get(1).add((-(1 - h / 2 * p.solve(x.get(i))) * y.get(1).get(i - 1) - (Math.pow(h, 2) * q.solve(x.get(i)) - 2) * y.get(1).get(i))/ (1 + h / 2 * p.solve(x.get(i))));
        }
        ArrayList<Point> points = new ArrayList<>();
        return points;
    }
}