package webapp;

import gestiondeserreurs.ServiceHibernateException;

import java.util.HashMap;
import java.util.List;

import metier.Catalogue;
import metier.Categorie;
import metier.Comporte;
import metier.Jouet;
import metier.Trancheage;

public interface InterfaceService {

	// Cette m�thode renvoie la liste de tous les jouets
	public abstract List<Jouet> appelejbLesJouets()
			throws ServiceHibernateException;
	
	// Cette m�thode renvoie la liste de tous les catalogues
	public abstract List<Catalogue> appelejbLesCatalogues()throws ServiceHibernateException;

	// Cette m�thode renvoie la liste de toutes les categories
	public abstract List<Categorie> appelejbLesCategories()throws ServiceHibernateException;
	
	// Cette m�thode renvoie la liste de toutes les tranches d'age
	public abstract List<Trancheage> appelejbLesTranches()throws ServiceHibernateException;
	
	public abstract Jouet getUnJouet(String id)
			throws ServiceHibernateException;

	// Cette m�thode ajoute  un jouet
	public abstract void ajouter(Jouet unJouet)
			throws ServiceHibernateException;
	
	// Cette m�thode ajoute  un comporte
		public abstract void ajouterComporte(Comporte unComporte)
				throws ServiceHibernateException;

	// Cette m�thode de type cat�gode renvoie un objet de type cat�gorie
	public abstract Categorie getUneCategorie(String id)throws ServiceHibernateException;

	// Cette m�thode de type cat�gode renvoie un objet de type catalogue
	public abstract Catalogue getUnCatalogue(String id)throws ServiceHibernateException;
	
	// Cette m�thode de type cat�gode renvoie un objet de type catalogue
	public abstract List<Object> getDictionnaireCatalogue(String annee)throws ServiceHibernateException;
	
	public List<Object> getLesCataloguesComplet(int deb,int fin) throws ServiceHibernateException; 
	
	
	// Cette m�thode  renvoie un objet de type Trancheage
	public abstract Trancheage getUneTranche(String id)
			throws ServiceHibernateException;

	// Cette m�thode efface les objets jouets dont les ID sont
	// contenus dans le tableau
	public abstract void effacer(String[] tabnum)
			throws ServiceHibernateException;
	
	// Cette m�thode emet � jour un jouet 
		
	public abstract void  modifier ( Jouet unJouet) throws ServiceHibernateException;
	public abstract void  modifierCatalogue(Catalogue unCatalogue) throws ServiceHibernateException;

}
