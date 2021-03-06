package br.com.caelum.loja.interceptors;

import java.util.Arrays;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AuditoriaInterceptor {
	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {
		String classe = ctx.getTarget().getClass().getSimpleName();
		String metodo = ctx.getMethod().getName();
		String params = Arrays.toString(ctx.getMethod().getParameterTypes());

		System.out.println("\n\n\n\n");
		System.out.println("*************AUDITORIA**************");
		System.out.println("Acessando: " + classe + "." + metodo + "(" + params
				+ ")");
		System.out.println("\n\n\n\n");

		return ctx.proceed();
	}
}
