# CalculatorTestJavaProgram  
Здравствуйте!
Это моя первая программа. Мне очень понравилось её создавать.
Она состоит из 3 файлов в которых выполняются разные методы: 
главный файл, проверки и расчёты.
Ознакомившись с задачей, я посчитал что более правильным будет 
не прекращать работу, выбросив исключение, если пользователь ввёл что-то не то, 
а вывести на экран сообщение об ошибке и продолжить заново.
Реализовать эту функцию я решил при помощи проверки введёной 
пользователем строки по 4 критериям: 
1) Есть ли в ней буквы латиницы или кириллицы.
2) Есть ли в ней числа.
3) Римские цифры и 4) Операнды
Также реализована функция выхода из программы, если пользователь напишет ключевое слово.
 Проверка осуществляется методом класса Scanner - findInLine и регулярными выражениями. 