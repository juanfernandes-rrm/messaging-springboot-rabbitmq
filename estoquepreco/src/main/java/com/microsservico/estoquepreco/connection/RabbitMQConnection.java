package com.microsservico.estoquepreco.connection;

import constante.RabbitMQConstantes;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.*;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {

    private final static String NAME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String name) {
        return new Queue(name, true, false, false);
    }

    private DirectExchange trocaDireta() {
        return new DirectExchange(NAME_EXCHANGE);
    }

    private Binding relacionamento(Queue queue, DirectExchange exchange) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void adiciona(){
        Queue filaEstoque = this.fila(RabbitMQConstantes.FILA_ESTOQUE);
        Queue filaPreco = this.fila(RabbitMQConstantes.FILA_PRECO);

        DirectExchange directExchange = this.trocaDireta();

        Binding ligacaoEstoque = relacionamento(filaEstoque, directExchange);
        Binding ligacaoPreco = relacionamento(filaPreco, directExchange);

        //criação das filas
        this.amqpAdmin.declareQueue(filaEstoque);
        this.amqpAdmin.declareQueue(filaPreco);

        //criaçao de exchange
        this.amqpAdmin.declareExchange(directExchange);

        //criacao de ligacoes
        this.amqpAdmin.declareBinding(ligacaoEstoque);
        this.amqpAdmin.declareBinding(ligacaoPreco);

    }

}
