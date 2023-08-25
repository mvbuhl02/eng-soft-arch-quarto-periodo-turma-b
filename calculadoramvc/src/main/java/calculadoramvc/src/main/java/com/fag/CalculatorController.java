package calculadoramvc.src.main.java.com.fag;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

@Path("/calculator")
public class CalculatorController {

    private final Template calculator;

    public CalculatorController (Template calculator) {
        this.calculator = requireNonNull(calculator, "calculator is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return calculator.instance();
    }

    @POST
    @Path("/calculate")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)

    public TemplateInstance calculate(@FormParam("num1") double num1,
                                      @FormParam("num2") double num2,
                                      @FormParam("operation") String operation) {
        double result = 0.0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                result = num2 != 0 ? num1 / num2 : Double.NaN;
                break;
            default:
                throw new BadRequestException("Operação inválida");
        }

        return calculator.instance().data("result", result);
    }
}
