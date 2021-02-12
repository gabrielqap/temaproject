# Temaproject
Pequena API para gerenciamento de cartas de EarthStone.

## Instalação
Para executar é necessário instalar as seguintes dependências:

* Java Runtime Environment (JRE) 
* Java Development Kit (JDK) 
* Maven

Com esses dependências instaladas, para executar o projeto basta acessar à pasta pelo terminal e digitar o seguinte comando:

``` 
mvn exec:java
```

### Descrição do projeto

Este é um projeto Maven, onde eu utilizei o Jersey para rodar o servidor, juntamente com a biblioteca do JAX-RS para configurar os endpoints.

O projeto possui os seguintes endpoints:

* GET ALL (/carta)
* GET BY ID (/carta/{id})
* POST (/carta)
* DELETE (/carta/{id})
* GET BY NAME (/carta/name/{name})
* GET BY CLASS (/carta/class/{className})
* GET BY TYPE (/carta/type/{type})

### Modelo da request para o POST
```json
{
    "attack": 8,
    "cardClass": "PALADIN",
    "defense": 2,
    "description": "Jax description",
    "name": "Jax",
    "type": "MAGIC"
}
```

O id gerado será em sequência, iniciando pelo 1.

### Regras do projeto

* Os itens "attack" e "defense" vão de 0 a 10;
* O item "type" só é aceito do tipo "MAGIC" e "CREATURE";
* O item "cardClass" só é aceito do tipo "WIZARD", "PALADIN", "HUNTER", "DRUID" e "ANY";
* Não é aceito o cadastro de uma carta com o mesmo nome.