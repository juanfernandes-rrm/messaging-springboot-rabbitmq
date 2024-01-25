# RabbitMQ

O **RabbitMQ** é um ***Mensage Broker*** Open Source, atuando como um intermediador de mensagens em sistemas de mensageria. É uma ferramenta amplamente utilizada em *Arquitetura de Microsserviços*, tornando a comunicação assíncrona entre serviços mais simples e eficiente. Além disso, o RabbitMQ oferece escalabilidade através de Clusters.

Os componentes fundamentais de um Sistema de mensageria são:

- **Publicador:** Responsável por enviar mensagens ao RabbitMQ.
- **Consumidor:** Encarregado de consumir as mensagens recebidas do RabbitMQ.
- **Message Broker:** Faz a distribuição das mensagens entre os diferentes consumidores.

## Funcionamento de Sistema de Mensageria

Podemos imaginar o RabbitMQ como uma caixa postal, garantindo que as mensagens enviadas cheguem corretamente aos destinatários.

Existem alguns conceitos importantes para entender o funcionamento do RabbitMQ:

- **Queue (Fila):** Buffer onde as mensagens são armazenadas temporariamente. Existem dois tipos de filas: Duráveis, onde as mensagens são persistidas em disco, e Não Duráveis, onde as mensagens são mantidas em memória até serem consumidas.
- **Exchange (Troca)**: Componente que recebe as mensagens e as encaminha 
para as filas apropriadas. Existem diferentes tipos de Exchanges, tais 
como:
    - Default
    - Direct: Encaminha as mensagens para as filas associadas, especificando uma routing_key.
    - Fanout: Encaminha as mensagens para todas as filas associadas, sem especificar uma routing_key.
    - Topic: Permite o roteamento baseado em padrões de routing_key.
    - Headers: Verifica o header antes de enviar a mensagem para a fila.
- **Payload (mensagem)**: Conteúdo real da mensagem, podendo variar de formato, como texto ou arquivos de mídia. As mensagens sempre são enviadas em bytes.        


O RabbitMQ realiza o **Load Balance** entre os consumidores através do algoritmo Round Robin, garantindo a distribuição equilibrada das mensagens entre os consumidores.
Além de suporta diversos protocolos, como *AMQP, STOMP, MQTT e HTTP*. Além disso, oferece bibliotecas para suportar várias linguagens de programação, incluindo Java, PHP, Python, C# e JavaScript.

**PREFETCH COUNT**

Limitador de envio de mensagem ao consumidor. Determina quantidade de mensagens que serão enviadas ao consumidor, que só voltará a receber mensagem após consumir todas as mensagens já recebidas. O padrão é 250 mensagem, se for definido como 0, será ilimitado, ou seja, será enviado todas as mensagem.
