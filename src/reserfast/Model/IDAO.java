package reserfast.Model;

import java.util.ArrayList;

public interface IDAO {
	
	Usuario getUsuario(int id);
	ArrayList<Usuario> getUsuarios();
	boolean createUsuario(Usuario unUsuario);
	boolean updateUsuario(Usuario unUsuarioCambiado);
	boolean deleteUsuario(int id);
	boolean deleteUsuario(String username);
	
	void seed();	

}
