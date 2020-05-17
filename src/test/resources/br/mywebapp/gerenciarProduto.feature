# language:pt

@gerenciarProduto
Funcionalidade: Gerenciar produtos
  Como usuário do sistema
  Quero gerenciar o cadastro de produtos
  Para manter as informações dos produtos atualizadas no sistema

  Cenário: Acessa a página de cadastro de produtos
    Dado que estou na página inicial
    Quando clicar no link de produto
    Então eu devo ver a página de cadastro de produtos

  Cenário: Cadastra novo produto
    Dado que estou na página inicial
    E clicar no link de produto
    Quando preencher o campo descrição com "produto 1"
    E prencher o campo quantidade com "2"
    E preencher o campo valor com "5.75"
    E selecionar a categoria "cat"
    E clicar no botão salvar
    Então eu devo ver a mensagem "Cadastro realizado com sucesso!"
    E devo ver as informações na lista de produtos
