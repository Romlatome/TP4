package webapp;

import gestion.GestionErgosum;
import gestiondeserreurs.ServiceHibernateException;

import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import metier.Catalogue;
import metier.Categorie;
import metier.Comporte;
import metier.Jouet;
import metier.Trancheage;

public class Service implements InterfaceService{

	public Service() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<Jouet> appelejbLesJouets() throws ServiceHibernateException {
		List <Jouet> listeJouet = null;
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			listeJouet = g.appelEjbLesJouets();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listeJouet;
	}

	@Override
	public List<Catalogue> appelejbLesCatalogues()
			throws ServiceHibernateException {
		List <Catalogue> listeCatalogue = null;
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			listeCatalogue = g.appelEjbLesCatalogues();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listeCatalogue;
	}

	@Override
	public List<Categorie> appelejbLesCategories()
			throws ServiceHibernateException {
		List <Categorie> listeCategorie = null;
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			listeCategorie = g.appelEJBLesCategories();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listeCategorie;
	}

	@Override
	public List<Trancheage> appelejbLesTranches()
			throws ServiceHibernateException {
		List <Trancheage> listeTrancheage = null;
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			listeTrancheage = g.appelEJBLesTranches();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listeTrancheage;
	}

	@Override
	public Jouet getUnJouet(String id) throws ServiceHibernateException {
		Jouet j = null;
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			j = g.getUnJouet(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return j;
	}

	@Override
	public void ajouter(Jouet unJouet) throws ServiceHibernateException {
	
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			g.ajouter(unJouet);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Categorie getUneCategorie(String id)
			throws ServiceHibernateException {
		Categorie c = null;
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			c = g.getUneCategorie(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public Catalogue getUnCatalogue(String id) throws ServiceHibernateException {
		Catalogue cat = null;
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			cat = g.getUnCatalogue(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cat;
	}

	@Override
	public List<Object> getDictionnaireCatalogue(String annee)
			throws ServiceHibernateException {
		List<Object> dictionnaire = null;
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			dictionnaire = (List<Object>) g.getDictionnaireCatalogue(annee);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dictionnaire;
	}

	@Override
	public Trancheage getUneTranche(String id) throws ServiceHibernateException {
		Trancheage t = null;
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			t = g.getUneTranche(id);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}

	@Override
	public void effacer(String[] tabnum) throws ServiceHibernateException {
		
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			g.effacer(tabnum);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(Jouet unJouet) throws ServiceHibernateException {
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			g.modifier(unJouet);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public void modifierCatalogue(Catalogue unCatalogue)
			throws ServiceHibernateException {
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			g.modifierCatalogue(unCatalogue);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void ajouterComporte(Comporte unComporte) throws ServiceHibernateException {
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			g.ajouterComporte(unComporte);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}


	@Override
	public List<Object> getLesCataloguesComplet(int deb, int fin)
			throws ServiceHibernateException {
		List<Object> dictionnaire = null;
		Context ctx;
		try {
			ctx = JBossContext.getInitialContext();
			GestionErgosum g = (GestionErgosum)ctx.lookup("EJBErgosum");
			
			dictionnaire = g.getLesCataloguesComplet(deb,fin);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dictionnaire;
	}

}
