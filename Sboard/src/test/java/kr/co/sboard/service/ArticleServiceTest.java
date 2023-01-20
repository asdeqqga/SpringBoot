package kr.co.sboard.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

public class ArticleServiceTest {
	
	private ArticleService service;
	
	public void test1() {
		
		service.fileUpload(null);
	}
}
