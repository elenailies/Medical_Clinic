package repository;
import proiect_pao.models.Medicine;
import config.DatabaseConfig;
import java.sql.*;

public class MedicineRepository {
	
    public void insertMedicineInDatabase(Medicine medicine) {
        if(existence(medicine) == 1) {
            System.out.println("Name already exist in database!");
            return;
        }

        String preparedSql = "call insertMedicine(?,?,?,?)";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            CallableStatement callableStatement = databaseConnection.prepareCall(preparedSql);
            callableStatement.setString(2, medicine.getName());
            callableStatement.setString(3, medicine.getDescription());
            callableStatement.setDouble(4, medicine.getPrice());
          
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.execute();
            System.out.println("The medicine with Name: " + medicine.getName() + " was added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public Medicine getMedicineFromDatabase(String  name) {
        String selectSql = "SELECT * FROM medicines WHERE name=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToMedicine(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


   private Medicine mapToMedicine(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Medicine(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3));
        }
        return null;
    }

   
    private int existence(Medicine medicine){
        if(getMedicineFromDatabase(medicine.getName()) == null){
            return 0;
        }
        else{
            return 1;
        }
    }

    
    public void removeMedicineFromDatabase(String  name) {
        String deleteSql = "DELETE FROM medicines WHERE name=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            if(getMedicineFromDatabase(name) != null) {
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteSql);
                preparedStatement.setString(1, name);
                int resultSet = preparedStatement.executeUpdate();
                System.out.println("The medicine with name: " + name + " was removed!");
            }
            else{
                System.out.println("The medicine with name: " + name + " doesn't exist!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatename(double newprice, String name) {
        String updateCopiesSql = "UPDATE Medicines SET price=? WHERE name=?";

        Connection databaseConnection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateCopiesSql);
            preparedStatement.setDouble(1, newprice);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            System.out.println("Clinic with name: " + name + " was modified!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

