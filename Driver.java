/*FILENAME: Driver.java
 *WHO: Xinhui Xu, Julia McDonald
 *WHAT: Assignment 6 Task 3
 */
import java.io.*;
import java.util.Scanner;

public class Driver{
  //Assumes correct input

    /* Takes a String representation of a Term and returns as Term object
     * @param input - the String of Term
     * @return Term - new Term object
     */
  public static Term scanToTerm(String input){
    //"2x^2" "3x" "5"
    int x_index = input.indexOf('x');
    int caret = input.indexOf('^');
    int exp; int coef;
    if (caret == -1){
      if (x_index == -1){ //constant term
        x_index = input.length();
        exp = 0;
      } else {
        exp = 1; //"5x"
      }
    } else { //"43x^19
      exp = Integer.parseInt(input.substring(caret + 1, input.length()));
    }
    if (x_index == 0) { //"x^82"
      coef = 1;
    } else {
      coef = Integer.parseInt(input.substring(0, x_index));
    }
    Term ret = new Term(coef, exp);
    return ret;
  }

    /* Takes a String input of a polynomial, e.x. "2x^2 + 4x + 4" and returns it as Polynomial object.
     * @param input - the user input of the polynomial
     * @return Polynomial - new Polynomial object
     */
  public static Polynomial scanToPolynomial(String input){
    Polynomial ret = new Polynomial();
    String[] term_strs = input.split("\\ \\+\\ ");
    for (int i = 0; i<term_strs.length; i++ ){
      ret.addTerm(scanToTerm(term_strs[i]));
    }
    //    System.out.println( ret );
    return ret;
  }

        /* Very roughly checks if input Polynomial string is valid.
     * @param s - input string
     */
    public static void isStrValid(String s){
	s = s.replace("x", "");
	s = s.replace("^", "");
	s = s.replace("+", "");
	s = s.replace(" ", "");
	s = s.replace("-", "");
	//	System.out.println(s);
	//    Strips away the possible non-number parts and see if it remains number //unsolved: empty input, ends with illegal +
	try {
	    Integer.parseInt(s);
	} catch(NumberFormatException e){
	    System.out.println("Illegal characters. Please check your input.");
	} catch(NullPointerException e){
	    return;
	}
    }

    /* Main method, contains predefined polynomials and user input prompts 
     */
  public static void main(String[] args){
    System.out.println( "Starting testing with predefined Polynomials:" + 
                       "\n---------------------------------------------" );
    
    Polynomial p1 = new Polynomial();
    p1.addTerm( new Term( 2, 2 ) );
    p1.addTerm( new Term( 5, 1 ) );
    p1.addTerm( new Term( 7, -3 ) );
    System.out.println( "Polynomial P1: " + p1 );
    
    Polynomial p11 = p1.clone();
    System.out.println( "P11 is a clone of P1: " + p11);
    
    Polynomial p2 = new Polynomial();
    p2.addTerm( new Term(  -2, 3 ));
    p2.addTerm( new Term(  1, 2 ));
    p2.addTerm( new Term(  3, 1 ));
    System.out.println( "Polynomial P2: " + p2 );
    
    Polynomial p22 = p2.clone();
    System.out.println( "P22 is clone of P2: " + p22 );
    
    p1.addPolynomial( p2 );
    System.out.println( "P1 = P1 + P2: " + p1 );
    
    p22.addPolynomial( p11 );
    System.out.println( "P22 = P22 + P11: " + p22 + "[P22 == P1]" );
    
    Polynomial p3 = new Polynomial();
    p3.addTerm( new Term(  2, 3 ));
    p3.addTerm( new Term(  -3, 2 ));
    p3.addTerm( new Term(  -8, 1 ));
    p3.addTerm( new Term(  -7, -3 ));
    System.out.println( "P3 has factors negating P1: " + p3 );
    
    p1.addPolynomial( p3 );
    System.out.println( "P1 = P1 + P3 [should be empty]: " + p1 );
    
    Polynomial p1000 = new Polynomial();
    p1000.addTerm( new Term( 1, 1000 ));
    System.out.println( "Polynomial P1000: " + p1000);
    
    p1000.addTerm( new Term( 0, 0 ));
    System.out.println( "adding empty Poly to P1000: " + p1000 );
    
    p1000.addTerm( new Term( 1, -1000 ));
    System.out.println( "P1000 with large range of empty terms: " + p1000 );
    
    System.out.println( "Testing reading methods:" + "\n--------------------------" );
    
    String p1_str = ""; String p2_str = "";
    Scanner scan = new Scanner(System.in);

    while (true) {
	System.out.println("Enter Polynomial P1:");
	String s1_str = scan.nextLine();
	isStrValid(s1_str);
    
	System.out.println("Enter Polynomial P2:");
	String s2_str = scan.nextLine();
	isStrValid(s2_str);
    
	System.out.println("The result of adding P1 and P2 is:");
	Polynomial s1 = scanToPolynomial(s1_str);
	Polynomial s2 = scanToPolynomial(s2_str);
	s1.addPolynomial(s2);
	System.out.println(s1);
    }
  }
}
