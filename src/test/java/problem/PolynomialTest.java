package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
  Term zero = new Term(0, new Variable[]{});
  Term _five = new Term(-5, new Variable[]{});
  Term five = new Term(5, new Variable[]{});
  Term x = new Term(3, new Variable[]{new Variable('x', 1)});
  Term xy2 = new Term(4,
    new Variable[]{new Variable('x', 1), new Variable('y', 2)});
  Term _xy2 = new Term(-4,
    new Variable[]{new Variable('x', 1), new Variable('y', 2)});
  Term y3 = new Term(5, new Variable[]{new Variable('y', 3)});
  Term x2y2 = new Term(7,
    new Variable[]{new Variable('x', 2), new Variable('y', 2)});

  @Test
  void Term_getDegree() {
    assertEquals(3, xy2.getDegree());
    assertEquals(1, x.getDegree());
    assertEquals(0, _five.getDegree());
    assertEquals(0, zero.getDegree());
  }

  @Test
  void Term_isLikeTerm() {
    assertTrue(zero.isLikeTerm(_five));
    assertTrue(xy2.isLikeTerm(_xy2));
    assertFalse(x.isLikeTerm(xy2));
  }

  @Test
  void Polynomial_standardForm() {
    assertEquals("4xy^2 + 3x - 5", new Polynomial(new Term[]{xy2, x, _five}).toString());
    assertEquals("5y^3 + 4xy^2 + 3x - 5", new Polynomial(new Term[]{xy2, x, _five, y3}).toString());
    assertEquals("7x^2y^2 + 5y^3 + 4xy^2", new Polynomial(new Term[]{xy2, y3, x2y2}).toString());
    assertEquals("-4xy^2 + 0", new Polynomial(new Term[]{zero, _xy2}).toString());
  }

  @Test
  void Polynomial_add() {
    Polynomial p1 = new Polynomial(new Term[]{xy2, x, five});
    Polynomial p2 = new Polynomial(new Term[]{_xy2, x, _five, y3});
    Polynomial p3 = new Polynomial(new Term[]{five});
    Polynomial p4 = new Polynomial(new Term[]{_five});

    System.out.print("(" + p1.toString() + ") + (" + p2.toString() + ") = ");

    assertEquals("5y^3 + 6x", p1.add(p2).toString());

    System.out.println(p1.toString());

    System.out.print("(" + p3.toString() + ") + (" + p4.toString() + ") = ");

    assertEquals("0", p3.add(p4).toString());

    System.out.println(p3.toString());



  }

}
