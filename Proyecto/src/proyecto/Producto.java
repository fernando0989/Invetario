package proyecto;

public class Producto {

    private String nombre;
    private String codigo;
    private float precio;
    private int existencia;

    public Producto() {
    }

    public Producto(String nombre, String codigo, float precio, int existencia) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String[] getFilas() {
        String[] filas = new String[4];
        filas[0] = getCodigo();
        filas[1] = getNombre();
        filas[2] = String.valueOf(precio);        
        filas[3] = String.valueOf(existencia);
        return filas;
    }

   
}
