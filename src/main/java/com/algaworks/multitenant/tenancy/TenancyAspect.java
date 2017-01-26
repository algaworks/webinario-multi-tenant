package com.algaworks.multitenant.tenancy;

import javax.persistence.EntityManager;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class TenancyAspect {

	@Autowired
	private EntityManager manager;

	@Before("execution(* com.algaworks.multitenant.repository.*.*(..))")
	public void definirTenant() {
		String tenantId = TenancyInterceptor.getTenantId();
		if (tenantId != null) {
			manager.unwrap(Session.class).enableFilter("tenant").setParameter("id", tenantId);
		}
	}

}
