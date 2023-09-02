package com.fag;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


import static java.util.Objects.requireNonNull;

@Path("/calculadora")
public class SomePage {

    private final Template page;


    public SomePage(Template page) {
        this.page = requireNonNull(page, "page is required");
        
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return page.data("dados",  "Isa");
    }

}
