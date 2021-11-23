
package Modelo;

public class Cliente {
    
private String id;
private String dni;
private String nom;
private String direc;
private String estado;

    public Cliente() {
    }

    public Cliente(String id, String dni, String nom, String direc, String estado) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.direc = direc;
        this.estado = estado;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the direc
     */
    public String getDirec() {
        return direc;
    }

    /**
     * @param direc the direc to set
     */
    public void setDirec(String direc) {
        this.direc = direc;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
