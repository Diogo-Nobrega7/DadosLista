# DadosLista
Fila de Atendimento Prioritário
A lista encadeada simples foi escolhida por ser a estrutura mais direta e eficiente para uma fila, onde o atendimento segue a ordem de chegada. As operações de inserir e remover o primeiro da fila exigem apenas a navegação para frente, tornando desnecessários os ponteiros extras de uma lista dupla ou a estrutura circular.

Playlist de Músicas
 A característica "circular" permite que a música toque em loop infinito, voltando ao início automaticamente após a última. Já a característica "duplamente encadeada", com ponteiros para o anterior e próximo, é fundamental para implementar as funções de avançar e voltar de música de forma eficiente.

Carrinho de Compras Online
A lista duplamente encadeada é a mais adequada para o carrinho de compras devido à necessidade de navegar para frente e para trás para revisar os itens. Além disso, a remoção de um item específico de qualquer posição do carrinho é mais eficiente e simples de implementar, pois cada nó possui referência tanto para o elemento anterior quanto para o próximo, facilitando a religação da lista.

Sistema de Rodízio de Jogadores
Para o rodízio de jogadores, a lista encadeada circular simples é a melhor opção, pois sua estrutura espelha perfeitamente a natureza contínua de um sistema de turnos. O fato de o último jogador apontar para o primeiro cria um loop natural para o rodízio, e como a única navegação necessária é avançar para o próximo, uma lista simples é suficiente.

Navegação de Páginas no Navegador
A lista duplamente encadeada foi escolhida para a navegação de páginas porque representa de forma ideal o histórico de um navegador. A funcionalidade de "voltar" e "avançar" depende da capacidade de se mover em ambas as direções, o que é fornecido de forma nativa pelos ponteiros anterior e próximo de cada nó.

Histórico de Pedidos em um Restaurante
A escolha da lista duplamente encadeada para o histórico de pedidos se justifica pela necessidade de cancelar um pedido de qualquer ponto da lista. Com ponteiros para o nó anterior e próximo, a remoção se torna mais eficiente, pois permite religar a lista facilmente sem a necessidade de guardar uma referência extra ao nó anterior durante a busca.

Desafio Extra (Desfazer/Refazer)
O sistema é melhor implementado com duas pilhas (uma para ações de desfazer, outra para refazer), que são construídas com listas encadeadas simples. Essa abordagem é ideal porque a lógica "desfazer" segue o princípio LIFO (o último a entrar é o primeiro a sair), que é o comportamento intrínseco de uma pilha, tornando a gestão das ações direta e eficiente.