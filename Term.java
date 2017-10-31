/*FILENAME: Term.java
  WHO: Julia McDonald, Xinhui Xu
 */
/**
 * Represents a polynomial term
 */
public class Term {
  //instance variables
  private int coef;
  private int exp;
  
  /**
   * Default constructor of a Term (no parameters)
   */
  public Term(){
    coef = 1;
    exp = 1;
  }
  
  /**
   * Constructor of a Term
   * @param coef - the coefficient of the term
   * @param exp - the exponent of the term
   */
  public Term( int coef, int exp ){
    this.coef = coef;
    this.exp = exp;
  }
  
  /**
   * Gets the coefficient
   * @return the coefficient of a Term
   */
  public int getCoef(){
    return coef;
  }
  
  /**
   * Sets the coefficient
   * @param the new coefficient
   */
  public void setCoef( int coef ){
    this.coef = coef;
  }
  
  /**
   * Gets the exponent
   * @return the exponent
   */
  public int getExp(){
    return exp;
  }
  
  /**
   * Sets the exponent
   * @param the new exponent
   */
  public void setExp( int exp ){
    this.exp = exp;
  }
  
  /**
   * Creates a String representation of a Term object
   * @return a readable representation of a Term object
   */
  public String toString(){
    if( coef == 0 )
      return "";
    if( exp == 0 )
      return coef + "";
    if( exp == 1 )
      return coef + "x";
    return coef + "x^" + exp;
  }
  
  /**
   * Driver method of the class
   */
  public static void main( String[] args ){
    Term one = new Term();
    Term two = new Term( 5, 3 );
    
    System.out.println( one + " " + one.getCoef() + " " + one.getExp() );
    System.out.println( two + " " + two.getCoef() + " " + two.getExp() );
    
    one.setCoef( 4 );
    one.setExp( 3 );
    
    two.setExp( 37 );
    
    System.out.println( one + " " + one.getCoef() + " " + one.getExp() );
    System.out.println( two + " " + two.getCoef() + " " + two.getExp() );
  }
  
}
