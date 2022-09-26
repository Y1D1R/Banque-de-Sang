import java.util.ArrayList;
import java.time.LocalDate;
import java.util.*;

public class Banque_de_sang {
	
	String Nom_Banque, adresse , NomDirecteur , Numero_tlph;
	int age=0;
	
	
	public static ArrayList<Mini_stock> Stock = new ArrayList<Mini_stock>();
	
	
	static Mini_stock Stock_O_p = new Mini_stock(Groupe_Sanguin.O_positif);
	static Mini_stock Stock_O_n = new Mini_stock(Groupe_Sanguin.O_négatif);
	static Mini_stock Stock_A_p = new Mini_stock(Groupe_Sanguin.A_positif);
	static Mini_stock Stock_A_n = new Mini_stock(Groupe_Sanguin.A_négatif);
	static Mini_stock Stock_B_p = new Mini_stock(Groupe_Sanguin.B_positif);
	static Mini_stock Stock_B_n = new Mini_stock(Groupe_Sanguin.B_négatif);
	static Mini_stock Stock_AB_p = new Mini_stock(Groupe_Sanguin.AB_positif);
	static Mini_stock Stock_AB_n = new Mini_stock(Groupe_Sanguin.AB_négatif);
	
	//NOMBRES TOTALS DE POCHES PAR GROUPE SANGUIN .
	static int ap = 0 , an = 0 ,bp = 0 , bn = 0 ,op = 0 , on = 0 , abp = 0 , abn = 0 ;
	
	public static ArrayList<Donneur> liste_donneur = new ArrayList<Donneur>();
	public static ArrayList<Demande_don> demandes_don = new ArrayList<Demande_don>();
	public static ArrayList<Demande_sang> demande_sang = new ArrayList<Demande_sang>();
	public static ArrayList<Demande_sang> dons_succes = new ArrayList<Demande_sang>();
	
	Scanner sc = new Scanner(System.in);
	
	//CONSTRUCTEUR
	public Banque_de_sang(String Nom_Banque, String adresse , String NomDirecteur , String num)
	{
		this.Nom_Banque = Nom_Banque;
		this.adresse = adresse ;
		this.NomDirecteur = NomDirecteur;
		this.Numero_tlph = num;

		Stock.add(Stock_O_p);
		Stock.add(Stock_O_n);
		Stock.add(Stock_A_p);
		Stock.add(Stock_A_n);
		Stock.add(Stock_B_p);
		Stock.add(Stock_B_n);
		Stock.add(Stock_AB_p);
		Stock.add(Stock_AB_n);
		
		
	}
	
	
	//GETTERS AND SETTERS
	
