# SumJar - Par ou Ímpar

<p align="center">
    <img src="https://logos-world.net/wp-content/uploads/2022/07/Java-Logo.png"/>
</p>

SumJar é uma aplicação para estudos em Java, feita em CLI para aplicação prática. Reúne o desejo de deixar uma aplicação funcional e visualmente bonita, mesmo usando o CLI como método de execução deste projeto.

## Propósito

O SumJar foi criado para fornecer uma forma divertida e simples de experimentar programação em Java e interações de linha de comando. Ele utiliza a lógica básica do jogo Par ou Ímpar e demonstra a interação com o usuário, manipulação de exceções e exibição de resultados de forma clara e formatada.

## Funcionalidades

- **Escolha de Número**: O usuário pode escolher um número de 0 a 10.
- **Escolha de Par ou Ímpar**: O usuário seleciona se prefere Par (P) ou Ímpar (I).
- **Jogo contra a Máquina**: A máquina escolhe um número aleatório, e o total da soma dos números determina o vencedor.
- **Mensagens de Erro**: Mensagens amigáveis são exibidas se o usuário inserir um valor inválido.

## Como Usar

1. **Iniciar o Jogo**: Execute a aplicação a partir do terminal.
   <p align="center">
       <img src="https://github.com/user-attachments/assets/aaff70d8-eb17-4ee9-9f5e-0261db2665b5" alt="Iniciar o Jogo" width="600"/>
   </p>

2. **Escolher Número**: Insira um número entre 0 e 10 quando solicitado.
   <p align="center">
       <img src="https://github.com/user-attachments/assets/09619006-e5b8-4c8a-bbf9-d38bb9de78e2" alt="Escolher Número" width="600"/>
   </p>

3. **Escolher Par ou Ímpar**: Escolha se prefere Par (P) ou Ímpar (I).
   <p align="center">
       <img src="https://github.com/user-attachments/assets/525e0dad-d0cc-4494-98c4-6b608c9f6036" alt="Escolher Par ou Ímpar" width="600"/>
   </p>

4. **Ver Resultado**: A máquina escolherá um número e o resultado será exibido, indicando se você ganhou ou perdeu.
   <p align="center">
       <img src="https://github.com/user-attachments/assets/9dadfaa6-adc0-4e3e-ac8b-72148e43a433" alt="Ver Resultado" width="600"/>
   </p>

## Estrutura do Projeto

- **`App.java`**: Ponto de entrada principal da aplicação.
- **`Game.java`**: Contém a lógica principal do jogo.
- **`Settings.java`**: Configurações e métodos auxiliares.
- **`TextBoxFormatter.java`**: Formatação de saída para a interface do usuário.
