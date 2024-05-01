package EMPRESA.ANDROID.DAO;
import android.widget.Switch;

import androidx.annotation.NonNull;

import EMPRESA.ANDROID.BEAN.*;
public class ProductDAO {
    ProductBean objProductBean;

    @NonNull
    public String CalcularOperacion(ProductBean objProductBean) {
        String mensaje = "";

        int marca = objProductBean.getMarca();
        int talla = objProductBean.getTalla();
        int numpares = objProductBean.getNumpares();

        this.objProductBean = new ProductBean();
        this.objProductBean.setMarca(marca);
        this.objProductBean.setTalla(talla);
        this.objProductBean.setNumpares(numpares);

        int costo = CalcularCostoParZapatilla(this.objProductBean);
        this.objProductBean.setCosto(costo);

        int venta = CalcularVenta(this.objProductBean);
        this.objProductBean.setVenta(venta);

        double descuento = CalcularDescuento(this.objProductBean);
        this.objProductBean.setDescuento(descuento);

        double ventaneta = CalcularVentaNeta(this.objProductBean);
        this.objProductBean.setVentaneta(ventaneta);

        mensaje = "El costo del par de Zapatillas: "+costo+"\n"+
                "Precio de venta zapatillas: "+venta+"\n"+
                "El descuento: "+descuento+"\n"+
                "la venta neta: "+ventaneta;

        return mensaje;
    }

    public int CalcularCostoParZapatilla(ProductBean objProductBean) {
        int costo = 0;

        switch (objProductBean.getMarca()) {
            case 0: {
                switch (objProductBean.getTalla()) {
                    case 0: {
                        costo = 150;
                        break;
                    }
                    case 1: {
                        costo = 160;
                        break;
                    }
                    case 2: {
                        costo = 160;
                        break;
                    }
                }
                break;
            }
            case 1: {
                switch (objProductBean.getTalla()) {
                    case 0: {
                        costo = 140;
                        break;
                    }
                    case 1: {
                        costo = 150;
                        break;
                    }
                    case 2: {
                        costo = 150;
                        break;
                    }
                }
                break;
            }
            case 2: {
                switch (objProductBean.getTalla()) {
                    case 0: {
                        costo = 80;
                        break;
                    }
                    case 1: {
                        costo = 85;
                        break;
                    }
                    case 2: {
                        costo = 90;
                        break;
                    }
                }
                break;
            }
        }
        return costo;
    }

    public int CalcularVenta(ProductBean objProductBean) {
        int venta = 0;
        venta = objProductBean.getCosto() * objProductBean.getNumpares();

        return venta;
    }

    public double CalcularDescuento(ProductBean objProductBean) {
        double descuento = 0;

        if (objProductBean.getNumpares() >= 2 && objProductBean.getNumpares() <= 5) {
            descuento = 0.05 * objProductBean.getVenta();
        } else {
            if (objProductBean.getNumpares() >= 6 && objProductBean.getNumpares() <= 10) {
                descuento = 0.08 * objProductBean.getVenta();
            } else {
                if (objProductBean.getNumpares() >= 11 && objProductBean.getNumpares() <= 20) {
                    descuento = 0.10 * objProductBean.getVenta();
                } else {
                    if (objProductBean.getNumpares() > 20) {
                        descuento = 0.15 * objProductBean.getVenta();
                    }
                }
            }
        }
        return descuento;
    }
    public double CalcularVentaNeta(ProductBean objProductBean){
        double ventaneta = 0;

        ventaneta = objProductBean.getVenta() - objProductBean.getDescuento();

        return ventaneta;
    }

}
