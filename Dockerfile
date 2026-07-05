# Крок 1: Вказуємо базовий образ із потрібною версією Java
# Використовуємо полегшену версію Alpine, щоб образ займав менше місця
FROM eclipse-temurin:17-jre-alpine

# Крок 2: Встановлюємо робочу директорію всередині контейнера
WORKDIR /app

# Крок 3: Вказуємо шлях до нашого зібраного JAR-файлу
# Якщо ви використовуєте Gradle, шлях буде build/libs/*.jar
ARG JAR_FILE=target/*.jar

# Крок 4: Копіюємо JAR-файл у контейнер і перейменовуємо його на app.jar
COPY ${JAR_FILE} app.jar

# Крок 5: Документуємо порт, на якому працює Spring Boot (за замовчуванням 8080)
EXPOSE 8080

# Крок 6: Вказуємо команду для запуску додатка
ENTRYPOINT ["java", "-jar", "app.jar"]

# tzdata for timzone
RUN apk add --no-cache tzdata

# timezone env with default
ENV TZ=UTC