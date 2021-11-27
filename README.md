# Лабораторная работа 5

## Задание

Реализовать внедрение зависимостей в контейнере [Quarkus](https://quarkus.io). Сделать свой интерфейс и две его реализации. Одна должна быть по-умолчанию, для второй должен быть отдельный [Qualifier](https://quarkus.io/guides/cdi-reference#qualified-injected-fields). Продемонстрировать работу обеих реализаций. Также реализовать метод, в котором вы сможете посмотреть все реализации того или иного bean'а.

## Разработка

### Структура проекта 

```
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── docker
    │   │   ├── Dockerfile.jvm
    │   │   ├── Dockerfile.legacy-jar
    │   │   ├── Dockerfile.native
    │   │   └── Dockerfile.native-distroless
    │   ├── java
    │   │   └── ru
    │   │       └── ashcheulov
    │   │           ├── commons
    │   │           │   └── PaymentMessage.java
    │   │           ├── enums
    │   │           │   └── PayServiceType.java
    │   │           ├── payment
    │   │           │   ├── ApplePay.java
    │   │           │   ├── GooglePay.java
    │   │           │   ├── IPaymentService.java
    │   │           │   └── MyAwesomePay.java
    │   │           ├── producers
    │   │           │   ├── ApplePayProducer.java
    │   │           │   ├── GooglePayProducer.java
    │   │           │   └── MyAwesomePayProducer.java
    │   │           ├── qualifiers
    │   │           │   ├── Apple.java
    │   │           │   ├── AppleProducer.java
    │   │           │   ├── AwesomeProducer.java
    │   │           │   ├── Google.java
    │   │           │   └── GoogleProducer.java
    │   │           └── routes
    │   │               ├── ApplePayRoute.java
    │   │               ├── GooglePayRoute.java
    │   │               ├── MyAwesomePayRoute.java
    │   │               └── NonamePayRoute.java
    │   └── resources
    │       ├── META-INF
    │       │   └── resources
    │       │       └── index.html
    │       └── application.properties
    └── test
        └── java
            └── ru
                └── ashcheulov
                    ├── ExampleResourceTest.java
                    └── NativeExampleResourceIT.java

```

## Результат разработки

В результате разработки был создан интерфейс [``IPaymentService``](src/main/java/ru/ashcheulov/payment/IPaymentService.java)

```java
/**
 * Payment service interface
 */
public interface IPaymentService {
    /**
     * @return payment result
     */
    String pay();
}
```

И три его реализации:
* [``ApplePay``](src/main/java/ru/ashcheulov/payment/ApplePay.java) с Qualifier [``Apple``](src/main/java/ru/ashcheulov/qualifiers/Apple.java)
* [``GooglePay``](src/main/java/ru/ashcheulov/payment/GooglePay.java) с Qualifier [``Google``](src/main/java/ru/ashcheulov/qualifiers/Google.java)
* [``MyAwesomePay``](src/main/java/ru/ashcheulov/payment/MyAwesomePay.java) без Qualifier является реализацией по-умолчанию

Для демонстрации работы всех реализаций были созданы следующие Rest endpoints:
* [``ApplePayRoute``](src/main/java/ru/ashcheulov/routes/ApplePayRoute.java) с относительным адресом ``/api/apple-pay``
* [``GooglePayRoute``](src/main/java/ru/ashcheulov/routes/GooglePayRoute.java) с относительным адресом ``/api/google-pay``
* [``MyAwesomePayRoute``](src/main/java/ru/ashcheulov/routes/MyAwesomePayRoute.java) с относительным адресом ``/api/my-awesome-pay``

Для просмотра всех реализаций [``NonamePayRoute``](src/main/java/ru/ashcheulov/routes/NonamePayRoute.java)
```java
public class NonamePayRoute {

    @Inject
    @Any
    Instance<IPaymentService> paymentServices;

    /**
     * Предоставляет список доступных сервисов для оплаты (просмотр всех реализаций бина IPaymentService)
     * @return сообщение включающее список доступные сервисы
     */
    @GET
    @Path("noname-pay")
    @Produces(MediaType.TEXT_PLAIN)
    public String pay() {
        //code here...
    }

    /**
     * Оплатить с помощью сервиса определённого типа
     * @param type тип сервиса для оплаты
     * @return сообщение об оплате с помощью соответствующего сервиса
     */
    @GET
    @Path("noname-pay/{type}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pay(@PathParam("type") PayServiceType type) {
        //code here...
    }
}
```

## Автор

[Ащеулов Михаил ПИМ-21](https://github.com/VergiliusAW)
