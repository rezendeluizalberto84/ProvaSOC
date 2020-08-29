#language: pt

Funcionalidade: Calcular Estima de FAP para uma empresa

  Como usuário
  Gostaria de calcular a estima de FAP de uma empresa
  Para que eu possa ver os valores gerados no documento

  Cenário: Deve ser exibido o resultado do cálculo da estima de FAP na tela
    Dado que estou acessando a aplicação
    Quando clico no menu Soluções e Recursos
    E clico no menu FAP
    E informo o nome da empresa "BBB"
    E informo o numero FAP "123"
    E seleciono a porcentagem RAT
    E informo a projeção salarial "800000"
    E seleciono Estimar FAP
    Então os cálculos são exibidos na tela com sucesso