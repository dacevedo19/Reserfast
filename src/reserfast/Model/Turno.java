package reserfast.Model;

import java.util.Date;

public class Turno {
    
    //Atributos
    
    int id_turno;
    int id_user;
    Date creationDate;
    Date date;    
    Entidad entidad;
    TipoTramite tipoTramite;
    
    
    //Getters and Setters
    
    public int getId_turno() {
        return id_turno;
    }
    
    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }
    
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }
    
    
    //Constructores
    
    public Turno (){}
    
    
    //Metodos
    
}
