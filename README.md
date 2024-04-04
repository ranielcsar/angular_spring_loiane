## Repositório de estudos seguindo a trilha de CRUD Angular + Spring da Loiane Groner


[Disponível gratuitamente no Youtube](https://www.youtube.com/playlist?list=PLGxZ4Rq3BOBpwaVgAPxTxhdX_TfSVlTcY)

[Repo original da Loiane](https://github.com/loiane/crud-angular-spring)

### Sobre
A aplicação tem como objetivo o gerenciamento de Cursos no qual você pode criar um novo curso, atualizar, deletar e ver todos os cursos cadastrados!
<br>

### Funcionalidades

#### CURSO: Listar | Criar | Atualizar | Deletar
> - [x] endpoints
> - [x] integração no front
     
#### Front
> - [x] mensagens de feedback de sucesso e erro
> - [x] validações nos formulários
> - [x] diálogo de confirmação de deleção
        
#### Back
> - [x] validação de dados ao criar curso
> - [x] adicionar páginação
> - [ ] aceitar imagens

<br />

Por enquanto o curso possui essas propriedades:
```ts
export interface Course {
  _id: string;
  name: string;
  category: string;
}
```

### Tecnologias Web
- Angular v15 (master) e Angular v17 (angular17)
- Angular Material

### Tecnologias API/Server
- Java
- Spring Boot
- Lombok
- Maven
- H2 Database
- Java Bean Validation
