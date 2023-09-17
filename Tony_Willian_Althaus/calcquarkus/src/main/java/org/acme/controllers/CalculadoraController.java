package org.acme.controllers;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/calculadora")
public class CalculadoraController {

    private final Template page;
    private final List<String> operations = List.of("+", "-", "*", "/");

    @Inject
    public CalculadoraController(Template page) {
        this.page = page;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return page.data("op", operations);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance calcular(@FormParam("valor1") double valor1, @FormParam("valor2") double valor2, @FormParam("operacao") String operacao) {
        double resultado = 0.0;

        switch (operacao) {
            case "+":
                resultado = valor1 + valor2;
                break;
            case "-":
                resultado = valor1 - valor2;
                break;
            case "*":
                resultado = valor1 * valor2;
                break;
            case "/":
                resultado = (valor2 != 0) ? valor1 / valor2 : 0;
                break;
        }

        return page.data("resultado", resultado);
    }
}
