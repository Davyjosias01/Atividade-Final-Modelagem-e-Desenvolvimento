
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author davyj
 */
public class Consumo {
    private Time dataHora;
    private float valor;

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Time dataHora) {
        this.dataHora = dataHora;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Consumo(Time dataHora, float valor) {
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public Consumo(float valor) {
        this.valor = valor;
        this.dataHora = Time.valueOf(LocalTime.now()) ;//Não descobri como pegar a data e a hora atual.
    }

    public Consumo() {}
    
}
