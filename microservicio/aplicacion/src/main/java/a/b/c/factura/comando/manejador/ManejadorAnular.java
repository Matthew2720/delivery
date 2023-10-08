package a.b.c.factura.comando.manejador;

import a.b.c.factura.comando.ComandoAnular;
import a.b.c.factura.puerto.repositorio.RepositorioFactura;
import a.b.c.factura.servicio.ServicioAnular;
import a.b.c.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAnular implements ManejadorComando<ComandoAnular> {

    private final ServicioAnular servicioAnular;
    private final RepositorioFactura repositorioFactura;

    public ManejadorAnular(ServicioAnular servicioAnular, RepositorioFactura repositorioFactura) {
        this.servicioAnular = servicioAnular;
        this.repositorioFactura = repositorioFactura;
    }

    @Override
    public void ejecutar(ComandoAnular comandoAnular) {
        servicioAnular.ejecutar(repositorioFactura.obtener(comandoAnular.getIdFactura()));
    }
}
