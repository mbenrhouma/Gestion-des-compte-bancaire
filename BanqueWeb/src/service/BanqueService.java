package service;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metierr.BanqueLocal;

@WebService
public class BanqueService {
   
	@EJB
	private BanqueLocal metier ;
	@WebMethod
	public void verser (
			@WebParam(name="code")long code, 
			@WebParam(name="montant")double mt) {
		
		metier.verser(code,mt);
	}
	
}
