package a.b.c.factura;

import a.b.c.factura.modelo.entidad.ProductoFacturar;
import a.b.c.producto.entidad.Producto;

public class ProductoFacturarTestDataBuilder {
    private Integer cantidad;
    private Producto producto;
    private Long id;

    public ProductoFacturarTestDataBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public ProductoFacturarTestDataBuilder conProducto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public ProductoFacturarTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoFacturar build() {
        return ProductoFacturar.crear(cantidad, producto);
    }

    public ProductoFacturar reconstruir() {
        return ProductoFacturar.reconstruir(id, cantidad, producto);
    }
}
