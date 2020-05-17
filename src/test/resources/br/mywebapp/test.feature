# language:pt

@test
Funcionalidade: Olá mundo
  Eu quero dar um Olá Mundo com Cucumber

  Cenário: Usuário acessa a página Home
    Dado que eu acesso a página inicial
    Então eu devo ver o texto "Ola, Estou usando CDI!"
