package Modelo;



/**
 *
 * @author jevergara
 */
public class Empleado {

    int id;
    String cc;
    String nom;
    String apell;
    int edad;
    String fecha = "dd-MMM-aaaa";
    String tel;
    String jefes;
    int cargoid;

    public Empleado() {
    }

    public Empleado(int id, String cc, String nom, String apell, int edad, String fecha, String tel, String jefes, int cargoid) {
        this.id = id;
        this.cc = cc;
        this.nom = nom;
        this.apell = apell;
        this.edad = edad;
        this.fecha = fecha;
        this.tel = tel;
        this.jefes = jefes;
        this.cargoid = cargoid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setApell(String apell) {
        this.apell = apell;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setJefes(String jefes) {
        this.jefes = jefes;
    }

    public void setCargoid(int cargoid) {
        this.cargoid = cargoid;
    }

    public int getId() {
        return id;
    }

    public String getCc() {
        return cc;
    }

    public String getNom() {
        return nom;
    }

    public String getApell() {
        return apell;
    }

    public int getEdad() {
        return edad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTel() {
        return tel;
    }

    public String getJefes() {
        return jefes;
    }

    public int getCargoid() {
        return cargoid;
    }

   
}
    
    

