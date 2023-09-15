package com.fag;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

import java.beans.ConstructorProperties;

import javax.xml.transform.Templates;

@Path("/calculadora")
public class CalculadoraController {

    Template page;

    public CalculadoraController(Template page) {
        this.page = page;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return page.data("resultado", null);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance calcular(
            @FormParam("valor1") double valor1,
            @FormParam("valor2") double valor2,
            @FormParam("operador") String operador
    ) {

        double resultado = 0.0;
        switch (operador){

        case "Soma":
        resultado = valor1 + valor2;
        break;
        case "Sub":
        resultado = valor1 - valor2;
        break;
        case "Mult":
        resultado = valor1 * valor2;
        break;
        case "Div":
        resultado = valor1 / valor2;
        break;

        }

        return page.data("resultado", resultado);
    }
}
