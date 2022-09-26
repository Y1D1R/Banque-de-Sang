import java.time.LocalDate;

public class Demande_sang {
	
	static int num = 1  ;
	int num_demande;
	String NomPatient , Objectif , remarques;
	int numd;
	LocalDate date_demande;
	int nb_poches ; 
	Groupe_Sanguin groupe_sanguin ; 
	
	//Constructeur
	public Demande_sang(String nom , int numd , Groupe_Sanguin gr , int nb_poches , LocalDate d , String obj , String rem)
	{
		this.num_demande = num ; 
		this.NomPatient = nom ;
		this.numd = numd ; 
		this.groupe_sanguin = gr ; 
		this.nb_poches = nb_poches ; 
		this.date_demande = d ; 
		this.Objectif = obj ; 
		this.remarques = rem ;
		num++;
	}

	//GETTERS AND SETTERS
	public String getNomPatient() {
		return NomPatient;
	}

	public void setNomPatient(String nomPatient) {
		NomPatient = nomPatient;
	}

	public String getObjectif() {
		return Objectif;
	}

	public void setObjectif(String objectif) {
		Objectif = objectif;
	}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}

	public LocalDate getDate_demande() {
		return date_demande;
	}

	public void setDate_demande(LocalDate date_demande) {
		this.date_demande = date_demande;
	}

	public int getNb_poches() {
		return nb_poches;
	}

	public void setNb_poches(int nb_poches) {
		this.nb_poches = nb_poches;
	}

	public Groupe_Sanguin getGroupe_sanguin() {
		return groupe_sanguin;
	}

	public void setGroupe_sanguin(Groupe_Sanguin groupe_sanguin) {
		this.groupe_sanguin = groupe_sanguin;
	}
	
	
	

}
