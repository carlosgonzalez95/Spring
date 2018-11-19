package es.indra.spring2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAspect {

	@Before("execution(* es.indra.springcat.service.impl.*.*(..))")
	public void antesDeLosMetodos(JoinPoint join) {

		System.out.println("Dntro del aspecto para: " + join);
	}
}
