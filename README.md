# Gabazar-livros
[![Build Status](https://app.travis-ci.com/gabazar/gabazar-livros.svg?branch=main)](https://app.travis-ci.com/gabazar/gabazar-livros)
[![codecov](https://codecov.io/gh/gabazar/gabazar-livros/branch/main/graph/badge.svg?token=J3DD2YVSYJ)](https://codecov.io/gh/gabazar/gabazar-livros)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-livros&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-livros) 
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-livros&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-livros) 
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-livros&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-livros) 
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=gabazar_gabazar-livros&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=gabazar_gabazar-livros)

## Contexto
Esse serviço faz parte do projeto [Gabazar](https://github.com/gabazar), esse serviço atende o dominio de Livros.

## Arquitetura
O serviço utiliza arquitetura hexagonal, todas a integrações externas (controllers, clients, repositories...) estão no pacote de adapters e as regras de negocio estão isoladas no pacote core. 

Contratos externos (ex.: APIs e eventos) não devem ter interação com as regras de negocio, eles devem ser mapeados para uma entidade do dominio e consequentemente enviados para o serviço / caso de uso correspondente.
