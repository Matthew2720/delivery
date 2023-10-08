package a.b.c.factura.controlador;

import a.b.c.ComandoRespuesta;
import a.b.c.factura.comando.ComandoAnular;
import a.b.c.factura.comando.ComandoSolicitudFacturar;
import a.b.c.factura.comando.manejador.ManejadorAnular;
import a.b.c.factura.comando.manejador.ManejadorFacturar;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
@Tag(name = "Controlador comando factura")
public class ComandoControladorFactura {

    private final ManejadorFacturar manejadorFacturar;
    private final ManejadorAnular manejadorAnular;

    public ComandoControladorFactura(ManejadorFacturar manejadorFacturar, ManejadorAnular manejadorAnular) {
        this.manejadorFacturar = manejadorFacturar;
        this.manejadorAnular = manejadorAnular;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Facturar", description = "Metodo utilizado para crear una nueva factura")
    public ComandoRespuesta<Long> facturar(@RequestBody ComandoSolicitudFacturar comandoSolicitudFacturar) {
        return this.manejadorFacturar.ejecutar(comandoSolicitudFacturar);
    }

    @PostMapping("anular/{id-factura}")
    @Operation(summary = "Anular", description = "Metodo utilizado para anular una nueva factura")
    public void anular(@PathVariable("id-factura") Long idFactura) {
        this.manejadorAnular.ejecutar(new ComandoAnular(idFactura));
    }
}
