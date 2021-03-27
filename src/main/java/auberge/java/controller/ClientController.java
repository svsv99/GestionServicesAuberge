package auberge.java.controller;

import auberge.java.main.Main;
import auberge.java.repository.IChambreRepository;
import auberge.java.repository.IClientRepository;
import auberge.java.repository.ILocationRepository;
import auberge.java.repository.IReservationRepository;
import auberge.java.repository.jdbc.*;
import auberge.java.service.DisplayService;
import auberge.java.service.MenuService;
import auberge.java.service.console.ConsoleDisplayService;
import auberge.java.service.console.ScannerMenuService;

public class ClientController {
    private final DisplayService displayService ;
    private final MenuService scannerMenuService ;
    IReservationRepository iReservationRepository;
    IClientRepository iClientRepository;
    IChambreRepository iChambreRepository;
    ILocationRepository iLocationRepository;
    public ClientController(){
        DataSource dataSource = new MysqlDataSource();
        iReservationRepository = new JdbcBasedReservationRepository(dataSource);
        iClientRepository = new JdbcBasedClientRepository(dataSource);
        iChambreRepository = new JdbcBasedChambreRepository(dataSource);
        iLocationRepository = new JdbcBasedLocationRepository(dataSource);
        displayService = new ConsoleDisplayService();
        scannerMenuService = new ScannerMenuService(displayService, iLocationRepository,  iReservationRepository, iChambreRepository, iClientRepository);
    }

    public void process()
    {
        int choix = -1;
        while(choix != 5)
        {
            Main.clrscr();
            displayService.afficherMenuClient();
            choix = scannerMenuService.faireChoixSousMenu(5);
            switch(choix)
            {
                case 1:
                    Main.clrscr();
                    scannerMenuService.ajoutClient();
                    break;
                case 2:
                    Main.clrscr();
                    displayService.afficherListeClients(iClientRepository.getAll());
                    scannerMenuService.pause();
                    break;
                case 3:
                    Main.clrscr();
                    scannerMenuService.rechercherClient();
                    scannerMenuService.pause();
                    break;
                case 4:
                    Main.clrscr();
                    scannerMenuService.supprimerClient();
                    break;
            }
        }
    }
}
