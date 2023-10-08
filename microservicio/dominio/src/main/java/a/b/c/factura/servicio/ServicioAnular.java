package a.b.c.factura.servicio;

import a.b.c.dominio.ValidadorArgumento;
import a.b.c.factura.modelo.entidad.Factura;
import a.b.c.factura.puerto.repositorio.RepositorioFactura;

public class ServicioAnular {

    private final RepositorioFactura repositorioFactura;

    public ServicioAnular(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Factura factura) {
        ValidadorArgumento.validarObligatorio(factura, "No existe una factura para anular");
        factura.anular();
        repositorioFactura.actualizarEstado(factura);
    }
}
