package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		System.out.println(factory);

//		//oneToONe
//		// creating question
//		Question q1 = new Question();
//		q1.setQuestionId(1);
//		q1.setQuestion("question 1");
//
//		Answer a1 = new Answer();
//		a1.setAnswerId(11);
//		a1.setAnswer("answer 1");
//		a1.setQuestion(q1);
//		
//		q1.setAnswer(a1);
//
//		// creating question
//		Question q2 = new Question();
//		q2.setQuestionId(2);
//		q2.setQuestion("question 2");
//
//		Answer a2 = new Answer();
//		a2.setAnswerId(22);
//		a2.setAnswer("answer 2");
//		a2.setQuestion(q2);
//		q2.setAnswer(a2);

		// manytoone
		// creating question
		Question q1 = new Question();
		q1.setQuestionId(1);
		q1.setQuestion("question 1");

		Answer a1 = new Answer();
		a1.setAnswerId(11);
		a1.setAnswer("answer 1");
		a1.setQuestion(q1);
		
		Answer a2 = new Answer();
		a2.setAnswerId(22);
		a2.setAnswer("answer 2");
		a2.setQuestion(q1);
		
		Answer a3 = new Answer();
		a3.setAnswerId(33);
		a3.setAnswer("answer 3");
		a3.setQuestion(q1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		q1.setAnswers(list);


		Session session = factory.openSession();
		session.beginTransaction();

		session.save(q1);
		session.save(a1);
		session.save(a2);
		session.save(a3);
		
		
		Question question = session.get(Question.class, 1);
		System.out.println(question.getAnswers());
		
		session.getTransaction().commit();

		// fetching
//		Question question = session.get(Question.class, 1);
//		System.out.println(question.getAnswer());

		session.close();
		factory.close();
	}
}
