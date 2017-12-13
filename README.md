# test
Practical assignments java
"HW4
Представим, что мы разрабатываем некий модуль системы проектирования помещений. У помещения есть такой параметр, как площадь, и известно, что предметы в помещении не должны занимать более 70% площади. Также известно, что освещённость помещения не должна выходить за пределы 300-4000 лк (каждое окно даёт освещённость помещения 700 лк, каждая лампочка даёт такую освещённость, как указано в её параметрах).

Создайте структуру классов и интерфейсов, позволяющую создавать здания (состоящие из помещений), помещения (с указанием их площади и количества окон), а также добавлять в помещение произвольное количество лампочек (пока не будет превышена максимальная освещённость в 4000 лк) и произвольное количество произвольных предметов (пока их суммарная площадь не превышает 70% площади помещения).

При попытке превысить освещённость должно быть порождено исключение IlluminanceTooMuchException, а при попытке превысить 70% площади добавляемым предметом должно быть порождено исключение SpaceUsageTooMuchException.

Предполагается, что использовать вашу библиотеку будут примерно так (написано в псевдокоде):

Здание building = new Здание(""Здание 1"");

building.addRoom(""Комната 1"", 100м2, 3окна);

building.addRoom(""Комната 2"", 5м2, 2окна);

building.getRoom(""Комната 1"").add(new Лампочка(150));

building.getRoom(""Комната 1"").add(new Лампочка(250));

building.getRoom(""Комната 1"").add(new Стол(""Стол письменный"", 3м2));

building.getRoom(""Комната 1"").add(new КреслоМягкое(""Кресло мягкое и пушистое"", от1м2, до2м2));

building.describe();

Пример вывода building.describe():

Здание 1

Комната 1

Освещённость = 2500 (3 окна по 700 лк, лампочки 150 лк и 250 лк)

Площадь = 100 м^2 (занято 4-5 м^2, гарантированно свободно 95 м^2 или 95% площади)

Мебель:

Стол письменный (площадь 3 м^2)

Кресло мягкое и пушистое (площадь от 1 м^2 до 2 м^2)

Комната 2

Освещённость = 1400 (2 окна по 700 лк)

Площадь = 5 м^2 (свободно 100%)

Мебели нет
"
