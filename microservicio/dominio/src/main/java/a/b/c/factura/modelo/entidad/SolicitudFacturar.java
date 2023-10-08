package a.b.c.factura.modelo.entidad;

import a.b.c.cliente.entidad.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SolicitudFacturar {

    private final Cliente cliente;
    private final List<ProductoFacturar> productosFacturar;

}
