package config;
import repository.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSetup {

    public void setUp() {
        String createTableClinicsSql = "CREATE TABLE IF NOT EXISTS CLINICS" +
                "(name varchar(13) PRIMARY KEY, address varchar(30)," +
                "openingHour varchar(30), closingHour varchar(50))";
        
        String createTableDoctorsSql = "CREATE TABLE IF NOT EXISTS DOCTORS" +
                "(firstName varchar(13) PRIMARY KEY, lastName varchar(30)," +
                "medicalOfficeName varchar(30), clinicName varchar(50))";
        
        String createTableMedicalOfficeSql = "CREATE TABLE IF NOT EXISTS MEDICALOFFICE" +
                "(name varchar(30) PRIMARY KEY, clinicName varchar(30))";
        
        String createTableMedicinesSql = "CREATE TABLE IF NOT EXISTS MEDICINES" +
                "(name varchar(13) PRIMARY KEY, description varchar(100)," +
                "price int)";
        

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        Repository repository = Repository.getRepository();

        try {
            repository.executeSql(databaseConnection, createTableClinicsSql);
            repository.executeSql(databaseConnection, createTableDoctorsSql);
            repository.executeSql(databaseConnection, createTableMedicalOfficeSql);
            repository.executeSql(databaseConnection, createTableMedicinesSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}