package main.java.fr.dauphine.lamsade.hib.ads.resources;

public class FormException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  
  public FormException(String msg) {
    super(msg);
  }
}
