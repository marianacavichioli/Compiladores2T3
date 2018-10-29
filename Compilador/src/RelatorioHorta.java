import java.util.ArrayList;
import java.util.List;

public class RelatorioHorta {

    final int QTD_MAX_SLOTS = 4;

    private String nome, estacao_base, estacao_atual, local;
    public String semente_slot[] = new String[QTD_MAX_SLOTS]; // lembrar sempre que se receber slot 1, é o indice 0 (tratar isso em todos os métodos)


    private boolean slot_capinado[] = new boolean[QTD_MAX_SLOTS];
    private boolean slot_adubado[] = new boolean[QTD_MAX_SLOTS];
    private int slot_regado[] = new int[QTD_MAX_SLOTS]; // 0 para nao regado, 1 para regado pouco, 2 para regado muito e 3 para encharcado

    private int qtd_dias;

    private List<String> colheita = new ArrayList<String>();

    public RelatorioHorta(){
        this.qtd_dias = 0;
        for(int i=0;i<QTD_MAX_SLOTS;i++){
            slot_capinado[i] = false;
            slot_adubado[i] = false;
            slot_regado[i] = 0;
        }
    }

    public int getQTD_MAX_SLOTS() {
        return QTD_MAX_SLOTS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstacao_base() {
        return estacao_base;
    }

    public void setEstacao_base(String estacao_base) {
        this.estacao_base = estacao_base;
    }

    public String getEstacao_atual() {
        return estacao_atual;
    }

    public void setEstacao_atual(String estacao_atual) {
        this.estacao_atual = estacao_atual;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSemente_slot(int i) {
        if(i<=QTD_MAX_SLOTS) {
            if (i == 0) { // caso em que foi pedido todos
                String semente = "semeados";
                for (int j = 0; j < QTD_MAX_SLOTS; j++) {
                    if(this.semente_slot[j] == null){ // encontrou algum slot que nao possui semente
                        semente = null;
                        break;
                    }
                }
                return semente; // retorna null se algum slot nao possui semente. Ou retorna "semeados" caso contrario
            }
            else // caso em que foi pedido um slot especifico
                return semente_slot[i-1];
        }
        else
            return null;
    }

    public void setSemente_slot(String semente_slot, int i) {
        if (i <= QTD_MAX_SLOTS){
            if (i == 0) { // caso em que foi pedido todos
                for (int j = 0; j < QTD_MAX_SLOTS; j++) {
                    this.semente_slot[j] = semente_slot;
                }
            }
            else { // caso em que foi pedido um slot especifico
                this.semente_slot[i-1] = semente_slot;
            }
        }
    }

    public boolean getSlot_capinado(int i) {
        if(i<=QTD_MAX_SLOTS){
            if(i==0){ // caso em que foi pedido todos
                boolean slot_capinado = true;
                for(int j=0;j<QTD_MAX_SLOTS;j++){
                    slot_capinado = slot_capinado && this.slot_capinado[j];
                }
                return slot_capinado; // retorna true apenas se todos slots estao capinados
            }
            else { // caso em que foi pedido um slot especifico
                return slot_capinado[i-1];
            }
        }
        else
            return false;
    }

    public void setSlot_capinado(int i, boolean slot_capinado) {
        if(i<=QTD_MAX_SLOTS) {
            if(i==0){ // caso em que foi pedido todos
                for(int j=0;j<QTD_MAX_SLOTS;j++){
                    this.slot_capinado[j] = slot_capinado;
                }
            }
            else{ // caso em que foi pedido um slot especifico
                this.slot_capinado[i-1] = slot_capinado;
            }
        }
    }

    public boolean getSlot_adubado(int i) {
        if(i<=QTD_MAX_SLOTS) {
            if(i==0){ // caso em que foi pedido todos
                boolean slot_adubado = true;
                for(int j=0;j<QTD_MAX_SLOTS;j++){
                    slot_adubado = slot_adubado && this.slot_adubado[j];
                }
                return slot_adubado; // retorna true apenas se todos slots estao adubados
            }
            else { // caso em que foi pedido um slot especifico
                return slot_adubado[i-1];
            }
        }
        else
            return false;
    }

    public void setSlot_adubado(int i, boolean slot_adubado) {
        if(i<=QTD_MAX_SLOTS) {
            if(i==0){ // caso em que foi pedido todos
                for(int j=0;j<QTD_MAX_SLOTS;j++){
                    this.slot_adubado[j] = slot_adubado;
                }
            }
            else { // caso em que foi pedido um slot especifico
                this.slot_adubado[i-1] = slot_adubado;
            }
        }
    }

    public int getSlot_regado(int i) {
        if(i<=QTD_MAX_SLOTS) {
            if (i == 0) { // caso em que foi pedido todos
                int slot_regado = 3; // 3 pois é o maximo para estar encharcado.
                for (int j = 0; j < QTD_MAX_SLOTS; j++) {
                    if (this.slot_regado[j] < slot_regado) {
                        slot_regado = this.slot_regado[j];
                    }
                }
                return slot_regado; // retorna o valor do menor regado entre todos slots
            } else { // caso em que foi pedido um slot especifico
                return slot_regado[i-1];
            }
        }
        else
            return 0;
    }

    public void setSlot_regado(int i, int slot_regado) {
        if(i<=QTD_MAX_SLOTS) {
            if(i==0){ // caso em que foi pedido todos
                for(int j=0;j<QTD_MAX_SLOTS;j++){
                    this.slot_regado[j] = slot_regado;
                }
            }
            else { // caso em que foi pedido um slot especifico
                this.slot_regado[i-1] = slot_regado;
            }
        }
    }

    public boolean incrementaSlot_regado(int i, int qtd) {
        if(i<=QTD_MAX_SLOTS) {
            if(i==0){ // caso em que foi pedido todos
                boolean pode_incrementar = true;
                for(int j=0;j<QTD_MAX_SLOTS;j++){
                    this.slot_regado[j] += qtd;
                    if (this.slot_regado[j] >= 3) { // Caso algum slot seja 3 ou mais, indica que nao podia incrementar
                        pode_incrementar = false;
                        this.slot_regado[j] = 3;
                    }
                }
                return pode_incrementar;
            }
            else { // caso em que foi pedido um slot especifico
                this.slot_regado[i-1] += qtd;
                if (this.slot_regado[i-1] < 3) {
                    return true;
                }
                this.slot_regado[i-1] = 3;
            }
        }
        return false;

    }


    public boolean decrementar_dia(){
        boolean pode_decrementar = true;
        for(int i=0; i < QTD_MAX_SLOTS; i ++){
            this.slot_regado[i] -= 1;
            if(this.slot_regado[i] < 0){ // Caso algum slot fique menor do que 0, indica que nao podia decrementar
                pode_decrementar = false;
            }
        }
        return pode_decrementar;
    }


    public int getQtd_dias() {
        return qtd_dias;
    }

    public void setQtd_dias(int qtd_dias) {
        this.qtd_dias = qtd_dias;
    }

    public void addColheita(String planta){
        this.colheita.add(planta);
    }

    public void gerarRelatorio(){
        System.out.println("A horta "+ this.getNome() + ", criada na estacao " +this.getEstacao_base()+ " no local " + this.getLocal() + " teve como resultados:");
        for (String planta : this.colheita)
            System.out.println("    -   A colheita de " + planta + " foi feita com sucesso!");
    }
}
