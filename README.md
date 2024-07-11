[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
<h1 align="center" style="font-weight: bold;">📦 Shipping Cost Service</h1>
<div align="center">
  
![spring][SPRING_BADGE]
![java][JAVA_BADGE]
<img src="https://img.shields.io/badge/H2 Database-darkblue?style=for-the-badge&logo=java" alt="Sistema Mercado">
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
 <img src="https://img.shields.io/badge/Version 1.0-gray?style=for-the-badge&logo=java" alt="Sistema Mercado">
</div>
<p align="center">
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> •
 <a href="#database">Database</a> •
</p>
<p align="center">
  <b>This is a microservice to calculate the shipping cost based in the distance from origin to destination and the price per kilometers.</b>
</p>
<h2 id="started">🚀 Getting started</h2>
<p>This project was created to calculate the shipping cost in a delivery. For this, I consumed two services, the first one is to return the location based in a <a href="https://viacep.com.br/">CEP</a> 
  and the last one is <a href="https://developers.google.com/maps/documentation/distance-matrix?hl=pt-br">to calculate the distance</a> in meters based in two locations. If you want take a look in the code, be confortable to clone this project: </p>

```bash
git clone https://github.com/Venicode/shipping-cost-service
```

<h3>Prerequisites</h3>

<p>To running this project, you must have all prerequisites below:</p>

- Java SDK 17+
- Api key in: <a href="https://developers.google.com/maps/documentation/distance-matrix/get-api-key?hl=pt-br">https://developers.google.com/maps/documentation/distance-matrix/get-api-key?hl=pt-br</a>

<h3>Starting</h3>

<p>When download to <a href="https://www.transfernow.net/dl/20240711EO9oihPP">shipping-cost-service.jar</a> is done, move this file whatever you want and open a command prompt. Then, check the path's file and type the command below:</p>

```bash
C:\path\to\file>java -jar shipping-cost-service.jar
```
<p>If you do this correctly, the api server will run: </p>

<img width="1284" alt="print-shipping" src="https://github.com/Venicode/shipping-cost-service/assets/44931124/370d4b12-dc5e-460c-ba63-9cef201af063">

<p>After that, you can access the swagger page: <a href="http://localhost:8080/swagger-ui/index.html#/">http://localhost:8080/swagger-ui/index.html#/</a></p>

<h2 id="routes">📍 API Endpoints</h2>

<p>Example to request something: <a href="http://localhost:8080/initialConfig">http://localhost:8080/initialConfig</a></p>
<p>All endpoints that you can use in the application group by entities:</p>

<p>Initial Config Endpoints</p>

```

POST /initialConfig - register a cep to origin and a cost per km to calculate the final shipping cost.

PUT /initialConfig/{id} - Update the initial config informations.

```

<p>Shipping Cost Endpoint</p>

```

GET /shippingcost/{cep}&idInitialConfig={id}&apikey={key} - Retrieve a map with the shipping cost, initial config (which parameter was applied to calculated), duration in minutes and the distante in kilometers.

```

<p>Example to response: </p>

```
{
  "shippingCost": 89.7112,
  "initialConfig": {
    "id": 1,
    "cepOrigin": "18608336",
    "costPerKm": 0.4
  },
  "origin": "Botucatu",
  "destination": "Campinas",
  "durationMinutes": 154.13333333333333,
  "km": 224.278
}
```

<h2 id="database">📝 Database</h2>

<p>For this project, I chose the H2 Database, it stores data in memomy, being ideal for testing, where it doesn't not persist the data on disk. So, when closing the terminal, all data will be lost.</p>
