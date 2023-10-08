package a.b.c.factura.servicio;

import a.b.c.factura.modelo.entidad.Factura;
import a.b.c.factura.modelo.entidad.SolicitudFacturar;
import a.b.c.factura.puerto.repositorio.RepositorioFactura;

public class ServicioFacturar {
    private final RepositorioFactura repositorioFactura;

    public ServicioFacturar(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public Long ejecutar(SolicitudFacturar solicitudFacturar) {
        Factura factura = Factura.crear(solicitudFacturar);
        return repositorioFactura.guardar(factura);
    }
}
