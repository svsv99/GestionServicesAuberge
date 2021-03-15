package auberge.java.service.console;

import auberge.java.domain.Location;
import auberge.java.domain.Reservation;
import auberge.java.repository.ILocationRepository;
import auberge.java.repository.IReservationRepository;
import auberge.java.service.DisplayService;
import auberge.java.service.MenuService;

import java.util.Scanner;

public class ScannerMenuService implements MenuService {
    private final DisplayService displayService;
    private final Scanner scanner;
    private final ILocationRepository ilocationRepository;
    private final IReservationRepository ireservationRepository;

    public ScannerMenuService(DisplayService displayService, ILocationRepository ilocationRepository, IReservationRepository ireservationRepository) {
        this.displayService = displayService;
        this.ireservationRepository = ireservationRepository;
        this.scanner = new Scanner(System.in);
        this.ilocationRepository = ilocationRepository;
    }
    private String lireChoix() {
        return scanner.next();
    }


    public void afficherMenu(String choix) {
        Location[] locations = ilocationRepository.getAll();
        if("1".equalsIgnoreCase(choix)){
            displayService.afficherListeLocation(locations);
        }
        /*else if ("2".equalsIgnoreCase(choix)){
            System.out.println("SAISIR LE MATRICULE A RECHERCHER");
            int idLocation = scanner.nextInt();
            Location location = ilocationRepository.getById(idLocation);
            if(location== null){
                System.out.println("AUCUN LOCATION TROUVE");
            }else{
displayService.afficherListeLocation(locations);            }

         */

        else if ("2".equalsIgnoreCase(choix)){

            Reservation[] reservations = ireservationRepository.getAll();
            displayService.afficherListeReservation(reservations);

        }
        else {
            displayService.afficherOptionInconnue();
        }
    }
    public void afficherMenu(){
        String choix = lireChoix();
        afficherMenu(choix);
    }


}
