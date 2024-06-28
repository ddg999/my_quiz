package com.tenco.quiz.ver2;

import java.sql.SQLException;
import java.util.List;

public interface QuizRepository {
	int addQuizQuestion(String question, String answer) throws SQLException;
	List viewQuizQuestion() throws SQLException;
	QuizDTO playQuizGame() throws SQLException;
}
