package designPattern.strategyPattern;

public class Client {
    public static void main(String[] args) {
        Strategy strategy = null;
        Soldier rambo = new Soldier();

        strategy = new StrategyGun();
        rambo.runContext(strategy);

        System.out.println();

        strategy = new StrategySword();
        rambo.runContext(strategy);

        System.out.println();

        strategy = new StrategyBow();
        rambo.runContext(strategy);

        System.out.println();
    }
}
