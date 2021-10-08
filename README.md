## Web приложение по управлению собственным туристическим телеграм ботом ##

* Бот выдает справочную информацию о введеном городе.
* Данные хранятся в базе данных.
* Управление данными (вывод, добавление, изменение, удаление) происходит через REST WebService.

Для запуска необходимо:
* cоздать базу данных
* Имя телеграм бота: TouristAssistant
* Токен: 2017117922:AAGstqPujtI1v6QvrhgMvr9nbzzVFuhC544

Все настройки хранятся в: /src/main/resources/application.properties

Команды бота:
* /start - приветствие
* /help - помощь
* /list - показать список городов в базе даных

Управление данными через REST WebService:
* GET:     /api/cities                вывод информации о всех городах
* GET:     /api/cities/{id}           вывод информации по id города
* GET:     /api/cities/name/{name}    вывод информации по названию города
* POST:    /api/cities                сохранение города
* PUT:     /api/cities                изменение информации о городе
* DELETE:  /api/cities/{id}           удаление города по id
* DELETE:  /api/cities/name/{name}    удаление всех городов из базы данных по названию
| Left-Aligned  | Center Aligned  | Right Aligned |
|:--------|:-----------------------:|:------------------------------------------------:|
| GET     | /api/cities             | вывод информации о всех городах                  |
| GET     | /api/cities/{id}        | вывод информации по id города                    |
| GET     | /api/cities/name/{name} | вывод информации по названию города   </head>    |
| POST    | /api/cities             | сохранение города                                |
| PUT     | /api/cities             | изменение информации о городе                    |
| DELETE  | /api/cities/{id}        | удаление города по id   </head>                  |
| DELETE  | /api/cities/name/{name} | удаление всех городов из базы данных по названию |


| Left-Aligned  | Center Aligned  | Right Aligned |
|:------------- |:---------------:| -------------:|
| col 3 is      | some wordy text |     **$1600** |
| col 2 is      | centered        |         $12   |
| zebra stripes | are neat        |        ~~$1~~ |

