package models;

public class LineasAereas {

    private double precios;
    private String destinos;
    private String servicios;

    public LineasAereas(double precios, String destinos, String servicios) {
        this.precios = precios;
        this.destinos = destinos;
        this.servicios = servicios;
    }

    public double getPrecios() {
        return precios;
    }

    public void setPrecios(double precios) {
        this.precios = precios;
    }

    public String getDestinos() {
        return destinos;
    }

    public void setDestinos(String destinos) {
        this.destinos = destinos;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }
    
    @Override
    public String toString() {
        return "LineasAereas("
                + " Precios: '" + precios + '\''
                + ", Destino: " + destinos + '\''
                + ", Servicios: '" + servicios + '\''
                + ")";
    }

}
