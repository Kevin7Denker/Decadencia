package ifpr.eic.info20.projetointegrador.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection{

  private static int MAX_CONNECTIONS=5;


   /* Recriar o banco*/
   private static String URL_DB = "//localhost:3306/";
   private static String DB_NAME = "";
   private static String USERNAME = "";
   private static String PASSWORD = "";

   private static String CON_STRING="jdbc:mysql:"+URL_DB+DB_NAME;

   private Connection[] conexoes;
   
   private static Conection instance;

   private Conection(){
       conexoes = new Connection[MAX_CONNECTIONS];
   }
   
   public static Conection getInstance(){
       if(instance != null){
          return instance;
       }
       instance = new Conection();
       return instance;
   }
  
   public Connection getConnection() throws SQLException{

       for(int i=0;i<MAX_CONNECTIONS;i++){
           if(instance.conexoes[i]==null || instance.conexoes[i].isClosed()){
               instance.conexoes[i] = DriverManager.getConnection(CON_STRING,USERNAME,PASSWORD);
               return instance.conexoes[i];
           }
       }
       throw new SQLException("Máximo de conexões");
   }


}