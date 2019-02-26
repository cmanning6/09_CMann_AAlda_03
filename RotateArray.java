class RotateArray implements Runnable
{
   int a[][] = null;
   boolean dir;
   int   sRow, eRow, sCol, eCol;
   
   public RotateArray ( boolean clockwise, int a [][], int sRow, int eRow,
   							 int sCol, int eCol ) {
       dir = clockwise; this.a = a; this.sRow = sRow; this.eRow = eRow; 
       this.sCol = sCol; this.eCol = eCol;
   }
	
   public void run() {
      rotateCircle();
   }

   protected void rotateCircle() {
		int eCol = a.length - sCol - 1, col = 0, row = 1;
		int temp[] = { a[sCol][sCol], a[sCol][eCol], a[eCol][eCol], a[eCol][sCol] };

		shiftLine(row, sCol, eCol, sCol); shiftLine(col, sCol, eCol, eCol);
		shiftLine(row, eCol, sCol, eCol); shiftLine(col, eCol, sCol, sCol);
		a[sCol][sCol+1] = temp[0]; a[sCol+1][eCol] = temp[1];
		a[eCol][eCol-1] = temp[2]; a[eCol-1][sCol] = temp[3];
	}

   protected void shiftLine(int line, int st, int eCol, int index) {
		boolean row_or_col = (line == 1);
		boolean right_or_left = (st < eCol);
		int i , j;
		if (right_or_left) { i = eCol; j = eCol - 1; }
		else { i = eCol; j = eCol + 1; }
		while ( i != st ) { 
		    if (row_or_col) { a[index][i] = a[index][j]; } 
		    else  { a[i][index] = a[j][index]; }
		    if (right_or_left) { i--; j--; } 
		    else { i++; j++; }
		}
	}
}
