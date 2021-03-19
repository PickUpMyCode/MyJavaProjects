package SnakeGame;

public class Rainbow {
	public static int r = 255, g = 11, b = 11;
	private static boolean  rbool = false, gbool = false, bbool = false;
	private static boolean subr = false, subg =false, subb = false, reset = false;;
	private static int cont = 0;
	private static boolean soma = false;
	public static int R() {
		if(rbool) {
			if(cont > 0) {
				if(r == 254) {
					rbool = false;
					subb = true;
				}
			}else {
				if(r == 254) {
					rbool = false;
					soma = true;
				}
			}
			return r++;
		}
		else {
			if(soma) {			
				cont++;
				soma = false;
				subb  = true;
			}
			if(subr) {
				if(r == 1) {
					subr = false;
					bbool =  true;
				}
				return r--;
			}
			return r;
		}
	}
	public static int G() {
		if(!gbool) {
			if(g == 254) {
				gbool = true;
				subr = true;
			}
			return g++;

		}else {
			if(subg) {
				if(g == 1) {
					subg = false;
					rbool = true;
				}
				return g--;
			}
			return g;
		}

	}
	public static int B() {
		if(bbool) {
			if(b == 254) {
				bbool = false;
				subg = true;
			}
			return b++;
		}else {
			if(subb) {
				if(b == 254) {
					reset = true;
					subb = false;
				}
				return b--;
			}
			if(reset) {
				reset();
			}
			return b;
		}
	}
	private static void reset() {
		r = 255;
		g = 11;
		b = 11;
		gbool = false;
		reset = false;
	}
}
