# 📈 Торговая платформа (Pet-проект)

Java Spring Boot backend для торговой платформы.

---

## 🎓 Стек технологий

* **Java 17**
* **Spring Boot** (Web, Data JPA)
* **PostgreSQL**
* **Maven**
* **Lombok**
* **Swagger (springdoc-openapi)**

---

## ⚙️ Возможности

* Создание и получение пользователей
* Мягкое удаление пользователей
* Блокировка / Разблокировка
* Восстановление удалённых
* Работа через DTO + мапперы
* Обработка исключений
* Swagger-документация
* (Проект ещё дорабатывается и планирует вырасти до MVP продукта)

---

## 🌐 Документация API

После запуска проекта:

* Swagger UI: [`/swagger-ui.html`](http://localhost:8080/swagger-ui.html)
* OpenAPI JSON: [`/api-docs`](http://localhost:8080/api-docs)

---

## 💡 Запуск локально

### 1. Клонируй репозиторий

```bash
git clone https://github.com/YOUR_USERNAME/tradePetProject.git
cd tradePetProject
```

### 2. Настрой PostgreSQL

Создай базу данных с именем `trade_db`

### 3. Создай `application.properties`

```bash
src/main/resources/application.properties
```

И скопируй содержимое из `application-example.properties` в `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/trade_db
spring.datasource.username=ВАШ_ЮЗЕР
spring.datasource.password=ВАШ_ПАРОЛЬ
spring.jpa.hibernate.ddl-auto=update
```

> ⚠️ Не загружай файл `application.properties` в публичный репозиторий!

### 4. Запусти проект

Из IDE или через консоль:

```bash
./mvnw spring-boot:run
```

---

## 📊 Примеры запросов

| Метод    | Endpoint                  | Описание                     |
| -------- | ------------------------- | ---------------------------- |
| `POST`   | `/api/users`              | Создание пользователя        |
| `GET`    | `/api/users`              | Получение всех пользователей |
| `DELETE` | `/api/users/{id}`         | Мягкое удаление              |
| `POST`   | `/api/users/{id}/ban`     | Заблокировать                |
| `POST`   | `/api/users/{id}/unban`   | Разблокировать               |
| `POST`   | `/api/users/{id}/restore` | Восстановить удалённого      |

---

## 🚀 TODO (в планах)

* [ ] JWT авторизация
* [ ] Пагинация
* [ ] Логгирование (SLF4J)
* [ ] Flyway для миграций
* [ ] React frontend

---

Автор: [@YevgeniyZotov](https://github.com/YevgeniyZotov) 🌟
