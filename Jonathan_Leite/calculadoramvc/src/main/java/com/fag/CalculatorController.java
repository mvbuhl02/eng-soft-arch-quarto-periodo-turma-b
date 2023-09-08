import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/calculadora")
public class CalculatorController {

    @Inject
    Template calculatorTemplate; 

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance calculatorForm() {
        return calculatorTemplate.data("result", "")
                                 .data("errorMessage", null);
    }

    @POST
    @Path("/calculate")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance calculate(
        @FormParam("firstValue") double firstValue,
        @FormParam("operation") String operation,
        @FormParam("secondValue") double secondValue
    ) {
        double result = 0.0;
        String errorMessage = null;


       if (operation != null) {
        if (operation.equals("add")) {
            result = firstValue + secondValue;
        } else if (operation.equals("subtract")) {
            result = firstValue - secondValue;
        } else if (operation.equals("multiply")) {
            result = firstValue * secondValue;
        } else if (operation.equals("divide")) {
            if (secondValue == 0) {
                errorMessage = "Divisão por zero não é permitida.";
            } else{
                result = firstValue / secondValue;
            } 
        }
       }
       return calculatorTemplate.data("result", "Resultado: " + result)
                                .data("errorMessage", errorMessage);
    }
}
