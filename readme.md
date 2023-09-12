<p align="center">
  <img src="https://github.com/CGenius-FIAP/API-GPT/blob/main/logo.jpeg" alt="header" width="50%" />
</p>

<h1 align="center">Cart Genius</h1>

> Status: ⚠️⚠️ In development ⚠️⚠️


- [Introduction](#intro)
- [Architecture Design](#archDesign)
- [Benefits](#benefits)
- [DDL Command](#ddl)
- [Installation](#install)
- [Endpoints](#endpoints)
- [Known-Issues](#known-issues)
- [Future Plans](#doc)
- [Credits](#credits)
- [Concluding Remarks](#conclusion)


Course: DevOps Tools & Cloud Computing<br>

# 1)
## 🚀🚀 <a id="intro"></a>Introduction 🚀🚀

  We are proud to announce the 3rd Sprint of the 2023 FIAP + PLUSOFT Challenge. We aimed to deliver precisely what we were asked to: a new chatbot integrated with OpenAI's groundbreaking ChatGPT, trained toward a more focused area.

  Our project was to create a sales assistant capable of answering a wide range of questions, from stock availability to furniture dimensions, power consumption of a GPU, differences between newer and older generations of certain products, and more.

  Eventually, we plan to add features to complete purchases through the chatbot itself . But for now, we are focusing on core aspects of the project, such as cloud availability and code refactoring for improved performance and lower operation costs.

  We've just finished the core essentials of the system, and from now until Sprint 4, we intend to polish and improve the UI/UX for our customers. We will also enhance the training prompts given to GPT, as well as provide secure storage for conversation history and incorporate image displays in the chatbox for further immersion.

  Our main goal is to automate, to a certain extent, the adaptability of the chatbot, making it easier to create prompts so that it can be used in almost all types of businesses.


<p align="center"><b>We're not there yet, but we will be eventually.</b></p>

---

# 2)
## ☁️☁️ <a id="archDesign"></a> Architecture Design ☁️☁️
<p align="center">
  <img src="https://github.com/CGenius-FIAP/Devops/blob/main/architecture%20design.jpeg" alt="header" width="50%" />
</p>


---


# 3)
## 🌟🌟 <a id="benefits"></a> Benefits of Using Chatbots 🌟🌟
Why Chatbots Are Transforming Customer Service:<br>
1️⃣ 🏦 Cost-Efficiency: When compared to traditional customer support methods, chatbots offer significantly reduced operating costs. These digital agents are available 24/7, providing non-stop customer service that human agents can't possibly match. This leads to a lower overhead without sacrificing quality support.

2️⃣ 🌍 Global Availability: Their constant availability isn't just convenient—it's a game-changer for global business operations. Chatbots can accommodate customers in various time zones without the extra expense of overnight staffing, thus widening your global reach and enhancing customer experience.

3️⃣ 📈 Scalability: Chatbots possess the incredible ability to handle multiple queries at once. This greatly reduces customer wait times and boosts overall efficiency. The result? Higher customer satisfaction rates and a more robust bottom line.

👉 All of these advantages come at just a fraction of the cost of maintaining a full-scale, human customer service team, making chatbots an extraordinarily cost-effective solution for modern businesses.

---
🛑 Considerations and Limitations 🛑
🚫 Unnatural Conversations: It's worth noting that chatbots aren't perfect. Users have reported less-than-stellar interactions, citing unnatural conversation flows and sometimes even irrelevant responses, which can be a drawback both for customers and businesses.

🚫 Limited Creativity: While scripted bots offer a predefined set of responses, they lack the creative problem-solving capabilities of generative AI models. Although these advanced AI solutions may come at a higher cost, the results they deliver can often justify the investment.


Generative chatbots can eliminate every single one of it's most unliked aspect: lack of humanity. New-gen chatbot will be capable of answering detailed questions about the product, price, description, everything.

While at the beggining the cost of development of such marvels can be slightly higher than the traditional way, the return it can provide to companies is unfathomable; and in time, development costs will lower, as popularity increases.
  

---

# 4)
##  <a id="ddl"></a> DDL

```plsql
DROP TABLE tb_erros CASCADE CONSTRAINTS;
 
DROP TABLE tb_cliente CASCADE CONSTRAINTS;
 
DROP TABLE tb_empresa CASCADE CONSTRAINTS;
 
DROP TABLE tb_feedback CASCADE CONSTRAINTS;
 
DROP TABLE tb_produto CASCADE CONSTRAINTS;
 
 
CREATE TABLE tb_cliente (
    id_cliente  NUMBER(19) NOT NULL,
    nr_cpf      VARCHAR2(255) NOT NULL,
    ds_email    VARCHAR2(255) NOT NULL,
    ds_endereco VARCHAR2(255) NOT NULL,
    nm_cliente  VARCHAR2(255) NOT NULL,
    ds_senha    VARCHAR2(255) NOT NULL,
    nr_telefone NUMBER(13) NOT NULL
);
 
ALTER TABLE tb_cliente ADD CONSTRAINT pk_cliente PRIMARY KEY ( id_cliente );
 
ALTER TABLE tb_cliente ADD CONSTRAINT un_cliente UNIQUE ( nr_cpf );
 
CREATE TABLE tb_empresa (
    id_empresa  NUMBER(19) NOT NULL,
    nr_cnpj     NUMBER(19) NOT NULL,
    ds_email    VARCHAR2(255) NOT NULL,
    ds_endereco VARCHAR2(255) NOT NULL,
    nm_empresa  VARCHAR2(255) NOT NULL,
    ds_senha    VARCHAR2(255),
    nr_telefone NUMBER(13) NOT NULL
);
 
ALTER TABLE tb_empresa ADD CONSTRAINT pk_empresa_nova PRIMARY KEY ( id_empresa );
 
ALTER TABLE tb_empresa ADD CONSTRAINT un_empresa_nova UNIQUE ( nr_cnpj );
 
CREATE TABLE tb_feedback (
id_feedback              NUMBER(19) NOT NULL,
    ds_avaliacao_atendimento FLOAT NOT NULL,
    ds_comentario            VARCHAR2 (255),
    ds_avaliacao_preco       FLOAT NOT NULL,
    ds_avaliacao_produto     FLOAT NOT NULL,
    ds_recomendacao_produto  NUMBER(1) NOT NULL,
    produto_id_produto       NUMBER(19) NOT NULL,
    empresa_id_empresa       NUMBER(19) NOT NULL,
    cliente_id_cliente       NUMBER(19) NOT NULL
);
 
ALTER TABLE tb_feedback ADD CONSTRAINT pk_feedbackv1 PRIMARY KEY ( id_feedback );
 
CREATE TABLE tb_produto (
    id_produto         NUMBER(19) NOT NULL,
    ds_descricao       VARCHAR2(255) NOT NULL,
    nm_produto         VARCHAR2(255) NOT NULL,
    qt_preco           NUMBER(19) NOT NULL,
    empresa_id_empresa NUMBER(19) NOT NULL
);
 
ALTER TABLE tb_produto ADD CONSTRAINT pk_produto PRIMARY KEY ( id_produto,
                                                               empresa_id_empresa );
 
ALTER TABLE tb_feedback
    ADD CONSTRAINT fk_feedback_cliente FOREIGN KEY ( cliente_id_cliente )
        REFERENCES tb_cliente ( id_cliente );
 
ALTER TABLE tb_feedback
    ADD CONSTRAINT fk_feedback_produto FOREIGN KEY ( produto_id_produto,
                                                     empresa_id_empresa )
        REFERENCES tb_produto ( id_produto,
                                empresa_id_empresa );
 
ALTER TABLE tb_produto
    ADD CONSTRAINT fk_produto_empresa FOREIGN KEY ( empresa_id_empresa )
        REFERENCES tb_empresa ( id_empresa );
 
CREATE TABLE tb_erros (
    id_erro NUMBER GENERATED ALWAYS AS IDENTITY,
    codigo_erro NUMBER,
    nome_erro VARCHAR2(255),
    data_ocorrencia DATE,
    usuario_logado VARCHAR2(255)
);

```


---

# 5)

## 🔧🔧 <a id="install"></a>Installation 🔧🔧

  We have developed two APIs at the moment. One of those do not implement CRUD and just makes queries to the ChatGPT, so we will demonstrate the one made with Maven/Java, for registering clients, companies, products and feedbacks;
  
  
  ### 1. Clone the repository
  > git clone https://github.com/CGenius-FIAP/Devops.git
<br>

  ### 2. Navigate to the Directory
  > cd Devops/api-sptring-atualizada
<br>

  ### 3. Build the executable JAR file (skipping tests scenarios)
  > ./mvnw clean install -DskipTests

  Or

  > mvn clean install -DskipTests
<br>

  ### 4. Enter the credentials (sent directly to the professor)
  > az login
 
  Or

  > git config --global credential.helper cache
  > git config --global credential.https://rm94377webapp.scm.azurewebsites.net.username rm94377@fiap.com.br
  > git config --global credential.https://rm94377webapp.scm.azurewebsites.net.password ************

  ## 5. [OPTIONAL]If, for some reason, git hasn't been initiated
  > git init

  ## 6. Once logged in in both git and azure, just add, commit and push
  > git add .<br>
  > git commit -m "Professor's test"<br>
  > git push azure master



---


## 📖📖 <a id="manual"></a>How to use 📖📖

To test the API, you will need an API CLIENT, such as Insomnia.

[Direct link for the official site download](https://updates.insomnia.rest/downloads/windows/latest?app=com.insomnia.app&source=website) <br>

Or else download it manually at their site: https://insomnia.rest/download

---


## <a id="endpoints"></a>Endpoints

| METHOD | ADDRESS                                        | ENDPOINT  | DESCRIPTION                             | JSON                                                                                   |
|--------|------------------------------------------------|-----------|----------------------------------------|-----------------------------------------------------------------------------------------|
| POST   | https://rm94377webapp.azurewebsites.net/       | clientes/ | Create/Register a new client            | `{"nome": "", "endereco": "", "telefone": "", "cpf": "", "email": "", "senha": ""}`     |
| POST   | https://rm94377webapp.azurewebsites.net/clientes/ | login  | Log into the system                     | `{"email": "", "senha": ""}`                                                           |
| PUT    | https://rm94377webapp.azurewebsites.net/clientes/ | {user_id} | Update user information                 | `{"nome": "", "endereco": "", "telefone": "", "email": "", "senha": ""}`                |
| DELETE | https://rm94377webapp.azurewebsites.net/clientes/ | {user_id} | Delete user from system                 | N/A (Delete Method)                                                                     |
| GET    | https://rm94377webapp.azurewebsites.net/clientes/ | {user_id} | Get user's information by his ID         | N/A (Get Method)                                                                        |
| GET    | https://rm94377webapp.azurewebsites.net/       | clientes/ | Get information from all registered clients | N/A (Get Method)                                                                        |
| GET    | https://rm94377webapp.azurewebsites.net/clientes/ | page   | Get information from 10 users at a time    | N/A (Get Method)                                                                        |

---

## <a name="known-issues"></a>Known Issues 🐛🔍

We appreciate your interest in our project and would like to keep you informed about some of the issues we are currently facing:

### Chatbot Memory Limitations 🤖🧠
- **Issue**: The chatbot sometimes fails to remember the entire conversation history, especially when a client asks about multiple items consecutively.
- **Impact**: This limits the chatbot's ability to provide coherent and context-aware responses in ongoing conversations.
- **Status**: Under Investigation.

### Database Connection Issues on Azure Web App 🌐💾
- **Issue**: The API, when hosted on Azure Web App, seems to work only for the first few minutes before the database starts refusing additional connections.
- **Impact**: This disrupts the functionality of the API after initial activation.
- **Possible Cause**: The Hibernate and JPA, which are supposed to manage and close database connections, may not be functioning as expected.
- **Status**: Under Investigation.

### Inefficient Azure Service Utilization 💰📈
- **Issue**: Multiple Azure services are currently being used where fewer could suffice, leading to unnecessary operational costs.
- **Impact**: Higher costs than necessary for maintaining the project, but not at an extreme level.
- **Status**: In the process of re-architecting to make the system more cost-efficient.

---


## <a id="doc"></a>Future Plans 🌱🛠️

We have several exciting features and improvements planned for the future sprint:

- **Security Measures**: 🛡️🔒 Working on several fronts to bolster security:
  - 🛡️ Implementing advanced authentication techniques for enhanced security.
  - 🔒 Improving the management of sensitive information using Azure Key Vaults and environment variables. (Note: These features are still in the process of being fully implemented.)

- **Data Visualization Tools**: 📊💡 
  - 📊 Creating intuitive dashboards and interactive charts to help our partner companies make data-driven decisions.
  - 💡 These tools will serve as strategic assets for businesses, enabling them to understand customer behaviors, track chatbot performance, and identify areas for improvement.

- **Other Short-Term Enhancements**: 
  - Continued performance optimizations, bug fixes, and UI/UX improvements.

We're committed to continuously improving the system based on feedback and technological advancements.

---


## <a id="credits"></a>Credits 👏🌟

This project was a collaborative effort and wouldn't have been possible without the contributions of:

- **Filipe Santos**: 👨‍💻🌩
  - **Role**: API Development, Cloud Deployment and GPT-Chatbot Training.
  - **Courses**: 
    - Enterprise Application Development
    - Digital Business Enablement
    - Disruptive Architectures - IOT, IOB, AI
    - DevOps
  
- **Jorge Camara**: 👨‍💻🎨
  - **Role**: Front-End Development and Testing.
  - **Courses**: 
    - Hybrid Mobile App Development
    - DevOps
  
- **Vitor Madureira**: 👨‍💻📊
  - **Role**: Database Management and Quality Assurance.
  - **Courses**: 
    - Compliance and Quality Assurance
    - Database Application and Data Science

Each individual brought unique skills and perspectives to the table, making the project more robust and well-rounded.

---


## <a id="conclusion"></a>Concluding Remarks 🎯🛠

This project is a work-in-progress and, while we are proud of what we have accomplished so far, we recognize that there is room for improvement. We are actively working to refine the system, address its limitations, and expand its capabilities. Your feedback is crucial for us, so feel free to open issues or contribute to the repository.

<p align="center"><b>We're not there yet, but we're committed to getting there. Thank you for being part of this journey with us.</b></p>

