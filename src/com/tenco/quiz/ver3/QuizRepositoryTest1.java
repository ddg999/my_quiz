package com.tenco.quiz.ver3;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class QuizRepositoryTest1 {

	public static void main(String[] args) {
		// QuizRepository 구현 클래스 테스트
		QuizRepositoryImpl quizRepositoryImpl = new QuizRepositoryImpl();
		// 실행의 흐름 직접 만들기
		try {
			while (true) {
				System.out.println("1.게임시작 2.퀴즈추가 3.퀴즈조회 4.종료");
				Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();
				if (choice == 1) {
					QuizDTO quizDTO = quizRepositoryImpl.playQuizGame();
					System.out.println(quizDTO.getQuestion());
					String answer = sc.next();
					if (answer.equalsIgnoreCase(quizDTO.getAnswer())) {
						System.out.println(">>> 정답입니다! <<<");
					} else {
						System.out.println(">>> 오답입니다 <<<");
					}	
				} else if (choice == 2) {
					System.out.print("퀴즈를 입력하세요 : ");
					String question = sc.next();
					System.out.print("정답을 입력하세요 : ");
					String answer = sc.next();
					quizRepositoryImpl.addQuizQuestion(question, answer);
					System.out.println(">>> 추가 완료 <<<");
				} else if (choice == 3) {
					List<QuizDTO> quizDtos = quizRepositoryImpl.viewQuizQuestion();
					for (QuizDTO quizDTO : quizDtos) {
						System.out.println("번호 : " + quizDTO.getId());
						System.out.println("퀴즈 : " + quizDTO.getQuestion());
						System.out.println("정답 : " + quizDTO.getAnswer());
						System.out.println("-------------------------------------");
					}
				} else if (choice == 4) {
					System.out.println("게임을 종료합니다");
					break;
				}
				System.out.println("-----------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
