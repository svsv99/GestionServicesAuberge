package auberge.java.main;

import auberge.java.repository.IChambreRepository;
import auberge.java.repository.IClientRepository;
import auberge.java.repository.ILocationRepository;
import auberge.java.repository.IReservationRepository;
import auberge.java.repository.jdbc.*;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        DataSource dataSource = new MysqlDataSource();
        //JdbcBasedReservationRepository jdbcBasedReservationRepository = new JdbcBasedReservationRepository(dataSource);
        IReservationRepository iReservationRepository = new JdbcBasedReservationRepository(dataSource);
        IClientRepository iClientRepository = new JdbcBasedClientRepository(dataSource);
        IChambreRepository iChambreRepository = new JdbcBasedChambreRepository(dataSource);
        ILocationRepository iLocationRepository = new JdbcBasedLocationRepository(dataSource);
    }

    public static void clrscr(){

        //Clears Screen in java

        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {}

    }

}
