## Repositório de estudos seguindo a trilha de CRUD Angular + Spring da Loiane Groner


Disponível gratuitamente no Youtube: https://www.youtube.com/playlist?list=PLGxZ4Rq3BOBpwaVgAPxTxhdX_TfSVlTcY

### Sobre
> A aplicação tem como objetivo o gerenciamento de Cursos no qual você pode criar um novo curso, atualizar, deletar e ver todos os cursos cadastrados!
<br>

### Funcionalidades

#### Listar cursos, criar curso, atualizar cursos, deletar curso
>  - [x] endpoint
>  - [x] integração no front
     
#### Front
>  - [x] mensagens de feedback de sucesso e erro
>  - [ ] diálogo de confirmação de deleção
        
#### Back
>  - [ ] adicionar páginação
>  - [ ] aceitar imagens
---

Por enquanto o curso possui essas propriedades:
```ts
export interface Course {
  _id: string;
  name: string;
  category: string;
}
```

### Tecnologias Web
> - Angular
> - Angular Material

### Tecnologias API/Server
> - Java
> - Spring Boot
> - Lombok
> - Maven
> - H2 Database
