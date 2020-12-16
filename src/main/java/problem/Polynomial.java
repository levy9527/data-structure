package problem;

// terms[]: constant variables: name, exponent
class Variable {
  private char name;
  private int exponent;

  Variable(char name, int exponent) {
    if (exponent < 0) exponent = 0;
    this.name = name;
    this.exponent = exponent;
  }

  public char getName() {
    return name;
  }

  public void setName(char name) {
    this.name = name;
  }

  public int getExponent() {
    return exponent;
  }

  public void setExponent(int exponent) {
    this.exponent = exponent;
  }
}

class Term {
  private int constant;
  private Variable[] variables;
  private boolean positive;

  Term(int constant, Variable[] variables, boolean positive) {
    this.constant = constant;
    this.variables = variables;
    this.positive = positive;
  }

  /**
   * get the sum of all variable's exponent
   */
  public int getDegree() {
    int sum = 0;
    for (Variable variable : variables) {
      sum += variable.getExponent();
    }
    return sum;
  }

  public int getLargestExponent() {
    int exponent = 0;
    for (Variable variable : variables) {
      int e = variable.getExponent();
      if (e > exponent) exponent = e;
    }
    return exponent;
  }

  public int getConstant() {
    return constant;
  }

  public void setConstant(int constant) {
    this.constant = constant;
  }

  public Variable[] getVariables() {
    return variables;
  }

  public void setVariables(Variable[] variables) {
    this.variables = variables;
  }

  public boolean isPositive() {
    return positive;
  }

  public void setPositive(boolean positive) {
    this.positive = positive;
  }
}
public class Polynomial {
  private Term[] terms;

  Polynomial(Term[] terms) {
    this.terms = terms;
    standardForm();
  }

  // find like terms
  // add constant
  public Polynomial add(Polynomial polynomial) {
    return null;
  }

  public Polynomial subtract() {
    return null;
  }

  /**
   * degree 最大的在前, 冒泡排序
   * 当 degree 相同时，让单个 variable 的 exponent 最大的在前，如：5y^3 + 4xy^2
   */
  private void standardForm() {
    for (int i = 0; i < terms.length - 1; i++) {
     for (int j = 0; j < terms.length - 1 - i; j++) {
       if (terms[j].getDegree() < terms[j + 1].getDegree() ||
         terms[j].getLargestExponent() < terms[j + 1].getLargestExponent()) {
         Term tmp = terms[j];
         terms[j] = terms[j + 1];
         terms[j + 1] = tmp;
       }
     }
    }
  }

  @Override
  public String toString(){
    StringBuilder result = new StringBuilder();
    String minus = " - ";
    String plus = " + ";


    for (int i = 0; i < terms.length; i++) {
      Term term = terms[i];

      // 第一个要特殊处理
      if (i == 0) {
        // 不用显示 + ，但要显示 -
        if (!term.isPositive()) result.append(minus.trim());
      }
      else {
        result.append(term.isPositive() ? plus : minus);
      }

      // constant 为 1 不显示系数, 但 0 却还是要显示的
      if (term.getConstant() != 1)
        result.append(term.getConstant());

      for (Variable variable : term.getVariables()) {
        // exponent 为 0 则相当于常量 1，跳过
        if (variable.getExponent() == 0) continue;

        result.append(variable.getName());

        // exponent 大于 1 才显示指数
        if (variable.getExponent() > 1) {
          result.append('^');
          result.append(variable.getExponent());
        }
      }
    }

    return result.toString();
  }

  public Term[] getTerms() {
    return terms;
  }

  public void setTerms(Term[] terms) {
    this.terms = terms;
  }
}
