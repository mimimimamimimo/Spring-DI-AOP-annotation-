package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
@Service  //service 있어야 검색가능
@Aspect
public class LogAdvice {
	
	
	public void printlog() {
		System.out.println("비즈니스로직수행전동작");
	}
	
	
	@Pointcut("excution(* com.springbook.biz..*Impl.*(..))")  //포인트컷
	public void all2Pointcut() {}
	@Before("all2Pointcut()")   //어드바이스
	public void getPointcut() {
		System.out.println("어노테이션-비즈니스로직수행전동작");
		
	}
	
	//애스팩트는 포인트컷과 어드바이스의 조합이다
}
