package a_correr;

public class Competidor {
	private int edad;
	private char sexo;
	private int num_de_corredor;
	
	public Competidor(int edad, char sexo, int num_de_corredor) {
		this.edad = edad;
		this.sexo = sexo;
		this.num_de_corredor = num_de_corredor;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getNum_de_corredor() {
		return num_de_corredor;
	}
	public void setNum_de_corredor(int num_de_corredor) {
		this.num_de_corredor = num_de_corredor;
	}
	public String toString() {
		return "Edad=" + edad + ", Sexo=" + sexo
				+ ", Num_de_corredor=" + num_de_corredor;
	}
	
	
}
