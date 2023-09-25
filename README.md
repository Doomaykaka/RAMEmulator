# RAMEmulator (Эмулятор оперативной памяти)

## Тестовое задание

Требуется создать класс на языке Java, имитирующий оперативную память. 
Объект класса должен инициализироваться путем указания единственного целочисленного аргумента - максимального объема свободной оперативной памяти.
Класс должен иметь следующие методы:

- Метод выделения требуемого количества оперативной памяти. Входной целочисленный аргумент - требуемый объем памяти.
- Метод выделения памяти в интервале от и до. Два входных целочисленных аргмуента - начало интервала и его конец. Выделенная память не может выделяться повторно.
- Метод освобождения памяти в интервале от и до. Два входных целочисленных аргмуента - начало интервала и его конец. Выделенная память становится свободной, свободная ранее память остаётся без изменений.
- Метод получения информации о количестве общей, выделенной и свободной памяти.
- Метод полной очистки (освобождения) памяти.

Дополнительные требования к реализации:

- Использование только Java Collections Framework.
- Обработка исключений при любых некорректных ситуациях

Дополнительные задание к классу:

- Метод дефрагментации памяти.

## Как запустить?

### Зависимости

- JDK 8 и выше
- Gradle 8.0.1 и выше

### Запуск приложения

```bash
	gradle run
```

### Запуск тестов

```bash
	gradle test
```