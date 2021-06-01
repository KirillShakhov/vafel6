package labs;

import labs.lab6.commands.ShootingMethod;

public class Bootstrap {
    public static void main(String[] args) {
        System.out.println("Решение краевой задачи для ОДУ первого порядка методом пристрелки.");
        ShootingMethod.execute();
    }
}
