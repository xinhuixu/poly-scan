/*FILENAME: Polynomial.java
 WHO: Julia McDonald, Xinhui Xu
 WHEN: Fall 2017
 WHAT: Assignment 6 Task 3
 */
import java.util.*;

public class Polynomial{

    /*A queue, implemented with Linkedlist*/
  public Queue<Term> terms;

    
  public Polynomial(){
   terms = new LinkedList<Term>();
  }

    /* Returns string representation of the Polynomial 
     @return s - String of Polynomial*/
  public String toString(){
    String s = "";
    Queue<Term> temp = new LinkedList<Term>();
    
    while (!terms.isEmpty()){
      if( terms.peek().getCoef() != 0 ){
        temp.add(terms.peek());
        s += /*terms.peek().getCoef()+ " " +*/ terms.remove() + " + ";
      } else {
        terms.remove();
      }
    }
    terms = temp;
    if( s.length() >= 2 )
      s = s.substring(0, s.length() - 2);
    
    return s;
  }
    /*Adds a term to the Polynomial object.
     * @param t - Term to be added
     */
  public void addTerm(Term t){ 
    if( t.getCoef() == 0 )
      return;
    
    if (terms.isEmpty()){
      terms.add(t);
      return;
    }
    Queue<Term> newTerms = new LinkedList<Term>();
    boolean isAdded = false;
    while (!terms.isEmpty()){
      
      if (terms.peek().getExp() > t.getExp()){
        newTerms.add(terms.remove());
        if (terms.isEmpty()) {
          newTerms.add(t);
        }
      } else if (terms.peek().getExp() == t.getExp()){
        terms.peek().setCoef( t.getCoef() + terms.peek().getCoef());
        newTerms.add(terms.remove());
        isAdded = true;
      }  else if (terms.peek().getExp() < t.getExp()){
        if (!isAdded){
          newTerms.add( t );
          isAdded = true;
        }
        newTerms.add( terms.remove());
      }
    } 

    terms = newTerms;
  }

    /* Add a Polynomial to this Polynomial 
    * @param p - Polynomial to be added
    */
  public void addPolynomial(Polynomial p){
    Queue<Term> temp = new LinkedList<Term>();
    while( !p.terms.isEmpty() ){
      temp.add( p.terms.peek() );
      this.addTerm( p.terms.remove() );
      if( terms.peek().getCoef() == 0 )
        terms.remove();
    }
    p.terms = temp;
  }

    /*Makes and returns a clone of this Polynomial.
     @return Polynomial - clone*/
  public Polynomial clone(){
    Polynomial p1 = new Polynomial();
    Queue<Term> clonedTerms = new LinkedList<Term>( terms );
    p1.terms = clonedTerms;
    return p1;
  }

    /*main method, basic testing*/
  public static void main(String [] args){
    Polynomial p0 = new Polynomial();
    p0.addTerm(new Term(2, 2));
    p0.addTerm(new Term(5, 1));
    p0.addTerm(new Term(7, -3));
    p0.addTerm(new Term(5, 5));
    p0.addTerm(new Term(3, 3));
    p0.addTerm(new Term(5, 1));
    System.out.println(p0);
    Polynomial p1 = new Polynomial();
    p1.addTerm(new Term(5, 4));
    p1.addTerm(new Term(4, -3));
    
    p0.addPolynomial(p1);
    
    System.out.println(p0);
    System.out.println(p1);
  }
  
}
