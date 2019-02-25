public class MTRotate 
{

	char a [][] = new char[8][10];
	public MTRotate() {
        
    	a[0] = new String ( "ljkk012345").toCharArray();
    	a[1] = new String ( "01ljkk2345").toCharArray();
    	a[2] = new String ( "01ljkk2345").toCharArray();
    	a[3] = new String ( "01234ljkk5").toCharArray();
    	a[4] = new String ( "01234ljkk5").toCharArray();
    	a[5] = new String ( "0123ljkk45").toCharArray();
    	a[7] = new String ( "0123ljkk45").toCharArray();
	}
    public static void main(String args[]){
		MTRotate app = new MTRotate();
		for (int i = 0; i < app.a.length ; ++i) {
   			for (int j = 0; j < app.a[0].length; ++j) {
   				System.out.printf("%3c ", app.a[i][j]);
   			}
   		System.out.println();
    	}
		for(int r = 0, r2 = app.a.length-1, c = 0, c2 = app.a[0].length-1;  ;) {
			// Makes new thread for each circle 
	   		new Thread(new RotateOneCircle( true/*( r  % 2) == 0*/, app.a ,r, r2 , c,
	   					 c2)).start();
	   		// Updates circle positions
	    	r = r + 1; r2 = r2 - 1; c = c + 1; c2 = c2 - 1;
	    	// If start equals the end then stop.
	    	if(r >= r2 || c >= c2) break; 
		}
	   	for (int i = 0; i < app.a.length ; ++i) {
   			for (int j = 0; j < app.a[0].length; ++j) {
   				System.out.printf("%3c ", app.a[i][j]);
   			}
   		System.out.println();
    	}
	}
}


class RotateOneCircle implements Runnable
{
   char a[][] = null;
   boolean dir;
   int   sRow, eRow, sCol, eCol;
   
   public RotateOneCircle ( boolean clockwise, char a [][], int sRow, int eRow,
   							 int sCol, int eCol ) {
       dir = clockwise; this.a = a; this.sRow = sRow; this.eRow = eRow; 
       this.sCol = sCol; this.eCol = eCol;
   }
	
   public void run() {
  //      System.out.printf("Direction : %s  Row start:end[%d %d] Col start:end,"
  //      						+" end[%d  %d]\n",
		// dir ? "clockwise ": "anticlock", sRow, eRow, sCol, eCol);

       shiftCircle();
   }

   private void shiftCircle() {
   		char tmpTopLeft = a[sRow][sCol];

   		if (dir) {
	   		for(int i = 0; i < eRow; ++i) {
				a[sRow+i][sCol] =  a[sRow+i+1][sCol];
			}
			for(int i = 0; i < eCol; ++i) {
				a[eRow][sCol+i] =  a[eRow][sCol+i+1];
			}
			for(int i = 0; i < eRow; ++i) {
				a[eRow-i][eCol] =  a[eRow-i-1][eCol];
			}
			for(int i = 0; i < eCol; ++i) {
				a[sRow][eCol-i] =  a[sRow][eCol-i-1];
			}

	   		a[sRow][sCol+1] = tmpTopLeft;
   		} else {
   			for (int i = 0; i < eCol ; ++i) {
	   			a[sRow][sCol+i] = a[sRow][sCol+i+1];
	   		}
	   		for (int i = 0; i < eRow ; ++i) {
	   			a[sRow+i][eCol] = a[sRow+i+1][eCol];
	   		}
	   		for (int i = 0; i < eCol ; ++i) {
	   			a[eRow][eCol-i-1] = a[eRow][eCol-i];
	   		}
	   		for (int i = 0; i < eRow ; ++i) {
	   			a[eRow-i][sCol] = a[eRow-i-1][eCol];
	   		}
	   		a[sRow+1][sCol] = tmpTopLeft;
   		}
   }

   public void printCircle(String str) {

   	System.out.println(str);
   	for (int i = 0; i < eRow ; ++i) {
   		for (int j = 0; j < eCol; ++j) {
   			System.out.print(a[i][j]);
   		}
   	System.out.println();
   	}
   }
}
