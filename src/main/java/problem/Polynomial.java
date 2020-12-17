package problem;

import java.util.ArrayList;

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

  Term(int constant, Variable[] variables) {
    this.constant = constant;
    this.variables = variables;
  }

  public boolean isLikeTerm(Term term) {
    return this.toString().equals(term.toString());
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

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (Variable variable : variables) {
      result.append(variable.getName());
      result.append(variable.getExponent());
    }
    return result.toString();
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

}
public class Polynomial {
  private Term[] terms;

  Polynomial(Term[] terms) {
    this.terms = terms;
    standardForm();
  }

  // find like terms
    // t1::forEach compareTo(t2::forEach) 判断 variable+exponent 的字符串 equals
    // perf? 匹配后，把 t2 中的元素的去掉
  // calc constant
  // standard form
  public Polynomial add(Polynomial polynomial) {
    Term[] compares = polynomial.getTerms();
    ArrayList<Term> result = new ArrayList<>();
    int[] hits = new int[compares.length];

    for (int i = 0; i < terms.length; i++) {
      Term term = terms[i];
      result.add(term);

      for (int j = 0; j < compares.length; j++) {
        if (term.isLikeTerm(compares[j])) {
          hits[j] = 1;
          int sum = term.getConstant() + compares[j].getConstant();

          if (sum == 0) {
            result.remove(term);
          }
          else {
            term.setConstant(sum);
          }
          break;
        }
      }
    }

    for (int j = 0; j < compares.length; j++) {
      if (hits[j] == 1) continue;
      result.add(compares[j]);
    }

    // https://stackoverflow.com/questions/9572795/convert-list-to-array-in-java
    terms = result.toArray(new Term[0]);
    standardForm();

    return this;
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
        if (term.getConstant() < 0) result.append(minus.trim());
      }
      else {
        result.append(term.getConstant() >= 0 ? plus : minus);
      }

      // constant 为 1 不显示系数, 但 0 却还是要显示的
      if (term.getConstant() != 1) {
        // 前面已经用过 +/- 号了，此时要取绝对值
        result.append(Math.abs(term.getConstant()));
      }

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
