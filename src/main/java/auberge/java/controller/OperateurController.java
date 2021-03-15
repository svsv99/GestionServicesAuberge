package auberge.java.controller;

import auberge.java.repository.ILocationRepository;
import auberge.java.repository.IReservationRepository;
import auberge.java.repository.jdbc.DataSource;
import auberge.java.repository.jdbc.JdbcBasedLocationRepository;
import auberge.java.repository.jdbc.JdbcBasedReservationRepository;
import auberge.java.repository.jdbc.MysqlDataSource;
import auberge.java.service.console.ConsoleDisplayService;
import auberge.java.service.console.ScannerMenuService;
import auberge.java.service.DisplayService;
import auberge.java.service.MenuService;


public class OperateurController {
    private final MenuService scannerMenuService;
    private final DisplayService displayService;


    public OperateurController() {
        DataSource dataSource = new MysqlDataSource();
        displayService = new ConsoleDisplayService();
        ILocationRepository iLocationRepository = new JdbcBasedLocationRepository(dataSource);
        IReservationRepository ireservationRepository = new JdbcBasedReservationRepository(dataSource);
        scannerMenuService = new ScannerMenuService(displayService,iLocationRepository, ireservationRepository);
    }
    public void process(){
        displayService.afficherBienvenu();
        displayService.afficherMenuPrincipal();
        scannerMenuService.afficherMenu();
    }
}
