## Repositório de estudos seguindo a trilha de CRUD Angular + Spring da Loiane Groner


Disponível gratuitamente no Youtube: https://www.youtube.com/playlist?list=PLGxZ4Rq3BOBpwaVgAPxTxhdX_TfSVlTcY

### O Crud
A aplicação tem como objetivo o gerenciamento de Cursos no qual você pode criar um novo curso, atualizar, deletar e ver todos os cursos cadastrados!

### Funcionalidades
- [x] listar cursos
  - [x] endpoint
  - [x] integração no front
      
- [x] criar cursos
  - [x] endpoint
  - [x] integração no front
        
- [x] atualizar curso
  - [x] endpoint
  - [x] integração no front
        
- [x] deletar curso
  - [x] endpoint
  - [x] integração no front
        
- [x] mensagens de feedback de sucesso e erro
- [ ] diálogo de confirmação de deleção

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
- Angular
- Angular Material

### Tecnologias Server
- Java
- Spring Boot
- Lombok
- Maven
- H2 Database
