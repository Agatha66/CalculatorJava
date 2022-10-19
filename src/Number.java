public class Number {
	int pos;
	
	double separateNumber(int i,String s){
		this.pos=i;
		String k = "";
		double number = 0;
		while(this.pos < s.length() && Character.isDigit(s.charAt(this.pos))
		   || this.pos < s.length() && s.charAt(this.pos) == '.' 
		   || this.pos < s.length() && s.charAt(this.pos) == 'E' 
		   || this.pos < s.length() && s.charAt(this.pos) == '-' && this.pos < s.length() && s.charAt(this.pos - 1) == 'E') 
		{
			k += s.charAt(this.pos);
			this.pos++;
		}
		number = Double.parseDouble(k);
		this.pos = this.pos-1;
		return number;
	}
	
	String separateExpression(int i,String s) {
		i++;
		String k = "";
		while(s.charAt(i) != ')') {
			k += s.charAt(i);
			i++;
		}
		return k;
	}
	
	double operation(String exp) {
		for(int i = 0; i < exp.length(); i++) { 
			if(exp.charAt(i) == '^') { //find if there has any symbol '^' in the expression
				boolean rMinus = false;
				
				while (!Character.isDigit(exp.charAt(i)) && exp.charAt(i) != '.')
					i--;
				
				while (Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.' || exp.charAt(i) == 'E' || exp.charAt(i) == '-' && exp.charAt(i - 1) == 'E') {
					i--;
					if(i == -1) {
						break;
					}
				}
				i++;
				
				int start = i;
			
				double l = this.separateNumber(i,exp);
				i=this.pos;
				i++;
				
				while(i < exp.length() && !Character.isDigit(exp.charAt(i)) && exp.charAt(i) != '.' && exp.charAt(i)!= '-')
					i++;
				
				if(exp.charAt(i - 1) == '-')
					rMinus = true;
				double r = this.separateNumber(i,exp);
				i=this.pos;
				
				if(rMinus)
					r = -r;
				int stop = i;
				double result = Math.pow(l, r);
				StringBuffer resString = new StringBuffer(exp);
				
				for(int j = start; j <= stop; j++) {
					resString.deleteCharAt(start);
					exp = resString.toString();
				}
				resString = new StringBuffer(exp);
				resString.insert(start, String.valueOf(result));
				exp = resString.toString();
				i = start;
			}
		}
		for(int i = 0; i < exp.length(); i++) { 
			if(exp.charAt(i) == '/') { //find if there has any symbol '/' in the expression
				boolean rMinus = false;
				
				while (!Character.isDigit(exp.charAt(i)) && exp.charAt(i) != '.')
					i--;
				
				while (Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.' || exp.charAt(i) == 'E' || i - 1 >= 0 && exp.charAt(i) == '-' && exp.charAt(i - 1) == 'E') {
					i--;
					if(i == -1) {
						break;
					}
				}
				i++;
				
				int start = i;
				
				double l = this.separateNumber(i,exp);
				i=this.pos;
				i++;
				
				while(i < exp.length() && !Character.isDigit(exp.charAt(i)) && exp.charAt(i) != '.' && exp.charAt(i)!= '-')
					i++;
				
				if(exp.charAt(i) == '-') {
					rMinus = true;
					i++;
				}
				
				double r = this.separateNumber(i,exp);
				i=this.pos;
				
				if(rMinus)
					r = -r;
				int stop = i;
				double result = l/r;
				StringBuffer resString = new StringBuffer(exp);
				
				for(int j = start; j <= stop; j++) {
					resString.deleteCharAt(start);
					exp = resString.toString();
				}
				resString = new StringBuffer(exp);
				resString.insert(start, String.valueOf(result));
				exp = resString.toString();
				i = start;
			}
		}
		for(int i = 0; i < exp.length(); i++) { 
			if(exp.charAt(i) == 'x') { //find if there has any symbol 'x' in the expression
				boolean rMinus = false;
				
				while (!Character.isDigit(exp.charAt(i)) && exp.charAt(i) != '.')
					i--;
				
				while (Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.' || exp.charAt(i) == 'E' || i - 1 >= 0 && exp.charAt(i) == '-' && exp.charAt(i - 1) == 'E') {
					i--;
					if(i == -1) {
						break;
					}
				}
				i++;
				
				int start = i;
				
				double l = this.separateNumber(i,exp);
				i=this.pos;
				i++;
				
				while(i < exp.length() && !Character.isDigit(exp.charAt(i)) && exp.charAt(i) != '.' && exp.charAt(i)!= '-')
					i++;
				
				if(exp.charAt(i) == '-') {
					rMinus = true;
					i++;
				}
				
				double r = this.separateNumber(i,exp);
				i=this.pos;
				
				if(rMinus)
					r = -r;
				int stop = i;
				double result = l*r;
				StringBuffer resString = new StringBuffer(exp);
				
				for(int j = start; j <= stop; j++) {
					resString.deleteCharAt(start);
					exp = resString.toString();
				}
				resString = new StringBuffer(exp);
				resString.insert(start, String.valueOf(result));
				exp = resString.toString();
				i = start;
			}
		}
		
		//change symbol '+-' to '-', '-+' to '-', '++' to '+', and '--' to '+'
		for(int i = 0; i < exp.length(); i++) { 
			if(exp.charAt(i) == '+' && exp.charAt(i + 1) == '-') {
				StringBuffer resString = new StringBuffer(exp);
				resString.deleteCharAt(i);
				exp = resString.toString();
				i--;
			}
			else if(exp.charAt(i) == '-' && exp.charAt(i + 1) == '+') {
				StringBuffer resString = new StringBuffer(exp);
				resString.deleteCharAt(i + 1);
				exp = resString.toString();
				i--;
			}
			else if(exp.charAt(i) == '+' && exp.charAt(i + 1) == '+') {
				StringBuffer resString = new StringBuffer(exp);
				resString.deleteCharAt(i);
				exp = resString.toString();
				i--;
			}
			else if(exp.charAt(i) == '-' && exp.charAt(i + 1) == '-') {
				StringBuffer resString = new StringBuffer(exp);
				resString.delete(i, i + 2);
				resString.insert(i, "+");
				exp = resString.toString();
				i--;
			}
		}
		
		double answer = 0d;
		//after there is no more symbol 'x', '/, and '^' in the expression
		for(int i = 0; i < exp.length(); i++) {
			
			if(i == 0 && exp.charAt(i) == '-') {
				i++;
				answer = this.separateNumber(i, exp);
				i=this.pos;
				answer = -answer;
			}
			else if(i == 0 && exp.charAt(i) == '+') {
				i++;
				answer = this.separateNumber(i, exp);
				i=this.pos;
			}
			else if(i >= 0 && exp.charAt(i) == '-' && i>0 && exp.charAt(i -1) != 'E') //find if there has any symbol '-'
			{
				if(i == 0) {
					answer = Double.parseDouble(exp);
					break;
				}
				while(!Character.isDigit(exp.charAt(i)))
					i++;
				answer -= this.separateNumber(i, exp);
				i=this.pos;
			}
			else if(exp.charAt(i) == '+') //find if there has any symbol '+'
			{
				if(i == 0) {
					answer = Double.parseDouble(exp);
					break;
				}
				while(!Character.isDigit(exp.charAt(i)))
					i++;
				answer += this.separateNumber(i, exp);
				i=this.pos;
			}
			else if(Character.isDigit(exp.charAt(i))) //if the expression only left numbers
			{
				answer = this.separateNumber(i, exp);
				i=this.pos;
			}
		}
		
		return answer;
	}
}