## Web приложение по управлению туристическим телеграм ботом ##

* Бот выдает справочную информацию о введеном городе.
* Данные хранятся в базе данных.
* Управление данными (вывод, добавление, изменение, удаление) происходит через REST WebService.

Для запуска необходимо:
* Имя телеграм бота: TouristAssistant
* Токен: 2017117922:AAGstqPujtI1v6QvrhgMvr9nbzzVFuhC544
* cоздать базу данных
######    CREATE DATABASE tourist_telegram_bot;

######    CREATE TABLE tourist_telegram_bot.city(
######    id INT AUTO_INCREMENT PRIMARY KEY,
######    city_name VARCHAR(50) NOT NULL,
######    information TEXT);

Все настройки хранятся в: /src/main/resources/application.properties

Команды бота:
* /start - приветствие
* /help - помощь
* /list - показать список городов в базе даных

Управление данными через REST WebService:
| HTTP метод |           URL           |                Операция                          |
|:----------:|:-----------------------:|:------------------------------------------------:|
| GET        | /api/cities             | вывод информации о всех городах                  |
| GET        | /api/cities/{id}        | вывод информации по id города                    |
| GET        | /api/cities/name/{name} | вывод информации по названию города              |
| POST       | /api/cities             | сохранение города                                |
| PUT        | /api/cities             | изменение информации о городе                    |
| DELETE     | /api/cities/{id}        | удаление города по id                            | 
| DELETE     | /api/cities/name/{name} | удаление всех городов из базы данных по названию |


