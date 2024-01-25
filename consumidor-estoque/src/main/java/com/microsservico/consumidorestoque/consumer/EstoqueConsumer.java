package com.microsservico.consumidorestoque.consumer;

import constante.RabbitMQConstantes;
import dto.EstoqueDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
    private void consumidor(EstoqueDTO estoqueDTO) throws InterruptedException {
        System.out.println(estoqueDTO.codigoProduto + " - " + estoqueDTO.quantidade);

        Thread.sleep(120000);
    }

}
