package org.acme.controller;

import org.jboss.resteasy.spi.BadRequestException;

public class CalculadoraService {

    public Double realizarCalculo(Double valor1, Double valor2, String operador){

        switch (operador){
            case "soma" :
                return valor1 + valor2;
            case "substracao":
                return valor1 - valor2;
            case "divisao":
                return  valor1 / valor2;
            case "multiplicacao":
                return valor1 * valor2;
            default:
                throw new BadRequestException("Solicitação Invalida");
        }
    }
}
