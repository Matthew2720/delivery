package a.b.c.factura.puerto.repositorio;

import a.b.c.factura.modelo.entidad.Factura;
import a.b.c.factura.modelo.entidad.ProductoFacturar;

import java.util.List;

public interface RepositorioProductoFacturar {

    void guardarPorFactura(Factura factura, Long idFactura);

    List<ProductoFacturar> obtenerPorFactura(Long idFactura);
}
