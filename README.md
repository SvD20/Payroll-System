# Payroll-System
Client-server application with a graphical interface for payroll

Клиентская часть клиент-серверного приложения для расчеты заработной платы сотрудников.

Клиент взаимодействует с сервером по стеку протоколов tcp/ip. Данные перед отправкой на сервер сереализуются в json формат (json строки).
Следовательно при получении ответов от сервера, происходит json десериализация полученных данных. 
Применены (подключены вручную через IDE) следующие инструменты: JavaFX, библиотеки Jackson.
Клиент помогает реализовать возможности авторизации, регистрации пользователей, расчета заработной платы, просмотра различной информации о ней.
Приложение было не закончено полностью (не реализованы все задуманные возможности).

Серверная часть клиент-серверного приложения для расчета заработной платы сотрудников.

Сервер взаимодействует с клиентом по стеку протоколов tcp/ip. Данные перед отправкой клиенту сереализуются в json формат (json строки). Следовательно при получении данных от клиента, происходит их json десериализация. Применены (подключены вручную через IDE) следующие инструменты: Hibernate, соответствующий СУБД MySQL драйвер, библиотеки Jackson. Применена многоуровневая архитектура, DAO. Велась работа с базой данных из пяти таблиц, четыре из которых связаны и имеют связи один-ко-многим и многие-к-одному.

Сервер реализует возможности авторизации, регистрации пользователей, расчета заработной платы, просмотра различной информации о ней.

The client part of a client-server application for calculating the payroll of employees.

The client communicates with the server via the tcp/ip protocol stack. The data before being sent to the server is serealized in json format (json strings).
Therefore, when receiving responses from the server, json deserializes the received data.
The following tools were applied (manually connected via IDE): JavaFX, Jackson libraries.
The client helps to realize the possibilities of authorization, user registration, payroll calculation, viewing various information about it.
The application was not completed completely (all planned features were not implemented).

The server part of a client-server application for calculating the payroll of employees.

The server communicates with the client via the tcp/ip protocol stack. Before sending the data to the client, the data is serealized in json format (json strings). Therefore, when receiving data from the client, they are json deserialized. The following tools were applied (manually connected via IDE): Hibernate, corresponding MySQL DBMS driver, Jackson libraries. Applied multi-level architecture, DAO. We worked with a database of five tables, four of which are connected and have one-to-many and many-to-one relationships.

The server implements the possibilities of authorization, user registration, payroll calculation, viewing various information about it.



