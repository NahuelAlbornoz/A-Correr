package a_correr;

public class Carrera {
	private int cant_competidores_insc;
	private int cant_cat_fem;
	private int cant_cat_masc;
	private int cant_competidores_meta;
	
	public Carrera(int cant_comp_insc, int cf, int cm, int comp_lleg_meta) {
		this.cant_competidores_insc = cant_comp_insc;
		this.cant_cat_fem = cf;
		this.cant_cat_masc = cm;
		this.cant_competidores_meta = comp_lleg_meta;
	}
	
	public int getCant_competidores_insc() {
		return cant_competidores_insc;
	}
	public void setCant_competidores_insc(int cant_competidores_insc) {
		this.cant_competidores_insc = cant_competidores_insc;
	}
	public int getCant_cat_fem() {
		return cant_cat_fem;
	}
	public void setCant_cat_fem(int cant_cat_fem) {
		this.cant_cat_fem = cant_cat_fem;
	}
	public int getCant_cat_masc() {
		return cant_cat_masc;
	}
	public void setCant_cat_masc(int cant_cat_masc) {
		this.cant_cat_masc = cant_cat_masc;
	}
	public int getCant_competidores_meta() {
		return cant_competidores_meta;
	}
	public void setCant_competidores_meta(int cant_competidores_meta) {
		this.cant_competidores_meta = cant_competidores_meta;
	}
	public String toString() {
		return "Cant_competidores_insc=" + cant_competidores_insc
				+ ", Cant_cat_fem=" + cant_cat_fem + ", Cant_cat_masc="
				+ cant_cat_masc + ", Cant_competidores_meta="
				+ cant_competidores_meta;
	}

	public void alcanzarMeta(Competidor [] competidores, int [] competidores_meta, Categoria [] cf, Categoria [] cm, Medalla m) {
		Categoria c = new Categoria();
		
		int num_cat;
		int num_corredor;
		
		for(int i=0; i<this.cant_competidores_meta; i++) {
			
			num_corredor = competidores_meta[i]-1;
			if(competidores[num_corredor].getSexo()=='F') {
				num_cat = c.clasificar(competidores[num_corredor].getEdad(), cf, this.cant_cat_fem);
				m.premiarFem(num_cat,num_corredor);
			}
			else if(competidores[competidores_meta[i]-1].getSexo()=='M') {
				num_cat = c.clasificar(competidores[competidores_meta[i]-1].getEdad(), cm, this.cant_cat_masc);
				m.premiarMasc(num_cat,num_corredor);
			}
		}
	}
}
