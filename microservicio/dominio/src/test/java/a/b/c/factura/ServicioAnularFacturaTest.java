package a.b.c.factura;

import a.b.c.core.BasePrueba;
import a.b.c.cliente.ClienteTestDataBuilder;
import a.b.c.cliente.entidad.TipoCliente;
import a.b.c.dominio.excepcion.ExcepcionValorObligatorio;
import a.b.c.factura.modelo.entidad.EstadoFactura;
import a.b.c.factura.modelo.entidad.Factura;
import a.b.c.factura.puerto.repositorio.RepositorioFactura;
import a.b.c.factura.servicio.ServicioAnular;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class ServicioAnularFacturaTest {

    @Test
    void deberiaAnularExitosamente() {
        var repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.guardar(Mockito.any())).thenReturn(1l);
        var factura = new FacturaTestDataBuilder().conFacturaPorDefecto()
                .conCliente(new ClienteTestDataBuilder().conClientePorDefecto()
                        .conTipoCliente(TipoCliente.ESPECIAL).reconstruir())
                .conEstado(EstadoFactura.ACTIVA).reconstruir();
        var servicioAnular = new ServicioAnular(repositorioFactura);

        servicioAnular.ejecutar(factura);

        ArgumentCaptor<Factura> captorFactura = ArgumentCaptor.forClass(Factura.class);
        Mockito.verify(repositorioFactura, Mockito.times(1)).actualizarEstado(captorFactura.capture());

        Assertions.assertTrue(captorFactura.getValue().esAnulada());
    }

    @Test
    void anularFacturaNullDeberiaLanzarError() {
        var repositorioFactura = Mockito.mock(RepositorioFactura.class);
        var servicioAnular = new ServicioAnular(repositorioFactura);

        BasePrueba.assertThrows(() -> servicioAnular.
                ejecutar(null), ExcepcionValorObligatorio.class, "No existe una factura para anular");


    }
}
