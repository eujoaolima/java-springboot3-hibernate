package com.aop.estudos.aopdemo;

import com.aop.estudos.aopdemo.dao.AccountDAO;
import com.aop.estudos.aopdemo.dao.MembershipDAO;
import com.aop.estudos.aopdemo.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
		System.out.println("Server running :)");
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, false);
		theAccountDAO.doWork();

		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
	}
}
