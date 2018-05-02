package ar.edu.untref.aydoo;

class Cliente {

    private String nombre;
    private String direccion;

    Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

}
