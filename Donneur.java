import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;

public class Donneur {
	
	Scanner sc = new Scanner(System.in);
	
	static int num  = 1 ;
	int num_seq ; 
	String NomComplet, Adresse, Contact, Email, Remarques;
	Genre genre ;
	Groupe_Sanguin groupe_sanguin;
	int age ;
	String username,password;
	
	//Constructeur
	public Donneur(String NomComplet, String Adresse, String Contact, String Email, Genre genre , int age ,Groupe_Sanguin gr ,String rem,String username,String password )
	{
		this.num_seq = num ;
		this.NomComplet = NomComplet;
		this.Adresse=Adresse;
		this.Contact=Contact;
		this.Email=Email;
		this.genre=genre;
		this.age=age;
		this.groupe_sanguin=gr;
		this.Remarques=rem;
		this.username=username;
		this.password=password;
		
		num ++ ;
	}
	
	//GETTERS AND SETTERS
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomComplet() {
		return NomComplet;
	}
	public void setNomComplet(String nomComplet) {
		NomComplet = nomComplet;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
	Contact = contact;
	}
	public String getEmail() {
		return Email;
	}
    public void setEmail(String email) {
		Email = email;
	}
	public String getRemarques() {
		return Remarques;
	}
	public void setRemarques(String remarques) {
		Remarques = remarques;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Groupe_Sanguin getGroupe_sanguin() {
		return groupe_sanguin;
	}
	public void setGroupe_sanguin(Groupe_Sanguin groupe_sanguin) {
		this.groupe_sanguin = groupe_sanguin;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//AFFICHAGE DES INFORMATIONS DU DONNEUR
	public void afficherDonneur() {
		System.out.println("=================================================================\n");
		System.out.println(" Numéro : "+this.num_seq);
		System.out.println(" Nom : "+this.NomComplet);
		System.out.println(" Age : "+this.age);
		System.out.println(" Genre : "+this.genre);
		System.out.println(" Adresse : "+this.Adresse);
		System.out.println(" Email : "+this.Email);
		System.out.println(" Groupe sanguin : "+this.groupe_sanguin);
		System.out.println(" Remarque : "+this.Remarques);
		System.out.println(" Username : "+this.username);
		System.out.println(" Password : "+this.password+"\n");
	}
	
	//FAIRE UNE DEMANDE DE DON
	public void demandeDon()	
	{
		int nb ;
		ArrayList<Donneur> l = new ArrayList<Donneur>();
		for(int i = 0 ; i < Banque_de_sang.demandes_don.size() ; i++ )
		{
			l.add(Banque_de_sang.demandes_don.get(i).donneur);
		}
		if(l.contains(this))
		{
		System.out.println("vous ne pouvez pas faire un don! veuillez attendre a ce que votre ancienne demande soit traitée \n\n");
		}
		else 
		{
			do {
			System.out.println("Veuillez entrer le nombre de poches que vous voullez donner!! [entre 1 et 4 poches] ");
			 nb = sc.nextInt();} while(nb<1 ||nb >4);
			System.out.println("votre demande est enregistrée! on vous remercie !\n\n");
			Banque_de_sang.demandes_don.add(new Demande_don(this,nb,java.time.LocalDate.now()));	
		}
	}
	
}

