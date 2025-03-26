package org.mercadodominio.Models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class Categoria extends PanacheEntity {
    private int CategoriaId;
    private String CategoriaNome;
}