	public String getNom_Banque() {
		return Nom_Banque;
	}
	public void setNom_Banque(String nom_Banque) {
		Nom_Banque = nom_Banque;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNomDirecteur() {
		return NomDirecteur;
	}
	public void setNomDirecteur(String nomDirecteur) {
		NomDirecteur = nomDirecteur;
	}
	public String getNumero_tlph() {
		return Numero_tlph;
	}
	public void setNumero_tlph(String numero_tlph) {
		Numero_tlph = numero_tlph;
	}

	
    //AJOUETR UN DONNEUR (Dans test)
	public void ajouterDonneur(Donneur d )
	{
		liste_donneur.add(d);
	}
	
	//ETIQUETTE GENRE
	private Genre etiq_genre()
	{
		Genre gnr = null;
	try {
	
	System.out.print("Genre[male,female] : "); 
	gnr = Genre.valueOf(sc.next()); 
	}
	catch(IllegalArgumentException e)
	{
		System.out.println("genre erroné!!! \n");
		etiq_genre();
	}
	return gnr;
	}
	
	//ETIQUETTE GROUPE SANGUIN
	private Groupe_Sanguin etiq_groupe_sanguin()
	{
		Groupe_Sanguin gr = null;
	try {
	
	System.out.print("\n Groupe sanguin[O_positif,O_négatif,A_positif,A_négatif,B_positif,B_négatif,AB_positif,AB_négatif] : "); 
	gr = Groupe_Sanguin.valueOf(sc.next()); 
	
	
	}
	catch(IllegalArgumentException e)
	{
		System.out.println("groupe sanguin erroné!!! \n");
		etiq_groupe_sanguin();
	}
	return gr;
	}
	
	//CHERCHER SI LE USERNAME EST DEJA EXISTANT
	private boolean chercher_username(String user)
	{
		ArrayList<String> l = new ArrayList<String>();
		for(int i = 0 ; i < liste_donneur.size() ; i++)
		{
			l.add(liste_donneur.get(i).username);
		}
		if(l.contains(user)==true) return true ; 
		else return false;
	}
	
	//AJOUTER UN NOUVEAU DONNEUR A PARTIR DE LA BANQUE DE SANG
	public void ajout_donneur()
	{
		System.out.println("=================================================================\n");
		Groupe_Sanguin gr; Genre gnr=null;String user;
		System.out.println("Veillez saisir les informations sur le donneur a ajouter :");
		sc.nextLine();
		System.out.print("Nom Complet : "); String nom = sc.nextLine();
		System.out.print("Adresse :  "); String adr = sc.nextLine() ; 
		System.out.print("contact : "); String cont = sc.nextLine();
		System.out.print("email : "); String email = sc.next();
		gnr = etiq_genre() ;
		do {
		System.out.print("age [min:18 | max:65] : "); age = sc.nextInt();
		}while(age<18 || age>65);
		 gr = etiq_groupe_sanguin() ;
		sc.nextLine();
		System.out.print("remarque : "); String rem = sc.nextLine();
		do {
		System.out.print("username : ");  user = sc.next();
	    }while(chercher_username(user)==true);
		System.out.print("password : "); String psw = sc.next(); 
		System.out.println("\n\n");
		liste_donneur.add(new Donneur(nom,adr,cont,email,gnr,age,gr,rem,user,psw));
		System.out.println("Donneur ajouté avec succés \n\n");
	}
	
	//SUPPRIMER UN DONNEUR A PARTIR DE LA BANQUE DE SANG
	public void supprimer_donneur()
	{
		System.out.println("=================================================================\n");
		Donneur d = null ;
		System.out.print("Donnez le numero du donneur a supprimer ");
		int num = sc.nextInt();
		System.out.println("\n");
		for(int i = 0 ; i < liste_donneur.size() ; i++ )
		{
			if(liste_donneur.get(i).num_seq==num)
				d = liste_donneur.get(i);
		}
		if(d==null)
		{
			System.out.println("Numéro du donneur inexistant !! \n");
		}
		else {
		liste_donneur.remove(d);
		System.out.println("Donneur supprimé avec succés \n ");
		}
	}
	
	//TRAITEMENT DES DEMANDES DE DONS
	public void traitement_demande()
	{
		Demande_don dem = null ;
		String rep;
		System.out.println("=================================================================\n");
		System.out.println("Saisissez le numero du donneur ayant effectué la demande");
		int nums = sc.nextInt();
		
		for(int i = 0 ; i < demandes_don.size() ; i++)
		{
			if(demandes_don.get(i).donneur.num_seq==nums)
			{
				dem = demandes_don.get(i) ;
			}
		}
		if(dem==null)
		{
			System.out.println("Demande Introuvable pour le numéro du donneur saisi \n\n");
		}
		else
		{
		System.out.println("Traitemant de la demande de "+ dem.donneur.NomComplet + "\n" );
		do {
		System.out.print("Validez-vous cette demande [A:Accepter / R:Rejeter]  : ");
		rep = sc.next(); 
		System.out.println("\n\n");
		}while(rep.equals("A")==false && rep.equals("R")==false);
	
		if(rep.equals("R"))
		{
			System.out.println("La demande de "+ dem.donneur.NomComplet + " faite le " + dem.date + " est rejetée \n\n");
			demandes_don.remove(dem);
		}
		else if(rep.equals("A"))
		{
			
			System.out.println("La demande de "+ dem.donneur.NomComplet + " faite le " + dem.date + " est acceptée \n\n");
			System.out.println("Le stock est mis A Jour\n\n ");
			ajouter_au_stock(dem);
			demandes_don.remove(dem);
		}
		
		}
	}
	
	//MISE A JOUR DU STOCK 
	private void ajouter_au_stock(Demande_don dem)
	{
	 
		if(dem.donneur.groupe_sanguin.equals(Groupe_Sanguin.O_positif))
		{
			Stock_O_p.liste.add(new Cont_Stock(dem.nb_poches , dem.donneur.num_seq ,  dem.date ));
			op = op + dem.nb_poches ; 
		} else
			if(dem.donneur.groupe_sanguin.equals(Groupe_Sanguin.O_négatif))
			{
				Stock_O_n.liste.add(new Cont_Stock(dem.nb_poches , dem.donneur.num_seq , dem.date ));
				on = on + dem.nb_poches ; 
			} else 
				if(dem.donneur.groupe_sanguin.equals(Groupe_Sanguin.A_positif))
				{
					Stock_A_p.liste.add(new Cont_Stock(dem.nb_poches , dem.donneur.num_seq , dem.date ));
					ap = ap + dem.nb_poches ; 
				} else
					if(dem.donneur.groupe_sanguin.equals(Groupe_Sanguin.A_négatif))
					{
						 Stock_A_n.liste.add(new Cont_Stock(dem.nb_poches , dem.donneur.num_seq , dem.date ));
						 an = an + dem.nb_poches ; 
					} else
						if(dem.donneur.groupe_sanguin.equals(Groupe_Sanguin.B_positif))
						{
							Stock_B_p.liste.add(new Cont_Stock(dem.nb_poches , dem.donneur.num_seq , dem.date ));
							bp = bp + dem.nb_poches ; 
						} else
							if(dem.donneur.groupe_sanguin.equals(Groupe_Sanguin.B_négatif))
							{
								Stock_B_n.liste.add(new Cont_Stock(dem.nb_poches , dem.donneur.num_seq , dem.date ));
								bn = bn + dem.nb_poches ; 
							} else
								if(dem.donneur.groupe_sanguin.equals(Groupe_Sanguin.AB_positif))
								{
									Stock_AB_p.liste.add(new Cont_Stock(dem.nb_poches , dem.donneur.num_seq , dem.date ));
									abp = abp + dem.nb_poches ; 
								} else
									if(dem.donneur.groupe_sanguin.equals(Groupe_Sanguin.AB_négatif))
									{
										Stock_AB_n.liste.add(new Cont_Stock(dem.nb_poches , dem.donneur.num_seq , dem.date ));
										abn = abn + dem.nb_poches ; 
									}
	  
	}
	
	//AFFICHAGE INFORMATIONS DONNEURS
	public void afficher_donneurs()
	{
		System.out.println("=================================================================\n");
		System.out.println("\t Liste Des Donneurs \n");
		for(int i = 0 ; i < liste_donneur.size() ; i++ )
		{
			
			System.out.println("Numéro du donneur : "+liste_donneur.get(i).num_seq);
			System.out.println("Nom du donneur : "+liste_donneur.get(i).NomComplet);
			System.out.println("Adresse : "+liste_donneur.get(i).Adresse);
			System.out.println("age : "+liste_donneur.get(i).age);
			System.out.println("Groupe Sanguin : " +liste_donneur.get(i).groupe_sanguin);
			System.out.println("Genre : "+liste_donneur.get(i).genre);
			System.out.println("username : "+liste_donneur.get(i).username);
			System.out.println("password : "+liste_donneur.get(i).password + "\n\n");
		}
	}
	
	//AFFICHAGE DU STOCK
	public void afficher_Stock()
	{
		System.out.println("=================================================================\n");
		System.out.println("\t STOCK");
		for(int i = 0 ; i <Stock.size() ; i++)
		{
			System.out.println("**" +Stock.get(i).groupe);
			for(int j = 0 ; j < Stock.get(i).liste.size() ; j++)
			{
				System.out.println(Stock.get(i).liste.get(j).nb_poches+" poches du donneur N° "+Stock.get(i).liste.get(j).num + "  extraites le "+Stock.get(i).liste.get(j).date_relev);
			}
			System.out.println("\n");
		}
		
		System.out.println("\t Affichage de nombre total de poches par groupe sanguin : \n");
		System.out.println("\n Nombre total de poches [A_positif]= " + ap);
		System.out.println("\n Nombre total de poches [A_négatif]= " + an);
		System.out.println("\n Nombre total de poches [B_positif]= " + bp);
		System.out.println("\n Nombre total de poches [B_négatif]= " + bn);
		System.out.println("\n Nombre total de poches [O_positif]= " + op);
		System.out.println("\n Nombre total de poches [O_négatif]= " + on);
		System.out.println("\n Nombre total de poches [AB_positif]= " + abp);
		System.out.println("\n Nombre total de poches [AB_négatif]= " + abn + "\n\n");
	}
	
	//AFFICHAGE DES DEMANDES DE DONS
	public void afficher_demandes_don()
	{
		System.out.println("=================================================================\n");
		System.out.println("\t DEMANDES DE DONS:");
		for ( int i = 0 ; i < demandes_don.size() ; i++)
		{
			System.out.println("le numéro du donneur "+demandes_don.get(i).donneur.num_seq);
			System.out.println("le nom du donneur "+demandes_don.get(i).donneur.NomComplet);
			System.out.println("nombre de poches "+demandes_don.get(i).nb_poches);
			System.out.println("Date de demande \n"+demandes_don.get(i).date + "\n\n");
		}
	}
	
	
	//ENREGISTRER UNE DEMANDE DE SANG
	public void demande_sang()
	{
		
		String rep , rep2 ;
		Groupe_Sanguin gr =null ; int nb;
		System.out.println("=================================================================\n");
		System.out.println("\n Veillez saisir les informations sur la demande \n");
		gr = etiq_groupe_sanguin();
		sc.nextLine();
		System.out.print("Nom du patient : ");  String nom = sc.nextLine();
		
		do {
	    	System.out.print("nbre de poches[au max 8 ] : "); nb = sc.nextInt() ; 
	    }while(nb<=0 || nb>8);
	   sc.nextLine();
	   
		System.out.print("objectif : "); String obj = sc.nextLine();
	  
	    System.out.print("Remarques : "); String rem = sc.nextLine();
	    
	    do {System.out.println("\n Avez vous trouvé un donneur??  [oui/non]");
	    rep = sc.next() ; } while(rep.equals("oui")==false && rep.equals("non")==false);
	    if(rep.equals("oui"))
	    {
	    	sc.nextLine();
	    	System.out.println("Numéro du donneur : ");
	    	int numd = sc.nextInt() ; 
	    	 demande_sang.add(new Demande_sang(nom,numd , gr,nb,java.time.LocalDate.now(),obj,rem));
	    	 System.out.println("Votre demande a été enregistrée avec succés!!! \n\n");
	    }
	    else
	    {	    
	  	    	if(nb>3)
	  	    	{
	  	    		do {System.out.println("\n Acceptez vous recevoir au max 3 poches??[oui/non] ");
	  		  	    rep2 = sc.next() ; } while(rep2.equals("oui")==false && rep2.equals("non")==false);
	  	    		if(rep2.equals("oui")) {
	  	    	 demande_sang.add(new Demande_sang(nom,-1, gr,3,java.time.LocalDate.now(),obj,rem));
	  	    	System.out.println("Votre demande a été enregistrée avec succés!!! \n\n");
	  	    	}
	  	    	else
	  	    	{
	  	    		System.out.println(" \n Merci !!! \n");
	  	    		
	  	    	}
	  	    }
	  	    else
	  	    {
	  	    	demande_sang.add(new Demande_sang(nom,-1, gr,nb,java.time.LocalDate.now(),obj,rem));
	  	    	System.out.println("Votre demande a été enregistrée avec succés!!! \n\n");
	  	    }
	    	  
	    }
	    
	    
	    
	}
	
	
	//TRAITEMENT DES DEMANDES DE SANG
	public void Traitement_demandes_sang()
	{
		String rep2 ;  int t=0;
		
		System.out.println("=================================================================\n");
		sc.nextLine();
		System.out.println("Donnez le nom du patient ayant effectué la demande !");
		String  nom = sc.nextLine();
		int i = 0 ; 
		boolean trouve = false ;
		while( i < demande_sang.size() && trouve == false)
		{   
			if(demande_sang.get(i).NomPatient.equals(nom))
				
			{
				int dd = demande_sang.get(i).numd ;
				if(dd==-1)
				{
					
					afficher_demandes_sang_patient(i);
					
					do {System.out.println("\nAcceptez vous de valider cette demande ??[oui/non] ");
	  		  	    rep2 = sc.next() ; } while(rep2.equals("oui")==false && rep2.equals("non")==false);
					if(rep2.equals("oui"))
							{
					Groupe_Sanguin ff = demande_sang.get(i).groupe_sanguin ;
					
					if(ff.equals(Groupe_Sanguin.A_positif)==true) 
					{
					
						if(ap<demande_sang.get(i).nb_poches) {
							System.out.println("Stock insufisant !\n\n");
						}else {
							int p=demande_sang.get(i).nb_poches;
							while(p>0) {
								if(p>=Stock_A_p.liste.get(t).nb_poches) {
								p=p-Stock_A_p.liste.get(t).nb_poches;
								Stock_A_p.liste.remove(t);	
								ap = ap - demande_sang.get(i).nb_poches;
								}else {
									Stock_A_p.liste.get(t).nb_poches=Stock_A_p.liste.get(t).nb_poches-p;
									this.ap = this.ap - demande_sang.get(i).nb_poches;
									p=0;
								
								}
								
						}
							
							dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
							demande_sang.remove(i);
							System.out.println("Le don est effectué le stock est mis a jour!!");
							System.out.println("La liste des dons fait avec succés est mise A Jour!! \n\n");
							
					}
					
				    }
					
					if(ff.equals(Groupe_Sanguin.A_négatif)==true) 
					{
						
						if(an<demande_sang.get(i).nb_poches) {
							System.out.println("Stock insufisant !\n\n");
						}else {
							int p=demande_sang.get(i).nb_poches;
							while(p>0) {
								if(p>=Stock_A_n.liste.get(t).nb_poches) {
								p=p-Stock_A_n.liste.get(t).nb_poches;
								Stock_A_n.liste.remove(t);		
								this.an = this.an - demande_sang.get(i).nb_poches;
								}else {
									Stock_A_n.liste.get(t).nb_poches=Stock_A_n.liste.get(t).nb_poches-p;
									this.an = this.an - demande_sang.get(i).nb_poches;
									p=0;
								
								}
								
						}
							dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
							demande_sang.remove(i);
							System.out.println("Le don est effectué le stock est mis a jour!!");
							System.out.println("La liste des dons fait avec succés est mise A Jour!! \n\n");
							
					}
					
				}
					
					if(ff.equals(Groupe_Sanguin.O_positif)==true) 
					{
						
						if(op<demande_sang.get(i).nb_poches) {
							System.out.println("Stock insufisant !\n\n");
						}else {
							int p=demande_sang.get(i).nb_poches;
							while(p>0) {
								if(p>=Stock_O_p.liste.get(t).nb_poches) {
								p=p-Stock_O_p.liste.get(t).nb_poches;
								Stock_O_p.liste.remove(t);	
								this.op = this.op - demande_sang.get(i).nb_poches;
								}else {
									Stock_O_p.liste.get(t).nb_poches=Stock_O_p.liste.get(t).nb_poches-p;
									this.op = this.op - demande_sang.get(i).nb_poches;
									p=0;
								
								}
								
						}
							dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
							demande_sang.remove(i);
							System.out.println("Le don est effectué le stock est mis a jour!!");
							System.out.println("La liste des dons fait avec succés est mise A Jour!! \n\n");
					}
					
				}
					
					if(ff.equals(Groupe_Sanguin.O_négatif)==true) 
					{
						
						if(on<demande_sang.get(i).nb_poches) {
							System.out.println("Stock insufisant !\n\n");
						}else {
							int p=demande_sang.get(i).nb_poches;
							while(p>0) {
								if(p>=Stock_O_n.liste.get(t).nb_poches) {
								p=p-Stock_O_n.liste.get(t).nb_poches;
								Stock_O_n.liste.remove(t);		
								this.on = this.on - demande_sang.get(i).nb_poches;
								}else {
									Stock_O_n.liste.get(t).nb_poches=Stock_O_n.liste.get(t).nb_poches-p;
									this.on = this.on - demande_sang.get(i).nb_poches;
									p=0;
								
								}
								
						}
							dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
							demande_sang.remove(i);
							System.out.println("Le don est effectué le stock est mis a jour!!");
							System.out.println("La liste des dons fait avec succés est mise A Jour!! \n\n");
							
					}
					
				}
					
					if(ff.equals(Groupe_Sanguin.B_positif)==true) 
					{
						
						if(bp<demande_sang.get(i).nb_poches) {
							System.out.println("Stock insufisant !\n\n");
						}else {
							int p=demande_sang.get(i).nb_poches;
							while(p>0) {
								if(p>=Stock_B_p.liste.get(t).nb_poches) {
								p=p-Stock_B_p.liste.get(t).nb_poches;
								Stock_B_p.liste.remove(t);		
								this.bp = this.bp - demande_sang.get(i).nb_poches;
								}else {
									Stock_B_p.liste.get(t).nb_poches=Stock_B_p.liste.get(t).nb_poches-p;
									this.bp = this.bp - demande_sang.get(i).nb_poches;
									p=0;
								
								}
								
						}
							dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
							demande_sang.remove(i);
							System.out.println("Le don est effectué le stock est mis a jour!!");
							System.out.println("La liste des dons fait avec succés est mise A Jour!! \n\n");
							
					}
					
				}
					
					if(ff.equals(Groupe_Sanguin.B_négatif)==true) 
					{
						
						if(bn<demande_sang.get(i).nb_poches) {
							System.out.println("Stock insufisant !\n\n");
						}else {
							int p=demande_sang.get(i).nb_poches;
							while(p>0) {
								if(p>=Stock_B_n.liste.get(t).nb_poches) {
								p=p-Stock_B_n.liste.get(t).nb_poches;
								Stock_B_n.liste.remove(t);	
								this.bn = this.bn - demande_sang.get(i).nb_poches;
								}else {
									Stock_B_n.liste.get(t).nb_poches=Stock_B_n.liste.get(t).nb_poches-p;
									this.bn = this.bn - demande_sang.get(i).nb_poches;
									p=0;
								
								}
								
						}
							dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
							demande_sang.remove(i);
							System.out.println("Le don est effectué le stock est mis a jour!!");
							System.out.println("La liste des dons fait avec succés est mise A Jour!! \n\n");
					}
					
				}
					
					if(ff.equals(Groupe_Sanguin.AB_positif)==true) 
					{
						
						if(abp<demande_sang.get(i).nb_poches) {
							System.out.println("Stock insufisant !\n\n");
						}else {
							int p=demande_sang.get(i).nb_poches;
							while(p>0) {
								if(p>=Stock_AB_p.liste.get(t).nb_poches) {
								p=p-Stock_AB_p.liste.get(t).nb_poches;
								Stock_AB_p.liste.remove(t);		
								this.abp = this.abp - demande_sang.get(i).nb_poches;
								}else {
									Stock_AB_p.liste.get(t).nb_poches=Stock_AB_p.liste.get(t).nb_poches-p;
									this.abp = this.abp - demande_sang.get(i).nb_poches;
									p=0;
								
								}
								
						}
							dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
							demande_sang.remove(i);
							System.out.println("Le don est effectué le stock est mis a jour!!");
							System.out.println("La liste des dons fait avec succés est mise A Jour!! \n\n");
							
					}
					
				}
					
					if(ff.equals(Groupe_Sanguin.AB_négatif)==true) 
					{
						
						if(abn<demande_sang.get(i).nb_poches) {
							System.out.println("Stock insufisant !\n\n");
						}else {
							int p=demande_sang.get(i).nb_poches;
							while(p>0) {
								if(p>=Stock_AB_n.liste.get(t).nb_poches) {
								p=p-Stock_AB_n.liste.get(t).nb_poches;
								Stock_AB_n.liste.remove(t);		
								this.abn = this.abn - demande_sang.get(i).nb_poches;
								}else {
									Stock_AB_n.liste.get(t).nb_poches=Stock_AB_n.liste.get(t).nb_poches-p;
									this.abn = this.abn - demande_sang.get(i).nb_poches;
									p=0;
								
								}
								
						}
							dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
							demande_sang.remove(i);
							System.out.println("Le don est effectué le stock est mis a jour!!");
							System.out.println("La liste des dons fait avec succés est mise A Jour!! \n\n");
							
					}
					
				}
							
							}else 
							{
							System.out.println("Cette demande ne peut pas etre acceptée!!!");	
							}
					
				
				trouve=true;
			}
				else // SI LE NOM DU DONNEUR EST DIFFERENT DE "///"
				{
					//afficher_demandes_sang_patient(i);	
					Groupe_Sanguin ff1 = demande_sang.get(i).groupe_sanguin ;
					int numd =  demande_sang.get(i).numd;
					
					//A_POSITIF
					if(ff1.equals(Groupe_Sanguin.A_positif)==true) 
					{
					
						int y=0; boolean trv=false;
						while(y<Stock_A_p.liste.size() && trv==false)
						{
							if(Stock_A_p.liste.get(y).num==numd)
							{
							    if(Stock_A_p.liste.get(y).nb_poches>demande_sang.get(i).nb_poches)
							    {
							    	Stock_A_p.liste.get(y).nb_poches=Stock_A_p.liste.get(y).nb_poches-demande_sang.get(i).nb_poches;
									ap = ap - demande_sang.get(i).nb_poches;
									System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
									dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
									demande_sang.remove(i);
							    }
							    else 
							    	if(Stock_A_p.liste.get(y).nb_poches<demande_sang.get(i).nb_poches)
							        {
							         	System.out.println("Le don ne peut pas etre validé! Le nombre de poches données par le donneur est insuffisant \n\n");
							         	demande_sang.remove(i);
							        } else
							    	   if(Stock_A_p.liste.get(y).nb_poches==demande_sang.get(i).nb_poches)
							    	   {
											Stock_A_p.liste.remove(y);	
											ap = ap - demande_sang.get(i).nb_poches;
											System.out.println("La demande de sang est valide ! Le stock est mis A Jour!");
											dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
											demande_sang.remove(i);
							    	   }
								trv=true;
							}
							else
							{
								y++;
							}
						}
						if(trv==false)
						{
							System.out.println("Aucun don pour le donneur saisi ! Demande Refusée !\n\n");
							demande_sang.remove(i);
						}
						
					
				    }
					
					//A_NEGATIF
					if(ff1.equals(Groupe_Sanguin.A_négatif)==true) 
					{
					
						int y=0; boolean trv=false;
						while(y<Stock_A_n.liste.size() && trv==false)
						{
							if(Stock_A_n.liste.get(y).num==numd)
							{
							    if(Stock_A_n.liste.get(y).nb_poches>demande_sang.get(i).nb_poches)
							    {
							    	Stock_A_n.liste.get(y).nb_poches=Stock_A_n.liste.get(y).nb_poches-demande_sang.get(i).nb_poches;
									an = an - demande_sang.get(i).nb_poches;
									System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
									dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
									demande_sang.remove(i);
							    }
							    else 
							    	if(Stock_A_n.liste.get(y).nb_poches<demande_sang.get(i).nb_poches)
							        {
							         	System.out.println("Le don ne peut pas etre validé! Le nombre de poches données par le donneur est insuffisant \n\n");
							         	demande_sang.remove(i);
							        } else
							    	   if(Stock_A_n.liste.get(y).nb_poches==demande_sang.get(i).nb_poches)
							    	   {
											Stock_A_n.liste.remove(y);	
											an = an - demande_sang.get(i).nb_poches;
											System.out.println("La demande de sang est valide ! Le stock est mis A Jour!");
											dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
											demande_sang.remove(i);
							    	   }
								trv=true;
							}
							else
							{
								y++;
							}
						}
						if(trv==false)
						{
							System.out.println("Aucun don pour le donneur saisi ! Demande Refusée !\n\n");
							demande_sang.remove(i);
						}
						
					
				    }
					//O_POSITIF
					if(ff1.equals(Groupe_Sanguin.O_positif)==true) 
					{
					
						int y=0; boolean trv=false;
						while(y<Stock_O_p.liste.size() && trv==false)
						{
							if(Stock_O_p.liste.get(y).num==numd)
							{
							    if(Stock_O_p.liste.get(y).nb_poches>demande_sang.get(i).nb_poches)
							    {
							    	Stock_O_p.liste.get(y).nb_poches=Stock_O_p.liste.get(y).nb_poches-demande_sang.get(i).nb_poches;
									op = op - demande_sang.get(i).nb_poches;
									System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
									dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
									demande_sang.remove(i);
							    }
							    else 
							    	if(Stock_O_p.liste.get(y).nb_poches<demande_sang.get(i).nb_poches)
							        {
							         	System.out.println("Le don ne peut pas etre validé! Le nombre de poches données par le donneur est insuffisant \n\n");
							         	demande_sang.remove(i);
							        } else
							    	   if(Stock_O_p.liste.get(y).nb_poches==demande_sang.get(i).nb_poches)
							    	   {
											Stock_O_p.liste.remove(y);	
											op = op - demande_sang.get(i).nb_poches;
											System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
											dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
											demande_sang.remove(i);
							    	   }
								trv=true;
							}
							else
							{
								y++;
							}
						}
						if(trv==false)
						{
							System.out.println("Aucun don pour le donneur saisi ! Demande Refusée !\n\n");
							demande_sang.remove(i);
						}
						
					
				    }
					//O_négatif
					if(ff1.equals(Groupe_Sanguin.O_négatif)==true) 
					{
					
						int y=0; boolean trv=false;
						while(y<Stock_O_n.liste.size() && trv==false)
						{
							if(Stock_O_n.liste.get(y).num==numd)
							{
							    if(Stock_O_n.liste.get(y).nb_poches>demande_sang.get(i).nb_poches)
							    {
							    	Stock_O_n.liste.get(y).nb_poches=Stock_O_n.liste.get(y).nb_poches-demande_sang.get(i).nb_poches;
									on = on - demande_sang.get(i).nb_poches;
									System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
									dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
									demande_sang.remove(i);
							    }
							    else 
							    	if(Stock_O_n.liste.get(y).nb_poches<demande_sang.get(i).nb_poches)
							        {
							         	System.out.println("Le don ne peut pas etre validé! Le nombre de poches données par le donneur est insuffisant \n\n");
							         	demande_sang.remove(i);
							        } else
							    	   if(Stock_O_n.liste.get(y).nb_poches==demande_sang.get(i).nb_poches)
							    	   {
											Stock_O_n.liste.remove(y);	
											on = on - demande_sang.get(i).nb_poches;
											System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
											dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
											demande_sang.remove(i);
							    	   }
								trv=true;
							}
							else
							{
								y++;
							}
						}
						if(trv==false)
						{
							System.out.println("Aucun don pour le donneur saisi ! Demande Refusée !\n\n");
							demande_sang.remove(i);
						}
						
					
				    }
					
					//B_POSITIF
					if(ff1.equals(Groupe_Sanguin.B_positif)==true) 
					{
					
						int y=0; boolean trv=false;
						while(y<Stock_B_p.liste.size() && trv==false)
						{
							if(Stock_B_p.liste.get(y).num==numd)
							{
							    if(Stock_B_p.liste.get(y).nb_poches>demande_sang.get(i).nb_poches)
							    {
							    	Stock_B_p.liste.get(y).nb_poches=Stock_B_p.liste.get(y).nb_poches-demande_sang.get(i).nb_poches;
									bp = bp - demande_sang.get(i).nb_poches;
									System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
									dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
									demande_sang.remove(i);
							    }
							    else 
							    	if(Stock_B_p.liste.get(y).nb_poches<demande_sang.get(i).nb_poches)
							        {
							         	System.out.println("Le don ne peut pas etre validé! Le nombre de poches données par le donneur est insuffisant \n\n");
							         	demande_sang.remove(i);
							        } else
							    	   if(Stock_B_p.liste.get(y).nb_poches==demande_sang.get(i).nb_poches)
							    	   {
											Stock_B_p.liste.remove(y);	
											bp = bp - demande_sang.get(i).nb_poches;
											System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
											dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
											demande_sang.remove(i);
							    	   }
								trv=true;
							}
							else
							{
								y++;
							}
						}
						if(trv==false)
						{
							System.out.println("Aucun don pour le donneur saisi ! Demande Refusée !\n\n");
							demande_sang.remove(i);
						}
						
					
				    }
					//B_NEGATIF
					if(ff1.equals(Groupe_Sanguin.B_négatif)==true) 
					{
					
						int y=0; boolean trv=false;
						while(y<Stock_B_n.liste.size() && trv==false)
						{
							if(Stock_B_n.liste.get(y).num==numd)
							{
							    if(Stock_B_n.liste.get(y).nb_poches>demande_sang.get(i).nb_poches)
							    {
							    	Stock_B_n.liste.get(y).nb_poches=Stock_B_n.liste.get(y).nb_poches-demande_sang.get(i).nb_poches;
									bn = bn - demande_sang.get(i).nb_poches;
									System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
									dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
									demande_sang.remove(i);
							    }
							    else 
							    	if(Stock_B_n.liste.get(y).nb_poches<demande_sang.get(i).nb_poches)
							        {
							         	System.out.println("Le don ne peut pas etre validé! Le nombre de poches données par le donneur est insuffisant \n\n");
							         	demande_sang.remove(i);
							        } else
							    	   if(Stock_B_n.liste.get(y).nb_poches==demande_sang.get(i).nb_poches)
							    	   {
											Stock_B_n.liste.remove(y);	
											bn = bn - demande_sang.get(i).nb_poches;
											System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
											dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
											demande_sang.remove(i);
							    	   }
								trv=true;
							}
							else
							{
								y++;
							}
						}
						if(trv==false)
						{
							System.out.println("Aucun don pour le donneur saisi ! Demande Refusée !\n\n");
							demande_sang.remove(i);
						}
						
					
				    }
					
					//AB_POSITIF
					if(ff1.equals(Groupe_Sanguin.AB_positif)==true) 
					{
					
						int y=0; boolean trv=false;
						while(y<Stock_AB_p.liste.size() && trv==false)
						{
							if(Stock_AB_p.liste.get(y).num==numd)
							{
							    if(Stock_AB_p.liste.get(y).nb_poches>demande_sang.get(i).nb_poches)
							    {
							    	Stock_AB_p.liste.get(y).nb_poches=Stock_AB_p.liste.get(y).nb_poches-demande_sang.get(i).nb_poches;
									abp = abp - demande_sang.get(i).nb_poches;
									System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
									dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
									demande_sang.remove(i);
							    }
							    else 
							    	if(Stock_AB_p.liste.get(y).nb_poches<demande_sang.get(i).nb_poches)
							        {
							         	System.out.println("Le don ne peut pas etre validé! Le nombre de poches données par le donneur est insuffisant \n\n");
							         	demande_sang.remove(i);
							        } else
							    	   if(Stock_AB_p.liste.get(y).nb_poches==demande_sang.get(i).nb_poches)
							    	   {
											Stock_AB_p.liste.remove(y);	
											abp = abp - demande_sang.get(i).nb_poches;
											System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
											dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
											demande_sang.remove(i);
							    	   }
								trv=true;
							}
							else
							{
								y++;
							}
						}
						if(trv==false)
						{
							System.out.println("Aucun don pour le donneur saisi ! Demande Refusée !\n\n");
							demande_sang.remove(i);
						}
						
					
				    }
					
					//AB_NEGTAIF
					if(ff1.equals(Groupe_Sanguin.AB_négatif)==true) 
					{
					
						int y=0; boolean trv=false;
						while(y<Stock_AB_n.liste.size() && trv==false)
						{
							if(Stock_AB_n.liste.get(y).num==numd)
							{
							    if(Stock_AB_n.liste.get(y).nb_poches>demande_sang.get(i).nb_poches)
							    {
							    	Stock_AB_n.liste.get(y).nb_poches=Stock_AB_n.liste.get(y).nb_poches-demande_sang.get(i).nb_poches;
									abn = abn - demande_sang.get(i).nb_poches;
									System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
									dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
									demande_sang.remove(i);
							    }
							    else 
							    	if(Stock_AB_n.liste.get(y).nb_poches<demande_sang.get(i).nb_poches)
							        {
							         	System.out.println("Le don ne peut pas etre validé! Le nombre de poches données par le donneur est insuffisant \n\n");
							         	demande_sang.remove(i);
							        } else
							    	   if(Stock_AB_n.liste.get(y).nb_poches==demande_sang.get(i).nb_poches)
							    	   {
											Stock_AB_n.liste.remove(y);	
											abn = abn - demande_sang.get(i).nb_poches;
											System.out.println("La demande de sang est valide ! Le stock est mis A Jour!\n\n");
											dons_succes.add(new Demande_sang(demande_sang.get(i).NomPatient,demande_sang.get(i).numd,demande_sang.get(i).groupe_sanguin,demande_sang.get(i).nb_poches,java.time.LocalDate.now(),demande_sang.get(i).Objectif,demande_sang.get(i).remarques));   
											demande_sang.remove(i);
							    	   }
								trv=true;
							}
							else
							{
								y++;
							}
						}
						if(trv==false)
						{
							System.out.println("Aucun don pour le donneur saisi ! Demande Refusée !\n\n");
							demande_sang.remove(i);
						}
						
					
				    }
					
					trouve=true;
				}
			
		}
			else
			{i++;}
		}
		if(trouve==false)
		{
			System.out.println("Demande Introuvable !! \n\n");
		}
		
		
		
		
			
	
	}
	
	
	//AFFICHAGE DES DEMANDES DE SANG
	public void afficher_demandes_sang()
	{
		System.out.println("=================================================================\n");
		System.out.println("\t DEMANDES DE SANG");
		for(int i = 0 ; i < demande_sang.size() ; i++ )
		{
			System.out.println("Numero de demande : "+demande_sang.get(i).num_demande);
			System.out.println("Nom patient: "+demande_sang.get(i).NomPatient);
			System.out.println("Nom Donneur: "+demande_sang.get(i).numd);
			System.out.println("groupe Sanguin : "+demande_sang.get(i).groupe_sanguin);
			System.out.println("nbre poches :"+ +demande_sang.get(i).nb_poches);
			System.out.println("objectif : "+demande_sang.get(i).Objectif);
			System.out.println("remarques : "+demande_sang.get(i).remarques);
			System.out.println("Date demande "+demande_sang.get(i).date_demande +"\n");
			
		}
	}
	
	//AFFICHAGE DE LA DEMANDE DE SANG DU PATIENT i
	public void afficher_demandes_sang_patient(int i)
	{
		
		System.out.println("=================================================================\n");
			System.out.println("Numero de demande : "+demande_sang.get(i).num_demande);
			System.out.println("Nom patient: "+demande_sang.get(i).NomPatient);
			System.out.println("Nom Donneur: "+demande_sang.get(i).numd);
			System.out.println("groupe Sanguin : "+demande_sang.get(i).groupe_sanguin);
			System.out.println("nbre poches :"+ +demande_sang.get(i).nb_poches);
			System.out.println("objectif : "+demande_sang.get(i).Objectif);
			System.out.println("remarques : "+demande_sang.get(i).remarques);
			System.out.println("Date demande "+demande_sang.get(i).date_demande +"\n");
			
		
	}
	
	//AFFICHAGE DES DONS VALIDEE
	public void affichage_dons_effectuees()
	{
		System.out.println("=================================================================\n");
		System.out.println("\t DONS DE SANG EFFECTUES AVEC SUCCES");
		for(int i = 0 ; i < dons_succes.size() ; i++ )
		{
			
			System.out.println("Nom patient: "+dons_succes.get(i).NomPatient);
			System.out.println("Nom Donneur: "+dons_succes.get(i).numd);
			System.out.println("groupe Sanguin : "+dons_succes.get(i).groupe_sanguin);
			System.out.println("nbre poches :"+ dons_succes.get(i).nb_poches);
			System.out.println("objectif : "+dons_succes.get(i).Objectif);
			System.out.println("remarques : "+dons_succes.get(i).remarques);
			System.out.println("Date Validation "+dons_succes.get(i).date_demande +"\n");
			
		}
	}
	
	///***LA CLASSE STOCK **//
	private static class Cont_Stock  {

		
		int nb_poches ;
		LocalDate date_relev;
		int num;
		
		public Cont_Stock( int nb_poches, int num, LocalDate date_relev)
		{
			this.nb_poches = nb_poches ;
			this.date_relev = date_relev;
			this.num = num ;
		}
		
	}
	
	private static class Mini_stock{
		
		Groupe_Sanguin groupe ;
		ArrayList<Cont_Stock> liste = new ArrayList<Cont_Stock>();
		
		public Mini_stock(Groupe_Sanguin gr)
		{
			this.groupe = gr ; 
		}
		
	}

	

}
