package a.b.c.configuracion;


import a.b.c.factura.puerto.repositorio.RepositorioFactura;
import a.b.c.factura.servicio.ServicioAnular;
import a.b.c.factura.servicio.ServicioFacturar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioFacturar servicioFacturar(RepositorioFactura repositorioFactura) {
        return new ServicioFacturar(repositorioFactura);
    }

    @Bean
    public ServicioAnular servicioAnular(RepositorioFactura repositorioFactura) {
        return new ServicioAnular(repositorioFactura);
    }


	

} 
