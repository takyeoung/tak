package com.kong.king.spring.guest04.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kong.king.spring.guest04.dto.GuestbookDTO;
import com.kong.king.spring.guest04.dto.PageRequestDTO;
import com.kong.king.spring.guest04.dto.PageResultDTO;
import com.kong.king.spring.guest04.entity.Guestbook;
import com.kong.king.spring.guest04.service.GuestbookService;





@SpringBootTest
public class GuestbookRepositoryTests {
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@Autowired
	private GuestbookService service;
	
//  @Test
//  public void insertDummies() {
//     IntStream.rangeClosed(1,300).forEach(i ->{
//        Guestbook guestbook = Guestbook.builder()
//              .title("제목..."+i)
//              .content("내용..." + i%5)
//              .writer("박준홍" + (i%10))
//              .build();
//        
//        System.out.println(guestbookRepository.save(guestbook));
//     });
//  }
  
//  @Test
//  public void updateTest() {
//     Optional<Guestbook> result = guestbookRepository.findById(302L);
//     
//     if(result.isPresent()) {
//        Guestbook guestbook = result.get();
//        
//        guestbook.changeTitle("업데이트 제목....");
//        guestbook.changeContent("업데이트 내용....");
//        
//        guestbookRepository.save(guestbook);
//     }
//  }

	
//	@Test
//	public void testQuery1() {
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
//		
//		QGuestbook qGuestbook = QGuestbook.guestbook;
//		
//		String keyword = "1";
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		
//		BooleanExpression expression = qGuestbook.title.contains(keyword);
//		
//		builder.and(expression);
//		
//		Page<Guestbook> result = guestbookRepository.findAll(builder,pageable);
//		
//		result.stream().forEach(guestbook -> {
//			System.out.println(guestbook);
//		});
//	}
	
//	@Test
//	   public void testQuery2() {
//	      Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").descending());
//	      
//	      QGuestbook qGuestbook = QGuestbook.guestbook;
//	      
//	      String keyword = "3";
//	      String keyword2 = "1";
//	      
//	      BooleanBuilder builder = new BooleanBuilder();
//	      
//	      BooleanExpression exTitle = qGuestbook.title.contains(keyword);
//	      BooleanExpression exContent = qGuestbook.content.contains(keyword2);
//	      BooleanExpression exAll = exTitle.and(exContent);
//	      
//	      builder.and(exAll);
//	      builder.and(qGuestbook.gno.gt(250L));
//	      
//	      Page<Guestbook> result = guestbookRepository.findAll(builder, pageable);
//	      
//	      result.stream().forEach(guestbook ->{
//	         System.out.println(guestbook);
//	      });
//
//	   }
	
//	@Test
//	public void testRegister() {
//		
//		GuestbookDTO guestbookDTO = GuestbookDTO.builder()
//				.title("샘플 제목.....")
//				.content("샘플 내용....")
//				.writer("user0")
//				.build();
//		
//		System.out.println(service.register(guestbookDTO));
//	}
	
	@Test
	public void testList() {
		
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
		
		PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);
		
		System.out.println("PREV:" + resultDTO.isPrev());
		System.out.println("NEXT" + resultDTO.isNext());
		System.out.println("TOTAL" + resultDTO.getTotalPage());
		
		System.out.println("----------------------------");
		for(GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
			
			System.out.println(guestbookDTO);
		}
		
		System.out.println("----------------------------");
		resultDTO.getPageList().forEach(i -> System.out.println(i));
	}
	
//	@Test
//	public void testSearch() {
//		
//		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().
//				page(1).size(10)
//				.type("tc")
//				.keyword("샘플")
//				.build();
//		
//		PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);
//		
//		System.out.println("PREV: "+ resultDTO.isPrev());
//		System.out.println("NEXT: "+ resultDTO.isNext());
//		System.out.println("TOTAL: "+ resultDTO.getTotalPage());
//		
//		System.out.println("------------------------");
//		for(GuestbookDTO guestookDTO : resultDTO.getDtoList()) {
//			System.out.println(guestookDTO);
//		}
//		
//		System.out.println("-----------------------------");
//		resultDTO.getPageList().forEach(i -> System.out.println(i));
//		
//	}
	
}
