package a.b.c.factura.puerto.repositorio;

import a.b.c.factura.modelo.entidad.Factura;

public interface RepositorioFactura {
    Long guardar(Factura factura);
    Factura obtener(Long id);
    void actualizarEstado(Factura factura);
}
