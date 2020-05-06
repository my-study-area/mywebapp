# mywebapp
Projeto Java Web Maven com plugin tomcat7-maven-plugin

## Começando
- clone o projeto
```bash
git clone https://github.com/my-study-area/mywebapp.git
```

- entre no diretório do Projeto
```
cd mywebapp
```

- inicie o servidor
```
mvn clean tomcat7:run
```
- acesse no navegador
[http://localhost:9090/](http://localhost:9090/)

Obs: para parar o servidor pressione `ctrl + c`
## Configurando o projeto no eclipse
Com o projeto importado no eclipse realize os seguintes passos:
- botão direito do mouse em cima do projeto > Run as > Maven build
- na janela que abrir no campo ***Goals*** digite: `mvn clean tomcat7:run` e pressione o botão ***Run***

## Iniciando servidor via docker
Esse passo é somente uma opção a mais caso o computador não tenha o maven instalado. O processo de desenvolvimento ficará um pouco mais complexo devido a problemas de permissão de arquivos, instalação de dependências e consultar os logs no terminal.
- construa o container e inicie o servidor
```
docker-compose up --build
```
- acesse no navegador:
[http://localhost:9090/](http://localhost:9090/)

```
docker-compose stop
```

Obs: em caso de erro de permissão no eclipse após alteração dos arquivos execute o seguinte comando dentro do seu projeto: `sudo chown $USER:$USER -R .`.(ao usar eclipse as alterações são refletidas assim que os arquivos são modificados. em outras IDEs será necessário executar: `docker-compose run --rm maven mvn compile` ou reiniciar o container).
