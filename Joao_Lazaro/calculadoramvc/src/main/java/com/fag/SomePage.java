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


@Path("/some-page")
public class SomePage {

    private final Template page;

    public SomePage(Template page) {
        this.page = requireNonNull(page, "page is required");
    }
    
    public Double addition (double val1, double val2){
        return val1 + val2;
    }

   public Double subtraction(double val1, double val2){
        return val1 - val2;
    }

    public Double division (double val1, double val2){
        return val1 / val2;
    }

    public Double multiplication(double val1, double val2){
        return val1 * val2;
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

        return page.data("result", addition(val1, val2));

        return page.data("result", subtraction(val1, val2));

        return page.data("result", division(val1, val2));

        return page.data("result", multiplication(val1, val2));

}
}