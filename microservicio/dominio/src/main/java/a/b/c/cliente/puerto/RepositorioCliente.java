package a.b.c.cliente.puerto;

import a.b.c.cliente.entidad.Cliente;

public interface RepositorioCliente {

    Cliente obtener(Long id);
}
