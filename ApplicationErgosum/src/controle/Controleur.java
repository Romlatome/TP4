package controle;

import gestiondeserreurs.ServiceHibernateException;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Catalogue;
import metier.Categorie;
import metier.Comporte;
import metier.ComportePK;
import metier.Jouet;
import metier.Trancheage;

import webapp.Service;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";
	private static final String SAISIE_JOUET= "saisiJouet";
	private static final String AJOUTER_JOUET= "AjouterJouet";
	private static final String AFFICHER_JOUET = "voirlesJouets";
	private static final String MODIFIER_JOUET = "modifierJouet";
	private static final String SUPPRIMER_JOUET = "supprimerJouet";
	private static final String ANNEE_CATALOGUE = "selectionAnneeCat";
	private static final String AFFICHE_CATALOGUE = "afficheCatalogue";
	private static final String AFFICHE_CATALOGUE_DICTIONNAIRE = "afficheCatalogueDictionnaire";
	private static final String MODIFIER_BUTTON_JOUET = "modificationFinaleJouet";
	private static final String AFFICHER_DICTIONNAIRE = "afficherDictionnaire";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		gestionActions(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		gestionActions(request,response);
	}

	private void gestionActions(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
			  {
				String pageDestination = "/index.jsp";
				String actionName = request.getParameter(ACTION_TYPE);
				
				System.out.println(actionName);
				// execute l'action
	              // Saisie d'une news :
				if (AFFICHER_JOUET.equals(actionName)) {
					List<Jouet> liste = null;
					Service s = new Service();
					liste =s.appelejbLesJouets();
					
					
					
					for(int i=0;i<liste.size();i++)
					{
						// pour les libelles des categories
						Categorie c = new Categorie();
						c= s.getUneCategorie(liste.get(i).getCodecateg().getId());
						liste.get(i).setCodecateg(c);
						// pour les intitulés des ages
						Trancheage t = new Trancheage();
						t = s.getUneTranche(liste.get(i).getCodetranche().getId());
						liste.get(i).setCodetranche(t);
					}
					
					request.setAttribute("listeJouets", liste);
					pageDestination="/ListeJouets.jsp";
					
		
				}
				else if (AJOUTER_JOUET.equals(actionName)){
					// lorsque l'utilisateur veut aller sur la page pour ajouter un jouet
					Service s = new Service();
					List<Trancheage> t = s.appelejbLesTranches(); // liste des tranches d'age
					List<Categorie> cat = s.appelejbLesCategories(); // liste des categories
					List<Catalogue> catalogue= s.appelejbLesCatalogues(); // liste des catalogues
					
					request.setAttribute("listeTranche",t);
					request.setAttribute("listeCategorie",cat);
					request.setAttribute("listeCatalogue",catalogue);
					pageDestination="/AjouterJouet.jsp";
					
				}
				else if(SAISIE_JOUET.equals(actionName))
				{
					
					String numero = request.getParameter("numero");
					String libelle = request.getParameter("libelle");
					String id_categorie = request.getParameter("lstCategorie");
					String id_tranche = request.getParameter("lstTranche");
					String quantite = request.getParameter("qte");
					String id_catalogue = request.getParameter("lstCatalogue");
					
					Service s = new Service();
					// creation du jouet à ajouter
					Jouet jAjout = new Jouet();
					jAjout.setId(numero);
					jAjout.setLibelle(libelle);
					
					Trancheage t = s.getUneTranche(id_tranche);
					jAjout.setCodetranche(t);
					
					Categorie c = s.getUneCategorie(id_categorie);
					jAjout.setCodecateg(c);
					//ajout du jouet dans la table jouet
					s.ajouter(jAjout);
					
					
					Catalogue cat = s.getUnCatalogue(id_catalogue);
					// ajout d'une ligne dans la table comporte
					Comporte unComporte = new Comporte();
					ComportePK PK_Comporte = new ComportePK();
					PK_Comporte.setNumero(jAjout);
					PK_Comporte.setAnnee(cat);
					unComporte.setId(PK_Comporte);
					unComporte.setQuantite(Integer.parseInt(quantite));
					s.ajouterComporte(unComporte);
					
					pageDestination = "/Controleur?action=voirlesJouets";
			           request.setAttribute("message","ajout");
			           
				}else if(SUPPRIMER_JOUET.equals(actionName))
				{
					//recuperation de la liste des id a effacer
			          String[] ids = request.getParameterValues("id");
			          //effacement de la liste des id
			         Service unService = new Service();
			          
			           if(ids != null)
			            {   unService.effacer(ids); }
			          //preparation de la liste
			           
			           pageDestination = "/Controleur?action=voirlesJouets";
			           request.setAttribute("message","suppri");
				}
				else if(ANNEE_CATALOGUE.equals(actionName))
				{
					Service s = new Service();
					List<Catalogue> catalogue= s.appelejbLesCatalogues(); // liste des catalogues
					request.setAttribute("listeCatalogue",catalogue);
					pageDestination = "/choixCatalogue.jsp";
				}
				else if(AFFICHE_CATALOGUE.equals(actionName))
				{
					String annee_depart = request.getParameter("lstCatalogueDebut");
					String nb_annee = request.getParameter("nbAnnees");
					
					Service s = new Service();
					
					List<Object> catalogue = s.getLesCataloguesComplet(Integer.parseInt(annee_depart),Integer.parseInt(nb_annee));
					request.setAttribute("catalogueComplet", catalogue);
					pageDestination="/AfficherCatalogues.jsp";
					
				}else if(MODIFIER_JOUET.equals(actionName))
				{
					String num = request.getParameter("num");
					Service s = new Service();
					Jouet j = s.getUnJouet(num);
					request.setAttribute("jouet",j);
					List<Categorie> liste = s.appelejbLesCategories();
					List<Trancheage> t = s.appelejbLesTranches(); // liste des tranches d'age
					System.out.println(t.get(0).getId());
					request.setAttribute("listeTranche",t);
					request.setAttribute("listeCategorie",liste);
					pageDestination ="/ModifierJouet.jsp";
				}else if(MODIFIER_BUTTON_JOUET.equals(actionName))
				{
					String numero = request.getParameter("numero");
					String libelle = request.getParameter("libelle");
					String id_categorie = request.getParameter("lstCategorie");
				    String id_tranche = request.getParameter("lstTranche");
					Service s = new Service();
					Categorie c = s.getUneCategorie(id_categorie);
					Trancheage t = s.getUneTranche(id_tranche);
					Jouet j = new Jouet();
					j.setCodetranche(t);
					j.setId(numero);
					j.setLibelle(libelle);
					j.setCodecateg(c);
					
					s.modifier(j);
					pageDestination ="/Controleur?action=voirlesJouets";
					request.setAttribute("message","modif");
				}
				else if (AFFICHER_DICTIONNAIRE.equals(actionName))	
				{
					Service s = new Service();
					List<Catalogue> catalogue= s.appelejbLesCatalogues(); // liste des catalogues
					request.setAttribute("listeCatalogue",catalogue);
					pageDestination="/selectionAnneeCat.jsp";
				}else if (AFFICHE_CATALOGUE_DICTIONNAIRE.equals(actionName))
				{
					String annee = request.getParameter("lstCatalogueDebut");
					Service s = new Service();
					List<Object> listeDictionnaireCatalogue = s.getDictionnaireCatalogue(annee);
					request.setAttribute("listeDico", listeDictionnaireCatalogue);
					pageDestination="/AfficherDictionnaire.jsp";
				}
				
					this.getServletContext().getRequestDispatcher(pageDestination).include(request, response); 
			  }

}
