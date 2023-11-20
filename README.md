<div align = center>

<br>

[![Badge License]][License]
![Badge Contributions]

<br>

![Logo]

<br>

[![Button Curse]][Curse]   
[![Button Wiki]][Wiki]

<br>

</div>

Мод "Игра престолов" для Minecraft - глобальное дополнение, которое превращает Minecraft в RPG c открытым миром. Вас ждёт множество новых блоков, предметов, оружия, мобов и структур. Исследуйте регионы мира, посещая города и замки, добывая новые руды, встречаясь как с друзьями, так и с врагами. Торгуйте, зарабатывайте достижения, выполняйте задания, собирайте армию. Выберите, на чьей стороне вы хотите сражаться!

## Общая информация

Этот репозиторий - проект Gradle, который должен быть открыт через IntelliJ IDEA. После установки среды проконтролируйте, чтобы версии Gradle JVM, Java и JDK соответствовали указанным ниже, иначе среда может установиться некорректно или не установиться вовсе.

| Технология | Версия  | Пояснение                                    | Где настроить                                                    |
|------------|---------|----------------------------------------------|------------------------------------------------------------------|
| Gradle     | 8.4-bin | Версия системы автоматической сборки         | -                                                                |
| Gradle JVM | 17.0.9  | Версия Java, используемая для запуска Gradle | File -> Settings -> Build -> Build Tools -> Gradle -> Gradle JVM |
| Java       | 8       | Language Level, используемый в проекте       | File -> Project Structure -> Project -> Language Level           |
| JDK        | 17.0.9  | Версия SDK, используемая в проекте           | File -> Project Structure -> Project -> SDK                      |

Если значения не соответствуют необходимым, необходимо перезагрузить проект Gradle. Ниже об этом будет написано подробнее.

## Установка и основы работы

Собственно, для начала нужно скачать и разархивировать в любое место на диске папку с исходниками. Будем называть это **папкой проекта**. В ней лежат папки (gradle, src) и различные файлы.

Эта версия использует RetroFuturaGradle - плагин, который применяет новые технологии для сборки старых версий. Таким образом, установка среды будет простой и автоматической.

Первым делом, запустите IntelliJ IDEA и откройте папку проекта: `File -> Open -> [Выбираете папку]`. Сразу после открытия начнётся установка среды. Если от вас потребуется разрешение на скачивание файлов, дайте его. Спустя некоторое время все необходимые файлы скачаются, и среда будет готова к работе.

Если на этом моменте что-то пошло не так, значит, самое время проверить значения, указанные в таблице из первого раздела. После изменения этих значений необходимо перезагрузить проект Gradle. Это можно сделать в **меню Gradle**, нажав на циклические стрелки. Меню можно открыть, нажав на значок слона в верхней правой части окна.

После установки среды весь необходимый инструментарий готов к работе. Сборочная машина Gradle вместе с плагином RetroFuturaGradle предлагает множество функций, которые находятся в ранее упомяенутом меню Gradle. Вот самые важные из них:

* Запуск клиента из среды: `Меню Gradle -> Run Configurations -> 1. Run Client`.
* Запуск локального сервера из среды: `Меню Gradle -> Run Configurations -> 2. Run Server`. К нему можно подключиться из клиента, введя в качестве адреса `localhost`.
* Компиляция мода в файл с расширением .jar: `Меню Gradle -> Tasks -> build`. После компиляции ваш мод появится в папке `папка_проекта/build/libs`. Вас интересует тот файл, который без приписки -dev.jar.

<!----------------------------------------------------------------------------->

[License]: LICENSE
[Curse]: https://www.curseforge.com/minecraft/mc-mods/gotminecraftmod
[Logo]: src/main/resources/assets/got/logo.png
[Wiki]: https://gotminecraftmod.fandom.com/ru/wiki/%D0%9C%D0%BE%D0%B4_%22%D0%98%D0%B3%D1%80%D0%B0_%D0%BF%D1%80%D0%B5%D1%81%D1%82%D0%BE%D0%BB%D0%BE%D0%B2%22_%D0%B4%D0%BB%D1%8F_Minecraft_%D0%B2%D0%B8%D0%BA%D0%B8


<!----------------------------------[ Badges ]--------------------------------->

[Badge Contributions]: https://img.shields.io/badge/Contributions-Welcome-3d6c23.svg?style=for-the-badge&labelColor=569A31
[Badge License]: https://img.shields.io/badge/License-GPL_3-0167a0.svg?style=for-the-badge&labelColor=blue


<!---------------------------------[ Buttons ]--------------------------------->

[Button Curse]: https://img.shields.io/badge/Download-f16436.svg?style=for-the-badge&logoColor=white&logo=CurseForge
[Button Wiki]: https://img.shields.io/badge/Wiki-FA005A.svg?style=for-the-badge&logoColor=white&logo=Fandom
