
public class Queens {
	/**
	 * kollaPlats tar en array och en integer som argument. En for-sats l�per igenom arrayen, f�rst kollas kolumnen, d�refter diagonalerna
	 * @param rader - array, i arrayen anges raden med hj�lp av positionen i arrayen och kolumnen d�r damen �r placerad anges med en siffra som motsvarar dess position
	 * @param aktuellRad - integer som anger positionen. 
	 * @return returnerar false om diagonalerna eller kolumnen krockar, annars true.
	 */
	public static boolean print = true;
	
 	public static boolean kollaPlats(int [] rader, int aktuellRad){
		for(int i=0; i <aktuellRad; i ++){
			if(rader[i]==rader[aktuellRad]) // kolla kolumnen, v�rdet f�r aktuellRad motsarar kolumnen  
				return false;
			else if((rader[aktuellRad]-rader[i])==(aktuellRad-i)) // kolla diagonalen 
				return false;
			else if((rader[i]-rader[aktuellRad])==(aktuellRad-i)) // kolla andra diagonalen 
				return false;
		}
		return true;
	} // kollar om platsen �r okej 

	/**Metoden storlek tar en integer(strl) som argument. Integern s�tts som storlek p� arrayen rader. 
	 * Metoden fyllplanen anropas med arrayen rader och 0 som argument.
	 * @param strl - storlek p� damspelet
	 */
	public static void storlek(int strl){
		int[] rader = new int [strl];
		fyllPlanen(rader, 0);
		
		
	}// storlek

	/**
	 * Fyllplanen tar en array och en integer som argument (0 f�rsta g�ngen)
	 * Metoden anropas rekursivt, och aktuellRad �kas med ett f�r varje anrop. N�r aktuellRad �r lika med arrayens l�ngd anrpas metoden printQ.
	 * Innan det rekursiva anropet sker kollas aktuellRads plats med metoden kollaPlats.
	 * @param rader - array
	 * @param aktuellRad - position i arrayen, varje position motsvarar en rad.
	 */
	private static void fyllPlanen(int[] rader,  int aktuellRad) {
		if(aktuellRad != rader.length){
			for(int x =0; x<rader.length; x ++){ 
				rader[aktuellRad] = x;
				if(kollaPlats(rader,aktuellRad)) // kollar om platsen fungerar och g�r i s� fall vidare 
					fyllPlanen(rader,  aktuellRad+1); // kommer den inte att fungera kommer den tillbaka och ett nytt varv g�rs. 
			}
		
		} else if (print){// f�r att skriva ut den n�r den �r full (i blir lika stor som l�ngden)
			printQ(rader);
			print = false;
			
		}
		

	}//fyllPlanen
	/**
	 * Metoden printQ skriver ut spelplanen som ett br�de. 
	 * F�rst skrivs f�rsta raden med siffror ut. D�refter skrivs varje rad ut som b�rjar med radnummer. 
	 * Ett plustecken visar en tom plats och Q representerar en dam.
	 * @param rader - array
	 */
	public static void printQ(int [] rader){
		for(int i=0; i<rader.length; i++){
			if(i == 0)
				System.out.print("  ");
			System.out.print(1+i+" ");
		} // s�tter upp radnr (fult)
		
		System.out.println();// radbrytning 
		
		for(int i=0; i< rader.length; i++){// s� det blir r�tt antal rader 
			for(int x=0; x<rader.length; x++){//f�r varje rad 
				if(x == 0)// rad nummer 
					System.out.print(1+i+" ");
				if(rader[i]== x)
					System.out.print("Q "); 
				else
					System.out.print("+ ");
			}
			System.out.println();//radbrytning
		}
		System.out.println();//radbrytning
	}//printQ skriver ut Q f�r att se hur resultatet blir 

	  public static void main(String[] args) {
	        storlek(8); // du kan l�gga till vilken storlek du vill.. Prova byta ut 8 mot en 4 tex
	    }
}//Queens
