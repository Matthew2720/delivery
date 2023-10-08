package a.b.c.producto.puerto;

import a.b.c.producto.entidad.Producto;

public interface RepositorioProducto {

    Producto obtener(Long id);
}
