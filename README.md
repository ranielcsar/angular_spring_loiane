## Repositório de estudos seguindo a trilha de CRUD Angular + Spring da Loiane Groner


Disponível gratuitamente no Youtube: https://www.youtube.com/playlist?list=PLGxZ4Rq3BOBpwaVgAPxTxhdX_TfSVlTcY

### Sobre o CRUD
> A aplicação tem como objetivo o gerenciamento de Cursos no qual você pode criar um novo curso, atualizar, deletar e ver todos os cursos cadastrados!
<br>

### Funcionalidades

#### Listar cursos
>  - [x] endpoint
>  - [x] integração no front
      
#### Criar curso
>  - [x] endpoint
>  - [x] integração no front
        
#### Atualizar curso
>  - [x] endpoint
>  - [x] integração no front
        
#### Deletar curso
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
<br>

### Tecnologias Web
> - Angular
> - Angular Material
<br>

### Tecnologias API/Server
> - Java
> - Spring Boot
> - Lombok
> - Maven
> - H2 Database
