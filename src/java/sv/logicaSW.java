package sv;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Hotel;
import models.LineasAereas;
import models.TarjetaC;

@WebService(serviceName = "logicaSW")
public class logicaSW {

    // TARJETA
    public static ArrayList<TarjetaC> listaTar = new ArrayList<>();

    @WebMethod(operationName = "createT")
    public Boolean TarjetCredito(@WebParam(name = "ci") String ci, @WebParam(name = "monto") double monto, @WebParam(name = "fecha_corte") String fecha_corte, @WebParam(name = "fecha_vencimiento") String fecha_vencimiento) {
        boolean encuentro = false;
        for (int i = 0; i < listaTar.size(); i++) {
            if (ci.equalsIgnoreCase(listaTar.get(i).getCi())) {
                encuentro = true;
            }
        }
        if (encuentro) {
            //return "mal";
            return false;
        } else {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha_cortef = formato.parse(fecha_corte);
                Date fecha_vencimientof = formato.parse(fecha_vencimiento);
                listaTar.add(new TarjetaC(ci, monto, fecha_cortef, fecha_vencimientof));
                return true;
                //return "bien" + listaTar.toString();
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
                return false;
                //return "mal";
            }
        }
    }


    @WebMethod(operationName = "getCard")
    public TarjetaC getCard(@WebParam(name = "ci") String ci) {
        TarjetaC tc = new TarjetaC();
        for (TarjetaC tarjetaC : listaTar) {
            if (tarjetaC.getCi().equals(ci)) {
                tc = tarjetaC;
                break;
            }
        }
        return tc;
    }

    @WebMethod(operationName = "updateCard")
    public Boolean updateCard(@WebParam(name = "ci") String ci, @WebParam(name = "monto") double monto, @WebParam(name = "fecha_corte") String fecha_corte, @WebParam(name = "fecha_vencimiento") String fecha_vencimiento) {
        boolean findOk = false;
        for (TarjetaC tarjetaC : listaTar) {
            if (tarjetaC.getCi().equals(ci)) {
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    Date fecha_cortef = formato.parse(fecha_corte);
                    Date fecha_vencimientof = formato.parse(fecha_vencimiento);
                    tarjetaC.setMonto(monto);
                    tarjetaC.setFecha_corte(fecha_cortef);
                    tarjetaC.setFecha_vencimiento(fecha_vencimientof);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                findOk = true;
                break;
            }
        }
        if (findOk) {
            return true;
        }
        return false;
    }

    @WebMethod(operationName = "deleteCard")
    public Boolean deleteCard(@WebParam(name = "ci") String ci) {
        boolean deleteOk = false;
        for (TarjetaC tarjetaC : listaTar) {
            if (tarjetaC.getCi().equals(ci)) {
                listaTar.remove(tarjetaC);
                deleteOk = true;
                break;
            }
        }
        if (deleteOk) {
            return true;
        }
        return false;
    }
    // FIN TARJETA

    // HOTELES
    @WebMethod(operationName = "listaHoteles")
    public List<Hotel> getHotels() {
        List<Hotel> hoteles = new ArrayList<>();
        hoteles.add(new Hotel("Oro Verde", 50.0, "Ordeñes lazo y sereso", "Desayunos, Almuerzos, Merienda, Hospedaje, Picina"));
        hoteles.add(new Hotel("El Dorado", 100.0, "Avenida Principal 123", "Desayunos, Almuerzos, Spa, Piscina, Conserjería"));
        return hoteles;
    }
    // FIN HOTELES

    // LINEAS AEREAS
    @WebMethod(operationName = "listaAerea")
    public List<LineasAereas> listaaerea() {
        ArrayList<LineasAereas> listAerea = new ArrayList<>();
        listAerea.add(new LineasAereas(50.0, "Quito", "Turismo"));
        listAerea.add(new LineasAereas(50.0, "Bogota", "Comercial"));
        return listAerea;
    }
// FIN LINEA AEREAS

}
