package repository;
import proiect_pao.models.Clinic;
import config.DatabaseConfig;
import java.sql.*;

public class ClinicRepository {
	
    public void insertClinicInDatabase(Clinic clinic) {
        if(existence(clinic) == 1) {
            System.out.println("Name already exist in database!");
            return;
        }

        String preparedSql = "call insertClinic(?,?,?,?,?)";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            CallableStatement callableStatement = databaseConnection.prepareCall(preparedSql);
            callableStatement.setString(2, clinic.getName());
            callableStatement.setString(3, clinic.getAddress());
            callableStatement.setString(4, clinic.getopeningHour());
            callableStatement.setString(5, clinic.getclosingHour());
          
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.execute();
            System.out.println("The clinic with Name: " + clinic.getName() + " was added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public Clinic getClinicFromDatabase(String  name) {
        String selectSql = "SELECT * FROM clinics WHERE name=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToClinic(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


   private Clinic mapToClinic(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Clinic(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4));
        }
        return null;
    }

   
    private int existence(Clinic clinic){
        if(getClinicFromDatabase(clinic.getName()) == null){
            return 0;
        }
        else{
            return 1;
        }
    }

    
    public void removeClinicFromDatabase(String  name) {
        String deleteSql = "DELETE FROM clinics WHERE name=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            if(getClinicFromDatabase(name) != null) {
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteSql);
                preparedStatement.setString(1, name);
                int resultSet = preparedStatement.executeUpdate();
                System.out.println("The clinic with name: " + name + " was removed!");
            }
            else{
                System.out.println("The clinic with name: " + name + " doesn't exist!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatename(String newname, String name) {
        String updateCopiesSql = "UPDATE clinics SET name=? WHERE name=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateCopiesSql);
            preparedStatement.setString(1, newname);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            System.out.println("Clinic with former name: " + name + " was modified!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}