# Stum — Stock Article Summarizer

Automatically summarizes the latest news articles related to a stock ticker — so you stay informed without reading every article.

[📽️ Demo Video](https://drive.google.com) • Built for HackStoga 2023  
Created by [Niru VK](https://github.com/niruvk)

---

## 🔍 Features

- 🔎 Search for any stock ticker (e.g., AAPL, TSLA)
- 📰 Fetches the top 5 recent news articles about the stock
- ✂️ Uses natural language processing (NLP) to generate concise, readable summaries
- 💻 User-friendly web interface powered by Spring Boot

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 17 or higher
- Maven 3+
- Internet connection
- API keys for:
  - [NewsAPI](https://newsapi.org/) or similar
  - [OpenAI](https://platform.openai.com/signup) (if using GPT for summarization)

### 🛠️ Setup Instructions

1. **Clone the repository**

```bash
git clone https://github.com/niruvk/Stum.git
cd Stum
```

2. **Configure API keys**

Set your API keys as environment variables or add them to the `src/main/resources/application.properties` file:

```properties
NEWS_API_KEY=your_newsapi_key_here
OPENAI_API_KEY=your_openai_key_here
```

3. **Build and run the project**

```bash
mvn clean install
mvn spring-boot:run
```

4. **Access the application**

Visit [http://localhost:8080](http://localhost:8080) in your browser and enter a stock ticker to get started!

---

## ⚙️ Project Structure

```
Stum/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/stum/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── service/
│   │   │       └── StumApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

---

## 📦 Technologies Used

- **Java 17** — Programming language
- **Spring Boot** — Web framework
- **Maven** — Build & dependency management
- **Thymeleaf** — Templating engine for HTML
- **NewsAPI** — Source for financial news
- **OpenAI GPT** — For summarization (can be replaced with custom model)

---

## 🧪 Testing

To run unit tests:

```bash
mvn test
```

---

## 🤝 Contributing

We welcome contributions!

1. Fork the repository
2. Create a new branch: `git checkout -b feature/my-feature`
3. Commit your changes: `git commit -m "Add new feature"`
4. Push to your fork: `git push origin feature/my-feature`
5. Open a pull request

Please follow Java coding standards and add documentation/comments as needed.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 💬 Feedback

If you have suggestions or encounter issues, please open an issue in the GitHub repo. We'd love to hear from you!

---

## ✨ Acknowledgements

- HackStoga 2023 for the platform
- OpenAI and NewsAPI for providing the backbone of the summarization system
