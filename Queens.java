
public class Queens {
	/**
	 * kollaPlats tar en array och en integer som argument. En for-sats löper igenom arrayen, först kollas kolumnen, därefter diagonalerna
	 * @param rader - array, i arrayen anges raden med hjälp av positionen i arrayen och kolumnen där damen är placerad anges med en siffra som motsvarar dess position
	 * @param aktuellRad - integer som anger positionen. 
	 * @return returnerar false om diagonalerna eller kolumnen krockar, annars true.
	 */
	public static boolean print = true;
	
 	public static boolean kollaPlats(int [] rader, int aktuellRad){
		for(int i=0; i <aktuellRad; i ++){
			if(rader[i]==rader[aktuellRad]) // kolla kolumnen, värdet för aktuellRad motsarar kolumnen  
				return false;
			else if((rader[aktuellRad]-rader[i])==(aktuellRad-i)) // kolla diagonalen 
				return false;
			else if((rader[i]-rader[aktuellRad])==(aktuellRad-i)) // kolla andra diagonalen 
				return false;
		}
		return true;
	} // kollar om platsen Šr okej 

	/**Metoden storlek tar en integer(strl) som argument. Integern sätts som storlek på arrayen rader. 
	 * Metoden fyllplanen anropas med arrayen rader och 0 som argument.
	 * @param strl - storlek på damspelet
	 */
	public static void storlek(int strl){
		int[] rader = new int [strl];
		fyllPlanen(rader, 0);
		
		
	}// storlek

	/**
	 * Fyllplanen tar en array och en integer som argument (0 första gången)
	 * Metoden anropas rekursivt, och aktuellRad ökas med ett för varje anrop. När aktuellRad är lika med arrayens längd anrpas metoden printQ.
	 * Innan det rekursiva anropet sker kollas aktuellRads plats med metoden kollaPlats.
	 * @param rader - array
	 * @param aktuellRad - position i arrayen, varje position motsvarar en rad.
	 */
	private static void fyllPlanen(int[] rader,  int aktuellRad) {
		if(aktuellRad != rader.length){
			for(int x =0; x<rader.length; x ++){ 
				rader[aktuellRad] = x;
				if(kollaPlats(rader,aktuellRad)) // kollar om platsen fungerar och gŒr i sŒ fall vidare 
					fyllPlanen(rader,  aktuellRad+1); // kommer den inte att fungera kommer den tillbaka och ett nytt varv gšrs. 
			}
		
		} else if (print){// fšr att skriva ut den nŠr den Šr full (i blir lika stor som lŠngden)
			printQ(rader);
			print = false;
			
		}
		

	}//fyllPlanen
	/**
	 * Metoden printQ skriver ut spelplanen som ett bräde. 
	 * Först skrivs första raden med siffror ut. Därefter skrivs varje rad ut som börjar med radnummer. 
	 * Ett plustecken visar en tom plats och Q representerar en dam.
	 * @param rader - array
	 */
	public static void printQ(int [] rader){
		for(int i=0; i<rader.length; i++){
			if(i == 0)
				System.out.print("  ");
			System.out.print(1+i+" ");
		} // sŠtter upp radnr (fult)
		
		System.out.println();// radbrytning 
		
		for(int i=0; i< rader.length; i++){// sŒ det blir rŠtt antal rader 
			for(int x=0; x<rader.length; x++){//fšr varje rad 
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
	}//printQ skriver ut Q fšr att se hur resultatet blir 

	  public static void main(String[] args) {
	        storlek(8); // du kan lŠgga till vilken storlek du vill.. Prova byta ut 8 mot en 4 tex
	    }
}//Queens
