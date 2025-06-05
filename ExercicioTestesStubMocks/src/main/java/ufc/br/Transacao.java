package ufc.br;

public class Transacao {
    public boolean saca(Conta conta, int valor) {
        if (valor < 0 || conta.leSaldo() < valor)  return false;
        conta.removeSaldo(valor);
        return true;
    }

    public boolean deposita(Conta conta, int valor) {
        if (valor <= 0)  return false;
        conta.adicionaSaldo(valor);
        return true;
    }
}
