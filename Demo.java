package a_correr;
import java.io.File;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = null;
		Competidor [] competidores = null;
		Categoria [] categorias_fem = null;
		Categoria [] categorias_masc = null;
		Medalla medalla = null;
		Carrera ca = null;
		int competidores_meta [] = null;
		try {
			long tiempo_inicial = System.currentTimeMillis();
			sc = new Scanner(new File("carrera3.in"));
			int cant_comp_insc = sc.nextInt();
			int cf = sc.nextInt();
			int cm = sc.nextInt();
			int comp_lleg_meta = sc.nextInt();
			
			//Valido los datos de entrada de la primera fila
			if((cant_comp_insc>=1)&&(cant_comp_insc<=1000000)&&(cf>=1)&&(cf<=60)&&(cm>=1)&&(cf<=60)&&(comp_lleg_meta>=0)&&(comp_lleg_meta<=cant_comp_insc)) {
				
				ca = new Carrera(cant_comp_insc, cf, cm, comp_lleg_meta);// Instancia carrera y añado participantes y categorias
	
				//LLeno las categorias fem
				categorias_fem = new Categoria[cf];
				for(int f=0; f<cf; f++) {
					int fn = sc.nextInt();
					int fx = sc.nextInt();
					if((fn>=10)&&(fn<=fx)&&(fx<=80)) {
						categorias_fem [f] = new Categoria(fn,fx,f+1); 
					}
				}
				
				//Lleno las categorias masc
				categorias_masc = new Categoria[cm];
				for(int m=0; m<cm; m++) {
					int mn = sc.nextInt();
					int mx = sc.nextInt();
					
					if((mn>=10)&&(mn<=mx)&&(mx<=80)) {
						categorias_masc [m] = new Categoria(mn,mx,m+1); 
					}
				}	
				
				// Estos parametros sirve para armar el arreglo de medallas para fem y masc
				medalla = new Medalla (cf,cm);
				// Prepara las medallas. 3 (oro, plata y bronce) para cada categoria y sexo
				// Cada medalla contiene el número de competidor
				medalla.preparar();
	
				// Lleno los competidores
				competidores = new Competidor [cant_comp_insc];
				for(int i=0; i<cant_comp_insc; i++) {
					int edad = sc.nextInt();
					String letra = sc.next();
					char sexo = letra.charAt(0);
					
					if(((sexo=='F')||(sexo=='M'))&&((edad>=10)&&(edad<=80))) {
						competidores[i] = new Competidor(edad, sexo, i+1);
					}
					
					//System.out.println(competidores[i]);
				}
				
				// Lleno los competidores que cruzaron la meta
				competidores_meta = new int [comp_lleg_meta];
				for(int c=0 ;c<comp_lleg_meta; c++) {
					int n_corred = sc.nextInt();
					competidores_meta[c] = n_corred; 
				}
				
				//Finalizo las carrera. Ahora tengo que saber quines llegaron a la meta
				ca.alcanzarMeta(competidores, competidores_meta, categorias_fem, categorias_masc, medalla);
				medalla.verMedallas();
				long tiempo_final = System.currentTimeMillis();
				long tiempo_rta = tiempo_final - tiempo_inicial;
				System.out.println("Tiempo de respuesta="+tiempo_rta);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			sc.close();
		}
	}
}