
public class Console {
	final int Tab	    = 9;
	final int BottomX   = 25;
	final int TopX      = 1;
	final int MiddleX   = 12;
	final int MiddleY   = 30;
	final int MessageLen = 80;

    //  uses ANSI escape sequence to position cursor. }
    public static void  bell() { System.out.print((char)(7)); }
    public static void   moveTo(int x, int y ) {
	System.out.printf( (char)(27) + "[" + x  + ";" + y + "H") ; }
	// System.out.print((char)(27) << "[" << y  << ";" << x << "H" ; }
/* ============================
    public static void  cursorUpNLines(int x) { System.out.print((char)(27) << "[" << x << ";A"; }

    public static void  cursorUp() { System.out.print((char)(27) << "[" << ";A"; }
    public static void  cursorDownNLines(int x) { System.out.print((char)(27) << "[" << x << ";B"; }

    // output device status report
    public static void reportDSR() { System.out.print((char)(27) << "[6n"; }

    // report cursor position ; not working?
    public static void reportCursor(int x, int y) { System.out.print((char)(27) << "[" << x << ";" << y << "R"; }

    // save cursor position for restoring late.
    public static void saveCursor() { System.out.print((char)(27) << "[s"; }

    public static void  restoreCursor() { System.out.print((char)(27) << "[u"; }

    // Clear screen and position cursor at home.
*/
    public static void  clear() { System.out.print((char)(27) + "[2J") ; }
/*
    // delete chars from curor position to the eoln.
    public static void eraseLine() { System.out.print((char)(27) << "[K"; }
    public static void setAllOff() { System.out.print((char)(27) << "[0m"; }

    public static void setBoldOff() { System.out.print((char)(27) << "=1|"; }

    public static void setBold() { System.out.print((char)(27) << "[1m"; }

    public static void setFaint() { System.out.print((char)(27) << "[2m"; }

    //  Set italic on
    public static void setItalic() { System.out.print((char)(27) << "[3m"; }

    //  Set blinking on.
    public static void setBlinking() { System.out.print((char)(27) << "[5m"; }

    // { Rapid blinking on. }
    public static void  setFastBlinking() { System.out.print((char)(27) << "[6m"; }

    // { Reverse the video. }
    public static void setReverseVideo() { System.out.print((char)(27) << "[7m"; }

    // { Concealed on, ISO 6429 standard }
    public static void concealedOn() { System.out.print((char)(27) << "[8m"; }

    //{ Set the foreground black, ISO 6429 standard. }
    public static void  setBlackForeground() { System.out.print((char)(27) << "[30m"; }

    // {  Red foreground, ISO 6429 standard. }
    public static void setRedForeground() { System.out.print((char)(27) << "[31m"; }

    // {  Green foreground, ISO 6429 standard. }
    public static void setGreenForeground() { System.out.print((char)(27) << "[32m"; }

    // {  Yellow foreground, ISO 6429 standard. }
    public static void setYellowForeground() { System.out.print((char)(27) << "[33m"; }

    // {  Blue forefround, ISO 6429 standard. }
    public static void setBlueForeground() { System.out.print((char)(27) << "[34m"; }

    // {  Magenta foreground, ISO 6429 standard. }
    public static void setMagentaForeground() { System.out.print((char)(27) << "[35m"; }

    // {  Cyan foreground, ISO 6429 standard. }
    public static void setCyanForeground() { System.out.print((char)(27) << "[36m"; }

    // {  White foreground, ISO 6429 standard. }
    public static void setWhiteForeground() { System.out.print((char)(27) << "[37m"; }

    // {  Black background, ISO 6429 standard. }
    public static void setBlackBackground() { System.out.print((char)(27) << "[40m"; }
	
    // {  Red background, ISO 6429 standard. }
    public static void setRedBackground(){ System.out.print((char)(27) << "[41m" ; }

    // { Green background, ISO 6429 standard. }
    public static void setGreenBackground() { System.out.print((char)(27) << "[42m"; }

    // { Yellow background, ISO 6429 standard. }
    public static void setYellowBackground() { System.out.print((char)(27) << "[43m"; }

    // { Blue background, ISO 6429 standard. }
    public static void setBlueBackground() { System.out.print((char)(27) << "[44m"; }

    // { Magenta background, ISO 6429 standard. }
    public static void setMagentaBackground() { System.out.print((char)(27) << "[45m"; }

    // { Cyan background, ISO 6429 standard. }
    public static void setCyanBackground() { System.out.print((char)(27) << "[46m"; }

    // { White background, ISO 6429 standard. }
    public static void setWhiteBackground() { System.out.print((char)(27) << "[47m"; }

    // {  Set the subscript. }
    public static void setSubscript() { System.out.print((char)(27) << "[48m"; }

    // {  Set superscript. }
    public static void setSuperscript() { System.out.print((char)(27) << "[49m"; }
*/
/* Following method  sets the screen width or type to one of
  the following:
	0 : 40 X 25 black and white, the third largest character size.
	1 : 40 X 25 color
	2 : 80 X 25 black and white , normal character size.
	3 : 80 X 25 color
	4 : 320 X 200 color
	5 : 320 X 200 black and white, the second largest character size.
	6 : 640 X 200 black and white ; the largest the character size.
*/
/*
    // { It sets the screen mode according above definition. }
    public static void  setScreenMode( int x ) { System.out.print((char)(27)<< "[="<< x<<"h"; }

    // { It resets the screen mode according above definition. }
    public static void  resetScreenMode( int x ) { System.out.print((char)(27)<<"[="<<x<<"l"; }

    // { Wrap at the end of line. }
    public static void  setLinewrap() { System.out.print((char)(27) << "[?7h"; }

    // { Wrap at the end of line. }
    public static void  resetLinewrap() { System.out.print((char)(27) << "[?7l"; }

    public static void messageAt(char * Message, int x,  int y) {
		moveTo(x, y);
		eraseLine();
		System.out.print((Message); }

    public static void messageAt( char * Message, int x,  int y,
					bool reverse, bool bold,  bool blinking) {
		moveTo(x, y);
		eraseLine();
		if (reverse) setReverseVideo();
		if (bold) setBold();
		if (blinking) setBlinking();
		System.out.print((Message);
		setAllOff();
		System.out.print((" "); }

    public static void   eraseMessageAt(int x, int y) {
         moveTo(x, y);
         eraseLine();
    //     drawBox(1, 1, 80, 25);
    }
*/
/*
    public static void one_line_menu(String menu, String pattern,
		        int WhereToPut) {
			reverse : boolean;  VAR choice : int) {
 // This method prints out a menu on a specified line. The contents of
 // the menu is store inside an one-dimensional character array and the choices
 // are indicated by patterns; each choice in the pattern is a non-blank string.
 // The menu can be printed out in ordinal or reversed vedio. The last parameter
 // will contain the user"s final choice.
 // An example of menu and pattern are as follow:
 // contents="1. Add   2. Delete   3. Insert   4. Print   5. Sort   6. Exit ";
 // pattern ="xxxxxx   xxxxxxxxx   xxxxxxxxx   xxxxxxxx   xxxxxxx   xxxxxxx ";
 // The menu and pattern are string of 80 characters.
	char c, c1  ;
        int stops = new int[20];
        int NumStops, LastChar, i, j;
        boolean changed ;

        drawBox(1, 1, 80, 25);
        clear();
        { Use the pattern to find the positions for each choice }
        NumStops := 1;
        changed := true;
        for i := 1 to 80 do {
            if pattern[i] = " " then
                     changed := true    { Next choice starts at the first
                                        non-blank character}
            else  {
                       if changed then
                          {
                                stops[NumStops] := i;
                                NumStops := NumStops + 1;
                          }
                       LastChar := i + 1;
                       changed := false;
                  }  { else }
         }  { end of for loop }
         Stops[NumStops] := LastChar + 1;
         if reverse then set_reverse_video
         else set_bold;
         For i := 1 to NumStops - 1 do
             {
                  for j := Stops[i] to Stops[i+1] - 2 do System.out.print((menu[j]);
                  GotoXY(Stops[i+1], WhereToPut)
             } { For }
         set_all_off;
	{ Make a choice }
	if (choice < 1 ) or (choice >= NumStops) then choice := NumStops - 1;
        moveTo(Stops[choice], WhereToPut);
        c := ReadKey;
        if c = #0 then c := ReadKey;    { c= #0 means the key pressed is a
                                         function key; which has two chars}

	while (c <> ' ') and (ord(c) <> 13)  do {
                case ord(c) of
                        75  : {
                                     choice := choice - 1;
                                     if choice < 1 then choice := NumStops - 1;
                                }

                        else   {
                                      choice := choice + 1;
                                      if choice >= NumStops then choice := 1;
                                 end

                    }  { case }

		GotoXY(Stops[choice], WhereToPut);
                c := ReadKey;
                if c = #0 then c := readkey;
	   }  { end of while }
           { Make the choice in the nemu blinking }
           set_blinking;
           for j := Stops[choice] to Stops[choice + 1] - 2 do System.out.print((menu[j]);
           set_all_off;
}
*/

/*
    public static void drawBox( int x1, int y1,
	int x2, int y2, boolean dline) {
    // It draws box by two points (x1, y1) and (x2, y2), which are any two
    // points in square (1, 1) and (24, 80). It may draw a double
    // line or single line box.

     int MinX, MinY, MaxX, MaxY, i ;
     char LLCorner, LRCorner, ULCorner, URCorner, Vertical, Horizontal;

	 if abs(x1 - x2) < 1 then exit;
	 if abs(y1 - y2) < 1 then exit;
     if double then {              { Double box corners }
                    LLCorner := #$C8;   { Code for double lower left corner }
                    LRCorner := #$BC;   { Lower right corner }
                    ULCorner := #$C9;   { Upper left }
                    URCorner := #$BB;   { Upper right corner }
                    Vertical := #$BA;   { Double vertical bar }
                    Horizontal := #$CD; {        Horizontal bar }
                    end
          else   {                 { Single box corner }
                    LLCorner := #$C0;   { Lower left }
                    LRCorner := #$D9;
                    ULCorner := #$DA;
                    URCorner := #$BF;
                    Vertical := #$B3;   { Double vertical bar }
                    Horizontal := #$C4; {        Horizontal bar }
                 }

     if x1 <= x2 then  {
                     MinX := x1;
                     MaxX := x2;
                     end
                else   {
                     MinX := x2;
                     MaxX := x1;
                     }

     if y1 <= y2 then  {
                     MinY := y1;
                     MaxY := y2;
                     end
                else   {
                     MinY := y2;
                     MaxY := y1;
                     }
	moverTo(MinX, MaxY);
	System.out.print((LLCorner);
	for i := MinX + 1 to MaxX -1 do
                      System.out.print((Horizontal);
	System.out.print((LRCorner);
	moveTo(MinX, MinY);
	System.out.print((ULCorner);
	for i := MinX + 1 to MaxX -1 do System.out.print((Horizontal);
	System.out.print((URCorner);
	for i := MinY + 1 to MaxY - 1 do {
                                                moveTo(MinX, i);
						System.out.print((Vertical);
						}
	for i := MinY + 1 to MaxY - 1  do {
						moveTo(MaxX, i);
						System.out.print((Vertical);
						}
    }
*/
/*
    static  char hold(int x=14, int y = 24, char * msg = "Press ENTER to continue, Q/q to quit ... ") {
		eraseLine();
		messageAt(msg, x, y);
		char trash[10] ;
		cin.getline(trash, 10);
		if ( strlen(trash) > 0 ) return trash[0];
		return ' ';
    }
*/
} 
