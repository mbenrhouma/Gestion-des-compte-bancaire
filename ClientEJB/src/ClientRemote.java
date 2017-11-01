import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.entites.Compte;
import metierr.BanqueRemote;


public class ClientRemote {

	public static void main(String[] args) {
		try {
			Context ctx = new InitialContext();
			String appName ="BanqueEAR";
			String moduleName="BanqueEJB";
			String beanName="BK";
			String remoteInterfac =BanqueRemote.class.getName();
			String name ="ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+remoteInterfac;
			
			
			BanqueRemote proxy = (BanqueRemote) ctx.lookup(name);
			
			proxy.addCompte(new Compte());
			proxy.addCompte(new Compte());
			proxy.addCompte(new Compte());
	
			Compte cp=proxy.getCompte(1L) ;
			System.out.println(cp.getSolde());
			proxy.verser(1L, 3000);
			proxy.retirer(1L, 2000);
			proxy.virement(1L, 2L, 1000);
			List<Compte> cptes=proxy.listCompte();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				

	}

}
