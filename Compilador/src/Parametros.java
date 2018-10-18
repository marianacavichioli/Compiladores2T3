import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class Parametros {

    private ArrayList<String> Lista;
    private String identificador;
    private String retorno;

    public Parametros(String identificador){
        this.identificador = identificador;
        Lista = new ArrayList<String>();
    }

    public String getIdentificador(){
        return identificador;
    }

    public void setLista(ArrayList<String> NLista){
        this.Lista = NLista;
    }

    public ArrayList<String> getLista(){
        return this.Lista;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
    public String getRetorno(){
        return retorno;
    }
}
