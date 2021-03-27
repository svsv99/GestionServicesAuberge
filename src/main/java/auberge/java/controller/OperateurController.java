package auberge.java.controller;

import auberge.java.main.Main;
import auberge.java.repository.IChambreRepository;
import auberge.java.repository.IClientRepository;
import auberge.java.repository.ILocationRepository;
import auberge.java.repository.IReservationRepository;
import auberge.java.repository.jdbc.*;
import auberge.java.service.DisplayService;
import auberge.java.service.console.ConsoleDisplayService;
import auberge.java.service.console.ScannerMenuService;


public class OperateurController {
    //private final MenuService scannerMenuService;
    private final DisplayService displayService;
    private final ScannerMenuService scannerMenuService;
    IReservationRepository iReservationRepository;
    IClientRepository iClientRepository;
    IChambreRepository iChambreRepository;
    ILocationRepository iLocationRepository;
    ChambreController chambreController = new ChambreController();
    ClientController clientController = new ClientController();
    ReservationController reservationController = new ReservationController();
    LocationController locationController = new LocationController();
    public OperateurController() {
        DataSource dataSource = new MysqlDataSource();
        displayService = new ConsoleDisplayService();
        iReservationRepository = new JdbcBasedReservationRepository(dataSource);
        iClientRepository = new JdbcBasedClientRepository(dataSource);
        iChambreRepository = new JdbcBasedChambreRepository(dataSource);
        iLocationRepository = new JdbcBasedLocationRepository(dataSource);
        scannerMenuService = new ScannerMenuService(displayService, iLocationRepository, iReservationRepository, iChambreRepository, iClientRepository);
    }
    public void process(){
        int choix = -1;
        while(choix != 5)
        {
            Main.clrscr();
            displayService.afficherBienvenu();
            displayService.afficherMenuPrincipal();
            choix = scannerMenuService.faireChoixMenu(5);
            switch(choix)
            {
                case 1:
                    chambreController.process();
                    break;
                case 2:
                    clientController.process();
                    break;
                case 3:
                    reservationController.process();
                    break;
                case 4:
                    locationController.process();
                    break;
            }
        }

    }
}
