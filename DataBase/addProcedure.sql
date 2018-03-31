delimiter //
CREATE PROCEDURE `statistic` (out var1 int)
  BEGIN
    select q.description, s.correct, l.description, link.link from question as q
      join statistic as s on q.id = s.questionId join literature as l on q.id = l.questionId
      join link on l.id = link.literatureId  where s.userId = ? group by q.description;
  END;

call "user_statistic" (int );