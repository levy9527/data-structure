package algs4.graph.mst;

public class EdgeWeighted implements Comparable<EdgeWeighted>{
  private int v;
  private int w;
  private double weighted;

  public EdgeWeighted(int v, int w, double weighted) {
    this.v = v;
    this.w = w;
    this.weighted = weighted;
  }

  public double weighted() {
   return 0D;
  }

  @Override
  public int compareTo(EdgeWeighted o) {
    return (int) (this.weighted - o.weighted());
  }

  public int either() {
    return v;
  }

  public int other(int v) {
    return v == this.v ? this.w : this.v;
  }

}
