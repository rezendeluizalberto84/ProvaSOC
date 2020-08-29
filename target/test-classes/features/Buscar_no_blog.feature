#language: pt

  Funcionalidade: Buscar algum artigo pelo campo de Busca

    Como usuário
    Gostaria de buscar um artigo no blog através do campo Busca
    Para que eu possa visualizar o resultado da busca

  Cenário: Deve exibir no resultado o que foi inserido no campo Busca
    Dado que estou acessando a aplicação
    Quando informo a palavra "home office"
    E seleciono Buscar
    Então o resultado é exibido com sucesso