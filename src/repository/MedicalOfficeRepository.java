package repository;
import proiect_pao.models.MedicalOffice;
import config.DatabaseConfig;
import java.sql.*;

public class MedicalOfficeRepository {
	
    public void insertMedicalOfficeInDatabase(MedicalOffice medicalOffice) {
        if(existence(medicalOffice) == 1) {
            System.out.println("Name already exist in database!");
            return;
        }

        String preparedSql = "call insertMedicalOffice(?,?,?)";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            CallableStatement callableStatement = databaseConnection.prepareCall(preparedSql);
            callableStatement.setString(2, medicalOffice.getName());
            callableStatement.setString(3, medicalOffice.getclinicName());
         
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.execute();
            System.out.println("The medical office with Name: " + medicalOffice.getName() + " was added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public MedicalOffice getMedicalOfficeFromDatabase(String  name) {
        String selectSql = "SELECT * FROM medicalOffice WHERE name=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToMedicalOffice(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


   private MedicalOffice mapToMedicalOffice(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new MedicalOffice(resultSet.getString(1), resultSet.getString(2));
        }
        return null;
    }

   
    private int existence(MedicalOffice medicalOffice){
        if(getMedicalOfficeFromDatabase(medicalOffice.getName()) == null){
            return 0;
        }
        else{
            return 1;
        }
    }

    
    public void removeMedicalOfficeFromDatabase(String  name) {
        String deleteSql = "DELETE FROM medicalOffice WHERE name=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            if(getMedicalOfficeFromDatabase(name) != null) {
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteSql);
                preparedStatement.setString(1, name);
                int resultSet = preparedStatement.executeUpdate();
                System.out.println("The medical office with name: " + name + " was removed!");
            }
            else{
                System.out.println("The medical office with name: " + name + " doesn't exist in library!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatename(String newname, String name) {
        String updateCopiesSql = "UPDATE medicalOffice SET name=? WHERE name=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateCopiesSql);
            preparedStatement.setString(1, newname);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            System.out.println("Madical office with former name: " + name + " was modified!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}