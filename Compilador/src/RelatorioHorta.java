import java.util.ArrayList;
import java.util.List;

public class RelatorioHorta {

    final int QTD_MAX_SLOTS = 4;

    private String nome, estacao_base, estacao_atual, local;
    private String semente_slot[] = new String[QTD_MAX_SLOTS];
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
        if(i<QTD_MAX_SLOTS)
            return semente_slot[i];
        else
            return null;
    }

    public void setSemente_slot(String semente_slot, int i) {
        if(i<QTD_MAX_SLOTS)
            this.semente_slot[i] = semente_slot;
    }

    public boolean getSlot_capinado(int i) {
        if(i<QTD_MAX_SLOTS)
            return slot_capinado[i];
        else
            return false;
    }

    public void setSlot_capinado(int i, boolean slot_capinado) {
        if(i<QTD_MAX_SLOTS)
            this.slot_capinado[i] = slot_capinado;
    }

    public boolean getSlot_adubado(int i) {
        if(i<QTD_MAX_SLOTS)
            return slot_adubado[i];
        else
            return false;
    }

    public void setSlot_adubado(int i, boolean slot_adubado) {
        if(i<QTD_MAX_SLOTS)
            this.slot_adubado[i] = slot_adubado;
    }

    public int getSlot_regado(int i) {
        if(i<QTD_MAX_SLOTS)
            return slot_regado[i];
        else
            return 0;
    }

    public void setSlot_regado(int i, int slot_regado) {
        if(i<QTD_MAX_SLOTS)
            this.slot_regado[i] = slot_regado;
    }

    public boolean incrementaSlot_regado(int i, int qtd) {
        if(i<QTD_MAX_SLOTS) {
            this.slot_regado[i] += qtd;
            if (this.slot_regado[i] < 3) {
                return true;
            }
            this.slot_regado[i] = 3;
        }
        return false;

    }
    public void decrement_day(){
        int i ;
        for(i=0; i < QTD_MAX_SLOTS; i ++){
            if(this.slot_regado[i] > 0){
                this.slot_regado[i] -= 1;
            }
        }
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
