package a.b.c.factura.comando.fabrica;

import a.b.c.cliente.puerto.RepositorioCliente;
import a.b.c.factura.comando.ComandoProductoFacturar;
import a.b.c.factura.comando.ComandoSolicitudFacturar;
import a.b.c.factura.modelo.entidad.ProductoFacturar;
import a.b.c.factura.modelo.entidad.SolicitudFacturar;
import a.b.c.producto.puerto.RepositorioProducto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FabricaSolicitudFacturar {

    private final RepositorioCliente repositorioCliente;
    private final RepositorioProducto repositorioProducto;

    public FabricaSolicitudFacturar(RepositorioCliente repositorioCliente, RepositorioProducto repositorioProducto) {
        this.repositorioCliente = repositorioCliente;
        this.repositorioProducto = repositorioProducto;
    }

    public SolicitudFacturar crear(ComandoSolicitudFacturar comandoSolicitudFacturar) {
        return new SolicitudFacturar(repositorioCliente.obtener(comandoSolicitudFacturar.getIdCliente()),
                obtenerProductos(comandoSolicitudFacturar.getComandoProductosFacturar())
        );
    }

    private List<ProductoFacturar> obtenerProductos(List<ComandoProductoFacturar> comandoProductosFacturar) {
        return comandoProductosFacturar.stream().map(comandoProducto ->
                        ProductoFacturar.crear(
                                comandoProducto.getCantidad(),
                                repositorioProducto.obtener(comandoProducto.getIdProducto())))
                                .collect(Collectors.toList());
    }
}
