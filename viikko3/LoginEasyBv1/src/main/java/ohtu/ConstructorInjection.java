package ohtu;

public class ConstructorInjection {
  private String name = null;

  public ConstructorInjection(String name, int roll) {
    this.name = name;
  }

  public String getMessage() {
    return name;
  }
}