package a_correr;

public class Categoria {
	private int edad_min;
	private int edad_max;
	private int num_cat;
	
	public Categoria(int edad_min, int edad_max, int num_cat) {
		this.edad_min = edad_min;
		this.edad_max = edad_max;
		this.num_cat = num_cat;
	}
	public Categoria() {
		this(0,0,0);
	}
	
	public int getEdad_min() {
		return edad_min;
	}
	public void setEdad_min(int edad_min) {
		this.edad_min = edad_min;
	}
	public int getEdad_max() {
		return edad_max;
	}
	public void setEdad_max(int edad_max) {
		this.edad_max = edad_max;
	}
	public int getNum_cat() {
		return num_cat;
	}
	public void setNum_cat(int num_cat) {
		this.num_cat = num_cat;
	}
	public String toString() {
		return "Edad_min=" + edad_min + ", Edad_max=" + edad_max
				+ ", Num_cat=" + num_cat;
	}
	public int clasificar(int edad, Categoria [] cat, int cmax) {
		int n_cat = 0;
		for(int i=0; i<cmax; i++) {
			if((edad>=cat[i].edad_min)&&(edad<=cat[i].edad_max)) {
				n_cat = cat[i].num_cat;
				break;
			}
			else {
				n_cat = -1;
			}
		}
		return n_cat;
	}
}
