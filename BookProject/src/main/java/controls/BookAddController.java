package controls;

import java.util.Map;

import DAO.BookDao;
import bind.DataBinding;
import vo.Book;

public class BookAddController implements Controller, DataBinding {
	BookDao bookDao;

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"book", vo.Book.class};
	}
	
	public BookAddController setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
		return this;
	}
	

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Book book = (Book)model.get("book");
		
		if(book.getTitle() == null) {
			
			return "/book/BookInsert.jsp";
		} else {
			bookDao.insert(book);
			
			return "redirect:list.do";
		}
	}
}