package reserfast.Model;

public class Usuario {
    
    //Atriibutos
    
    int user_id;
    String username;
    String password;
    int ci;
    String name;
    String email;
    
    
    //Getters and Setters
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    //Constructores
    
    public Usuario (){};
    
        public Usuario (int user_id, String user, String pass, String name, String email, int ci){
        this.user_id = user_id;
        this.username = user;
        this.password = pass;
        this.ci = ci;
        this.name = name;
        this.email = email;
    }
    
    public Usuario (String user, String pass, String name, String email, int ci){
        this.username = user;
        this.password = pass;
        this.ci = ci;
        this.name = name;
        this.email = email;
    }
    
    //Metodos
    
    
}
