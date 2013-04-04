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

	// Cette méthode renvoie la liste de tous les jouets
	public abstract List<Jouet> appelejbLesJouets()
			throws ServiceHibernateException;
	
	// Cette méthode renvoie la liste de tous les catalogues
	public abstract List<Catalogue> appelejbLesCatalogues()throws ServiceHibernateException;

	// Cette méthode renvoie la liste de toutes les categories
	public abstract List<Categorie> appelejbLesCategories()throws ServiceHibernateException;
	
	// Cette méthode renvoie la liste de toutes les tranches d'age
	public abstract List<Trancheage> appelejbLesTranches()throws ServiceHibernateException;
	
	public abstract Jouet getUnJouet(String id)
			throws ServiceHibernateException;

	// Cette méthode ajoute  un jouet
	public abstract void ajouter(Jouet unJouet)
			throws ServiceHibernateException;
	
	// Cette méthode ajoute  un comporte
		public abstract void ajouterComporte(Comporte unComporte)
				throws ServiceHibernateException;

	// Cette méthode de type catégode renvoie un objet de type catégorie
	public abstract Categorie getUneCategorie(String id)throws ServiceHibernateException;

	// Cette méthode de type catégode renvoie un objet de type catalogue
	public abstract Catalogue getUnCatalogue(String id)throws ServiceHibernateException;
	
	// Cette méthode de type catégode renvoie un objet de type catalogue
	public abstract List<Object> getDictionnaireCatalogue(String annee)throws ServiceHibernateException;
	
	public List<Object> getLesCataloguesComplet(int deb,int fin) throws ServiceHibernateException; 
	
	
	// Cette méthode  renvoie un objet de type Trancheage
	public abstract Trancheage getUneTranche(String id)
			throws ServiceHibernateException;

	// Cette méthode efface les objets jouets dont les ID sont
	// contenus dans le tableau
	public abstract void effacer(String[] tabnum)
			throws ServiceHibernateException;
	
	// Cette méthode emet à jour un jouet 
		
	public abstract void  modifier ( Jouet unJouet) throws ServiceHibernateException;
	public abstract void  modifierCatalogue(Catalogue unCatalogue) throws ServiceHibernateException;

}
