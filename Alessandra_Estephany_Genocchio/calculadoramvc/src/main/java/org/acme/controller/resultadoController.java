package org.acme.controller;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

public class resultadoController {
    private final Template resultado;

    public resultadoController(Template page) {

        this.resultado = requireNonNull(page, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance
    get(@FormParam("valor1") double valor1,
        @FormParam("valor2")  double valor2,
        @FormParam("operador") String operador)
    {
        double resultadoOperacao = 0.0;

        return resultado.data("resultadoOperacao", resultadoOperacao);
    }

}
