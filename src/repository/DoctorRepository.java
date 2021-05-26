package repository;
import proiect_pao.models.Doctor;
import config.DatabaseConfig;
import java.sql.*;

public class DoctorRepository {
	
    public void insertDoctorInDatabase(Doctor doctor) {
        if(existence(doctor) == 1) {
            System.out.println("Name already exist in database!");
            return;
        }

        String preparedSql = "call insertDoctor(?,?,?,?,?)";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            CallableStatement callableStatement = databaseConnection.prepareCall(preparedSql);
            callableStatement.setString(2, doctor.getfirstName());
            callableStatement.setString(3, doctor.getlastName());
            callableStatement.setString(4, doctor.getmedicalOfficeName());
            callableStatement.setString(5, doctor.getclinicName());
          
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.execute();
            System.out.println("The doctor with last name: " + doctor.getlastName() + " was added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public Doctor getDoctorFromDatabase(String  lastName) {
        String selectSql = "SELECT * FROM doctors WHERE lastName=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToDoctor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


   private Doctor mapToDoctor(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Doctor(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4));
        }
        return null;
    }

   
    private int existence(Doctor doctor){
        if(getDoctorFromDatabase(doctor.getlastName()) == null){
            return 0;
        }
        else{
            return 1;
        }
    }

    
    public void removeDoctorFromDatabase(String  lastName) {
        String deleteSql = "DELETE FROM doctors WHERE lastName=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            if(getDoctorFromDatabase(lastName) != null) {
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteSql);
                preparedStatement.setString(1, lastName);
                int resultSet = preparedStatement.executeUpdate();
                System.out.println("The doctor with name: " + lastName + " was removed!");
            }
            else{
                System.out.println("The doctor with name: " + lastName + " doesn't exist in clinic!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatename(String newclinicName, String lastName) {
        String updateCopiesSql = "UPDATE doctors SET clinicName=? WHERE lastName=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateCopiesSql);
            preparedStatement.setString(1, newclinicName);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();
            System.out.println("Doctor with name: " + lastName + " was transfered!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}