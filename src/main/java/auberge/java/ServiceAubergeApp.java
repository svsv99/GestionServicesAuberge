package auberge.java;

import auberge.java.controller.OperateurController;

public class ServiceAubergeApp {
    public static void main(String[] args) {
        System.out.println("initialisation application");
        OperateurController operateurController = new OperateurController();
        operateurController.process();
    }
}
