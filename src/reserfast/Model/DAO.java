package reserfast.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAO implements IDAO {
    
    public void seed() {
				
        Usuario u1 = new Usuario("IgnatiusReilly", "pass123", "Ignacio Reilly", "igna@gmail.com", 45512348);
        Usuario u2 = new Usuario("cvite", "pass123", "Carlos Vitette", "carlitosmelallevetoda@gmail.com", 21447751);
        Usuario u3 = new Usuario("amanzaloco", "pass123", "Guido Pella", "guidopella@gmail.com", 9541233);
        Usuario u4 = new Usuario("carlangas4551", "pass123", "Carlos Saul Menem", "carlosmemem@gmail.com", 12458912);    
        
        createUsuario(u1);
        createUsuario(u2);
        createUsuario(u3);
        createUsuario(u4);      
	}

	//USUARIOS
	
	@Override
	public Usuario getUsuario(int id) {
		Connection c = dbContext.createConnection();		
		if(Integer.class.isInstance(id)) {
			String query = "SELECT * FROM usuarios WHERE user_id = "+id+ " LIMIT 1";
			try {
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(query);
				
				if (rs.next()) {
					int idU = rs.getInt("user_id");
					String userU = rs.getString("username");
					String passU = rs.getString("password");
					String nombreU = rs.getString("name");
					String emailU = rs.getString("email");
					int dniU = rs.getInt("ci");
					Usuario u = new Usuario(idU, userU, passU, nombreU, emailU, dniU);					
					return u;
				}				
			} catch (SQLException e) {	
				try {
					e.printStackTrace();
					c.rollback();					
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}						
			} finally {
				try {
					c.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}			
		}
	
		return null;
	}

	@Override
	public ArrayList<Usuario> getUsuarios() {
		Connection c = dbContext.createConnection();	
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		String query = "SELECT * FROM usuarios";
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			while (rs.next()) {
				int idU = rs.getInt("user_id");
				String userU = rs.getString("username");
				String passU = rs.getString("password");
				String nombreU = rs.getString("name");
				String emailU = rs.getString("email");
				int dniU = rs.getInt("ci");
				Usuario u = new Usuario(idU, userU, passU, nombreU, emailU, dniU);	
				listaUsuarios.add(u);
			}				
		} catch (SQLException e) {	
			try {
				e.printStackTrace();
				c.rollback();				
			} catch (SQLException e1) {					
				e1.printStackTrace();
			}						
		} finally {
			try {
				c.close();
			} catch (SQLException e) {					
				e.printStackTrace();
			}
		}			
			
		return listaUsuarios;
	}

	@Override
	public boolean createUsuario(Usuario unUsuario) {
		if(unUsuario != null) {
			String user = unUsuario.getUsername();
			String pass = unUsuario.getPassword();	
			String nombre = unUsuario.getName();
			String email = unUsuario.getEmail();
			int dni = unUsuario.getCi();
			String query = "INSERT INTO usuarios (username, password, nombre, email, ci) " + 
					"SELECT '"+user+"', '"+pass+"', '"+nombre+"', '"+email+"', "+dni+" WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE ci = "+dni+");";
			
			return excecuteQuery(query);
		}		
		return false;
	}

	@Override
	public boolean updateUsuario(Usuario unUsuarioCambiado) {
		if(unUsuarioCambiado != null) {
			int id = unUsuarioCambiado.getUser_id();
			String user = unUsuarioCambiado.getUsername();
			String pass = unUsuarioCambiado.getPassword();
			String nombre = unUsuarioCambiado.getName();
			String email = unUsuarioCambiado.getEmail();
			int dniU = unUsuarioCambiado.getCi();
			String query = "UPDATE usuarios SET username = '"+user+"', password = '"+pass+"', nombre = '"+nombre+"', email = '"+email+"', ci = "+dniU+" WHERE user_id = "+id;
			
			return excecuteQuery(query);
		}		
		return false;
	}

	@Override
	public boolean deleteUsuario(int id) {
		if(Integer.class.isInstance(id)) {
			String query = "DELETE FROM usuarios WHERE user_id = "+id;
			
			return excecuteQuery(query);			
		}		
		return false;
	}
	
	@Override
	public boolean deleteUsuario(String username) {
		if(username.isEmpty()) {
			return false;
		} else {
			String query = "DELETE FROM usuarios WHERE username = "+username;
			
			return excecuteQuery(query);	
		}	
	}
        
        	//QUERY
	
	private boolean excecuteQuery (String query) {
		boolean retorno = false;
		Connection c = dbContext.createConnection();
		
		try {
			Statement s = c.createStatement();
			s.executeUpdate(query);
			c.commit();	
			retorno = true;
		} catch (SQLException e) {	
			try {
				e.printStackTrace();
				c.rollback();					
			} catch (SQLException e1) {					
				e1.printStackTrace();
			}						
		} finally {
			try {
				c.close();
			} catch (SQLException e) {					
				e.printStackTrace();
			}
		}
		
		return retorno;		
	}
    
}
