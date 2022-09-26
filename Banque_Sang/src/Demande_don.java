import java.time.LocalDate;
import java.util.Date;

public class Demande_don {
	
	Donneur donneur ;
	int nb_poches;
	LocalDate date;

	//Constructeur
	public Demande_don(Donneur d , int nb ,LocalDate da)
	{
		this.donneur=d;
		this.nb_poches=nb;
		this.date=da;

	}

	//GETTERS AND SETTERS
	public Donneur getDonneur() {
		return donneur;
	}

	public void setDonneur(Donneur donneur) {
		this.donneur = donneur;
	}

	public int getNb_poches() {
		return nb_poches;
	}

	public void setNb_poches(int nb_poches) {
		this.nb_poches = nb_poches;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
	

}
