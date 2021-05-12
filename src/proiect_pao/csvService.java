import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class csvService {

    private static csvService instance = null;

    private csvService(){
    }

    public static csvService getInstance(){
        if(instance == null){
            instance = new csvService();
        }
        return instance;
    }

    public void writeCSV(String action){
        try (FileWriter writer = new FileWriter("Actions.csv", true);) {
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            writer.append(action);
            writer.append(",");
            writer.append(String.valueOf(currentTime));
            writer.append("\n");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

}