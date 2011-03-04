package br.com.caelum.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class CalculadorDeParcela {
	@WebMethod
	public double CalculaParcela(
			@WebParam(name = "valorTotal") double valorTotal,
			@WebParam(name = "quantidade") int qtdde) {

		if (qtdde < 0) {
			return 0;
		}
		
		double oValorTotal = valorTotal * (1 + (qtdde / 100.0));

		return oValorTotal / qtdde;
	}
}
