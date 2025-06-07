# CyberEnergy - Sistema de Gerenciamento de Energia Inteligente ⚡

## 📋 Sobre o Projeto

O CyberEnergy é uma API REST desenvolvida em Spring Boot para gerenciamento inteligente de energia. O sistema permite o monitoramento, controle e otimização do consumo de energia, além do gerenciamento de dispositivos e usuários.

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- MySQL 8
- Maven
- Swagger/OpenAPI
- Caffeine Cache

## 🛠️ Pré-requisitos

- JDK 17 ou superior
- Maven
- MySQL 8
- Git

## 🔧 Configuração do Ambiente

### 1. Clone o Repositório

```bash
git clone https://github.com/rickqueirozz/Gs_Java.git
cd Gs_Java/gs_java
```

### 2. Configuração do Banco de Dados

- Crie um banco de dados MySQL
- Configure as credenciais no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cyber_energy
spring.datasource.username=root
spring.datasource.password=root
```

### 3. Executando o Projeto

```bash
./mvnw spring-boot:run
```

## 📚 Documentação da API

### Endpoints Principais

#### Usuários

- `POST /api/v1/usuarios/criar` - Criar novo usuário
- `GET /api/v1/usuarios/{id}` - Buscar usuário por ID
- `GET /api/v1/usuarios/buscar` - Buscar usuários por filtros
- `PUT /api/v1/usuarios/{id}` - Atualizar usuário
- `DELETE /api/v1/usuarios/{id}` - Remover usuário

#### Dispositivos

- `POST /api/v1/dispositivos/criar` - Cadastrar novo dispositivo
- `GET /api/v1/dispositivos/{id}` - Buscar dispositivo por ID
- `GET /api/v1/dispositivos/buscar` - Buscar dispositivos por filtros
- `PUT /api/v1/dispositivos/{id}` - Atualizar dispositivo
- `DELETE /api/v1/dispositivos/{id}` - Remover dispositivo

### Documentação Swagger

Acesse a documentação completa da API em:

```
http://localhost:8080/api/v1/swagger-ui.html
```

## 📦 Estrutura do Projeto

```
src/main/java/com/fiap/cultura/
├── controller/     # Controladores REST
├── service/        # Lógica de negócio
├── repository/     # Acesso ao banco de dados
├── model/          # Entidades
├── dto/            # Objetos de transferência de dados
└── enums/          # Enumerações
```

## 🔍 Funcionalidades Principais

### Gerenciamento de Usuários

- Cadastro de usuários
- Busca por nome, email ou localização
- Atualização de dados
- Remoção de usuários

### Gerenciamento de Dispositivos

- Cadastro de dispositivos inteligentes
- Monitoramento de consumo
- Controle remoto
- Estatísticas de uso

### Recursos Adicionais

- Cache com Caffeine
- Documentação Swagger
- Validações de dados
- Tratamento de erros

## 🤝 Contribuindo

1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a Branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## ✨ Autor

- **Ricardo Queiroz** - [rickqueirozz](https://github.com/rickqueirozz)

## 📞 Suporte

Para suporte, envie um email para [seu-email@exemplo.com] ou abra uma issue no GitHub.
