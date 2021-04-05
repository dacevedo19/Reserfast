package reserfast.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {
	
	public TableManager() {
		
		dropTables();
		createUsuariosTable();
		createTurnosTable();
                createEntidadesTable();
                createTipoTramiteTable();
		
	}	
	
	
	//Métodos
	
	public void createUsuariosTable() {
		createTable("CREATE TABLE IF NOT EXISTS usuarios (user_id serial PRIMARY KEY, username VARCHAR NOT NULL, "
				+ "password VARCHAR NOT NULL, nombre VARCHAR NOT NULL, email VARCHAR NOT NULL, ci INTEGER NOT NULL)");
	}	
	
	public void createTurnosTable() {
		createTable("CREATE TABLE IF NOT EXISTS turnos (id_turno serial PRIMARY KEY, "
				+ "id_usuario INTEGER NULL REFERENCES usuarios, creationDate DATE NOT NULL, date DATE NOT NULL, fecha DATE NOT NULL)");
	}	
        
        public void createEntidadesTable() {
                createTable("CREATE TYPE entidades AS ENUM('BPS', 'DGI', 'MTSS')");
        }
        
        public void createTipoTramiteTable() {
                createTable("CREATE TYPE tipo_tramites AS ENUM('BPS_fonsasa', 'BPS_prestamos_sociales', 'BPS_desempleo', 'DGI_convenio', 'DGI_no_sede', 'DGI_sede', "
                        + "'MTSS_denuncia')");
        }
	
	public void createTable(String aQuery) {
		Connection contexto = dbContext.createConnection();
		String query = aQuery;		
		try {
			Statement SQLquery = contexto.createStatement();
			SQLquery.executeUpdate(query);
			contexto.commit();
		}catch(SQLException e) {
			try {
				contexto.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}		
		}finally {
			try {
				contexto.close();
			}catch(SQLException s){
				s.printStackTrace();
			}
		}
	}
		
	public void dropTables()  {
		Connection contexto = dbContext.createConnection();
		String query1 = "DROP SCHEMA public CASCADE;";
		String query2 = "CREATE SCHEMA public;";
		String query3 = "GRANT ALL ON SCHEMA public TO postgres;";
		String query4 = "GRANT ALL ON SCHEMA public TO public;";
		
		try {
			Statement SQLquery = contexto.createStatement();
			SQLquery.execute(query1);
			SQLquery.execute(query2);
			SQLquery.execute(query3);
			SQLquery.execute(query4);
		}catch(SQLException e) {
			try {
				contexto.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}		
		}finally {
			try {
				contexto.close();
			}catch(SQLException s){
				s.printStackTrace();
			}
		}				
	}
}