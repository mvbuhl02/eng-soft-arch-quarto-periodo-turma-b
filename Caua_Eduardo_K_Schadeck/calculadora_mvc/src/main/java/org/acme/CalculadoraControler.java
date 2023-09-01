package org.acme;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import services.CaculatorServices;

import static java.util.Objects.requireNonNull;

import org.jboss.resteasy.annotations.Form;

@Path("/calculadora")
public class CalculadoraControler {

    @Inject
    CaculatorServices services;
    

    private final Template page;

    public CalculadoraControler(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {

        return page.data("result", null);

    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance calculate(@FormParam("valor1") Double val1,
    @FormParam("valor2") Double val2) {

        return page.data("result", services.addition(val1, val2));

        return page.data("result", services.subtraction(val1, val2));

        return page.data("result", services.division(val1, val2));

        return page.data("result", services.multiplication(val1, val2));

    }
}
