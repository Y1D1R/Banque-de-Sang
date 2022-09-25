import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.*;
public class Test {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean c = true,c1=true,d=true,er=true,k=true,p=true , ll=true;
		int choix;
		int chanceB=3, chanceD=3;
		int numD=-1,choixD=-1;
		int espace=0 ;
		
		
		//Les Donneurs déja enregistrés
		Donneur a = new Donneur("ab cd","ouarkik"," 0555688", "sadbra2@gmaoil.com",Genre.male , 21 , Groupe_Sanguin.A_positif , "","aa","aa");
		Donneur a1 = new Donneur("ad hb","ouarkik"," 0555688", "sadbra2ddq@gmaoil.com",Genre.male , 18 , Groupe_Sanguin.AB_positif , "allergie","bb","bb");
		Donneur a2 = new Donneur("AA ZZ","ouarkik"," 0555658", "sdq@gmail.com",Genre.male , 22 , Groupe_Sanguin.A_positif , "allergie","cc","cc");
		
		//La banque de sang et ses donneurs
        Banque_de_sang b = new Banque_de_sang("arrahma","azazga","ajkl kdjk", "06754899665");

  
       
		//ajout de 2 donneur
        
		b.ajouterDonneur(a1);
		b.ajouterDonneur(a);
		b.ajouterDonneur(a2);
		try {
			//MENU PRINCIPALE
		while(c1) {   
	    System.out.println("===============================================================================\n\n");	
		System.out.println(" °°°°°°°°°°°°°°°  ESPACE DE TRAVAIL °°°°°°°°°°°°°°°\n");	
		System.out.println(" +1+ Banque du sang ");
		System.out.println(" +2+ Donneur ");
		System.out.println(" +3+ Quitter \n\n");
		System.out.println("===============================================================================\n");
		
	
		    	System.out.print(" veillez saisir votre espace : ");		
				espace= sc.nextInt(); 
			
			
		chanceB=3;
		switch(espace) {
		//ESPACE DE LA BANQUE
		case 1 : while(chanceB>0) {
			System.out.println("\n\n");
			System.out.println("         ¤¤¤¤¤¤  LOGIN BANQUE ¤¤¤¤¤¤\n");
			System.out.print("Utilisateur : ");
			String user=sc.next();
			System.out.println("");
			System.out.print("Mot de passe : ");
			String mdp=sc.next();
			System.out.println("");
			System.out.println("\n");
			if (user.equals("a")&&mdp.equals("a")) {
				chanceB=0; c = true ;
				while(c) {k=true;p=true;ll=true;
				System.out.println("¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n\n");
					System.out.println("         ¤¤¤¤¤¤  Menu Principale de la Banque ¤¤¤¤¤¤");
					System.out.println("=================================================================");
					System.out.println("\n");
					System.out.println(" +1+ Gestion du Stock");
					System.out.println(" +2+ Gestion des donneurs");
					System.out.println(" +3+ Gestion des dons du sang");
					System.out.println(" +4+ Les demandes du sang");
					System.out.println(" +5+ Liste Des Dons effectués avec succés");
					System.out.println(" +6+ Quiter\n\n");
					System.out.println("=================================================================\n");
					
					
					System.out.println("==> Veuillez saisir votre choix (1--6) !");
					choix =sc.nextInt();
					switch(choix) {
					case 1 : System.out.println(" Gestion du stock\n");
					         
					         b.afficher_Stock(); 
					         break;
					case 2 : while(p) {
						     System.out.println("=================================================================\n");
						     System.out.println(" Gestion des donneurs\n"); 
					         System.out.println(" +1+ Affichage des donneurs");
					         System.out.println(" +2+ Ajouter un donneur");
					         System.out.println(" +3+ Supprimer un donneur");
					         System.out.println(" +4+ Quitter\n");
					         System.out.println(" ==> Veuillez saisir votre choix (1--4) !");
					         int chDonn=sc.nextInt();
					         switch(chDonn) {
					         case 1:b.afficher_donneurs();break;
					         case 2:b.ajout_donneur(); break;
					         case 3:b.supprimer_donneur(); break;
					         case 4: p=false;break;
					         default:System.out.println(" Veuillez saisir un choix VALIDE entre 1 et 4 ! \n\n"); break;
					         
					         }
					         
					         }
					         break;
					case 3 : while(ll) {
						System.out.println("=================================================================\n");
						 System.out.println(" +1+ Affichage des demandes de dons ");
					     System.out.println(" +2+ Traiter une demande ");
					     System.out.println(" +3+ Quitter\n");
					     System.out.println(" ==> Veuillez saisir votre choix (1--3) !");
					     int chDemande2=sc.nextInt();
					     switch(chDemande2) {
					     case 1:  b.afficher_demandes_don();break;
					     case 2: b.traitement_demande();break;
					     case 3: ll=false;break;
					     default:System.out.println(" Veuillez saisir un choix VALIDE entre 1 et 3 ! \n\n"); break;
					         }
					}
						    
					        break;
					         
					        
					case 4 : while(k) {
						System.out.println("=================================================================\n");
						     System.out.println(" +1+ Demandes du sang");
						     System.out.println(" +2+ Affichage des demandes de sang ");
						     System.out.println(" +3+ Traitement des demandes de sang ");
						     System.out.println(" +4+ Quitter\n");
						     System.out.println(" ==> Veuillez saisir votre choix (1--4) !");
						     int chDemande=sc.nextInt();
						     switch(chDemande) {
						     case 1: b.demande_sang();break;
						     case 2: b.afficher_demandes_sang();break;
						     case 3: b.Traitement_demandes_sang(); break;
						     case 4: k=false;break;
						     default:System.out.println(" Veuillez saisir un choix VALIDE entre 1 et 4 ! \n\n"); break;
						     }
					         
					}
					         break;
					         
					case 5 :System.out.println("=================================================================\n"); 
						System.out.println(" Liste des dons avec succés \n");
			         
			         b.affichage_dons_effectuees(); 
			         break;
			         
					case 6 : System.out.println(" Voulez vous reelement quiter ? [oui/non]");
					         String q=sc.next();
					         if(q.equals("non")) {c=true;
					         break;}else if(q.equals("oui")) {
					        	 choix=0;
					        	 c=false;
					        	
					        	
					        	 
					         } break;
					default : System.out.println(" Veuillez saisir un choix VALIDE entre 1 et 6 ! \n\n");         
					
					}
				}
			}else {
				chanceB--;
				System.out.println(" Vous avez encore "+chanceB+" chances pour bien s'authentifier !\n\n");
				
			}
		}System.out.println("");System.out.println(""); break;
		
		//ESPACE DU DONNEUR
		case 2: while(chanceD>0) {
			System.out.println("=================================================================\n\n");
			System.out.println("         ¤¤¤¤¤¤  LOGIN DONNEUR ¤¤¤¤¤¤");
			System.out.print("Utilisateur : ");
			String userd=sc.next();
			System.out.println("");
			System.out.print("Mot de passe : ");
			String mdpd=sc.next();
			System.out.println("");
			int ii=0;
			while(ii<b.liste_donneur.size()&& er) {
				if(userd.equals(b.liste_donneur.get(ii).username)&&mdpd.equals(b.liste_donneur.get(ii).password)) {
					chanceD=0;
					 numD=ii;
					 er=false;
					 d=true;
				}else {
						ii++;
					}
			}
			if(numD != -1) {
					while(d) {
						System.out.println("¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤\n\n");
						System.out.println("         ¤¤¤¤¤¤  Menu Principale du donneur ¤¤¤¤¤¤");
						System.out.println("=================================================================\n");
						System.out.println("\n");
						System.out.println(" +1+ Afficher mes informations");
						System.out.println(" +2+ Faire un don");
						System.out.println(" +3+ Quitter\n\n");
						System.out.println("=================================================================\n");
						System.out.println("==> Veuillez saisir votre choix (1--3) !");
						 choixD=sc.nextInt();
						switch(choixD) {
						case 1: b.liste_donneur.get(numD).afficherDonneur();break;
						case 2: System.out.println("=================================================================\n");
							    System.out.println("     Faire un don     ");
						        b.liste_donneur.get(numD).demandeDon();
						        break;
						case 3: d=false;System.out.println(" Voulez vous reelement quiter ? [oui/non]");
				         String DD=sc.next();
				         if(DD.equals("non")) {d=true;
				         break;}else if(DD.equals("oui")) {
				        	 d=false;er=true;
				         } break;
						default : System.out.println(" Veuillez donner un choix VALIDE entre 1 et 3 ! \n\n\n "); 
						}
					}
			}else {	
			chanceD--;
			System.out.println(" Vous avez encore "+chanceD+" chances pour bien s'authentifier !\n\n");
			}
		    }
		chanceD=3;er=true;
		    break;
		case 3: c1=false;
		        System.out.println("************** Au revoir **************");
		        break;
		
		
		default : System.out.println(" Veuillez donner un choix VALIDE entre 1 et 3 ! \n\n\n ");        
		
		
		}
		
	}
	}
		catch(InputMismatchException e) {
	    	System.out.println("Erreur de type d'input \n");
	    	System.out.println("Veuillez relancer l'application de nouveau ! \n");
		}
		
		}
	
}
