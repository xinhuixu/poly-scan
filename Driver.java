public class Driver{
  public static void main( String[] args ){
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
  }
}