package a_correr;
import java.io.File;
import java.io.PrintWriter;

public class Medalla {
	private int oro;
	private int plata;
	private int bronce;
	private int cat_fem;
	private int cat_masc;
	private Medalla medallas_masc[];
	private Medalla medallas_fem[];
	
	public Medalla(int cf, int cm) {
		this.cat_fem = cf;
		this.cat_masc = cm;
		this.medallas_fem = new Medalla[cf];
		this.medallas_masc = new Medalla[cm];
	}
	
	public Medalla (int oro, int plata, int bronce) {
		this.oro = oro;
		this.plata = plata;
		this.bronce = bronce;
	}

	public int getOro() {
		return oro;
	}
	public void setOro(int oro) {
		this.oro = oro;
	}
	public int getPlata() {
		return plata;
	}
	public void setPlata(int plata) {
		this.plata = plata;
	}
	public int getBronce() {
		return bronce;
	}
	public void setBronce(int bronce) {
		this.bronce = bronce;
	}
	public int getCat_fem() {
		return cat_fem;
	}
	public void setCat_fem(int cat_fem) {
		this.cat_fem = cat_fem;
	}
	public int getCat_masc() {
		return cat_masc;
	}
	public void setCat_masc(int cat_masc) {
		this.cat_masc = cat_masc;
	}
	public Medalla[] getMedallas_masc() {
		return medallas_masc;
	}
	public void setMedallas_masc(Medalla[] medallas_masc) {
		this.medallas_masc = medallas_masc;
	}
	public Medalla[] getMedallas_fem() {
		return medallas_fem;
	}
	public void setMedallas_fem(Medalla[] medallas_fem) {
		this.medallas_fem = medallas_fem;
	}

	public String toString() {
		return "Oro=" + oro + ", Plata=" + plata + ", Bronce="
				+ bronce;	
	}

	public void preparar() {
		for(int i=0; i<this.cat_fem; i++) {
			this.medallas_fem[i] = new Medalla(0,0,0);
		}
		for(int j=0; j<this.cat_masc; j++) {
			this.medallas_masc[j] = new Medalla(0,0,0);
		}
	}
	
	public void premiarFem(int num_cat, int num_corredor) {
		for(int f=0; f<this.cat_fem; f++) {
			if((num_cat-1==f)&&(this.medallas_fem[f].getOro()==0))  
				this.medallas_fem[f].setOro(num_corredor+1);
			else if((num_cat-1==f)&&(this.medallas_fem[f].getPlata()==0)) 
				this.medallas_fem[f].setPlata(num_corredor+1);
			else if((num_cat-1==f)&&(this.medallas_fem[f].getBronce()==0)) 
				this.medallas_fem[f].setBronce(num_corredor+1);
		}
	}
	
	public void premiarMasc(int num_cat, int num_corredor) {
		for(int m=0; m<this.cat_masc; m++) {
			if((num_cat-1==m)&&(this.medallas_masc[m].getOro()==0))  
				this.medallas_masc[m].setOro(num_corredor+1);
			else if((num_cat-1==m)&&(this.medallas_masc[m].getPlata()==0)) 
				this.medallas_masc[m].setPlata(num_corredor+1);
			else if((num_cat-1==m)&&(this.medallas_masc[m].getBronce()==0)) 
				this.medallas_masc[m].setBronce(num_corredor+1);
		}
	}
	
	public void verMedallas() {
		
		PrintWriter pr = null;
		try {
			pr = new PrintWriter(new File("carrera.out"));
			System.out.println("FEMENINO");
			for(int f=0; f<this.cat_fem; f++) {
				System.out.println(this.medallas_fem[f]);
				pr.print(f+1+ " ");
				pr.print(this.medallas_fem[f].getOro()+ " ");
				pr.print(this.medallas_fem[f].getPlata()+ " ");
				pr.print(this.medallas_fem[f].getBronce());
				pr.println();
			}
			System.out.println("MASCULINO");
			for(int m=0; m<this.cat_masc; m++) {
				System.out.println(this.medallas_masc[m]);
				pr.print(m+1+ " ");
				pr.print(this.medallas_masc[m].getOro()+ " ");
				pr.print(this.medallas_masc[m].getPlata()+ " ");
				pr.print(this.medallas_masc[m].getBronce()+ " ");
				pr.println();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			pr.close();
		}
	}
}
