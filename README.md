# pizza-app
Roller: ADMIN, MANAGER, USER
Säkrade endpoints för de med ADMIN och MANAGER behörigheter, 

använder mySQL databas  och rabbit mq som jag kör via en docker container.

**** Starta pizza-app och order-service****

**https://github.com/lisayli/Order-Service

ADMIN kommer åt alla rolers behörigheter
MANAGER är begränsad till vid del
USER kan enbart läsa och skicka välja sin order

**http://localhost:8080/api/v1/admin/**
**http://localhost:8080/api/v1/management/**
**http://localhost:8080/api/v1/pizza/**


**Admin token**: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBtYWlsLmNvbSIsImlhdCI6MTY4NjQ5OTM4OCwiZXhwIjoxNjg2NTg1Nzg4fQ.fIV-4l810vJIV_VTtgBoACSGX-NCuiUtWRpfZ9o06KE
**Manager token**: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYW5hZ2VyQG1haWwuY29tIiwiaWF0IjoxNjg2NDk5Mzg4LCJleHAiOjE2ODY1ODU3ODh9.O4qUEzl3PFrf-HYKZsAlojZ41ZcpjX_9zRw_tANoTP8
**User token**: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQG1haWwuY29tIiwiaWF0IjoxNjg2NDk5Mzg5LCJleHAiOjE2ODY1ODU3ODl9.e66q8qmqA6LDY86HVywI2aqxk97Uu9npQanjFoutw1A

ange ditt manager token
![image](https://github.com/lisayli/pizza-app/assets/72072783/6c979e57-1837-4faf-a166-00d24e710bb2)

**POST http://localhost:8080/api/v1/management/create**
JSON för att skapa en pizza:

	{
		"name": "California",
		"price": "119",
		"ingredient": "tomat,ost,ananas,cheddar"
	}
  
  all pizzas:
  **GET http://localhost:8080/api/v1/pizza**
  
  pizza by id:
  **GET http://localhost:8080/api/v1/pizza/1**
  
  ------------------------------------------------------------
  Använd valfritt token:
  
  ![image](https://github.com/lisayli/pizza-app/assets/72072783/e39bcb92-6007-4c90-a951-ee81cc0396e2)
  
  send order, ange pizzaid i slutet ex 1 med dina uppgifter:
  **POST http://localhost:8080/api/v1/pizza/send/1**
  JSON för att skricka order detaljer:
  
  {
	"firstName":"firstname",
	"lastName":"lastname,
	"email":"youremail@email"
}

rabbitMQ sender ska ha skickat iväg ordern till order servicen som hanterar datan.
  

