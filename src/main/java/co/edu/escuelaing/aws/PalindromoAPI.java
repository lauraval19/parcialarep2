package co.edu.escuelaing.aws;

public class PalindromoAPI {
    String cadena;

    public PalindromoAPI(String cadena) {
        this.cadena = cadena;
    }

    public boolean ispalindromo(String cad){
        String invertir = "";
        for (int i = cad.length() - 1; i >= 0; i--) {
            invertir += cad.charAt(i);
        }
        if(cad.equals(invertir)){
            return true;
        }else{return false;}
    }

    public String palindromo(String cadena){
        boolean var = ispalindromo(cadena);
        String ispali = "";
        if(var){
            ispali = "Si es palíndromo";
        }else{ispali="No es palíndromo";}
        return "{operation:palindromo,input:"+cadena+",output:"+ispali+"}";
    }

}
