package models;

import javax.ejb.Stateful;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

@Stateful
@WebService
@Addressing
public class Hotel {

    private String nombreHotel;
    private Double precio;
    private String direccion;
    private String listServicios;

    public Hotel() {
    }

    public Hotel(String nombreHotel, Double precio, String direccion, String listServicios) {
        this.nombreHotel = nombreHotel;
        this.precio = precio;
        this.direccion = direccion;
        this.listServicios = listServicios;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getListServicios() {
        return listServicios;
    }

    public void setListServicios(String listServicios) {
        this.listServicios = listServicios;
    }

    @Override
    public String toString() {
        return "Hotel("
                + "nombre='" + nombreHotel + '\''
                + ", precio=" + precio
                + ", direccion='" + direccion + '\''
                + ", servicios='" + listServicios + '\''
                + ")";
    }

}
