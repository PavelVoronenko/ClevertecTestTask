<h1 align="center">ClevertecTestTask</h1> 
<h3 align="center">Используемый стек технологий</h2><br>
<h>PostgreSQL, JDBC, JUnit5, Mockito</h><br><br>
<h3 align="center">Инструкция по запуску</h2><br>
<p>Приложение запускается <em>java RunnerClassName <набор_параметров></em>, где набор параметров в формате itemId-quantity (itemId - идентификатор товара, quantity - его количество.</h><br>
<p>Например: <em>java CheckRunner 3-1 2-5 5-1 card-1234</em> сформирует и выведет в консоль и в файл "Receipt.txt" чек, содержащий в себе наименование товара с id=3 в количестве 1шт, id=2 в количестве 5 штук, id=5 - одна штука. Card-1234 означает, что была предъявлена скидочная карта с номером 1234. Без скидочной карты процент скидки составит 0%.</h><br>
