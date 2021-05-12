package proiect_pao;


public class csvSingleton {
	 
    private static csvSingleton instance = null;
 
    private csvSingleton() {
    	
 
    }
 
    public static synchronized csvSingleton getInstance() {

        if (instance == null) {
            instance = new csvSingleton();
        }
        return instance;
    }
}
