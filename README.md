# CalculatorTestJavaProgram  
2 версия программы.
Реализован парсинг методом разбиения входящей строки и далее посимвольным занесением её в отдельный ArrayList.
Это позволило сразу исключать из записи в новую строку недопустимые элементы и выкидывать исключения.
Далее строка без лишних пробелов подаётся в класс Calculation, метод NumbersCalculation, где реализован следующий алгоритм:
1. Строка подаётся в метод getNextNumber, где мы считываем первый символ.
2. Если символ - число, то мы, путём for loop, составляем посимвольно число до знака операнда, удаля/смещая символы к началу,
методом sequence.remove(0).
3. На знаке операнда мы выходим из петли и отправляем массив символов, например [1, 3, 6],
в отдельную функцию которая выдаёт нам int число 136.
4. Число возвращается в метод где дальше, в отдельной функции getNextOperator, нам возвращается операнд, из тойже строки
из которой мы получали число, и операнд в которой путём смещения оказался на нулевой позиции.
5. Далее строка опять сместилась, там осталось число которое мы получаем тем же способом что и первое. Считаем.
6. Как мы узнаём когда конец строки? В методе getNextNumber возникает ошибка IndexOutOfBoundsException. Мы ловим её в методе NumbersCalculation и завершаем цикл. 
6. Преобразовываем результат в строку (это надо для операций с римскими цифрами) и подаём в main.
Римские цифры мы считаем точно так же, предварительно преобразовав строку с ними в точно такую же строку но с арабскими аналогами.
На ответ мы подаём обратно преобразованую строку с римским числом.
Так же в методе NumbersCalculation мы оставляем предыдущий результат вычисления первых двух чисел в переменной, при следующем цикле
мы проверяем не равна ли переменная нулю, если нет то мы обходим её, вызвращаем следующий операнд и число. Это даёт нам возможность 
оперировать длинными цепочками вычислений типа 2+8-1*20/4.
