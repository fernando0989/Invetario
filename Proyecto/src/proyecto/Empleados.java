package proyecto;

import javax.swing.JRadioButton;

public class Empleados {

    private String UsuarioE;
    private String nombreE;
    private String apellidosE;
    private String sexoE;
    private String contraE;

    public Empleados() {
    }

    public Empleados(String UsuarioE, String nombreE, String apellidosE, String sexoE, String contraE) {
        this.UsuarioE = UsuarioE;
        this.nombreE = nombreE;
        this.apellidosE = apellidosE;
        this.sexoE = sexoE;
        this.contraE = contraE;
    }
    
    public String getUsuarioE() {
        return UsuarioE;
    }

    public void setUsuarioE(String UsuarioE) {
        this.UsuarioE = UsuarioE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getApellidosE() {
        return apellidosE;
    }

    public void setApellidosE(String apellidosE) {
        this.apellidosE = apellidosE;
    }

    public String getSexoE() {
        return sexoE;
    }

    public void setSexoE(String sexoE) {
        this.sexoE = sexoE;
    }

    public String getContraE() {
        return contraE;
    }

    public void setContraE(String contraE) {
        this.contraE = contraE;
    }

    public String[] getFilas() {
        String fila[] = new String[5];
        fila[0] = getUsuarioE();
        fila[1] = getNombreE();
        fila[2] = getApellidosE();
        fila[3] = getSexoE();
        fila[4] = getContraE();
        return fila;
    }

}
