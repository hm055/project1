package ex3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageBeanImpl implements MessageBean{
	private String message;
	private String name;
	
	public MessageBeanImpl() {
	}

	public String getMessage() {
		return message;
	}

	public MessageBeanImpl(String message, String name) {
		super();
		this.message = message;
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//(1) 생성자를 이용하여 멤버값 지정
	//(2)setter  이용하여 멤버값 지정
	//(3)의존성 주입(DI)으로 멤버값 지정(*)
	//@Autowired
	//@Qualifier("output2")
	@Resource(name="output2")
	private Outputer outputer;
	
	

	
	public void sayHello()  {
		System.out.println(name+"님께 " + message + "전달되었습니다.");
		try {
			outputer.writeMessage(name+"님께 " + message + "전달되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}