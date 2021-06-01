package labs.lab6;
import labs.models.IFuncX;
import labs.models.Point;
import java.util.ArrayList;

public class ShootingMethodMath {
    private static Double get_c1(ArrayList<ArrayList<Double>> y, double y2, int n) {
        return (y2 - y.get(0).get(n)) / y.get(1).get(n);
    }


    private static Double get_solv_y_i(ArrayList<ArrayList<Double>> y, double y2, int n, int i) {
        return y.get(0).get(i) + get_c1(y, y2, n) * y.get(1).get(i);
    }

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

//        for(ArrayList<Double> a : y){
//            String res = "";
//            for(Double d : a){
//                res +=d + " : ";
//            }
//            System.out.println(res);
//        }
        ArrayList<Double> y_res = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            y_res.add(get_solv_y_i(y, y2, n, i));
        }
        for(Double e : y_res){
            System.out.println(e);
        }


        ArrayList<Point> points = new ArrayList<>();
        for(int i = 0; i < x.size(); i++){
            points.add(new Point(x.get(i), y_res.get(i)));
        }
        return points;
    }
}