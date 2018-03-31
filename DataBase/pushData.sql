INSERT INTO topic (name, description) VALUES ( "Java", "Тест по Java содержит вопросы, ответы на которые
знает большинство разработчиков с минимальным опытом программирования на Java. Тест будет полезен многим,
в том числе людям, которые не имеют большого опыта работы с Java и хотят получить минимальное представление
о базовых понятиях этого популярного языка программирования.");
INSERT INTO test (name, description, topicId) VALUES ( "Java - Основы", "этот раздел содержит вопросы касающиеся
 основных понятий, терминов и аббревиатур, конвенций именования классов, переменных и методов. Также в этом разделе
 рассматриваются вопросы по файлам (.java, .class, .jar) и пакетам, жизненному циклу объектов, сборке мусора (garbage collection).", 1);
INSERT INTO question (description, testId) VALUES ( "Какими значениями инициализируются переменные по умолчанию?", 1);
INSERT INTO question (description, testId) VALUES ( "Как передается значение переменной (по ссылке/значению)?", 1);
INSERT INTO question (description, testId) VALUES ( "Что вы знаете о функции main, какие обязательные условия ее определения?", 1);
INSERT INTO question (description, testId) VALUES ( "Что такое «итерация цикла»?", 1);
INSERT INTO question (description, testId) VALUES ( "Какой оператор используется для немедленной остановки цикла?", 1);
INSERT INTO literature (description, questionId) VALUES ( "Внутренние классы в Java", 1);
INSERT INTO literature (description, questionId) VALUES ( "Анонимные классы в Java", 2);
INSERT INTO literature (description, questionId) VALUES ( "Перечисления в Java", 3);
INSERT INTO literature (description, questionId) VALUES ( "Ход выполнения программы", 4);
INSERT INTO literature (description, questionId) VALUES ( "Колекции", 5);
INSERT INTO link (link, literatureId) VALUES ( "www.quizful.net", 1);
INSERT INTO link (link, literatureId) VALUES ( "www.dffefw.com", 1);
INSERT INTO link (link, literatureId) VALUES ( "www.wegfdb.com", 2);
INSERT INTO link (link, literatureId) VALUES ( "www.dfbdfjbi.com", 2);
INSERT INTO link (link, literatureId) VALUES ( "www.sdlkvnsdj.ocm", 3);
INSERT INTO link (link, literatureId) VALUES ( "www.sdlkgv.com", 3);
INSERT INTO link (link, literatureId) VALUES ( "www.xcvd.ru", 4);
INSERT INTO link (link, literatureId) VALUES ( "www.sjd.su", 4);
INSERT INTO link (link, literatureId) VALUES ( "www.gfdsse.dsf", 5);
INSERT INTO link (link, literatureId) VALUES ( "www.sqewf.com", 5);

INSERT INTO answer (description, correct, questionId) VALUES ("Инициализируются только переменные класса: 0, null, true/false", true, 1);
INSERT INTO answer (description, correct, questionId) VALUES ("Инициализирутся 0", false, 1);
INSERT INTO answer (description, correct, questionId) VALUES ("Инициализирутся true", false, 1);
INSERT INTO answer (description, correct, questionId) VALUES ("Инициализирутся false", false, 1);

INSERT INTO answer (description, correct, questionId) VALUES ("по ссылке", false, 2);
INSERT INTO answer (description, correct, questionId) VALUES ("по значению", true, 2);
INSERT INTO answer (description, correct, questionId) VALUES ("по ссылке и по значению", false, 2);
INSERT INTO answer (description, correct, questionId) VALUES ("затрудняюсь ответить", false, 2);

INSERT INTO answer (description, correct, questionId) VALUES ("никаких", false, 3);
INSERT INTO answer (description, correct, questionId) VALUES ("обязательная запись: public static void main", false, 3);
INSERT INTO answer (description, correct, questionId) VALUES ("обязательная запись: public static void main + входные параметры (только массив строк)", true, 3);
INSERT INTO answer (description, correct, questionId) VALUES ("обязательная запись: public static void main + входные параметры (любые параметры)", false, 3);

INSERT INTO answer (description, correct, questionId) VALUES ("одноразовое выполнение цикла", true, 4);
INSERT INTO answer (description, correct, questionId) VALUES ("многоразовое выполнение цикла", false, 4);
INSERT INTO answer (description, correct, questionId) VALUES ("одноразовое выполнение цикла с итератором", false, 4);
INSERT INTO answer (description, correct, questionId) VALUES ("одноразовое выполнение цикла без итератора", false, 4);

INSERT INTO answer (description, correct, questionId) VALUES ("continue", false, 5);
INSERT INTO answer (description, correct, questionId) VALUES ("for", false, 5);
INSERT INTO answer (description, correct, questionId) VALUES ("exit", false, 5);
INSERT INTO answer (description, correct, questionId) VALUES ("break", true, 5);

INSERT INTO role (id, user, tutor, admin, role) VALUES (1, 1, 0, 0, "ROLE_USER");
INSERT INTO role (id, user, tutor, admin, role) VALUES (2, 0, 1, 0, "ROLE_TUTOR");
INSERT INTO role (id, user, tutor, admin, role) VALUES (3, 0, 0, 1, "ROLE_ADMIN");
INSERT INTO role (id, user, tutor, admin, role) VALUES (4, 0, 1, 1, "ROLE_USER");
INSERT INTO role (id, user, tutor, admin, role) VALUES (5, 1, 1, 1, "ROLE_TUTOR");
INSERT INTO role (id, user, tutor, admin, role) VALUES (6, 1, 1, 0, "ROLE_USER");

INSERT INTO statistic (correct, questionId) VALUES (true, 1);
INSERT INTO statistic (correct, questionId) VALUES (false, 1);
INSERT INTO statistic (correct, questionId) VALUES (true, 2);
INSERT INTO statistic (correct, questionId) VALUES (false, 2);
INSERT INTO statistic (correct, questionId) VALUES (true, 3);
INSERT INTO statistic (correct, questionId) VALUES (false, 3);
INSERT INTO statistic (correct, questionId) VALUES (true, 4);
INSERT INTO statistic (correct, questionId) VALUES (false, 4);
INSERT INTO statistic (correct, questionId) VALUES (true, 5);
INSERT INTO statistic (correct, questionId) VALUES (false, 5);

INSERT INTO user (id, firstName, lastName, login, password, roleId) VALUES ('1', 'Kirill', 'Sereda', 'ksereda', '12345', '3');
INSERT INTO user (id, firstName, lastName, login, password, roleId) VALUES ('2', 'Alex', 'Rybin', 'alex23', '123123', '2');

