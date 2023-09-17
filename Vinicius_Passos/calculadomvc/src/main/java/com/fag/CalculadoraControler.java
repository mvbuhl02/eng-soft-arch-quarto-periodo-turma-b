package com.fag;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

import java.util.List;

import com.fag.Services.Sinal;

@Path("/CalculadoraControler")
public class CalculadoraControler {
    private final Template page;

    public CalculadoraControler(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return page.data("opcao", List.of("Soma", "Sub", "Mult", "Div"));
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance calcular(
            @FormParam("valor1") Double valor1,
            @FormParam("valor2") Double valor2,
            @FormParam("opcao") String opcao) {
        Double resultado = 0d;
        Sinal sinal = new Sinal();
        resultado = sinal.calcular(valor1, valor2, opcao);

        if (resultado == null) {
            return page.data("resultado", null, "mensagem", "Não pode divisão por 0");
        }
        return page.data("resultado", resultado, "mensagem", "Calculado com sucesso");
    }

}
