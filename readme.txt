ADMIN:
method = GET - /JavaTests/admin/users/getUsersRest - возвращает список всех пользователей
method = GET - /JavaTests/admin/users/saveAsAdmin/{userId} - изменяет роль пользователя на Admin
method = GET - /JavaTests/admin/users/saveAsTutor/{userId} - изменяет роль пользователя на Tutor
method = GET - /JavaTests/admin/users/saveAsUser/{userId} - изменяет роль пользователя на User
method = POST - /JavaTests/admin/topic/addTopicRest - принимает Topic и создает его в БД
method = POST - /JavaTests/admin/topic/updateTopicRest - принимает Topic и обновляет его в БД
method = POST - /JavaTests/admin/topic/updateTopicRest - принимает Topic и удаляет его из БД
method = GET - /JavaTests/admin/statistic/getTestStatisticRest - возвращает список статистик по пройденным тестам
method = GET - /JavaTests/admin/statistic/getQuestionStatisticRest - возвращает список статистик по пройденным вопросам
method = GET - /JavaTests/admin/statistic/getUserStatisticRest - возвращает список статистик пользователей


TUTOR:
method = GET - /JavaTests/tutor/getTopics/getTopicsRest - возвращает список тем
method = POST - /JavaTests/tutor/getTopics/addTopicRest - принимает Topic и создает его в БД
method = POST - /JavaTests/tutor/getTopics/updateTopicRest - принимает Topic и обновляет его в БД
method = POST - /JavaTests/tutor/getTopics/deleteTopicRest - принимает Topic и удаляет его из БД
method = GET - /JavaTests/tutor/getTopics/getTestsByTopicIdRest/{topicId} - возвращает список тестов по id темы
method = POST - /JavaTests/tutor/getTopics/addTestRest - принимает Test и добавляет его в БД
method = POST - /JavaTests/tutor/getTopics/updateTestRest - принимает Test и обновляет его в БД
method = POST - /JavaTests/tutor/getTopics/deleteTestRest - принимает Test и удаляет его из БД
method = GET - /JavaTests/tutor/getTopics/getQuestionsByTestIdRest/{testId} - возвращает список вопросов по id теста
method = POST - /JavaTests/tutor/getQuestions/addQuestionRest - принимает Question и добавляет его в БД
method = POST - /JavaTests/tutor/getQuestions/updateQuestionRest - принимает Question и обновляет его в БД
method = POST - /JavaTests/tutor/getQuestions/deleteQuestionRest - принимает Question и удаляет его из БД
method = GET - /JavaTests/tutor/getQuestions/getAnswersByQuestionIdRest/{questionId} - возвращает список ответов по id вопроса
method = POST - /JavaTests/tutor/getQuestions/addAnswerRest - принимает Answer и добавляет его в БД
method = POST - /JavaTests/tutor/getQuestions/updateAnswerRest - принимает Answer и обновляет его в БД
method = POST - /JavaTests/tutor/getQuestions/deleteAnswerRest - принимает Answer и удаляет его из БД
method = GET - /JavaTests/tutor/getStatistics/getTestStatisticRest - возвращает список статистик по пройденным тестам
method = GET - /JavaTests/tutor/getStatistics/getQuestionStatisticRest - возвращает список статистик по пройденным вопросам
method = GET - /JavaTests/tutor/getStatistics/getUserStatisticRest - возвращает список статистик пользователей
method = GET - /JavaTests/tutor/getQuestions/getLiteratureRest - возвращает список литературы
method = POST - /JavaTests/tutor/getQuestions/addLiteratureRest - принимает Literature и добавляет ее в БД
method = POST - /JavaTests/tutor/getQuestions/updateLiteratureRest - принимает Literature и обновляет ее в БД
method = POST - /JavaTests/tutor/getQuestions/deleteLiteratureRest - принимает Literature и удаляет ее из БД
method = GET - /JavaTests/tutor/getQuestions/getLinksRest - возвращает список ссылок
method = GET - /JavaTests/tutor/getQuestions/getLinksByLiteratureIdRest/{literatureId} - возвращает список ссылок по id литературы
method = POST - /JavaTests/tutor/getQuestions/addLinkRest - принимает Link и добавляет ее в БД
method = POST - /JavaTests/tutor/getQuestions/updateLinkRest - принимает Link и обновляет ее в БД
method = POST - /JavaTests/tutor/getQuestions/deleteLinkRest - принимает Link и удаляет ее из БД

USER:
method = GET - /JavaTests/user/test/getTestsRest - возвращает список тестов
method = GET - /JavaTests/user/test/getQuestionsByTestIdRest/{testId} - возвращает список вопросов по id теста
method = GET - /JavaTests/user/test/getAnswersByQuestionIdRest/{questionId} - возвращает список ответов по id вопроса
method = POST - /JavaTests/user/test/setAnswersRest/{questionId} - принимает список отмеченных пользователем ответов на вопрос, id которого указывается в URL; вычисляет и отмечает вопрос правильно/неправильно отвеченным, но НЕ заносит данные в БД!
method = GET - /JavaTests/user/test/getResultStatisticRest - возвращает список статистики по отвеченным вопросам (после вызова этого метода все результаты СОХРАНЮТСЯ в БД, т.е. после вызова этого метода тест ДОЛЖЕН быть завершен!)
method = GET - /JavaTests/user/test/getLiteratureByQuestionId/{questionId} - возвращает список литературы по id вопроса
method = GET - /JavaTests/user/test/getLinkByQuestionId/{questionId} - возвращает список ссылок по id вопроса

SECURITY:
method = POST - /JavaTests/registrationRest - принимает User с ролью user и создает его в БД (для регистрации)
method = POST - /JavaTests/logout - logout
method = POST - /JavaTests/login?login=owin&password=tutor - пример login, где owin - login и tutor - password