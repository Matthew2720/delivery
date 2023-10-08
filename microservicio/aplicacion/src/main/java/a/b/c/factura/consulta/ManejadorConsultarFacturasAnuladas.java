package a.b.c.factura.consulta;

import a.b.c.factura.modelo.dto.ResumenFacturaDTO;
import a.b.c.factura.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarFacturasAnuladas {

    private final DaoFactura daoFactura;

    public ManejadorConsultarFacturasAnuladas(DaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }

    public List<ResumenFacturaDTO> ejecutar(){
        return daoFactura.obtenerResumenDeFacturasAnuladas();
    }
}
