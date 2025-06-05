package ufc.br;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class TestTransacao {
    @Test
    public void testaSaqueBemSucedidoComValorValidoSTUB() {
        Conta conta = Mockito.mock(Conta.class);
        Mockito.when(conta.leSaldo()).thenReturn(50);
        Transacao transacao = new Transacao();

        boolean resultado = transacao.saca(conta, 10);
        assertTrue(resultado);
    }

    @Test
    public void testaSaqueBemSucedidoComSaldoMenorQueValorSTUB() {
        Conta conta = Mockito.mock(Conta.class);
        Mockito.when(conta.leSaldo()).thenReturn(50);
        Transacao transacao = new Transacao();

        boolean resultado = transacao.saca(conta, 100);
        assertFalse(resultado);
    }

    @Test
    public void testaSaqueBemSucedidoComValorNegativoSTUB() {
        Conta conta = Mockito.mock(Conta.class);
        Mockito.when(conta.leSaldo()).thenReturn(50);
        Transacao transacao = new Transacao();

        boolean resultado = transacao.saca(conta, -10);
        assertFalse(resultado);
    }

    @Test
    public void testaDepositoBemSucedidoComValorValidoSTUB() {
        Conta conta = Mockito.mock(Conta.class);
        Mockito.when(conta.leSaldo()).thenReturn(0);
        Transacao transacao = new Transacao();
        boolean resultado = transacao.deposita(conta, 50);
        assertTrue(resultado);
    }

    @Test
    public void testaDepositoBemSucedidoComValorInvalidoSTUB() {
        Conta conta = Mockito.mock(Conta.class);
        Mockito.when(conta.leSaldo()).thenReturn(0);
        Transacao transacao = new Transacao();

        boolean resultado = transacao.deposita(conta, -50);
        assertFalse(resultado);
    }

    @Test
    public void testaSaqueBemSucedidoComValorValidoMock(){
        Conta conta = Mockito.mock(Conta.class);
        Mockito.when(conta.leSaldo()).thenReturn(50);
        ArgumentCaptor<Integer> captadorSaldo = ArgumentCaptor.forClass(Integer.class);
        Mockito.doNothing().when(conta).removeSaldo(captadorSaldo.capture());

        Transacao transacao = new Transacao();
        transacao.saca(conta, 10);
        assertEquals(10, captadorSaldo.getValue());
    }

    @Test
    public void testaQuantidadeDeExecucoesDoSaqueBemSucedidoMock(){
        Conta conta = Mockito.mock(Conta.class);
        Mockito.when(conta.leSaldo()).thenReturn(50);
        ArgumentCaptor<Integer> captadorSaldo = ArgumentCaptor.forClass(Integer.class);
        Mockito.doNothing().when(conta).removeSaldo(captadorSaldo.capture());

        Transacao transacao = new Transacao();
        transacao.saca(conta, 10);
        assertEquals(10, captadorSaldo.getValue());
        Mockito.verify(conta, Mockito.times(1)).removeSaldo(10);
    }
}
