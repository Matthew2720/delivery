package a.b.c.factura;

import a.b.c.cliente.ClienteTestDataBuilder;
import a.b.c.cliente.entidad.Cliente;
import a.b.c.cliente.entidad.TipoCliente;
import a.b.c.factura.modelo.entidad.Factura;
import a.b.c.factura.modelo.entidad.ProductoFacturar;
import a.b.c.factura.puerto.repositorio.RepositorioFactura;
import a.b.c.factura.servicio.ServicioFacturar;
import a.b.c.producto.ProductoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;

class ServicioFacturarTest {

    @Test
    void deberiaGenerarFacturaYGuardar(){
        Cliente cliente = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .conTipoCliente(TipoCliente.ESPECIAL)
                .reconstruir();
        ProductoFacturar productoFacturarArroz = new ProductoFacturarTestDataBuilder()
                .conCantidad(5)
                .conProducto(new ProductoTestDataBuilder()
                        .conProductoPorDefecto()
                        .conValor(BigDecimal.valueOf(2000))
                        .conAplicaIva(true).conNombre("Arroz")
                        .reconstruir())
                .build();
        var solicitudFacturar = new SolicitudFacturarTestDataBuilder()
                .conProductoFacturar(productoFacturarArroz)
                .conCliente(cliente).build();

        var repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.guardar(Mockito.any())).thenReturn(1l);

        var servicioFacturar = new ServicioFacturar(repositorioFactura);

        var idFacturaCreada = servicioFacturar.ejecutar(solicitudFacturar);

        ArgumentCaptor<Factura> captorFactura = ArgumentCaptor.forClass(Factura.class);
        Mockito.verify(repositorioFactura, Mockito.times(1)).guardar(captorFactura.capture());
        Assertions.assertEquals(cliente, captorFactura.getValue().getCliente());
        Assertions.assertEquals(productoFacturarArroz, captorFactura.getValue().getProductos().get(0));
        Assertions.assertEquals(10710l, captorFactura.getValue().getValorTotal().longValue());
        Assertions.assertEquals(1l, idFacturaCreada);
    }
}
