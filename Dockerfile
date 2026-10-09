# Estágio 1: Build da aplicação com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia dependências primeiro para aproveitar o cache de camadas do Docker
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte e empacota o jar executável
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Imagem final enxuta para execução (apenas o JRE)
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=builder /app/target/ecommerce-java-backend-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
