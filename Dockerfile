FROM openjdk:17
COPY ./ShoppingCartDesign/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","ShoppingCartDesign"]



