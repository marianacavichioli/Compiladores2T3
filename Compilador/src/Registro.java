import java.util.ArrayList;
import java.util.List;

public class Registro {

    private String nome;
    public List<EntradaTabelaDeSimbolos> simbolos;

    public Registro(String nome) {
        simbolos = new ArrayList<EntradaTabelaDeSimbolos>();
        this.nome = nome;
    }

    public void adicionarSimbolo(String nome, String tipo) {
        simbolos.add(new EntradaTabelaDeSimbolos(nome,tipo));
    }

    public void adicionarSimbolos(List<String> nomes, String tipo) {
        for(String s:nomes) {
            simbolos.add(new EntradaTabelaDeSimbolos(s, tipo));
        }
    }
    public String getTipo (String nome){
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return etds.getTipo();
            }
        }
        return "null";
    }

    public boolean existeSimbolo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String n){
        nome = n;
    }


    @Override
    public String toString() {
        String ret = "Nome: "+nome;
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            ret += "\n   "+etds;
        }
        return ret;
    }
}
