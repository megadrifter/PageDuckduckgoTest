# language:ru
Функционал: Тестирование поиска Duckduckgo

  @ducktest
  Сценарий: Просмотр результатов поиска
    Когда открывается страница "Главная страница"
    И пользователь (ищет) "IDEA"
    Тогда открывается страница "Результаты поиска"
    И (количество результатов поиска должно быть не равно нулю)

  @failtest
  Сценарий: Просмотр нулевых результатов поиска
    Когда открывается страница "Главная страница"
    И пользователь (ищет) "lskdfajdflkjgdfalkjgadflkdfajadfl;jfdalkjafdsglkfjg"
    Тогда открывается страница "Результаты поиска"
    И (количество результатов поиска должно быть не равно нулю)


  @parametrized
  Структура сценария: Просмотр результатов поиска текста
    Когда открывается страница "Главная страница"
    И пользователь (ищет) <подстановка текста>
    Тогда открывается страница "Результаты поиска"
    И (количество результатов поиска должно быть не равно нулю)

    Примеры:
      | подстановка текста |
      | "один" |
      | "два" |
      | "три" |
      | "четыре" |

