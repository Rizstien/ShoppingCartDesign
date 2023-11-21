FROM openjdk:17
COPY ./out/production/ShoppingCartDesign/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","ShoppingCartDesign"]



