package problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolynomialTest {
  Term five = new Term(5, new Variable[]{}, false);
  Term x = new Term(3, new Variable[]{new Variable('x', 1)}, true);
  Term xy2 = new Term(4,
    new Variable[]{new Variable('x', 1), new Variable('y', 2)},
    true);
  Term y3 = new Term(5, new Variable[]{new Variable('y', 3)}, true);
  Term x2y2 = new Term(7,
    new Variable[]{new Variable('x', 2), new Variable('y', 2)},
    true);

  @Test
  void Term_getDegree() {
    assertEquals(3, xy2.getDegree());
    assertEquals(1, x.getDegree());
    assertEquals(0, five.getDegree());
  }

  @Test
  void Polynomial_standardForm() {
    Polynomial polynomial = new Polynomial(new Term[]{xy2, x, five});
    assertEquals("4xy^2 + 3x - 5", polynomial.toString());
    assertEquals("5y^3 + 4xy^2 + 3x - 5", new Polynomial(new Term[]{xy2, x, five, y3}).toString());
    assertEquals("7x^2y^2 + 5y^3 + 4xy^2", new Polynomial(new Term[]{xy2, y3, x2y2}).toString());
  }

}
