package reserfast;

import reserfast.Model.*;

public class Reserfast {

    public static void main(String[] args) {       	
			
        //Inicializamos la tabla

        TableManager tm = new TableManager();		

        //Seedeamos la db

        DAO dao = new DAO();
        dao.seed();
    }
    
    
}
